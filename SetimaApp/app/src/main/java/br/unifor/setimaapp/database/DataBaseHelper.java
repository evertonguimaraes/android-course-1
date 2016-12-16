package br.unifor.setimaapp.database;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Everton on 12/10/16.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "matriculas.db";

    private static final int DATABASE_VERSION = 1;

    private Context context;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        readWriteSQL(db, "db/create.sql");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        readWriteSQL(db, "db/update.sql");
        onCreate(db);
    }

    public void readWriteSQL(SQLiteDatabase db, String path) {

        try {

            String sqlLine = null;

            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(path);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            while((sqlLine = reader.readLine()) != null){
                db.execSQL(sqlLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
