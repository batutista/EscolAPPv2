package br.com.italoqueiroz.escolapp.Atividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.italoqueiroz.escolapp.R;

public class MostraEscola extends AppCompatActivity {

    private TextView nome_escola_textView;
    private TextView email_escola_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_escola);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        nome_escola_textView = (TextView)findViewById(R.id.mostra_escola_nome);
        nome_escola_textView.setText(bundle.getString("nome_escola"));

        email_escola_textView = (TextView)findViewById(R.id.mostra_escola_email);
        email_escola_textView.setText(bundle.getString("email_escola"));


    }
}
