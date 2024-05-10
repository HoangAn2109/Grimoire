package com.example.homescreen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homescreen.R;
import com.example.homescreen.models.RecBooksModel;

import java.util.List;

public class RecBooksAdapter extends RecyclerView.Adapter<RecBooksAdapter.ViewHolder>{

    Context context;

    List<RecBooksModel> list;




    public RecBooksAdapter(Context context, List<RecBooksModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecBooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_hor_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecBooksAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.BookPic);
            name = itemView.findViewById(R.id.BookName);

        }
    }
}
