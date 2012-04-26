/**
 * Ilmoittaja stores name-value pairs in a hasmap and controls their duration
 */
package com.ahathoor.tetris.logic;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author User
 */
public class Ilmoittaja {
    private HashMap<String,Integer> ilmoitukset = new HashMap<String,Integer>();
    private boolean ticking = false;

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
        ticking = true;
        Set set = ((HashMap)ilmoitukset.clone()).entrySet(); 
        // Get an iterator 
        Iterator i = set.iterator(); 
        // Reduce values until <0, then delete it
        while(i.hasNext()) {
            Map.Entry<String,Integer> me = (Map.Entry)i.next(); 
            int value = me.getValue();
            if (value <= 0) 
                ilmoitukset.remove(me.getKey());
            else
                ilmoitukset.put(me.getKey(), value-1);
        }
        ticking = false;
    }
    /**
     * Nollaa Ilmoittajan
     */
    public void nollaa() {
        ilmoitukset = new HashMap();
    }
    /**
     * Palauttaa ilmoituksen Settinä 
     * "Ilmoitus%alkuduraatio",duraatio
     * @return 
     */
    public Set getIlmoitukset() {
        HashMap<String,Integer> palautus = new HashMap<String,Integer>();
        Iterator i = ilmoitukset.entrySet().iterator();
        while (i.hasNext()){
            Map.Entry<String,Integer> me = (Map.Entry) i.next();
            palautus.put(me.getKey().toString(),  me.getValue());
        }
        return palautus.entrySet(); 
    }
    /**
     * palauttaa true jos Ilmoittaja sisältää nimetyn ilmoituksen
     * @param s
     * @return 
     */
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
