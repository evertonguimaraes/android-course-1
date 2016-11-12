package br.unifor.segundaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.unifor.segundaapp.model.Aluno;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView mListViewContato;

    private ArrayList<Aluno> listaContatos;

    private ArrayAdapter<Aluno> adapter;

    private int layoutAdapter = android.R.layout.simple_list_item_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_second_activity);

        mListViewContato = (ListView) findViewById(R.id.listViewContatos);

        listaContatos = loadContacts();

        adapter = new ArrayAdapter<Aluno>(getBaseContext(), layoutAdapter, listaContatos);

        mListViewContato.setAdapter(adapter);
        mListViewContato.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        // Recupera a Instancia do contato que foi selecionado.
        Aluno contato = adapter.getItem(i);

        Intent intent =  new Intent(SecondActivity.this, FirstActivity.class);

        intent.putExtra("contatoSelecionado", contato);

        startActivity(intent);

    }

    // Metodo criado para simular a criação de dados de contato.
    private ArrayList<Aluno> loadContacts(){
        ArrayList<Aluno> contatos= new ArrayList<Aluno>();

        Aluno contatoF = new Aluno("Fulano", "Rua A", "33440099", "fulano@unifor.br");
        Aluno contatoB = new Aluno("Beltrano", "Rua B", "33440066", "beltrano@unifor.br");
        Aluno contatoC =  new Aluno("Cilano", "Rua C", "33440022", "ciclano@unifor.br");

        contatos.add(contatoB);
        contatos.add(contatoC);
        contatos.add(contatoF);

        return contatos;
    }
}
