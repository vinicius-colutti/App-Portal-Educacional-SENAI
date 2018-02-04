package br.com.bmnv.portalaluno.app;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends  Fragment  {

    EditText edit_cpf, edit_senha;
    Button btn_logar;

    String url = "";
    String parametros = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login, container, false);

        edit_cpf = (EditText)rootView.findViewById(R.id.edit_cpf);
        edit_senha = (EditText)rootView.findViewById(R.id.edit_senha);
        btn_logar = (Button)rootView.findViewById(R.id.btn_logar);


        getAplication();



        return rootView;




    }



    private void getAplication() {
        btn_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()){

                    String cpf = edit_cpf.getText().toString();
                    String senha = edit_senha.getText().toString();

                    if(cpf.isEmpty() || senha.isEmpty()){
                        Toast.makeText(getContext(), "Preencha todas os campos", Toast.LENGTH_LONG).show();

                    }else{
                        url = "http://10.107.144.27/login/logar.php";

                        parametros = "email=" + cpf +"&senha=" + senha;


                        new Login.SolicitaDados().execute(url);


                    }
                }else{
                    Toast.makeText(getContext(), "Nenhuma Conexao foi detectada", Toast.LENGTH_LONG).show();

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

                Intent abreInicio = new Intent(getContext(), HomeActivity.class);
                abreInicio.putExtra("id", dados[1]);
                abreInicio.putExtra("email", dados[2]);
                abreInicio.putExtra("curso", dados[3]);
                startActivity(abreInicio);



            }else{

                Toast.makeText(getContext(), "Usuário ou senha incorretos", Toast.LENGTH_LONG).show();


            }

            getActivity().finish();


        }

        }
    }



