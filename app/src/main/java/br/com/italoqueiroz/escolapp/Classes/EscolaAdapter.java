package br.com.italoqueiroz.escolapp.Classes;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.italoqueiroz.escolapp.R;
import retrofit2.Callback;

/**
 * Created by batut on 15/10/2017.
 */

public class EscolaAdapter extends ArrayAdapter<Escola> {

    public EscolaAdapter(@NonNull Context context, @NonNull List<Escola> objects) {
        super(context, 0, objects);
    }

/*
    public EscolaAdapter(Callback<List<Escola>> context, List<Escola> arrayWord) {
        super(context, 0, arrayWord);
    }
    */


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_escolas, parent, false);
        }


        Escola currentEscola = getItem(position);

        TextView nomeEscola = (TextView) listItemView.findViewById(R.id.nome_da_escola);
        TextView emailEscola = (TextView) listItemView.findViewById(R.id.email_da_escola) ;

        nomeEscola.setText(currentEscola.getNome());
        emailEscola.setText(currentEscola.getEmail());

        return listItemView;
    }
}
