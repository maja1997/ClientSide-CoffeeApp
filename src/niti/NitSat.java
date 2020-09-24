/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Maja
 */
public class NitSat extends Thread{
    JLabel lblSat;

    public NitSat(JLabel lblSat) {
        this.lblSat = lblSat;
    }

    @Override
    public void run() {
        while(true){
            lblSat.setText(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
        }
    }
    
}
