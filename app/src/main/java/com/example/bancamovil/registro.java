package com.example.bancamovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class registro extends AppCompatActivity {

    Button btnGraubarUsu;
    EditText txtNomUsu, txtTrajeta, txtClave_internet;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnGraubarUsu = (Button) findViewById(R.id.btnRegistraUsu);
        txtNomUsu = (EditText) findViewById(R.id.txtNomUsu);
        txtTrajeta = (EditText) findViewById(R.id.txtTrajeta);
        txtClave_internet = (EditText) findViewById(R.id.txtClave_internet);

        btnGraubarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.abrir();
                helper.insertarReg(String.valueOf(txtNomUsu.getText()),
                        String.valueOf(txtTrajeta.getText()),
                        String.valueOf(txtClave_internet.getText()));
                helper.cerrar();
                Toast.makeText(getApplicationContext(), "Registro almacenado con exito",
                        Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}
