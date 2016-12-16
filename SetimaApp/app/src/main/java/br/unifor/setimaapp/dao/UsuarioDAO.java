package br.unifor.setimaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.unifor.setimaapp.model.IModel;
import br.unifor.setimaapp.model.Usuario;

/**
 * Created by Everton on 12/10/16.
 */

public class UsuarioDAO extends GenericDAO {

    public UsuarioDAO(Context context) {
        super(context);
    }

    @Override
    public List findAll() {

        Usuario usuario;
        List<Usuario> listUsuario = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        Cursor cursor = mDatabase.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            usuario = new Usuario(
                    cursor.getLong(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("email")),
                    cursor.getString(cursor.getColumnIndex("senha")));

            listUsuario.add(usuario);
        }

        return listUsuario;
    }

    @Override
    public IModel find(IModel obj) {

        //TODo implementar
        return null;
    }

    @Override
    public ContentValues getContentValues(IModel obj) {
        Usuario usuario = (Usuario) obj;

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", usuario.getId());
        contentValues.put("nome", usuario.getNome());
        contentValues.put("email", usuario.getEmail());
        contentValues.put("senha", usuario.getSenha());

        return contentValues;
    }
}