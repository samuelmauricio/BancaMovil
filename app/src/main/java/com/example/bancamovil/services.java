package com.example.bancamovil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class services extends AppCompatActivity {

    BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;
    boolean esconderFab = true;
    boolean moverFab = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        bottomAppBar = findViewById(R.id.bottomBar);
        //indicamos que bottomAppBar va a ser el toolbar o barra de herramientas
        //para asi poner los iconos del menu ahi
        setSupportActionBar(bottomAppBar);

        floatingActionButton = findViewById(R.id.fabBottomBar);

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (esconderFab){
                    floatingActionButton.hide();
                    esconderFab = false;
                }else {
                    floatingActionButton.show();
                    esconderFab = true;
                }
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (moverFab){
                    bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                    moverFab = false;
                }else {
                    bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                    moverFab = true;
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.transferencias:
                Toast.makeText(this,"Transferencia seleccionada", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(services.this, Transferencias.class));
                break;
            case R.id.ptc:
                Toast.makeText(this,"Pago de Tarjetas de Crédito seleccionada", Toast.LENGTH_SHORT).show();
                break;
            case R.id.registro:
                Toast.makeText(this,"Registro de Usuarios seleccionada", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(services.this, registro.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);

        return true;
    }
}
