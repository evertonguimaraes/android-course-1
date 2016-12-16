package br.unifor.setimaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import br.unifor.setimaapp.database.DataBaseHelper;
import br.unifor.setimaapp.model.IModel;

/**
 * Created by Everton on 12/10/16.
 */

public abstract class GenericDAO <T extends IModel> {

    private static final String TABLE_COURSES = "course";
//    private static final String TABLE_CATEGORY = "category";

    protected SQLiteDatabase mDatabase;

    public GenericDAO(Context context) {

        DataBaseHelper agendaHelper = new DataBaseHelper(context);
        mDatabase = agendaHelper.getWritableDatabase();

    }

    // Método para inserção no banco
    public void insert(T obj) {

        mDatabase.insert(TABLE_COURSES,
                null,
                getContentValues(obj));

        Log.i("INSERT", obj.toString());
    }

    // Método para atualização no banco
    public void update(T obj){
        mDatabase.update(TABLE_COURSES,
                getContentValues(obj),
                "id = ?",
                new String[]{obj.getId().toString()});

        Log.i("UPDATE", obj.toString());
    }

    // Método para remover do banco
    public void delete(T obj){
        mDatabase.delete(TABLE_COURSES,
                "id = ?",
                new String[]{obj.getId().toString()});

        Log.i("DELETE", obj.toString());
    }

    public abstract List<T> findAll();

    public abstract T find (T obj);

    public abstract ContentValues getContentValues(T obj);
}
