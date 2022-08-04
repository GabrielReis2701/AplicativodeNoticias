package com.example.appnoticia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appnoticia.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetalhesActivity extends AppCompatActivity {

    NewsHeadlines headlines;
    TextView txt_title, txt_author, txt_time, txt_detail, txt_content;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_time = findViewById(R.id.text_detail_time);
        txt_detail = findViewById(R.id.text_detail_detail);
        txt_content = findViewById(R.id.text_detail_content);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitulo());
        txt_author.setText(headlines.getAutor());
        txt_time.setText(headlines.getPublicadoEm());
        txt_detail.setText(headlines.getDescricao());
        txt_content.setText(headlines.getContente());

        Picasso.get().load(headlines.getUrlToImage()).into(img_news);

    }
}