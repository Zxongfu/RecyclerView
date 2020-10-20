package com.example.recyclerview.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import com.example.recyclerview.Controller.MyAdapter;
import com.example.recyclerview.Model.Book;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * MVC: MainActivity -- Controller;-->Model(JavaBean)-->view(xml)
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Book> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);

        //can use setOrientation
        //((LinearLayoutManager) layoutManager).setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        //set Data
        initData();

        // specify an adapter (see also next example)

        mAdapter = new MyAdapter(mData);
        recyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        //use List<E> put data (Object:Book.class) inside ArrayList
        mData = new ArrayList<>();
        mData.add(new Book("畫在身上的名字"));
        mData.add(new Book("看不見的訪客"));
        mData.add(new Book("媽媽的彩虹"));
        mData.add(new Book("唱唱跳跳寶寶"));
        mData.add(new Book("嘮嘮叨叨的媽媽"));
        mData.add(new Book("聖誕老公公的魔法雪球"));
        mData.add(new Book("跟著節日玩遊戲"));
        mData.add(new Book("聖誕節奇蹟"));

    }
}
