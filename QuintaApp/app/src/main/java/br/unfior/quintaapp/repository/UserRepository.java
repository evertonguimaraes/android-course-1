package br.unfior.quintaapp.repository;

import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

import br.unfior.quintaapp.model.User;

/**
 * Created by bruno on 26/11/16.
 */

public class UserRepository extends GenericRepository<User> {

    private static UserRepository instance;

    private UserRepository() {
    }

    public static UserRepository getInstance(){

        if(instance == null){
            instance = new UserRepository();
        }

        return instance;
    }

    @Override
    public ContentValues getContentValues(User obj) {
        // TODO: Fazer quando trabalhar com BD
        return null;
    }

}
