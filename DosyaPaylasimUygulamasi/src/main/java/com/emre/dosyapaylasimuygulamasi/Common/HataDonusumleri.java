/*
Hata kodlarinin mesajlara donusturuldugu tablo
 */
package com.emre.dosyapaylasimuygulamasi.Common;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author emre
 */
public class HataDonusumleri {

    /**
     * Durum kodu ve mesajlarini tasiyan tablo
     */
    public static final Map<Integer, String> donusumTablosu =  new HashMap<Integer, String>() {{
        put(100, "Dosya yuklendi.");
        put(200, "Dosya kaydedildi.");
        put(101, "Dosya yuklenirken sorun olustu.");
        put(102, "Yuklenecek dosya, belirtilen dizinde bulunamadi.");
        put(103, "Yuklenecek dosyaya erisim saglanamadi.");
        put(104, "Lutfen bir dizin yerine dosya seciniz.");
        put(201, "Dosya indirilirken sorun olustu.");
        put(202, "Dosya bulunamadi. Sifre yanlis, erisim suresi dolmus veya dosya indirilmis olabilir.");
        put(203, "Sifre veya kaydedilecek dizin bos olamaz.");
        put(901, "API Sunucusu yanit vermiyor. Internet baglantinizda problem veya maksimum istek limiti asilmis olabilir. Lutfen daha sonra tekrar deneyin.");
    }};
}
