package com.example.appnoticia.Models;

import java.io.Serializable;

public class NewsHeadlines implements Serializable {
    Source source = null;
    String autor = "";
    String titulo = "";
    String descricao = "";
    String url = "";
    String urlToImage = "";
    String publicadoEm = "";
    String contente = "";


    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublicadoEm() {
        return publicadoEm;
    }

    public void setPublicadoEm(String publicadoEm) {
        this.publicadoEm = publicadoEm;
    }

    public String getContente() {
        return contente;
    }

    public void setContente(String contente) {
        this.contente = contente;
    }
}
