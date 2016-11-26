package br.unfior.quintaapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.unfior.quintaapp.model.Category;

/**
 * Created by bruno on 26/11/16.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private List<Category> categories;
    private LayoutInflater inflater;

    public CategoryAdapter(Context context, List<Category> categories) {

        this.inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.categories = categories;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }

}
