package br.unifor.setimaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.unifor.setimaapp.model.Disciplina;
import br.unifor.setimaapp.model.IModel;

/**
 * Created by Everton on 12/10/16.
 */

public class DisciplinasDAO extends GenericDAO {

    public DisciplinasDAO(Context context) {
        super(context);
    }

    @Override
    public List findAll() {

        Disciplina disciplina;
        List<Disciplina> listDisciplinas = new ArrayList<>();

        String sql = "SELECT * FROM disciplina";

        Cursor cursor = mDatabase.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            disciplina = new Disciplina(
                    cursor.getLong(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("descricao")));

            listDisciplinas.add(disciplina);
        }
        return listDisciplinas;
    }

    @Override
    public IModel find(IModel obj) {
        //TODo implementar
        return null;
    }

    @Override
    public ContentValues getContentValues(IModel obj) {
        Disciplina disciplina = (Disciplina) obj;

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", disciplina.getId());
        contentValues.put("nome", disciplina.getNome());
        contentValues.put("descricao", disciplina.getDescricao());

        return contentValues;
    }
}
