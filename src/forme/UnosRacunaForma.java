/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.IObjekat;
import domen.Pozicija;
import domen.Proizvodjac;
import domen.Racun;
import domen.Radnik;
import domen.StavkaRacuna;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import konstante.Konstante;
import logika.Kontroler;
import modeli.ModelTabeleStavki;
import povezivanje.Komunikacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Maja
 */
public class UnosRacunaForma extends javax.swing.JFrame {
    
    IObjekat radnik;
    GlavnaForma gf;
    ManipulacijaRacunima manRac;


    /**
     * Creates new form UnosRacunaForma
     */
    public UnosRacunaForma(IObjekat radnik, GlavnaForma gf) {
        initComponents();
        tblStavke.setModel(new ModelTabeleStavki());
        this.radnik = radnik;
        this.gf = gf;
        popuniPozicije();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbPozicije = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtIznos = new javax.swing.JTextField();
        btnVratiMe = new javax.swing.JButton();
        btnVratiNaPrikaz = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Unos racuna");

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblStavke);

        btnDodaj.setText("Dodaj ");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj racun");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel2.setText("Pozicija:");

        cmbPozicije.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Ukupan iznos:");

        txtIznos.setEditable(false);

        btnVratiMe.setText("Vrati me na glavni meni");
        btnVratiMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiMeActionPerformed(evt);
            }
        });

        btnVratiNaPrikaz.setText("Vrati na prikaz");
        btnVratiNaPrikaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiNaPrikazActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(51, 51, 51)
                                .addComponent(cmbPozicije, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnVratiMe)
                                .addGap(18, 18, 18)
                                .addComponent(btnVratiNaPrikaz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbPozicije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVratiMe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVratiNaPrikaz, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVratiMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiMeActionPerformed
        gf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVratiMeActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        DodajStavkuForma dsf = new DodajStavkuForma(this, true);
        dsf.pack();
        dsf.setVisible(true);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int red = tblStavke.getSelectedRow();
        ModelTabeleStavki mts = (ModelTabeleStavki) tblStavke.getModel();
        if(red != -1){
            mts.obrisiStavku(red);
            srediUkupanIznos();
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        ModelTabeleStavki mts = (ModelTabeleStavki) tblStavke.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date datum = sdf.parse(sdf.format(new Date()));
            double ukupanIznos = Double.parseDouble(txtIznos.getText());
            Pozicija poz = (Pozicija) cmbPozicije.getSelectedItem();
            ArrayList<StavkaRacuna> listaS = mts.getListaStavki();
            if(listaS.isEmpty()){
                JOptionPane.showMessageDialog(this, "Racun mora imati barem 1 stavku");
                return;
            }
            Racun r = new Racun(-1, datum, ukupanIznos, poz, (Radnik) radnik, listaS);
            
            ServerskiOdgovor so = Kontroler.getInstanca().sacuvajRacun(r);

            if(so.isUspesno()){
                ocistiFormu();
                JOptionPane.showMessageDialog(this, so.getPoruka());
            }else{
                JOptionPane.showMessageDialog(this, so.getPoruka());
            }
        } catch (ParseException ex) {
            Logger.getLogger(UnosRacunaForma.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnVratiNaPrikazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiNaPrikazActionPerformed
        this.dispose();
        manRac.setVisible(true);
    }//GEN-LAST:event_btnVratiNaPrikazActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnVratiMe;
    private javax.swing.JButton btnVratiNaPrikaz;
    private javax.swing.JComboBox cmbPozicije;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtIznos;
    // End of variables declaration//GEN-END:variables

    private void popuniPozicije() {
        ServerskiOdgovor so = Kontroler.getInstanca().vratiPozicije();

        if(so.isUspesno()){
          List<IObjekat> lista = (List<IObjekat>) so.getOdgovor();
            cmbPozicije.removeAllItems();
            for (IObjekat iObjekat : lista)
                cmbPozicije.addItem(iObjekat);
        }
        else{
            JOptionPane.showMessageDialog(this, so.getPoruka(),"Greska", JOptionPane.ERROR_MESSAGE);
        }    
    }

    void dodajStavku(StavkaRacuna sr) {
        ModelTabeleStavki mts = (ModelTabeleStavki) tblStavke.getModel();
        ArrayList<StavkaRacuna> lista = mts.getListaStavki();
        for (StavkaRacuna stavkaRacuna : lista) {
            if(sr.equals(stavkaRacuna)){
                mts.osveziKolicinu(stavkaRacuna, sr.getKolicina());
                srediUkupanIznos();
                return;
            }
        }
        mts.dodajStavku(sr);
        srediUkupanIznos();
    }

    private void srediUkupanIznos() {
        ModelTabeleStavki mts = (ModelTabeleStavki) tblStavke.getModel();
        ArrayList<StavkaRacuna> lista = mts.getListaStavki();
        double ukupanIznos = 0.00;
        
        for (StavkaRacuna st : lista) 
            ukupanIznos+=st.getIznos();
        
        txtIznos.setText(ukupanIznos+"");
    }

    private void ocistiFormu() {
        txtIznos.setText("");
        tblStavke.setModel(new ModelTabeleStavki());        
    }


    void srediFormuZaDetalje(Racun r) {
        ModelTabeleStavki mts = new ModelTabeleStavki();
        btnDodaj.setVisible(false);
        btnObrisi.setVisible(false);
        btnSacuvaj.setVisible(false);
        btnVratiMe.setVisible(false);
        
        cmbPozicije.setSelectedItem(r.getPozicija());
        txtIznos.setText(r.getUkupanIznos()+"");
        ArrayList<StavkaRacuna> lista = r.getListaStavki();
        List<IObjekat> listaObj = new ArrayList<>();
        
        for (StavkaRacuna iObjekat : lista) 
            listaObj.add(iObjekat);
        mts.setListaStavki(listaObj);
        tblStavke.setModel(mts);
    }

    void setForma(ManipulacijaRacunima aThis) {
        manRac=aThis;
    }

    void srediZaUnos() {
        btnVratiNaPrikaz.setVisible(false);
    }
}