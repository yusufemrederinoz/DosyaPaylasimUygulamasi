/*
API ile iletisim kuran adaptor sinifi
 */
package com.emre.dosyapaylasimuygulamasi.api;

import com.emre.dosyapaylasimuygulamasi.Model.APICevabi;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author emre
 * API ile iletisim kuran sinif
 * Projede kullanilan API dokumantasyonu ile ilgili detayli bilgiye su siteden ulasabilirsiniz.
 * https://www.file.io/
 */
public class Adaptor implements IAdaptor {

    private final String APIUrl = "https://file.io";

    private APICevabi apiCevabi;

    public Adaptor() {

    }

    /**
     *
     * @param dosyaYolu Yerel makinadaki karsiya yuklenecek dosya yolu. Ornek: C:\Program Files\Users\emre\ornek.txt
     * @return Hata mesaj kodu
     */
    @Override
    public int dosyaYukle(String dosyaYolu) {
        
        // Dosyayi disk uzerinden memorye alma islemi
        // Hata kodu: 102 - Yuklenecek dosya, belirtilen dizinde bulunamadi.
        // Hata kodu: 104 - Lutfen bir dizin yerine dosya seciniz.
        
        File dosya = new File(dosyaYolu);
        if(!dosya.exists()) {
            return 102;
        }else if(dosya.isDirectory()) {
            return 104;
        }

        HttpEntity entity = MultipartEntityBuilder.create()
                .addPart("file", new FileBody(dosya))
                .build();

        HttpPost istek = new HttpPost(APIUrl);
        istek.setEntity(entity);

        // APIye POST istegi gonderme islemi
         CloseableHttpClient istemci = HttpClientBuilder.create().build();
        try {
            HttpResponse cevap = istemci.execute(istek);
            HttpEntity cevapEntity = cevap.getEntity();
            String cevapIcerigi = EntityUtils.toString(cevapEntity);
            apiCevabi = jsonCevabiNesneyeDonustur(cevapIcerigi);
        } catch (IOException ex) {
           // Hata kodu: 901 - API Sunucusu yanit vermiyor. Internet baglantinizda problem veya maksimum istek limiti asilmis olabilir. Lutfen daha sonra tekrar deneyin.
            return 901;
        }
        
        // Durum kodu: 100 - Dosya yuklendi.
        return 100;
    }

    /**
     *
     * @param sifre Uzak sunucuda dosyaya erisim icin gereken sifre
     * @param dizin Dosyanin kaydedilecegi dizin ismi
     * @return Hata mesaj kodu
     */
    @Override
    public int dosyaIndir(String sifre, String dizin) {
        String dosyaHedefUrl = String.format("%s/%s", APIUrl, sifre);
        
        try {
            URL url = new URL(dosyaHedefUrl);
            // Zaman damgasi kaydedilecek dosya ismi olacak
            String zamanDamgasi = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String tamDosyaAdi = String.format("%s\\%s.txt",dizin, zamanDamgasi);
            File hedef = new File(tamDosyaAdi);
            
            // Indirilecek dosyayi, hedef dizine kaydetme islemi
            // Hata kodu: 202 - Dosya bulunamadi. Sifre yanlis veya erisim suresi dolmus olabilir.
            FileUtils.copyURLToFile(url, hedef);
        } catch (IOException e) {
            return 202;
        } 
        
        // Durum kodu: 200 - Dosya kaydedildi.
        return 200;
    }

        
    /**
     *
     * @param jsonCevap Uzak sunucudan donen HTTP cevabinin icerigi
     * @return Dosya nesnesi
     */
   
    private APICevabi jsonCevabiNesneyeDonustur(String jsonCevap) {
        return new Gson().fromJson(jsonCevap, APICevabi.class);
    }
    
    
    @Override
    public APICevabi getAPICevabi() {
       return apiCevabi;
    }

     /*
     * @return Yuklenen dosyanin sifresini dondurur
     */
    @Override
    public String dosyaSifresi() {
        return apiCevabi.getKey();
    }

     /*
     * @return Yuklenen dosyanin erisim suresini dondurur
     */
    @Override
    public String dosyaErisimSuresi() {
        return apiCevabi.getExpiry();
    }

    /*
     * @return Yuklenen dosyanin yuklenme sonucunu dondurur
     */
    @Override
    public boolean dosyaYuklenmeSonucu() {
        return apiCevabi.getSuccess();
    }

  

}
