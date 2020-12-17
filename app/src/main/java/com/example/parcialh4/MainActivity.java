package com.example.parcialh4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.parcialh4.entidad.PartidaGuardada;

public class MainActivity extends AppCompatActivity {

    private ImageButton pj1;
    private ImageButton pj2;
    private ImageButton pj3;
    private ImageButton pj4;
    private ImageButton pj5;
    private ImageButton pj6;
    private ImageButton pj7;
    private ImageButton pj8;
    public String heroe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pj1 = findViewById(R.id.ironman);
        pj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heroe = "Ironman";
                consultarEinsertar(heroe);
               // abrirLVL1(heroe);
            }
        });

        pj2 = findViewById(R.id.batman);
        pj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heroe = "Batman";
                consultarEinsertar(heroe);
                //abrirLVL1(heroe);
            }
        });

        pj3 = findViewById(R.id.superman);
        pj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heroe = "Superman";
                consultarEinsertar(heroe);
               // abrirLVL1(heroe);
            }
        });

        pj4 = findViewById(R.id.deku);
        pj4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heroe = "Deku";
                consultarEinsertar(heroe);
                //abrirLVL1(heroe);
            }
        });

        pj5 = findViewById(R.id.spiderman);
        pj5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heroe = "Spiderman";
                consultarEinsertar(heroe);
                //abrirLVL1(heroe);
            }
        });

        pj6 = findViewById(R.id.goku);
        pj6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heroe = "Goku";
                consultarEinsertar(heroe);
                //abrirLVL1(heroe);
            }
        });

        pj7 = findViewById(R.id.flash);
        pj7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heroe = "Flash";
                consultarEinsertar(heroe);
               // abrirLVL1(heroe);
            }
        });

        pj8 = findViewById(R.id.naruto);
        pj8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heroe = "Naruto";
                consultarEinsertar(heroe);
                //abrirLVL1(heroe);
            }
        });
    }

    public void abrirLVL1(String heroe){
        Intent intent = new Intent(this,LVL1Activity.class);
        intent.putExtra("heroe",heroe);
        startActivity(intent);
    }
    public void consultarEinsertar(String heroe)
    {
        BDSQLite admin=new BDSQLite(this,"referencias",null,1);
        SQLiteDatabase db=admin.getReadableDatabase();

        PartidaGuardada ptg;

        Cursor fila= db.rawQuery("select * from"+
                " partidaguardada where personaje ='"+heroe+"'",null);
        if(fila.moveToFirst())
        {
            ptg=new PartidaGuardada();
            ptg.setId(fila.getInt(0));
            ptg.setPersonaje(fila.getString(1));
            ptg.setActividad(fila.getInt(2));
            ptg.setPuntaje(fila.getInt(3));

            Integer activ=ptg.getActividad();
            Log.d("s","aqiii nivel xdd"+activ.toString());
            if(activ==1)
            {
                Intent intent = new Intent(this,LVL1Activity.class);
                intent.putExtra("heroe",heroe);
                startActivity(intent);
            }
            if(activ==2)
            {
                Intent intent = new Intent(this,LVL2Activity.class);
                intent.putExtra("heroe",heroe);
                startActivity(intent);
            }
            if(activ==3)
            {
                Intent intent = new Intent(this,LVL3Activity.class);
                intent.putExtra("heroe",heroe);
                startActivity(intent);
            }
            if(activ==4)
            {
                Intent intent = new Intent(this,Final.class);
                intent.putExtra("heroe",heroe);
                startActivity(intent);
            }
        }
        else
        {
            ContentValues registro=new ContentValues();
            registro.put("personaje",heroe);
            registro.put("actividad",1);
            registro.put("puntaje",1);

            db.insert("partidaguardada",null,registro);
            db.close();
        }
    }
}