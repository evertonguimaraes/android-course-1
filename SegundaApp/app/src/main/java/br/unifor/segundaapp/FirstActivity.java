package br.unifor.segundaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.unifor.segundaapp.model.Aluno;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG_I = "TAG_I";

    private EditText mEditTextNome;
    private EditText mEditTextTelefone;
    private EditText mEditTextEndereco;
    private EditText mEditTextEmail;

    private Button mButtonLimpar;
    private Button mButtonMensagem;

    private Aluno contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first_activity);

        mEditTextNome = (EditText) findViewById(R.id.editTextNome);
        mEditTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        mEditTextEndereco = (EditText) findViewById(R.id.editTextEndereco);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);

        mButtonLimpar = (Button) findViewById(R.id.buttonLimpar);
        mButtonMensagem = (Button) findViewById(R.id.buttonMensagem);


        Intent it = getIntent();
        if(it != null){

            contato = (Aluno) it.getSerializableExtra("contatoSelecionado");
            if(contato != null){
                mEditTextNome.setText(contato.getNome());
                mEditTextTelefone.setText(contato.getTelefone());
                mEditTextEmail.setText(contato.getEmail());
                mEditTextEndereco.setText(contato.getEndereco());
            }

        }

        // Criando um evento instanciando diretamente na activity
        mButtonMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = "Nome: "+contato.getNome()+
                        ", Telefone: "+contato.getTelefone()+
                        ", Email: "+ contato.getEmail();

                // Criando um Toast para exibir uma mensagem rápida da tela
                Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
            }
        });

        mButtonLimpar.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonLimpar:

                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setCancelable(false)
                        .setMessage("Voce realmente deseja limpar os campos?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                mEditTextNome.setText("");
                                mEditTextTelefone.setText("");
                                mEditTextEndereco.setText("");
                                mEditTextEmail.setText("");

                                dialogInterface.dismiss();

                            }
                        })
                        .setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();


                break;
            default:
                Log.i(TAG_I, "Mensagem");
        }
    }
}
