package br.com.italoqueiroz.escolapp.Atividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.italoqueiroz.escolapp.Classes.Escola;
import br.com.italoqueiroz.escolapp.Classes.EscolaAdapter;
import br.com.italoqueiroz.escolapp.Classes.EscolaService;
import br.com.italoqueiroz.escolapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaEscolas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_escolas);

/*
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
        */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mobile-aceite.tcu.gov.br/nossaEscolaRS/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EscolaService service = retrofit.create(EscolaService.class);
        Call<List<Escola>> call = service.getEscola();

        call.enqueue(new Callback<List<Escola>>() {

            public static final String TAG = "italo" ;

            @Override
            public void onResponse(Call<List<Escola>> call, retrofit2.Response<List<Escola>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ListaEscolas.this, "Response teve sucesso", Toast.LENGTH_SHORT).show();
                    List<Escola> escolas = response.body();

                    EscolaAdapter adapter = new EscolaAdapter(ListaEscolas.this, escolas);

                    ListView listView = (ListView) findViewById(R.id.lista_escolas);

                    listView.setAdapter(adapter);
                }else{
                    Toast.makeText(ListaEscolas.this, "Response não teve sucesso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Escola>> call, Throwable throwable) {
                Toast.makeText(ListaEscolas.this, "Não foi possível realizar a requisição", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
