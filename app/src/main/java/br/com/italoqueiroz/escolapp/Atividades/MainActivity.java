package br.com.italoqueiroz.escolapp.Atividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.italoqueiroz.escolapp.R;

public class MainActivity extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPassword;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = (EditText) findViewById(R.id.acessar_login);
        txtPassword = (EditText) findViewById(R.id.acessar_senha);

        mAuth = FirebaseAuth.getInstance();





        Button botaoAcessar = (Button) findViewById(R.id.buttonAcessar);
        botaoAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInWithEmailAndPassword(txtUser.getText().toString(), txtPassword.getText().toString())
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(!task.isSuccessful()){
                                    Toast.makeText(MainActivity.this, "Usuario ou senha inválido", Toast.LENGTH_LONG).show();
                                }else {
                                    FirebaseUser user = task.getResult().getUser();
                                    if(user != null){
                                        Intent cadastrar = new Intent(MainActivity.this, Acessar.class);
                                        startActivity(cadastrar);
                                        finish();
                                    }
                                }
                            }
                        });

            }
        });

        Button botaoCadastrar = (Button) findViewById(R.id.buttonCadastrar);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acessar = new Intent(MainActivity.this, Cadastrar.class);
                startActivity(acessar);
            }
        });




    }

}
