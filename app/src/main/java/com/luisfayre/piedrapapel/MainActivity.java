package com.luisfayre.piedrapapel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button piedra, papel, tijeras;
    private ImageView cpu, jugador;
    String jugadorEleccion, cpuEleccion, resultado;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpu = (ImageView) findViewById(R.id.iv_cpu);
        jugador = (ImageView) findViewById(R.id.iv_player);

        piedra = (Button) findViewById(R.id.button_piedra);
        papel = (Button) findViewById(R.id.button_papel);
        tijeras = (Button) findViewById(R.id.button_tijeras);

        r = new Random();
        piedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugadorEleccion = "piedra";
                jugador.setImageResource(R.drawable.piedra);
                calcular();
            }
        });
        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugadorEleccion = "papel";
                jugador.setImageResource(R.drawable.papel);
                calcular();
            }
        });
        tijeras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugadorEleccion = "tijeras";
                jugador.setImageResource(R.drawable.tijeras);
                calcular();
            }
        });


    }

    public void calcular() {
        int cpur = r.nextInt(3);

        if(cpur == 0){
            cpuEleccion = "piedra";
            cpu.setImageResource(R.drawable.piedra);
        }else if(cpur == 1){
            cpuEleccion = "papel";
            cpu.setImageResource(R.drawable.papel);
        }else if (cpur == 2) {
            cpuEleccion = "tijeras";
            cpu.setImageResource(R.drawable.tijeras);
        }
        //Piedra
        if (jugadorEleccion.equals("piedra") && cpuEleccion.equals("papel")){
            resultado = "Perdiste";

        }
        if (jugadorEleccion.equals("piedra") && cpuEleccion.equals("tijeras")){
            resultado = "Ganaste";

        }
        if (jugadorEleccion.equals("piedra") && cpuEleccion.equals("piedra")){
            resultado = "Empate";

        }

        //Papel
        if (jugadorEleccion.equals("papel") && cpuEleccion.equals("papel")){
            resultado = "Empate";

        }
        if (jugadorEleccion.equals("papel") && cpuEleccion.equals("tijeras")){
            resultado = "Perdiste";

        }
        if (jugadorEleccion.equals("papel") && cpuEleccion.equals("piedra")){
            resultado = "Ganaste";

        }
        //Tijeras
        if (jugadorEleccion.equals("tijeras") && cpuEleccion.equals("papel")){
            resultado = "Ganaste";

        }
        if (jugadorEleccion.equals("tijeras") && cpuEleccion.equals("tijeras")){
            resultado = "Empate";

        }
        if (jugadorEleccion.equals("tijeras") && cpuEleccion.equals("piedra")){
            resultado = "Perdiste";

        }

        Toast.makeText(MainActivity.this, resultado, Toast.LENGTH_SHORT).show();
    }
    }



