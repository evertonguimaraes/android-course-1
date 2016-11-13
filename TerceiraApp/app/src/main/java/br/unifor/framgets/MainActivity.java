package br.unifor.framgets;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Point;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();

        Point displaySize = new Point();
        display.getSize(displaySize);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(displaySize.y > displaySize.x){
            //TODO: Modo retrato
            Fragment1 f1 = new Fragment1();
            ft.replace(R.id.main_content, f1);
        } else {
            //TODO: Modo paisagem
            Fragment2 f2 = new Fragment2();
            ft.replace(R.id.main_content, f2);
        }

        ft.commit();

    }
}
