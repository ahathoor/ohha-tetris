/*
 * Hallinnoi ArrayListia jossa säilytetään tetrispalikoiden sijainnit,
 */
package com.ahathoor.tetris;

import java.util.ArrayList;

/**
 *
 * @author mkctammi
 */
public class TetrisAlusta {
    
    private String gamestate;
    private int korkeus;
    private int leveys;
    
    ArrayList<PalikkaRivi> alusta = new ArrayList<PalikkaRivi>();

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }
    
    /**
     * Luo uuden tetrisalustan korkeus=20 leveys = 10
     */
    public TetrisAlusta() {
        this(10,20);
    }
    public TetrisAlusta(int w,int h) {
        korkeus = 20;
        leveys = 10;
        //rakennetaan PalikkaRivi kerrallaan alusta
        for (int rivi = 0;rivi<=korkeus;rivi++) {
            alusta.add(new PalikkaRivi(leveys));
        }        
    }
    /**
     * Siirtää palikoita alaspäin mikäli mahdollista, palauttaa true jos onnistui
     */
    public boolean shiftBlocks() {
        //kerätään liikkuvat blokit arraylistiin
        ArrayList<int[]> liikkuvat = new ArrayList<int[]>();
        for (int x = 0; x < leveys; x++){
            for (int y=0;y < korkeus;y++) {
                if (!getPalikkaAt(x,y).isStopped()) {
                    int[] lisays = {x,y};
                    liikkuvat.add(lisays);
                }
            }
        }
        for (int[] koordinaatti : liikkuvat){
            int x = koordinaatti[0];
            int y = koordinaatti[1];
            if(y==0) return false;
            if(!getPalikkaAt(x,y+1).isEmpty() && getPalikkaAt(x,y+1).isStopped()) return false;
        }
        for (int[] koordinaatti : liikkuvat){
            int x = koordinaatti[0];
            int y = koordinaatti[1];
            
            getPalikkaAt(x,y-1).copyAttributes(getPalikkaAt(x,y));
            getPalikkaAt(x,y).clear();
        }
        return true;
    }
    /**
     * Kääntää liikkuvat palikat kokonaisuutena
     */
    public void flipBlock() {
        //TODO liikkuvien palikoiden koordinaattien keskiarvon ympärillä pyörittämistä
    }
    
    
    /**
     * Lisää palikan kohtaan x,y,
     * jos negatiivinen tai yli laudan ei tee mitään
     */
    public void LisaaPalikka(int x,int y) {

        if (x<0) return;
        if (x>leveys)return;
        if (y<0) return;
        if (y>korkeus) return;
        
        getPalikkaAt(x,y).setFilled(true);
    }
    public void LisaaLiikkuvaPalikka(int x,int y) {
        this.getPalikkaAt(x, y).setFilled(true);
        this.getPalikkaAt(x, y).setStopped(false);
    }
    /**
     * Palauttaa palikan kohdassa x,y, palauttaa null jos kysytty ei laudalla
     * @param x
     * @param y
     * @return
     */
    public Palikka getPalikkaAt(int x,int y) {

        if (x<0) return null;
        if (x>leveys) return null;
        if (y<0)  return null;
        if (y>korkeus)  return null;
        
        return alusta.get(y).getPalikat().get(x);
    }
}
