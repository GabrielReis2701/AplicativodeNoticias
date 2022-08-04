package com.example.appnoticia.Models;

import java.io.Serializable;
import java.util.List;

public class NewsApiResponse  implements Serializable {
    String status;
    int totalResults;
    List<NewsHeadlines> artigos;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsHeadlines> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<NewsHeadlines> artigos) {
        this.artigos = artigos;
    }
}
