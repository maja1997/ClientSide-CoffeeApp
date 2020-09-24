/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.IObjekat;
import domen.StavkaRacuna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maja
 */
public class ModelTabeleStavki extends AbstractTableModel{
    
    List<IObjekat> listaStavki;
    String[] naziviKolona = {"Rb", "Proizvod", "Cena", "Kolicina", "Iznos"};

    public ModelTabeleStavki() {
        listaStavki = new ArrayList<>();
    }

    public void setListaStavki(List<IObjekat> listaStavki) {
        this.listaStavki = listaStavki;
        fireTableDataChanged();
    }
    
    
    

    @Override
    public int getRowCount() {
        return listaStavki.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna sr = (StavkaRacuna) listaStavki.get(rowIndex);
        
        switch(columnIndex){
            case 0 : return sr.getRb();
            case 1: return sr.getProizvod();
            case 2: return sr.getProizvod().getCena();
            case 3: return sr.getKolicina();
            case 4: return sr.getProizvod().getCena()*sr.getKolicina();
            
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public void dodajStavku(StavkaRacuna sr) {
        listaStavki.add(sr);
        srediRedneBrojeve();
        fireTableDataChanged();
    }

    public ArrayList getListaStavki() {
        return (ArrayList) listaStavki;
    }

    private void srediRedneBrojeve() {
        ArrayList<StavkaRacuna> lista = (ArrayList)listaStavki;
        int brojac = 1;
        for (StavkaRacuna st : lista) {
            st.setRb(brojac++);
        }
    }

    public void obrisiStavku(int red) {
        listaStavki.remove(red);
        srediRedneBrojeve();
        fireTableDataChanged();
    }


    public void osveziKolicinu(StavkaRacuna stavkaRacuna, int kolicina) {
        int kol = stavkaRacuna.getKolicina();
        stavkaRacuna.setKolicina(kol+kolicina);
        fireTableDataChanged();
    }

  
    
    
    
    
}
