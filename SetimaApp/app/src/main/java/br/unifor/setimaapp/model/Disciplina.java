package br.unifor.setimaapp.model;

/**
 * Created by Everton on 12/10/16.
 */

public class Disciplina implements IModel {


    private Long id;
    private String nome;
    private String descricao;

    public Disciplina(Long id, String descricao, String nome) {
        this.descricao = descricao;
        this.id = id;
        this.nome = nome;
    }

    public Disciplina(String descricao, String nome) {
        this.descricao = descricao;
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;

    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
