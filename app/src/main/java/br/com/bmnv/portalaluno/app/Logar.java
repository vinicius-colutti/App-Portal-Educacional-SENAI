package br.com.bmnv.portalaluno.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

/**
 * Created by 16165895 on 03/04/2017.
 */

public class Logar extends AppCompatActivity {

    EditText edit_cpf, edit_senha;
    Button botao_logar;


    String url = "";
    String parametros = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        botao_logar = (Button) findViewById(R.id.btn_logar);
        edit_cpf = (EditText) findViewById(R.id.edit_cpf);
        edit_senha = (EditText) findViewById(R.id.edit_senha);






    }

    public void logar(View view) {
        getAplication(edit_cpf.getText().toString(), edit_senha.getText().toString());

    }


    private void getAplication(final String cpf, final String senha ) {
        botao_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()){



                    if(cpf.isEmpty() || senha.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio", Toast.LENGTH_LONG).show();

                    }else{
                        url = "http://10.107.144.7/login/logar.php";

                        parametros = "email=" + cpf +"&senha=" + senha;


                        new SolicitaDados().execute(url);


                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();

                }



            }
        });
    }



    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls){


            return Conexao.postDados(urls[0], parametros);

        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String resultado){

            //edit_login.setText(resultado);


            if(resultado.contains("login_ok")){

                String[] dados = resultado.split(",");
                //edit_login.setText(dados[0] + " - " + dados[1]);

                Intent abreInicio = new Intent(Logar.this, HomeActivity.class);
                abreInicio.putExtra("id", dados[1]);
                abreInicio.putExtra("email", dados[2]);
                startActivity(abreInicio);


            }else{

                Toast.makeText(getApplicationContext(), "Usuário ou senha incorretos", Toast.LENGTH_LONG).show();


            }


        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}

