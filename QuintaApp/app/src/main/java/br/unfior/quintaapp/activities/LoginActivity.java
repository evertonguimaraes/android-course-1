package br.unfior.quintaapp.activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.unfior.quintaapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsername;
    private EditText mPassword;
    private TextView mSingon;
    private Button mSingin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recuperar as referências dos objetos visuais
        mUsername = (EditText) findViewById(R.id.login_edittext_username);
        mPassword = (EditText) findViewById(R.id.login_edittext_pasword);
        mSingon = (TextView) findViewById(R.id.login_textview_singon);
        mSingin = (Button) findViewById(R.id.login_button_singin);

        // Ouvindo evento de click
        mSingin.setOnClickListener(this);
        mSingon.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.login_textview_singon:
                //TODO: Clique do text view
                break;

            case R.id.login_button_singin:

                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();

                boolean isValid = true;

                if(username.isEmpty()){
                    mUsername
                            .setError("O nome de usuário não pode ser vazio.");
                    isValid = false;
                }

                if(password.isEmpty()){
                    mPassword.setError("A senha não pode ser vazia.");
                    isValid = false;
                }

                if (isValid){

                    // TODO: Realizar login

                } else {
                    Snackbar.make(view,
                            "Preencha os campos solicitados.",
                            Snackbar.LENGTH_SHORT).show();
                }




                break;
        }

    }
}
