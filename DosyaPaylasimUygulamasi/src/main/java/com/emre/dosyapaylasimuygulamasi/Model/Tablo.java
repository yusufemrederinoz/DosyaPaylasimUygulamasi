/*
 * API cevabi nesnesini, JTable bilesenin istedigi nesneye cevirmek icin gerekli nesne yapisi
 * API cevabinda sadece 1 satir donus yapacagi icin, listede sadece 1 eleman olacak
 */
package com.emre.dosyapaylasimuygulamasi.Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author emre
 */
public class Tablo extends AbstractTableModel {

    private final String[] sutunBasliklari = {"Dosya Adi","Yuklenme Durumu","Sifre","Erisim Linki","Erisim Suresi"};
    private final ArrayList<Dosya> dosyaYuklenmeCevaplari = new ArrayList<>();
    
    public Tablo(Dosya dosya) {
        dosyaYuklenmeCevaplari.add(dosya);
    }
    
    
    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return sutunBasliklari.length;
    }
    
    @Override
    public Object getValueAt(int satir, int sutun) {
      Object geciciNesne = null;
        switch (sutun) {
            case 0:
                geciciNesne = dosyaYuklenmeCevaplari.get(satir).getDosyaAdi();
                break;
            case 1:
                geciciNesne = dosyaYuklenmeCevaplari.get(satir).getApiCevabi().getSuccess();
                break;
            case 2:
                geciciNesne = dosyaYuklenmeCevaplari.get(satir).getApiCevabi().getKey();
                break;
            case 3:
                geciciNesne = dosyaYuklenmeCevaplari.get(satir).getApiCevabi().getLink();
                break;
            case 4:
                geciciNesne = dosyaYuklenmeCevaplari.get(satir).getApiCevabi().getExpiry();
                break;
            default:
                break;
        }
      return geciciNesne;
    }
    
    
    // Sutun basliklarini JTable uzerinde gostermek icin geren metot
    @Override
   public String getColumnName(int sutun) {
      return sutunBasliklari[sutun];
   }
   
   
    @Override
   public Class getColumnClass(int col) {
      if (col == 0) {
         return Integer.class;
      }
      else {
         return String.class;
      }
   }
   
    /**
     *
     * @param dosya Veri degistirildiginde bu metot ile tablo guncellenmesi gerceklesecek
     */
    public void veriKaynaginiDegistir(Dosya dosya) {
       dosyaYuklenmeCevaplari.set(0, dosya);
   }
    
}
