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
        //rakennetaan PalikkaRivi kerrallaan alusta
        if (w<1) w = 5;
        if (h<1) h = 5;
        korkeus = h;
        leveys = w;
        for (int rivi = 0;rivi<korkeus;rivi++) {
            alusta.add(new PalikkaRivi(leveys));
        }        
    }
    /**
     * Pyrkii siirtämään palikoita suhteellisesti määrän xshift,yshift
     */
    public boolean shiftBlocks(int xshift, int yshift) {
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
            if(!laudalla(x+xshift,y+yshift)) return false;
            if(!getPalikkaAt(x+xshift,y+yshift).isEmpty() && getPalikkaAt(x+xshift,y+yshift).isStopped()) return false;
        }
        for (int[] koordinaatti : liikkuvat){
            int x = koordinaatti[0];
            int y = koordinaatti[1];
            
            getPalikkaAt(x+xshift,y+yshift).copyAttributes(getPalikkaAt(x,y));
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
        if (!laudalla(x,y)) return;
        getPalikkaAt(x,y).setFilled(true);
    }
    public void LisaaLiikkuvaPalikka(int x,int y) {
        if (!laudalla(x,y)) return;
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

        if(!laudalla(x,y)) return null;
        
        return alusta.get(y).getPalikat().get(x);
    }
    /**
     * Palauttaa onko x,y piste laudalla
     */
    public boolean laudalla(int x,int y){
        
        if (x<0) return false;
        if (x>leveys-1) return false;
        if (y<0)  return false;
        if (y>korkeus-1)  return false;
        return true;
    }
}
