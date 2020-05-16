package com.example.recyclerview.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.Model.Book;
import com.example.recyclerview.R;

import java.util.List;


class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Book> data ;

    //Constructor
    public MyAdapter(List<Book> data) {
        //create field
        this.data=data;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.text_view);
        }
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your data at this position
        // - replace the contents of the view with that element
        Book book = data.get(position);
        holder.textView.setText(book.getName());

        holder.textView.setVisibility(book.getName() == null ?
                View.GONE : View.VISIBLE);

    }

    // Return the size of your dataset
    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        } else
            return 0;

    }
}
