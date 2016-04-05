package net.infobosccoma.cantinadechalmunv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //eric
    }

    public void onClickFoto(View v) {
        //fer foto sense guardar.

    }

    public void onClickLoggin(View v) {
        // entrara a l'aplicació miran si te els nom i cognom entrats, i si s'ha fet la foto

        TextView nom = (TextView) findViewById(R.id.editTextNom);
        TextView cognom = (TextView) findViewById(R.id.editTextCognom);

        if (!(nom.getText().toString().equals("") && cognom.getText().toString().equals(""))) {
            //entrar a l'aplicació
            setContentView(R.layout.activity_menu);

        } else {
            //torrada per dir que falta alguna cosa.

        }

    }
}
