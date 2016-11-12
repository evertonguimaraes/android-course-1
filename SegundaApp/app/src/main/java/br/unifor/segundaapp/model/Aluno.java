package br.unifor.segundaapp.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Everton on 11/12/16.
 */

public class Aluno implements Serializable{

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private ArrayList<Disciplina> disciplinas;

    public Aluno(){

    }

    public Aluno(String nome, String endereco, String telefone, String email){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public Aluno(String nome, String endereco, String telefone, String email, ArrayList<Disciplina> disciplinas){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    @Override
    public String toString() {
        return this.nome+" ("+this.email+")";
    }
}
