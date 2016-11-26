package br.unfior.quintaapp.repository;

import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

import br.unfior.quintaapp.model.IModel;

/**
 * Created by bruno on 26/11/16.
 */

public abstract class GenericRepository<T extends IModel> {

    private List<T> list;

    public GenericRepository() {
        list = new ArrayList<>();
    }

    public void insert(T obj){
        list.add(obj);
    }

    public void update(T obj){
        // TODO: Fazer quando trabalhar com BD
    }

    public void delete(T obj){
        list.remove(obj);
    }

    public T find(Long id){
        // TODO: Fazer quando trabalhar com BD
        return null;
    }

    public abstract ContentValues getContentValues(T obj);

    public List<T> findAll(){
        return list;
    }

}
