package br.com.italoqueiroz.escolapp.Classes;

/**
 * Created by batut on 29/10/2017.
 */

public class User {
    public String nome;
    public String sobrenome;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String nomeC, String sobrenomeC) {
        this.nome = nomeC;
        this.sobrenome = sobrenomeC;
    }
}
