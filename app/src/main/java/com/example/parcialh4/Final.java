package com.example.parcialh4;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Final extends AppCompatActivity{

    private TextView txtoportunidad;
    private TextView txtpuntaje;
    private TextView txtTiempo;

    TextView personaje;

    public static String heroe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.termina);


        txtoportunidad = findViewById(R.id.idpersonaje);
        txtpuntaje = findViewById(R.id.idpuntaje);
        txtTiempo = findViewById(R.id.idTiempo);

        personaje = findViewById(R.id.idpersonaje);

        //LLAMADA AL INTENT ENVIADO DESDE EL LEVEL3
        Intent intent = getIntent();
        heroe = intent.getStringExtra("heroe");

        personaje.setText(heroe);
        BDSQLite admin= new BDSQLite(this,"referencias",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

            db.delete("partidaguardada","personaje= '"+heroe+"'", null);
            db.close();

    }
}