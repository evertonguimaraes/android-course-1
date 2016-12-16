package br.unifor.setimaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import br.unifor.setimaapp.dao.GenericDAO;
import br.unifor.setimaapp.dao.UsuarioDAO;
import br.unifor.setimaapp.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private GenericDAO dao;
    private List<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new UsuarioDAO(this);
        usuarios = dao.findAll();

        dao.insert(usuarios.get(0));

    }
}
