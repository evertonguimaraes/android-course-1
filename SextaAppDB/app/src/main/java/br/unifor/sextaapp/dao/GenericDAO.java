package br.unifor.sextaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.unifor.sextaapp.database.DatabaseHelper;
import br.unifor.sextaapp.model.Course;
import br.unifor.sextaapp.model.IModel;

/**
 * Created by Everton on 12/3/16.
 */

public abstract class GenericDAO <T extends IModel> {

    private static final String TABLE_COURSES = "course";
    private static final String TABLE_CATEGORY = "category";

    protected SQLiteDatabase mDatabase;

    public GenericDAO(Context context) {

        DatabaseHelper agendaHelper = new DatabaseHelper(context);
        mDatabase = agendaHelper.getWritableDatabase();

    }

    // Método para inserção no banco
    public void insert(T obj) {

        mDatabase.insert(TABLE_COURSES, // Define em qual tabela serão inseridos os registros.
                null, // Por padrão o CursorFactory é nulo.
                getContentValues(obj)); // Contem os valores que serão inseridos no banco.

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

    //TODO: implementar o metodo find (Object)

    //TODO: implementar o metodo findAll

    // Outra sugestao seria deixar a classe mais genérica implementado os metodos
    // findALL e toList que serão especializados dentro do DAO específico.
    public  List<Course> findAllCourses(){
        Course course = null;
        List<Course> courseList = new ArrayList<Course>();

        // Cria a String de consulta SQL de forma programatica
        String sql = "SELECT * FROM course";

        // Chama o método rawQuery que irá realizar a consulta e retornar um objeto Cursor
        // O objeto Cursor contem todos os registos da tabela COURSE existentes no banco.
        Cursor cursor = mDatabase.rawQuery(sql, null);

        // iterar sobre o objeto cursor.
        while (cursor.moveToNext()) {

            // Monta o objeto COURSE pelo id da coluna retornado no objeto CURSOR
            course = new Course(
                    cursor.getLong(0), // id
                    cursor.getString(1), // name
                    cursor.getString(2), // workingPlan
                    cursor.getString(3), // courseHours
                    cursor.getString(4) // workShift
            );

            //OU

            // Monta o objeto COURSE pela TAG da coluna retornado no objeto CURSOR
            /*
            course = new Course(
                    cursor.getLong(cursor.getColumnIndex("id")), // id
                    cursor.getString(cursor.getColumnIndex("name")), // name
                    cursor.getString(cursor.getColumnIndex("working_plan")), // workingPlan
                    cursor.getString(cursor.getColumnIndex("course_hours")), // courseHours
                    cursor.getString(cursor.getColumnIndex("work_shift")) // workShift
            );
             */
            courseList.add(course);

        }

        return courseList;
    }

    public abstract ContentValues getContentValues(T obj);



}
