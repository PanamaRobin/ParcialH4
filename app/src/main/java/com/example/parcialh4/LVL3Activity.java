package com.example.parcialh4;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parcialh4.entidad.PartidaGuardada;

import java.util.Random;
//import android.content.Intent;

public class LVL3Activity extends Activity implements View.OnClickListener {
    private ImageView img;
    public static Random generador=new Random();
    public static final Integer[] imagenes = {R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6
            , R.drawable.i7, R.drawable.i8, R.drawable.i9};

    private ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    private MediaPlayer mediaplayer;

    private ImageView v1,v2,v3;

    private TextView txtoportunidad;
    private TextView txtpuntaje;
    private TextView txtTiempo;

    public static Integer oportunidad=3;
    public static Integer puntos;

    public  Integer contador=0;
    public Boolean verifcaTiempo=false;

    public static int num_image=0;

    private CountDownTimer timer;

    TextView personaje;

    public Integer nivel3=3;

    public static String heroe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer_lvl);

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
        txtTiempo=findViewById(R.id.idTiempo);
        personaje = findViewById(R.id.id_personaje);

        v1=findViewById(R.id.vida1);
        v2=findViewById(R.id.vida2);
        v3=findViewById(R.id.vida3);

        v3.setVisibility(View.VISIBLE);
        v2.setVisibility(View.VISIBLE);
        v1.setVisibility(View.VISIBLE);


        //LLAMADA AL INTENT ENVIADO DESDE EL LEVEL2
        Intent intent = getIntent();
        heroe = intent.getStringExtra("heroe");
        iniciar_valores();
        txtpuntaje.setText(puntos.toString());
        iniciaContador();


        oportunidad=intent.getIntExtra("oportunidad",3);
        contador=intent.getIntExtra("contador",0);
        personaje.setText(heroe);

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


        //LLAMADA AL INTENT ENVIADO DESDE EL RECYCLER ACTIVITY
        //Intent intent = getIntent();
        //String medicamento = intent.getStringExtra("medicamento");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Integer n1 = 1;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s1);
                mediaplayer.start();
                b1.setImageResource(R.drawable.bear6);
                b1.setEnabled(false);
                comprobarContador();
                ver_puntaje();
                break;
            case R.id.button2:
                Integer n2 = 2;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s2);
                mediaplayer.start();
                b2.setImageResource(R.drawable.bear6);
                b2.setEnabled(false);
                comprobarContador();
                ver_puntaje();
                break;
            case R.id.button3:
                Integer n3 = 3;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s3);
                mediaplayer.start();
                b3.setImageResource(R.drawable.bear6);
                b3.setEnabled(false);
                comprobarContador();
                ver_puntaje();
                break;
            case R.id.button4:
                Integer n4 = 4;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s4);
                mediaplayer.start();
                b4.setImageResource(R.drawable.bear6);
                b4.setEnabled(false);
                comprobarContador();
                ver_puntaje();
                break;
            case R.id.button5:
                Integer n5 = 5;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s5);
                mediaplayer.start();
                b5.setImageResource(R.drawable.bear6);
                b5.setEnabled(false);
                comprobarContador();
                ver_puntaje();
                break;
            case R.id.button6:
                Integer n6 = 6;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s6);
                mediaplayer.start();
                b6.setImageResource(R.drawable.bear6);
                b6.setEnabled(false);
                comprobarContador();
                ver_puntaje();
                break;
            case R.id.button7:
                Integer n7 = 7;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s7);
                mediaplayer.start();
                b7.setImageResource(R.drawable.bear6);
                b7.setEnabled(false);
                comprobarContador();
                ver_puntaje();
                break;
            case R.id.button8:
                Integer n8 = 8;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s8);
                mediaplayer.start();
                b8.setImageResource(R.drawable.bear6);
                b8.setEnabled(false);
                comprobarContador();
                ver_puntaje();
                break;
            case R.id.button9:
                Integer n9 = 9;
                contador += 1;
                mediaplayer = MediaPlayer.create(this, R.raw.s9);
                mediaplayer.start();
                b9.setImageResource(R.drawable.bear6);
                b9.setEnabled(false);
                comprobarContador();
                ver_puntaje();
                break;
        }
    }
    public void resetarImagenes()
    {
        //limpiarlos
        b1.setImageResource(android.R.color.transparent);
        b2.setImageResource(android.R.color.transparent);
        b3.setImageResource(android.R.color.transparent);
        b4.setImageResource(android.R.color.transparent);
        b5.setImageResource(android.R.color.transparent);
        b6.setImageResource(android.R.color.transparent);
        b7.setImageResource(android.R.color.transparent);
        b8.setImageResource(android.R.color.transparent);
        b9.setImageResource(android.R.color.transparent);
        //habilitarlos
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
    }
    public void comprobarContador()
    {
        Log.d("contadorrr","  "+contador);
        if(contador==num_image)
        {
            contador=0;
            puntos +=1;
            BDSQLite admin=new BDSQLite(this,"referencias",null,1);
            SQLiteDatabase db=admin.getReadableDatabase();

            ContentValues registro=new ContentValues();
            registro.put("personaje",heroe);
            registro.put("actividad",nivel3);
            registro.put("puntaje",puntos);


            db.update("partidaguardada",registro,"personaje='"+heroe+"'",null);
            db.close();

            resetarImagenes();
            img_alea();
            // txtTiempo.setText(" ");
            timer.cancel();
            iniciaContador();
        }
        if (oportunidad == 0)
        {
            reinicio();
        }
        if(verifcaTiempo==true)
        {
            //txtTiempo.setText(" ");
            timer.cancel();
            verifcaTiempo=false;
            resetarImagenes();
            iniciaContador();

        }
        llenado_txt();
    }
    public void iniciaContador()
    {
        timer=new CountDownTimer(60000,1000){

            @Override
            public void onTick(long l) {
                txtTiempo.setText("Faltan: "+l/1000);
            }

            @Override
            public void onFinish() {
                //txtTiempo.setText("TERMINE");
                oportunidad -= 1;
                if(oportunidad==2)
                {
                    v3.setVisibility(View.INVISIBLE);
                }
                else if(oportunidad==1)
                {
                    v2.setVisibility(View.INVISIBLE);
                }
                contador=0;

                verifcaTiempo=true;
                img_alea();
                llenado_txt();
                comprobarContador();

            }
        };
        timer.start();
    }
    public void ver_puntaje()
    {

        String pt=txtpuntaje.getText().toString();
        Log.d("s",pt);
        if(pt.equals("30"))
        {
            mediaplayer = MediaPlayer.create(this, R.raw.ac3);
            mediaplayer.start();

            BDSQLite admin=new BDSQLite(this,"referencias",null,1);
            SQLiteDatabase db=admin.getReadableDatabase();

            ContentValues registro=new ContentValues();
            registro.put("personaje",heroe);
            registro.put("actividad",4);
            registro.put("puntaje",puntos);


            db.update("partidaguardada",registro,"personaje='"+heroe+"'",null);
            db.close();

            Intent mostrar = new Intent(this, Final.class);
            mostrar.putExtra("heroe",heroe);
            startActivity(mostrar);
        }
    }
    public void reinicio()
    {
        Integer op=3;
        //Integer pu=21;
        Integer con=0;
        resetarImagenes();
        Intent mostrar= new Intent(this, LVL3Activity.class);
        mostrar.putExtra("oportunidad",op);
        //mostrar.putExtra("puntaje",pu);
        mostrar.putExtra("contador",con);
        mostrar.putExtra("heroe",heroe);

        startActivity(mostrar);

    }
    public void llenado_txt()
    {
        txtpuntaje.setText(puntos.toString());
//        txtoportunidad.setText(oportunidad.toString());
    }
    public void iniciar_valores()
    {
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
        oportunidad = intent.getIntExtra("oportunidad",3);
        puntos = ptg.getPuntaje();
        contador = intent.getIntExtra("contador",0);
        db.close();
    }
    public void img_alea()
    {
        int ale=generador.nextInt(imagenes.length-1+1);
        int g=imagenes[ale];

        Log.d("generado","  "+ale);
        Log.d("tamano","  "+imagenes.length);
        img.setImageResource(g);
        num_image=ale+1;
        decir_numero(num_image);
        Log.d("numero_imagene","  "+num_image);
    }
    public void decir_numero(Integer numero)
    {
        if(numero==1)
        {
            mediaplayer = MediaPlayer.create(this, R.raw.s1);
            mediaplayer.start();
        }else if(numero==2)
        {
            mediaplayer = MediaPlayer.create(this, R.raw.s2);
            mediaplayer.start();
        }else if(numero==3)
        {
            mediaplayer = MediaPlayer.create(this, R.raw.s3);
            mediaplayer.start();
        }else if(numero==4)
        {
            mediaplayer = MediaPlayer.create(this, R.raw.s4);
            mediaplayer.start();
        }else if(numero==5)
        {
            mediaplayer = MediaPlayer.create(this, R.raw.s5);
            mediaplayer.start();
        }else if(numero==6)
        {
            mediaplayer = MediaPlayer.create(this, R.raw.s6);
            mediaplayer.start();
        }else if(numero==7)
        {
            mediaplayer = MediaPlayer.create(this, R.raw.s7);
            mediaplayer.start();
        }else if(numero==8)
        {
            mediaplayer = MediaPlayer.create(this, R.raw.s8);
            mediaplayer.start();
        }else if(numero==9)
        {
            mediaplayer = MediaPlayer.create(this, R.raw.s9);
            mediaplayer.start();
        }
    }
}
