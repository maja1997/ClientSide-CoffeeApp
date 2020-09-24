/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.IObjekat;
import domen.Proizvod;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maja
 */
public class ModelTabeleProizvoda extends AbstractTableModel{

    List<IObjekat> listaProizvoda;
    String[] naziviKolona = {"Naziv proizvoda", "Cena", "Opis", "Proizvodjac"};
    
    public ModelTabeleProizvoda() {
        listaProizvoda = new ArrayList<>() ;
    }

    @Override
    public int getRowCount() {
        return listaProizvoda.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proizvod p = (Proizvod) listaProizvoda.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getNazivProizvoda();
            case 1: return p.getCena();
            case 2: return p.getOpis();
            case 3: return p.getProizvodjac();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public void setLista(List<IObjekat> listaProizvoda) {
        this.listaProizvoda = listaProizvoda;
        fireTableDataChanged();
    }

    public Proizvod vratiSelektovaniProizvod(int red) {
        return (Proizvod) listaProizvoda.get(red);
    }

    public Proizvod dajProizvod(int red) {
        return (Proizvod) listaProizvoda.get(red);
    }
    
    
    
    
}
