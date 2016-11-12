package br.unifor.segundaapp.model;

import java.io.Serializable;

/**
 * Created by Everton on 11/12/16.
 */

public class Disciplina implements Serializable{

    private int codigo;
    private int cargaHoraria;
    private String ementa;
    private String sala;

    public Disciplina(){

    }

    public Disciplina(int codigo, int cargaHoraria, String ementa, String sala){
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.ementa = ementa;
        this.sala = sala;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
