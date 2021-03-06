/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.IObjekat;
import domen.Proizvod;
import java.util.List;
import javax.swing.JOptionPane;
import konstante.Konstante;
import logika.Kontroler;
import modeli.ModelTabeleProizvoda;
import povezivanje.Komunikacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Maja
 */
public class ManipulacijaProizvodima extends javax.swing.JFrame {
    
    GlavnaForma gf;

    /**
     * Creates new form ManipulacijaProizvodima
     */
    public ManipulacijaProizvodima() {
        initComponents();
        srediTabelu();
        
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
        tblProizvodi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnVratiMe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prikaz proizvoda");

        tblProizvodi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProizvodi);

        jLabel1.setText("Pretrazi po nazivu:");

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni proizvod");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi proizvod");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnVratiMe.setText("Vrati me na meni");
        btnVratiMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiMeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIzmeni)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnVratiMe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni)
                        .addGap(42, 42, 42)
                        .addComponent(btnObrisi))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnVratiMe)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        Proizvod p = new Proizvod();
        p.setNazivProizvoda(txtNaziv.getText());
        
        ServerskiOdgovor so = Kontroler.getInstanca().pretraziProizvode(p);

        if(so.isUspesno()){
            List<IObjekat> listaProizvoda = (List<IObjekat>) so.getOdgovor();
            ModelTabeleProizvoda mtp = (ModelTabeleProizvoda) tblProizvodi.getModel();
            mtp.setLista(listaProizvoda);
            if(listaProizvoda.isEmpty()){
                JOptionPane.showMessageDialog(this, "Sistem ne moze da pronadje proizvode po zadatim kriterijumima pretrage");
            }else{
                JOptionPane.showMessageDialog(this, "Sistem je pronasao proizvode po zadatim kriterijumima pretrage");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Sistem ne moze da pronadje proizvode po zadatim kriterijumima pretrage");        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int red = tblProizvodi.getSelectedRow();
        
        if(red != -1){
            ModelTabeleProizvoda mtp = (ModelTabeleProizvoda) tblProizvodi.getModel();
            Proizvod pr = mtp.dajProizvod(red);
            IzmenaProizvodaForma ipf = new IzmenaProizvodaForma(this, true, pr);
            ipf.pack();
            ipf.setVisible(true);    
        }
        else{
            JOptionPane.showMessageDialog(this, "Sistem ne moze da prikaze proizvod po zadatoj vrednosti","Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnVratiMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiMeActionPerformed
       gf.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnVratiMeActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int red = tblProizvodi.getSelectedRow();
        ModelTabeleProizvoda mtp = (ModelTabeleProizvoda) tblProizvodi.getModel();
        Proizvod p = mtp.dajProizvod(red);
        int response = JOptionPane.showConfirmDialog(this, "Da li sigurno zelite da obrisete proizvod " + p +"?", "Brisanje proizvoda", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.OK_OPTION) {
            
           ServerskiOdgovor so = Kontroler.getInstanca().obrisiProizvod(p);
           
           if (so.isUspesno()) {
                JOptionPane.showMessageDialog(this, so.getPoruka(), "Uspesno", JOptionPane.INFORMATION_MESSAGE);
                srediTabelu();
                
            } else {
                JOptionPane.showMessageDialog(this, so.getPoruka(), "Neuspesno", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

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
            java.util.logging.Logger.getLogger(ManipulacijaProizvodima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManipulacijaProizvodima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManipulacijaProizvodima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManipulacijaProizvodima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManipulacijaProizvodima().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnVratiMe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProizvodi;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    void setGlavna(GlavnaForma aThis) {
        this.gf = aThis;
    }

    private void srediTabelu() {
        Proizvod p = new Proizvod();
        p.setNazivProizvoda("");
        
        ServerskiOdgovor so = Kontroler.getInstanca().pretraziProizvode(p);

        if(so.isUspesno()){
            List<IObjekat> listaProizvoda = (List<IObjekat>) so.getOdgovor();
            ModelTabeleProizvoda mtp = new ModelTabeleProizvoda();
            mtp.setLista(listaProizvoda);
            tblProizvodi.setModel(mtp);
        }else{
            JOptionPane.showMessageDialog(this, "Neuspesno ucitana lista proizvoda","Greska", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
