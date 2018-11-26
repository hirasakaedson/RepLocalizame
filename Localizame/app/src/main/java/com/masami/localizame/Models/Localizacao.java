package com.masami.localizame.Models;

import java.util.Date;

public class Localizacao {
    private int idLocalizacao;
    private float longitude;
    private float latitude;
    private String dataLocalizacao;

    public int getId(){
        return idLocalizacao;
    }
    public void setId(int id){
        this.idLocalizacao=id;
    }
    public float getLongitude(){
        return longitude;
    }
    public void setLongitude(float longitude){
        this.longitude=longitude;
    }
    public float getLatitude(){
        return latitude;
    }
    public void setLatitude(float latitude){
        this.latitude=latitude;
    }
    public String getDataLocalizacao(){
        return dataLocalizacao;
    }
    public void setDataLocalizacao(String dataLocalizacao){
        this.dataLocalizacao=dataLocalizacao;
    }
}
