package com.example.parcialh4;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Final extends AppCompatActivity{


    private Button inicio;



    public static String heroe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.termina);


        inicio=findViewById(R.id.idinicio);

        //LLAMADA AL INTENT ENVIADO DESDE EL LEVEL3
        Intent intent = getIntent();
        heroe = intent.getStringExtra("heroe");

        BDSQLite admin= new BDSQLite(this,"referencias",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        db.delete("partidaguardada","personaje= '"+heroe+"'", null);
        db.close();
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirInicio();
            }
        });
    }
    public void abrirInicio()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}