/*
 * API Cevabi ile gerekli diger degerleri tutan nesne yapisi
 */
package com.emre.dosyapaylasimuygulamasi.Model;

/**
 *
 * @author emre
 */
public class Dosya {
    private APICevabi apiCevabi;
    private String dosyaAdi;
    
    
    public APICevabi getApiCevabi() {
        return apiCevabi;
    }
    
    public void setApiCevabi(APICevabi apiCevabi) {
        this.apiCevabi = apiCevabi;
    }

    
    public String getDosyaAdi() {
        return dosyaAdi;
    }
    
    public void setDosyaAdi(String dosyaAdi) {
        this.dosyaAdi = dosyaAdi;
    }
    
}

