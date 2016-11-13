package br.unifor.cores;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private View mCores;
    private Button mAlterarCor;
    private int mVermelho;
    private int mVerde;
    private int mAzul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVermelho = 0;
        mVerde = 0;
        mAzul = 0;

        mCores = findViewById(R.id.main_cores);
        mCores.setBackgroundColor(Color.argb(255, mVermelho, mVerde, mAzul));


        mAlterarCor = (Button) findViewById(R.id.main_alterar_cor);
        mAlterarCor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(MainActivity.this, CorActivity.class);
                it.putExtra("vermelho", mVermelho);
                it.putExtra("azul", mAzul);
                it.putExtra("verde", mVerde);

                startActivityForResult(it, REQUEST_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){

            case REQUEST_CODE:
                if(resultCode == RESULT_OK){
                    mVermelho = data.getIntExtra("vermelho",0);
                    mVerde = data.getIntExtra("verde",0);
                    mAzul = data.getIntExtra("azul",0);
                    mCores.setBackgroundColor(Color.argb(255, mVermelho, mVerde, mAzul));
                }
                break;

        }


    }
}
