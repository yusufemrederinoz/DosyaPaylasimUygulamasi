/*
API cevabini tasiyan model yapisi
Tasinacak degerlerin degisken isimleri, API cevabindan donen JSON verinin icerigindeki degerler ile ayni olmasi lazim.

 */
package com.emre.dosyapaylasimuygulamasi.Model;

/**
 *
 * @author emre
 */
public class APICevabi {
    
    private String link;
    private String expiry;
    private String key;
    private boolean success;
    
    
    
    public void setLink(String link) {
        this.link = link;
    }
   
    public String getLink() {
        return link;
    }
    
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
   
    public String getExpiry() {
        return expiry;
    }
    
            
    public void setKey(String key) {
        this.key = key;
    }
   
    public String getKey() {
        return key;
    }
    
     public void setSuccess(boolean success) {
        this.success = success;
    }
   
    public boolean getSuccess() {
        return success;
    }
    
}
