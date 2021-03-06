/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emre.dosyapaylasimuygulamasi.UI;

import com.emre.dosyapaylasimuygulamasi.Common.HataDonusumleri;
import com.emre.dosyapaylasimuygulamasi.Model.APICevabi;
import com.emre.dosyapaylasimuygulamasi.Model.Dosya;
import com.emre.dosyapaylasimuygulamasi.Model.Tablo;
import com.emre.dosyapaylasimuygulamasi.api.Adaptor;
import java.io.File;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author emre
 */
class FileSystemModel implements TreeModel {

    private String root;

    private final Vector listeners;

    public FileSystemModel() {

        root = System.getProperty("user.home");
        File tempFile = new File(root);
        root = tempFile.getAbsolutePath();

        listeners = new Vector();
    }

    @Override
    public Object getRoot() {
        return (new File(root));
    }

    @Override
    public Object getChild(Object parent, int index) {
        File directory = (File) parent;
        String[] directoryMembers = directory.list();
        return (new File(directory, directoryMembers[index]));
    }

    @Override
    public int getChildCount(Object parent) {
        File fileSystemMember = (File) parent;
        if (fileSystemMember.isDirectory()) {
            String[] directoryMembers = fileSystemMember.list();
            return directoryMembers.length;
        } else {

            return 0;
        }
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        File directory = (File) parent;
        File directoryMember = (File) child;
        String[] directoryMemberNames = directory.list();
        int result = -1;

        for (int i = 0; i < directoryMemberNames.length; ++i) {
            if (directoryMember.getName().equals(directoryMemberNames[i])) {
                result = i;
                break;
            }
        }

        return result;
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((File) node).isFile();
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        if (l != null && !listeners.contains(l)) {
            listeners.addElement(l);
        }
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        if (l != null) {
            listeners.removeElement(l);
        }
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        // Does Nothing!
    }

    public void fireTreeNodesInserted(TreeModelEvent e) {
        Enumeration listenerCount = listeners.elements();
        while (listenerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();
            listener.treeNodesInserted(e);
        }
    }

    public void fireTreeNodesRemoved(TreeModelEvent e) {
        Enumeration listenerCount = listeners.elements();
        while (listenerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();
            listener.treeNodesRemoved(e);
        }

    }

    public void fireTreeNodesChanged(TreeModelEvent e) {
        Enumeration listenerCount = listeners.elements();
        while (listenerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();
            listener.treeNodesChanged(e);
        }

    }

    public void fireTreeStructureChanged(TreeModelEvent e) {
        Enumeration listenerCount = listeners.elements();
        while (listenerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();
            listener.treeStructureChanged(e);
        }

    }

}

public class AnaMenu extends javax.swing.JFrame {

    /**
     * Creates new form AnaMenu
     */
    public AnaMenu() {
        initComponents();
        FileSystemModel fileSystemDataModel = new FileSystemModel();
        dosyaListeAgaci.setModel(fileSystemDataModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dosyaSecmePaneli = new javax.swing.JScrollPane();
        dosyaListeAgaci = new javax.swing.JTree();
        dosyaDetayGorunumPaneli = new javax.swing.JScrollPane();
        dosyaTablosu = new javax.swing.JTable();
        ustMenu = new javax.swing.JMenuBar();
        menuButtonu = new javax.swing.JMenu();
        dosyaIndirMenuItemi = new javax.swing.JMenuItem();
        cikisMenuItemi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dosyaListeAgaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dosyaListeAgaciMousePressed(evt);
            }
        });
        dosyaListeAgaci.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                dosyaListeAgaciValueChanged(evt);
            }
        });
        dosyaSecmePaneli.setViewportView(dosyaListeAgaci);

        dosyaTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Yuklenme Durumu", "Sifre", "Erisim Suresi", "Yukle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dosyaDetayGorunumPaneli.setViewportView(dosyaTablosu);

        menuButtonu.setText("Menu");

        dosyaIndirMenuItemi.setText("Dosya Indir");
        dosyaIndirMenuItemi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dosyaIndirMenuItemiMousePressed(evt);
            }
        });
        menuButtonu.add(dosyaIndirMenuItemi);

        cikisMenuItemi.setText("Cikis Yap");
        cikisMenuItemi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cikisMenuItemiMousePressed(evt);
            }
        });
        menuButtonu.add(cikisMenuItemi);

        ustMenu.add(menuButtonu);

        setJMenuBar(ustMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dosyaSecmePaneli, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dosyaDetayGorunumPaneli, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dosyaDetayGorunumPaneli, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
            .addComponent(dosyaSecmePaneli)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dosyaListeAgaciValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_dosyaListeAgaciValueChanged

        seciliDosyaYolu = dosyaListeAgaci.getLastSelectedPathComponent().toString();

        File seciliDosya = new File(seciliDosyaYolu);
        seciliDosyaNesnesi = new Dosya();

        // Secili deger eger dosya ise ismi goster, dizin ismi ise gosterme
        if (seciliDosya.isFile()) {
            seciliDosyaNesnesi.setDosyaAdi(seciliDosya.getName());
            seciliDegerDosyaMi = true;
        } else {
            seciliDosyaNesnesi.setDosyaAdi("");
            seciliDegerDosyaMi = false;
        }

        // Yukleme gerceklesmeden once varsayilan butun degerler bos olacak
        APICevabi seciliAPICevabi = new APICevabi();
        seciliAPICevabi.setExpiry(" - ");
        seciliAPICevabi.setKey(" - ");
        seciliAPICevabi.setLink(" - ");
        seciliAPICevabi.setSuccess(false);
        seciliDosyaNesnesi.setApiCevabi(seciliAPICevabi);

        Tablo tabloModeli = new Tablo(seciliDosyaNesnesi);

        dosyaTablosu.setModel(tabloModeli);
    }//GEN-LAST:event_dosyaListeAgaciValueChanged

    private void dosyaIndirMenuItemiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dosyaIndirMenuItemiMousePressed
        // Sifre ekranini goruntuleme islemi
        SifreEkrani sifreEkrani = new SifreEkrani(this, true);
        sifreEkrani.setVisible(true);
    }//GEN-LAST:event_dosyaIndirMenuItemiMousePressed

    private void cikisMenuItemiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cikisMenuItemiMousePressed
        // Cikis yapma islemi
        System.exit(NORMAL);
    }//GEN-LAST:event_cikisMenuItemiMousePressed

    private void dosyaListeAgaciMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dosyaListeAgaciMousePressed

        // Hata Kodu: 101 - Dosya yuklenirken sorun olustu.
        int sonuc = 101;
        // Cift tiklandiginda ve eger secili deger dosya ise eventi gerceklestir
        if (evt.getClickCount() == 2) {
            if (seciliDegerDosyaMi) {
                Adaptor apiBaglantiAdaptoru = new Adaptor();
                sonuc = apiBaglantiAdaptoru.dosyaYukle(seciliDosyaYolu);
                durumMesaji = HataDonusumleri.donusumTablosu.get(sonuc);
                HataEkrani hataEkrani = new HataEkrani(new AnaMenu(), true);
                hataEkrani.setHataMesaji(durumMesaji);
                hataEkrani.setVisible(true);

                // Eger yukleme basarili ise, APIden donen JSON cevabini nesne olarak al ve tabloyu guncelle
                // Durum Kodu: 100 - Dosya yuklendi.
                if (sonuc == 100) {
                    APICevabi donenAPICevabi = apiBaglantiAdaptoru.getAPICevabi();
                    seciliDosyaNesnesi.setApiCevabi(donenAPICevabi);
                    Tablo tabloModeli = new Tablo(seciliDosyaNesnesi);
                    dosyaTablosu.setModel(tabloModeli);
                }
            } 
        }
    }//GEN-LAST:event_dosyaListeAgaciMousePressed

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
            java.util.logging.Logger.getLogger(AnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cikisMenuItemi;
    private javax.swing.JScrollPane dosyaDetayGorunumPaneli;
    private javax.swing.JMenuItem dosyaIndirMenuItemi;
    private javax.swing.JTree dosyaListeAgaci;
    private javax.swing.JScrollPane dosyaSecmePaneli;
    private javax.swing.JTable dosyaTablosu;
    private javax.swing.JMenu menuButtonu;
    private javax.swing.JMenuBar ustMenu;
    // End of variables declaration//GEN-END:variables

    // JTreeden secili dosya yolunu dialoga gondermek icin gerekiyor 
    private static String seciliDosyaYolu;

    // Secili dosya yukleme bilgilerini tabloda gostermek icin gerekiyor
    private Dosya seciliDosyaNesnesi;

    // Secili dosyanin, dosya mi veya dizin mi oldugu kontrolu icin gerekiyor
    private boolean seciliDegerDosyaMi = false;

    //Yukleme sonucunu tasiyan durum mesaji degeri
    private static String durumMesaji;

    public static String getSeciliDosyaYolu() {
        return seciliDosyaYolu;
    }

}
