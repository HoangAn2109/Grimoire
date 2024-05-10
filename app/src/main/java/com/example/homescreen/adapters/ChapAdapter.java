package com.example.homescreen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homescreen.R;
import com.example.homescreen.models.ChapModel;

import java.util.List;

public class ChapAdapter extends RecyclerView.Adapter<ChapAdapter.ViewHolder>{

    private final RecyclerViewInterface recyclerViewInterface;

    Context context;

    List<ChapModel> list;

    public ChapAdapter(RecyclerViewInterface recyclerViewInterface, Context context, List<ChapModel> list) {
        this.recyclerViewInterface = recyclerViewInterface;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ChapAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chapters, parent, false);
        return new ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapAdapter.ViewHolder holder, int position) {
        holder.chap_num.setText(list.get(position).getChap_num());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView chap_num;

        TextView chap_content;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            chap_num = itemView.findViewById(R.id.tvchap_num);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
