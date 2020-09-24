/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.IObjekat;
import domen.Racun;
import domen.StavkaRacuna;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Maja
 */
public class ModelTabeleRacuna extends AbstractTableModel{
    
    List<IObjekat> listaRacuna;
    String[] naziviKolona = {"Pozicija", "Datum", "Proizvodi", "Ukupan iznos"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    
    public ModelTabeleRacuna() {
        listaRacuna = new ArrayList<>();
    }
    
    

    @Override
    public int getRowCount() {
        return listaRacuna.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racun r = (Racun) listaRacuna.get(rowIndex);
        switch(columnIndex){
            case 0: return r.getPozicija();
            case 1: return sdf.format(r.getDatumIzrade());
            case 2: String proizvodi = "";
                    for (StavkaRacuna sr : r.getListaStavki()) {
                        proizvodi+=sr.getProizvod()+", ";
                    }
                    return proizvodi;
               
            case 3: return r.getUkupanIznos()+"";
            default: return "";
        }
     }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public Racun dajRacun(int red) {
        return (Racun) listaRacuna.get(red);
    }

    public void setLista(List<IObjekat> listaRacuna) {
        this.listaRacuna = listaRacuna;
    }
    
    
    }
    
    

