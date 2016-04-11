package net.infobosccoma.cantinadechalmunv1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final int CAMERA_APP_CODE = 100;
    private ImageView imatge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //eric

        imatge = (ImageView) findViewById(R.id.imageView);
    }

    public static boolean isIntentAvailable(Context context, String action) {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    public void onClickFoto(View v) {
        //fer foto sense guardar.
        if (isIntentAvailable(this, MediaStore.ACTION_IMAGE_CAPTURE)) {
            // intenci? de fer una foto
            Intent takePictureIntent = new Intent(
                    MediaStore.ACTION_IMAGE_CAPTURE);
            // crear la ruta del fitxer on desar la foto
            // li passem par?metres a l'Inent per indicar que es vol guarda
            // la captura en un fitxer
            // inciar l'intent
            startActivityForResult(takePictureIntent, CAMERA_APP_CODE);
        } else {
            Toast.makeText(this, "No hi ha cap aplicaci? per capturar fotos",
                    Toast.LENGTH_LONG).show();
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_APP_CODE) {
            if (resultCode == RESULT_OK) {
                // mostrar els bytes rebuts de l'intent
                imatge.setImageBitmap((Bitmap) data.getExtras().get("data"));
//                try {
//                    // mostrar el fitxer que ha desat l'app de captura
//                    imatge.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(),
//                            Uri.fromFile(tempImageFile)));
//                } catch (FileNotFoundException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    // TODO he de gestionar els errors
//                    e.printStackTrace();
//                }
            }
        }
    }

    public void onClickLoggin(View v) {
        // entrara a l'aplicació miran si te els nom i cognom entrats, i si s'ha fet la foto

        TextView nom = (TextView) findViewById(R.id.editTextNom);
        TextView cognom = (TextView) findViewById(R.id.editTextCognom);

        if (!(nom.getText().toString().equals("") || cognom.getText().toString().equals("") || imatge.getDrawable() == null)) {
            //entrar a l'aplicació
            setContentView(R.layout.activity_menu);

        } else {
            //torrada per dir que falta alguna cosa.
            Toast.makeText(this, R.string.torradaMain, Toast.LENGTH_LONG).show();
        }
    }
}
