/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Pozicija;
import domen.Proizvod;
import domen.Proizvodjac;
import domen.Racun;
import domen.Radnik;
import konstante.Konstante;
import povezivanje.Komunikacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Maja
 */
public class Kontroler {
    private static Kontroler instanca;

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if(instanca==null)
            instanca=new Kontroler();
        return instanca;
    }

    public ServerskiOdgovor vratiProizvode() {
        Proizvod pr = new Proizvod();
        pr.setNazivProizvoda("");
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.VRATI_PROIZVODE, pr);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniProizvod(Proizvod izmenjen) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.IZMENA_PROIZVODA, izmenjen);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor prijaviNaSistem(Radnik r) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.ULOGUJ_RADNIKA, r);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor pretraziProizvode(Proizvod p) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.PRETRAGA_PROIZVODA, p);
        Komunikacija.getInstance().posaljiZahtev(kz);        
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;    
    }

    public ServerskiOdgovor obrisiProizvod(Proizvod p) {
            KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.BRISANJE_PROIZVODA, p);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            return so;
    }

    public ServerskiOdgovor obrisiRacun(Racun r) {
            KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.BRISANJE_RACUNA, r);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            return so;
    }

    public ServerskiOdgovor pretraziRacune(Racun r) {
            KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.PRETRAGA_RACUNA, r);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            return so;
    }

    public ServerskiOdgovor unesiProizvod(Proizvod proizvod) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.UNOS_PROIZVODA, proizvod);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor(); 
        return so;
    }

    public ServerskiOdgovor vratiProizvodjace() {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.VRATI_PROIZVODJACE, new Proizvodjac());        
        Komunikacija.getInstance().posaljiZahtev(kz);       
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor sacuvajRacun(Racun r) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.UNOS_RACUNA, r);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();   
        return so;
    }

    public ServerskiOdgovor vratiPozicije() {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.VRATI_POZICIJE, new Pozicija());
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();    
        return so;
    }

    public String zavrsiSaRadom() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Konstante.KRAJ_RADA);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so.getPoruka();    
    }
    
    
}
