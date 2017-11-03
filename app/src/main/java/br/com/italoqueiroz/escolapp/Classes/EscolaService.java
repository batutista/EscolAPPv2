package br.com.italoqueiroz.escolapp.Classes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.facebook.HttpMethod.GET;

/**
 * Created by batut on 02/11/2017.
 */

public interface EscolaService {

    @GET("escolas")
    Call<List<Escola>> getEscola();
}
