package com.example.appnoticia;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.SearchView;
import android.widget.Toast;

import com.example.appnoticia.Models.NewsApiResponse;
import com.example.appnoticia.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener, View.OnClickListener {

    RecyclerView recyclerView;
    Button bt_1,bt_2,bt_3,bt_4,bt_5,bt_6,bt_7;
    CustomAdapter adapter;
    ProgressDialog dialog;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "general", null);

        searchView = findViewById(R.id.search_view);
        recyclerView = findViewById(R.id.recycle_main);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Procurando novos artigos de "+ query);
                dialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getNewsHeadlines(listener, "general", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        dialog = new ProgressDialog(this);
        dialog.setTitle("Buscando novos artigos...");
        dialog.show();

        bt_1 = findViewById(R.id.btn_1);
        bt_1.setOnClickListener(this);

        bt_2 = findViewById(R.id.btn_2);
        bt_2.setOnClickListener(this);

        bt_3 = findViewById(R.id.btn_3);
        bt_3.setOnClickListener(this);

        bt_4 = findViewById(R.id.btn_4);
        bt_4.setOnClickListener(this);

        bt_5 = findViewById(R.id.btn_5);
        bt_5.setOnClickListener(this);

        bt_6 = findViewById(R.id.btn_6);
        bt_6.setOnClickListener(this);

        bt_7 = findViewById(R.id.btn_7);
        bt_7.setOnClickListener(this);



    }

    private final OnFetchDataListener <NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onfetchData(List<NewsHeadlines> list, String message) {
           //list = new ArrayList<NewsHeadlines>();
            if (list.isEmpty()){
                Toast.makeText(MainActivity.this, "Dados não encontrados!!!", Toast.LENGTH_SHORT).show();
            }else {
                showNews(list);
                dialog.dismiss();
            }

        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "Ocorreu um erro!!!!", Toast.LENGTH_SHORT).show();
        }
    };


    private void showNews(List<NewsHeadlines> list) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomAdapter(this, list, this);
    }

    @Override
    public void OnNewsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivity.this, DetalhesActivity.class).putExtra("data", headlines));
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String category = button.getText().toString();
        dialog.setTitle("Buscando novos artigos da "+category);
        dialog.show();
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, category, null);
    }
}