/*
API cagirilarini iceren interface yapisi
 */
package com.emre.dosyapaylasimuygulamasi.api;

import com.emre.dosyapaylasimuygulamasi.Model.APICevabi;

/**
 *
 * @author emre
 */
public interface IAdaptor {
    
    public int dosyaYukle(String dosyaYolu);
    
    public int dosyaIndir(String sifre, String dizin);
    
    public APICevabi getAPICevabi();
    
    public String dosyaSifresi();
    
    public String dosyaErisimSuresi();
    
    public boolean dosyaYuklenmeSonucu();
}
