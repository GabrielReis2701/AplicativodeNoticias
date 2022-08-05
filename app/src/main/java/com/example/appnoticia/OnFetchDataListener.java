package com.example.appnoticia;

import com.example.appnoticia.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onfetchData(List<NewsHeadlines> list, String message);
    void onError(String message);
}
