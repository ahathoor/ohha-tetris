
package com.ahathoor.tetris.logic;

import java.util.*;

/**
 * Ilmoittaja säilyttää ilmoituksia listassa, ja vähentää niiden kestoa ja poistaa ne tarvittaessa
 * @author User
 */
public class Ilmoittaja {
    private ArrayList<Ilmoitus> ilmoitukset = new ArrayList<Ilmoitus>();
    
    public Ilmoittaja() {
    }
    /**
     * Lisää uuden ilmoituksen jollakin duraatiolla.
     * 
     * @param ilmoitus
     * @param duraatio 
     */
    public void ilmoita(String nimi, int duraatio){
        ilmoitukset.add(new Ilmoitus(nimi,duraatio));
    }
    /**
     * vähentää voimassa olevien ilmoitusten jäljelläolevaa kestoa
     * ja poistaa valmiit ilmoitukset
     */
    public void tick() {
        for (int i=0;i<ilmoitukset.size();i++) {
            Ilmoitus il = ilmoitukset.get(i);
            il.setKesto(il.getKesto()-1);
            if (il.getKesto()<1)
                ilmoitukset.remove(il);
        }
        }
    /**
     * Nollaa Ilmoittajan
     */
    public void nollaa() {
        ilmoitukset = new ArrayList<Ilmoitus>();
    }
    /**
     * Palauttaa ilmoituksen
     * @return 
     */
    public ArrayList<Ilmoitus> getIlmoitukset() {
        return ilmoitukset;
    }
    }
