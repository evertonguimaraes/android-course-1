package br.unifor.primeiraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    private TextView mTextViewMensagem;
    private TextView mTextViewResposta;
    private EditText mEditTextNome;
    private Button mButtonCliqueAqui;
    private Button mMainButtonWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResposta = (TextView) findViewById(R.id.textView2);
        mEditTextNome = (EditText) findViewById(R.id.editText1);
        mButtonCliqueAqui = (Button) findViewById(R.id.button1);

        mButtonCliqueAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = mEditTextNome.getText().toString();
                mTextViewResposta.setText("Olá "+nome+"Bem vindo ao curso de Android");
            }
        });

        mMainButtonWelcome = (Button) findViewById(R.id.main_button_welcome);
        mMainButtonWelcome.setOnLongClickListener(this);

        Log.i("App", "método onCreate() chamado");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("App", "método onRestart() chamado");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("App", "método onStart() chamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("App", "método onResume() chamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("App", "método onPause() chamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("App", "método onStop() chamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("App", "método onDestroy() chamado");
    }

    @Override
    public boolean onLongClick(View v) {

        switch (v.getId()){
            case R.id.main_button_welcome:

                Intent it = new Intent(this, SecondaryActivity.class);
                startActivity(it);

                break;
        }

        return false;
    }
}
