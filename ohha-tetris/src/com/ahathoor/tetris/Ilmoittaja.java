// 1. harjoitukset, tehtävä 1.1, Mikko Tamminen
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author User
 */
public class Ilmoittaja {
    private HashMap ilmoitukset = new HashMap();

    public Ilmoittaja() {
    }
    /**
     * Lisää uuden ilmoituksen jollakin duraatiolla.
     * 
     * @param ilmoitus
     * @param duraatio 
     */
    public void ilmoita(String ilmoitus, int duraatio){
        ilmoitukset.put(ilmoitus + "%" + duraatio, duraatio);
    }
    /**
     * vähentää voimassa olevien ilmoitusten jäljelläolevaa kestoa
     * ja poistaa valmiit ilmoitukset
     */
    public void tick() {
        Set set = ilmoitukset.entrySet(); 
        // Get an iterator 
        Iterator i = set.iterator(); 
        // Reduce values until <0, then delete it
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next(); 
            int value = Integer.parseInt(me.getValue().toString());
            if (value <= 0) 
                ilmoitukset.remove(me.getKey());
            else
                ilmoitukset.put(me.getKey(), value-1);
        }
    }
    public void nollaa() {
        ilmoitukset = new HashMap();
    }
    /**
     * Palauttaa ilmoituksen Settinä 
     * "Ilmoitus%alkuduraatio",duraatio
     * @return 
     */
    public Set getIlmoitukset() {
        return ilmoitukset.entrySet(); 
    }
    public boolean hasIlmoitus(String s) {
        Set set = ilmoitukset.entrySet();
        Iterator i = set.iterator(); 
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next(); 
            String key = me.getKey().toString(); 
            if (key.split("%")[0].equals(s))
                return true;
        }
        return false;
    }
}
