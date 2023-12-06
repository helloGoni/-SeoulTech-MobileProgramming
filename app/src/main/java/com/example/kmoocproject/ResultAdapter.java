package com.example.kmoocproject;

import android.content.Intent;
import android.view.LayoutInflater;

import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {
    ArrayList<Result> items = new ArrayList<Result>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.result_item, viewGroup,false);

        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Result item = items.get(position);
        viewHolder.setItem(item);
        //viewHolder.textView.setText(new String(item.getName().getBytes("ISO-8859-1"), "UTF-8"));
        try {
            viewHolder.textView.setText(new String(item.getName().getBytes("ISO-8859-1"), "UTF-8"));
            viewHolder.textView3.setText(new String(item.getTeachers().getBytes("ISO-8859-1"), "UTF-8").substring(0,3));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getItemCount() { return items.size(); }
    public void addItem(Result item) { items.add(item); }
    public void setItems(ArrayList<Result> items) {this.items=items;}

    public Result getItem(int position) { return items.get(position); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView2, textView3, textView4;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    //intent.putExtra("Key",value);
                    context.startActivity(intent);
                }
            });
        }

        public void setItem(Result item) {
            textView.setText(item.getName());
            String temp = item.getStart().substring(0,10)+ " ~ " + item.getEnd().substring(0,10);
            textView2.setText(temp);
            textView3.setText(item.getTeachers().substring(0,3));
            //textView4.setText(item.lecEndTime);
        }
    }

}
