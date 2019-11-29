package com.srp.deleterecyclerviewcheckbox;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox chk_select_all;
    private ModelAdapter mAdapter;
    private Context mContext;
    private List<Model> itemList = new ArrayList<>(getModelList());
    private Button btn_delete_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        initViews();
        setUpRecyclerView();
    }

    private void initViews() {
        chk_select_all = findViewById(R.id.chk_select_all);
        btn_delete_all = findViewById(R.id.btn_delete_all);
        chk_select_all.setOnClickListener(this);
        btn_delete_all.setOnClickListener(this);
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ModelAdapter(mContext, itemList);
        recyclerView.setAdapter(mAdapter);
    }

    private ArrayList<Model> getModelList() {
        ArrayList<Model> item_list = new ArrayList<>();
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
        item_list.add(new Model("Lolly Pop", false));
        item_list.add(new Model("Marsh Mallow", false));
        item_list.add(new Model("Nougat", false));
        return item_list;
    }

    @Override
    public void onClick(View view) {
        if (view.equals(chk_select_all)) {
            if (chk_select_all.isChecked()) {
                setState(true);
            } else {
                setState(false);
            }
        } else if (view.equals(btn_delete_all)) {
            if (chk_select_all.isChecked()) {
                deleteList();
            } else {
                Snackbar.make(view, "Please click on select all check box, " +
                        "to delete all items.", Snackbar.LENGTH_LONG).show();
            }
        }
    }

    private void deleteList() {
        itemList.clear();
        mAdapter.notifyDataSetChanged();
        chk_select_all.setChecked(false);
    }

    private void setState(boolean check) {
        for (int i = 0; i < itemList.size(); i++) {
            itemList.get(i).setSelected(check);
        }
        mAdapter.notifyDataSetChanged();
    }
}