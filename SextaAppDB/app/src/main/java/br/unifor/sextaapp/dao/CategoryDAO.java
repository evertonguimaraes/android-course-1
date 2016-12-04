package br.unifor.sextaapp.dao;

import android.content.ContentValues;
import android.content.Context;

import br.unifor.sextaapp.model.Category;
import br.unifor.sextaapp.model.IModel;

/**
 * Created by Everton on 12/3/16.
 */

public class CategoryDAO extends GenericDAO<Category>{


    public CategoryDAO(Context context) {
        super(context);
    }

    @Override
    public ContentValues getContentValues(Category obj) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", obj.getId());
        contentValues.put("name", obj.getName());
        contentValues.put("description", obj.getDescription());

        return contentValues;
    }
}
