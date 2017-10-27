package br.com.italoqueiroz.escolapp.Atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.italoqueiroz.escolapp.R;

public class Acessar extends AppCompatActivity {

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acessar);

        Button botaoMapas = (Button) findViewById(R.id.buttonMapas);
        botaoMapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapas = new Intent(Acessar.this, MapasEscolas.class);
                startActivity(mapas);
            }
        });

        Button listaEscolas = (Button)findViewById(R.id.buttonListaEscolas);
        listaEscolas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listaEscolaIntent = new Intent(Acessar.this, ListaEscolas.class);
                startActivity(listaEscolaIntent);
            }
        });
    }



}
