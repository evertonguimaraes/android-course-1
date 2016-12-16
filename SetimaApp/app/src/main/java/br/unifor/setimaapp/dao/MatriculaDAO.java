package br.unifor.setimaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.unifor.setimaapp.model.Disciplina;
import br.unifor.setimaapp.model.IModel;
import br.unifor.setimaapp.model.Matricula;

/**
 * Created by Everton on 12/10/16.
 */

public class MatriculaDAO extends GenericDAO {

    public MatriculaDAO(Context context) {
        super(context);
    }

    @Override
    public List findAll() {

        Matricula matricula = null;
        List<Matricula> listMatricula = new ArrayList<>();

        String sql = "SELECT * FROM matricula";

        Cursor cursor = mDatabase.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            matricula = new Matricula(
                    cursor.getLong(cursor.getColumnIndex("id_usuario")),
                    cursor.getLong(cursor.getColumnIndex("id_disciplina")),
                    cursor.getString(cursor.getColumnIndex("data")));


            listMatricula.add(matricula);
        }

        return listMatricula;
    }

    @Override
    public IModel find(IModel obj) {
        //TODo implementar
        return null;
    }

    @Override
    public ContentValues getContentValues(IModel obj) {
        Matricula matricula = (Matricula) obj;

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", matricula.getId());
        contentValues.put("id_usuario", matricula.getIdUsuario());
        contentValues.put("id_disciplina", matricula.getIdDisciplina());
        contentValues.put("data", matricula.getData());

        return null;
    }
}
