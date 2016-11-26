package br.unfior.quintaapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.unfior.quintaapp.model.User;
import br.unfior.quintaapp.repository.UserRepository;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mName;
    private EditText mUsername;
    private EditText mPassword;
    private Button mSave;

    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mName = (EditText) findViewById(R.id.singin_edittext_name);
        mUsername = (EditText) findViewById(R.id.singin_edittext_username);
        mPassword = (EditText) findViewById(R.id.singin_edittext_password);
        mSave = (Button) findViewById(R.id.singin_button_save);

        mSave.setOnClickListener(this);

        userRepository = UserRepository.getInstance();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.singin_button_save:

                String name = mName.getText().toString();
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();

                boolean isValid = true;

                if(name.isEmpty()){
                    mName.setError("O campo nome não pode ser vazio;");
                    isValid = false;
                }

                if(username.isEmpty()){
                    mUsername.setError("O campo usuário não pode ser vazio;");
                    isValid = false;
                }

                if(password.isEmpty()){
                    mPassword.setError("O campo senha não pode ser vazio;");
                    isValid = false;
                }

                if(isValid){

                    User user = new User(name, username, password);
                    userRepository.insert(user);

                    Snackbar.make(view,
                            "Usuário cadastrado com sucesso",
                            Snackbar.LENGTH_SHORT).show();

                    finish();

                } else {
                    Snackbar.make(view,
                            "Por favor preencha os campos com erros.",
                            Snackbar.LENGTH_SHORT).show();
                }

                break;

        }

    }
}
