/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emre.dosyapaylasimuygulamasi.UI;

import com.emre.dosyapaylasimuygulamasi.Common.HataDonusumleri;
import com.emre.dosyapaylasimuygulamasi.api.Adaptor;

/**
 *
 * @author rapt0r
 */
public class SifreEkrani extends javax.swing.JDialog {

    /**
     * Creates new form SifreEkrani2
     */
    public SifreEkrani(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sifreOnayButtonu = new javax.swing.JButton();
        sifreGirisYaziAlani = new javax.swing.JTextField();
        sifreEtiketi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        sifreOnayButtonu.setText("Dosyayi indir");
        sifreOnayButtonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sifreOnayButtonuActionPerformed(evt);
            }
        });

        sifreEtiketi.setText("Sifre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(sifreEtiketi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sifreOnayButtonu)
                    .addComponent(sifreGirisYaziAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sifreGirisYaziAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sifreEtiketi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sifreOnayButtonu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sifreOnayButtonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sifreOnayButtonuActionPerformed
        // Ana menu uzerinden JTreeden secilen dosya yolu getSeciliDosyaYolu ile cagirilarak getiriliyor
        // Eger sifre ve secili dizin null degilse, APIye HTTP istegi gonderiliyor
        // Hata kodu: 201 - Dosya indirilirken sorun olustu.
        int sonuc = 201;
        String seciliDosyaYolu = AnaMenu.getSeciliDosyaYolu();
        String sifre = sifreGirisYaziAlani.getText();

        try {
            if (!(seciliDosyaYolu.equals("") && sifre.equals(""))) {
                Adaptor apiBaglantiAdaptoru = new Adaptor();
                sonuc = apiBaglantiAdaptoru.dosyaIndir(sifre, seciliDosyaYolu);
            } 
        }catch(NullPointerException ex) {
            // Hata kodu: 203 - Sifre veya kaydedilecek dizin bos olamaz.
             sonuc = 203;
        }
  
        durumMesaji = HataDonusumleri.donusumTablosu.get(sonuc);
        HataEkrani hataEkrani = new HataEkrani(new AnaMenu(), true);
        hataEkrani.setHataMesaji(durumMesaji);
        hataEkrani.setVisible(true);
    }//GEN-LAST:event_sifreOnayButtonuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SifreEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SifreEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SifreEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SifreEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SifreEkrani dialog = new SifreEkrani(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel sifreEtiketi;
    private javax.swing.JTextField sifreGirisYaziAlani;
    private javax.swing.JButton sifreOnayButtonu;
    // End of variables declaration//GEN-END:variables

    //Indirme sonucunu tasiyan durum mesaji degeri
    private static String durumMesaji;

    public static String getDurumMesaji() {
        return durumMesaji;
    }
}
