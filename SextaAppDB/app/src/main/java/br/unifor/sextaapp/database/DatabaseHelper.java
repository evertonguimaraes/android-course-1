package br.unifor.sextaapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import br.unifor.sextaapp.model.Course;

/**
 * Created by Everton on 12/2/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "courses.db";

    private static final String TABLE_COURSES = "course";
    // private static final String TABLE_CATEGORIES = "category";

    private static final int DATABASE_VERSION = 2;

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // A String representa o SQL que será executado para a criação de tabelas.
        String sql = "CREATE TABLE " + TABLE_COURSES
                + "(id INTEGER PRIMARY KEY, "
                + "name TEXT, "
                + "working_plan TEXT, "
                + "course_hours TEXT,"
                + "work_shift TEXT);";
        /*
         String sql2 = "CREATE TABLE "+ TABLE_CATEGORIES
              + "(id integer primary key not null,\n" +
              + "name text not null,\n" +
              + "description);";
         */

        db.execSQL(sql);
        // db.execSQL(sql2);

        // OU
        // Realiza a leitura do arquivo para create / update a tabela.
        // readWriteSQL(db, "db/create.sql");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABLE_COURSES;

        db.execSQL(sql);

        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }


    public void readWriteSQL(SQLiteDatabase db, String path) {

       // TODO:
        // Criar a classe AssetManager
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(path);

            // TODO: criar um BufferedReader para processar o arquivo.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
