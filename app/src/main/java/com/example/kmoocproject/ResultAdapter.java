package com.example.kmoocproject;

import android.content.Intent;
import android.view.LayoutInflater;

import android.view.View;
import android.util.Log;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {
    ArrayList<Result> items = new ArrayList<>();

    public ResultAdapter(ArrayList<Result> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.result_item, viewGroup,false);

        return new ViewHolder(itemView,this);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Result item = items.get(position);
        viewHolder.setItem(item);
        viewHolder.bind(item);
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

        private ResultAdapter adapter;

        public void bind(Result item) {
            textView.setText(item.getName());
            String temp = item.getStart().substring(0,10)+ " ~ " + item.getEnd().substring(0,10);
            textView2.setText(temp);
            textView3.setText(item.getTeachers().substring(0,3));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Context context = v.getContext();
                    if(position != RecyclerView.NO_POSITION) {
                        Result clickedItem = adapter.items.get(position);
                        Intent intent = new Intent(context, DetailActivity.class);
                        //intent.putExtra("Key",value);
                        intent.putExtra("lecName", clickedItem.getName());
                        String dateTemp =clickedItem.getStart().substring(0,10)+ " ~ " + clickedItem.getEnd().substring(0,10);
                        intent.putExtra("lecDate", dateTemp);
                        intent.putExtra("lecShort", clickedItem.getShortDescription());
                        intent.putExtra("lecURL", clickedItem.getBlocksUrl());
                        intent.putExtra("lecID",clickedItem.getId());
                        context.startActivity(intent);
                    }
                }
            });
        }

        public ViewHolder(View itemView, ResultAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
        }



        public void setItem(Result item) {
            textView.setText(item.getName());
            String temp = item.getStart().substring(0,10)+ " ~ " + item.getEnd().substring(0,10);
            textView2.setText(temp);
            textView3.setText(item.getTeachers().substring(0,3));
        }
    }

}
