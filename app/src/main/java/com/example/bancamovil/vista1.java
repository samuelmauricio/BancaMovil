package com.example.bancamovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class vista1 extends AppCompatActivity {

    private Button cancelar;
    private Button ingresar;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista1);

        cancelar = (Button) findViewById(R.id.btnCancelar);
        ingresar = (Button) findViewById(R.id.btnIngresar);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(vista1.this, MainActivity.class));
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtnum1 = (EditText) findViewById(R.id.etnum1);
                EditText txtnum2 = (EditText) findViewById(R.id.etnum2);
                EditText txtnum3 = (EditText) findViewById(R.id.etnum3);
                EditText txtnum4 = (EditText) findViewById(R.id.etnum4);

                String digitos = txtnum1.getText().toString()+txtnum2.getText().toString()+txtnum3.getText().toString()+txtnum4.getText().toString();

                EditText claveInter = (EditText) findViewById(R.id.et_clave_internet);

                Cursor cursor = helper.consultarUsu(digitos,claveInter.getText().toString());
                if (cursor.getCount()>0){
                    startActivity(new Intent(vista1.this, services.class));
                }else {
                    Toast.makeText(getApplicationContext(), "Tarjeta y/o Clave de internet incorrectos",
                            Toast.LENGTH_LONG).show();
                }
                txtnum1.setText("");
                txtnum2.setText("");
                txtnum3.setText("");
                txtnum4.setText("");
                claveInter.setText("");
                claveInter.findFocus();
            }
        });
    }
}
