package br.unifor.setimaapp.model;

import java.util.Date;

/**
 * Created by Everton on 12/10/16.
 */

public class Matricula implements IModel {

    private Long id;
    private Long idDisciplina;
    private Long idUsuario;
    private String data;

    public Matricula(Long idUsuario, Long idDisciplina, String data) {
        this.idUsuario = idUsuario;
        this.idDisciplina = idDisciplina;
        this.data = data;
    }

    public Matricula(Long id, Long idDisciplina, Long idUsuario, String data) {

        this.id = id;
        this.idDisciplina = idDisciplina;
        this.idUsuario = idUsuario;
        this.data = data;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
