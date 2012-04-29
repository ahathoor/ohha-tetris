/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.logic;

/**
 *
 * @author ahathoor
 */
public class Ilmoitus {
    private String nimi;
    private int alkukesto;
    private int kesto;

    public Ilmoitus(String nimi, int kesto) {
        this.nimi = nimi;
        this.alkukesto = kesto;
        this.kesto = kesto;
    }

    public int getAlkukesto() {
        return alkukesto;
    }

    public int getKesto() {
        return kesto;
    }

    public String getNimi() {
        return nimi;
    }

    public void setKesto(int kesto) {
        this.kesto = kesto;
    }

    @Override
    public String toString() {
        return "nimi:" + nimi + ", alkukesto:" + alkukesto + ", kesto" + kesto;
    }
    
    
}
