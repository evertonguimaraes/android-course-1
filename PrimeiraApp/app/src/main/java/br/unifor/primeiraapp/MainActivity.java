package br.unifor.primeiraapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewMensagem;
    private TextView mTextViewResposta;
    private EditText mEditTextNome;
    private Button mButtonCliqueAqui;

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

    }
}
