package com.srp.deleterecyclerviewcheckbox;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CheckBox chk_select_all;
    private Button btn_delete_all;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        recyclerView = findViewById(R.id.recycler_view);
        chk_select_all = findViewById(R.id.chk_select_all);
        btn_delete_all = findViewById(R.id.btn_delete_all);
       setRecyclerView();
    }

    private void setRecyclerView(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ModelAdapter(mContext,getModelList()));
    }

    private List<Model> getModelList() {
        List<Model> item_list = new ArrayList<>();
        item_list.add(new Model("Alpha", false));
        item_list.add(new Model("Beta", false));
        item_list.add(new Model("Cup Cake", false));
        item_list.add(new Model("Donut", false));
        item_list.add(new Model("Eclair", false));
        item_list.add(new Model("Froyo", false));
        item_list.add(new Model("Ginger Bread", false));
        item_list.add(new Model("Honeycomb", false));
        item_list.add(new Model("IceCream Sandwich", false));
        item_list.add(new Model("Jelly Bean", false));
        item_list.add(new Model("Kitkat", false));
        item_list.add(new Model("LollyPop", false));
        item_list.add(new Model("MarshMallow", false));
        item_list.add(new Model("Nougat", false));
        item_list.add(new Model("Oreo", false));
        item_list.add(new Model("Pie", false));
        item_list.add(new Model("Q 10", false));
        return item_list;
    }
}
