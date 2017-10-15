package br.com.italoqueiroz.escolapp.Atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.italoqueiroz.escolapp.Classes.Escola;
import br.com.italoqueiroz.escolapp.Classes.EscolaAdapter;
import br.com.italoqueiroz.escolapp.R;

public class ListaEscolas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_escolas);


        ArrayList<Escola> escolas = new ArrayList<Escola>();
        escolas.add(new Escola("Escola um"));
        escolas.add(new Escola("Escola dois"));
        escolas.add(new Escola("Escola trê"));
        escolas.add(new Escola("Escola quatro"));
        escolas.add(new Escola("Escola cinco"));
        escolas.add(new Escola("Escola seis"));
        escolas.add(new Escola("Escola sete"));
        escolas.add(new Escola("Escola oito"));
        escolas.add(new Escola("Escola nove"));
        escolas.add(new Escola("Escola dez"));
        escolas.add(new Escola("Escola onze"));
        escolas.add(new Escola("Escola doze"));


        EscolaAdapter adapter = new EscolaAdapter(this, escolas);

        ListView listView = (ListView) findViewById(R.id.lista_escolas);

        listView.setAdapter(adapter);
    }
}
