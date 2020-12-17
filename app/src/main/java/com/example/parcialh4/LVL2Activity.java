package com.example.parcialh4;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parcialh4.entidad.PartidaGuardada;

import java.util.Random;
//import android.content.Intent;

public class LVL2Activity extends Activity implements View.OnClickListener {
    private ImageView img;
    public static Random generador = new Random();
    public static final Integer[] imagenes = {R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6
            , R.drawable.i7, R.drawable.i8, R.drawable.i9};

    private ImageView b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private MediaPlayer mediaplayer;

    private ImageView v1,v2,v3;

    private TextView txtpuntaje;

    public static Integer oportunidad = 3;
    public static Integer puntos ;

    public Integer contador = 0;

    public static int num_image = 0;

    TextView personaje;

    public Integer nivel2=2;

    public static String heroe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_lvl);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);

        img = findViewById(R.id.imagen);

        txtpuntaje = findViewById(R.id.puntaje);
        personaje = findViewById(R.id.id_personaje);



        v1=findViewById(R.id.vida1);
        v2=findViewById(R.id.vida2);
        v3=findViewById(R.id.vida3);

        v3.setVisibility(View.VISIBLE);
        v2.setVisibility(View.VISIBLE);
        v1.setVisibility(View.VISIBLE);


        //LLAMADA AL INTENT ENVIADO DESDE EL LEVEL1
        Intent intent = getIntent();
        heroe = intent.getStringExtra("heroe");

        iniciar_valores();
        personaje.setText(heroe);
        txtpuntaje.setText(puntos.toString());
        img_alea();


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Integer n1 = 1;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s1);
                mediaplayer.start();
                verificar(n1);
                img_alea();
                ver_puntaje();
                break;
            case R.id.button2:
                Integer n2 = 2;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s2);
                mediaplayer.start();
                verificar(n2);
                img_alea();
                ver_puntaje();
                break;
            case R.id.button3:
                Integer n3 = 3;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s3);
                mediaplayer.start();
                verificar(n3);
                img_alea();
                ver_puntaje();
                break;
            case R.id.button4:
                Integer n4 = 4;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s4);
                mediaplayer.start();
                verificar(n4);
                img_alea();
                ver_puntaje();
                break;
            case R.id.button5:
                Integer n5 = 5;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s5);
                mediaplayer.start();
                verificar(n5);
                img_alea();
                ver_puntaje();
                break;
            case R.id.button6:
                Integer n6 = 6;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s6);
                mediaplayer.start();
                verificar(n6);
                img_alea();
                ver_puntaje();
                break;
            case R.id.button7:
                Integer n7 = 7;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s7);
                mediaplayer.start();
                verificar(n7);
                img_alea();
                ver_puntaje();
                break;
            case R.id.button8:
                Integer n8 = 8;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s8);
                mediaplayer.start();
                verificar(n8);
                img_alea();
                ver_puntaje();
                break;
            case R.id.button9:
                Integer n9 = 9;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s9);
                mediaplayer.start();
                verificar(n9);
                img_alea();
                ver_puntaje();
                break;
        }
    }

    public void ver_puntaje() {

        String pt = txtpuntaje.getText().toString();
        Log.d("s", pt);
        if (pt.equals("20")) {
            mediaplayer = MediaPlayer.create(this, R.raw.ac3);
            mediaplayer.start();

            BDSQLite admin=new BDSQLite(this,"referencias",null,1);
            SQLiteDatabase db=admin.getReadableDatabase();

            ContentValues registro=new ContentValues();
            registro.put("personaje",heroe);
            registro.put("actividad",3);
            registro.put("puntaje",puntos+1);


            db.update("partidaguardada",registro,"personaje='"+heroe+"'",null);
            db.close();

            Intent mostrar = new Intent(this, LVL3Activity.class);
            mostrar.putExtra("heroe",heroe);
            startActivity(mostrar);
        }
    }

    public void verificar(Integer nv) {
        Log.d("s", nv + "    " + contador);
        Log.d("s", nv + "nuemero imagen" + num_image);
        Log.d("s", "oportunidad"+oportunidad);
        //num_image+=1;
        if (num_image != nv) {
            mediaplayer = MediaPlayer.create(this, R.raw.fallo);
            mediaplayer.start();
            contador -= 1;
            oportunidad -= 1;
            if(oportunidad==2)
            {
                v3.setVisibility(View.INVISIBLE);
            }
            else if(oportunidad==1)
            {
                v3.setVisibility(View.INVISIBLE);
                v2.setVisibility(View.INVISIBLE);
            }
        } else {
            puntos += 1;

            BDSQLite admin=new BDSQLite(this,"referencias",null,1);
            SQLiteDatabase db=admin.getReadableDatabase();

            ContentValues registro=new ContentValues();
            registro.put("personaje",heroe);
            registro.put("actividad",nivel2);
            registro.put("puntaje",puntos);


            db.update("partidaguardada",registro,"personaje='"+heroe+"'",null);
            db.close();
        }
        if (oportunidad == 0) {
            reinicio();
        }
        llenado_txt();
    }

    public void reinicio() {
        Integer op = 3;
      //  Integer pu = 11;
        Integer con = 0;

        Intent mostrar = new Intent(this, LVL2Activity.class);
        mostrar.putExtra("oportunidad", op);
        //mostrar.putExtra("puntaje", pu);
        mostrar.putExtra("contador", con);
        mostrar.putExtra("heroe",heroe);
        startActivity(mostrar);

    }

    public void llenado_txt() {
        txtpuntaje.setText(puntos.toString());
        //txtoportunidad.setText(oportunidad.toString());
    }

    public void iniciar_valores() {
        BDSQLite admin=new BDSQLite(this,"referencias",null,1);
        SQLiteDatabase db=admin.getReadableDatabase();

        PartidaGuardada ptg;
        ptg=new PartidaGuardada();

        Cursor fila= db.rawQuery("select * from"+
                " partidaguardada where personaje ='"+heroe+"'",null);
        if(fila.moveToFirst())
        {

            ptg.setId(fila.getInt(0));
            ptg.setPersonaje(fila.getString(1));
            ptg.setActividad(fila.getInt(2));
            ptg.setPuntaje(fila.getInt(3));
        }

        Intent intent = getIntent();
        oportunidad = intent.getIntExtra("oportunidad", 3);
        puntos = ptg.getPuntaje();
        contador = intent.getIntExtra("contador", 0);
        db.close();
    }

    public void img_alea() {
        int ale = generador.nextInt(imagenes.length - 1 + 1);
        int g = imagenes[ale];

        Log.d("generado", "  " + ale);
        Log.d("tamano", "  " + imagenes.length);
        img.setImageResource(g);
        num_image = ale + 1;
        Log.d("numero_imagene", "  " + num_image);
    }
}
