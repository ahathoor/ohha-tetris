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
     * Palauttaa laudalta löytyvät liikkuvat blokit
     * ArrayListinä koordinaattipareina
     * @return 
     */
    public ArrayList<int[]> getLiikkuvat() {
    
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
        return liikkuvat;
    }
    public void pyorita() {
        //find the center of gravity of the moving blocks
        
        //arrange blocks to an arraylist 
        //where values are relative to this block
        
        //flip the x-y values of the relativity array
        
        //attempt to put this new configuration on the board
    }
    /**
     * Pyrkii siirtämään palikoita suhteellisesti määrän xshift,yshift
     */
    public boolean shiftBlocks(int xshift, int yshift) {
        ArrayList<int[]> liikkuvat = this.getLiikkuvat();
        ArrayList<int[]> liikkuvat_trans = new ArrayList<int[]>();
        
        for (int[] coords : liikkuvat) {
            liikkuvat_trans.add(new int[] {coords[0] + xshift, coords[1] + yshift});
        }
        
        if (!this.mahtuuko(liikkuvat_trans)) return false;
        
        int i = 0;
        for (int[] coords : liikkuvat_trans) {
            Palikka uusi = this.getPalikkaAt(coords[0], coords[1]);
            int[] oldcoords = liikkuvat.get(i);
            Palikka vanha = this.getPalikkaAt(oldcoords[0], oldcoords[1]);
            uusi.copyAttributes(vanha);
            if (!liikkuvat_trans.contains(oldcoords)) {
                vanha.clear();
            }
            i++;
        }
        return true;
    }
    /**
     * poistaa laudalta poistettavat palikat
     * @param poistettavat 
     */
    public void poistaLaudalta(ArrayList<int[]> poistettavat) {
        for (int[] koordinaatti : poistettavat) {
            this.getPalikkaAt(koordinaatti[0], koordinaatti[1]).clear();
        }
    }
    /**
     * Kertoo onko annetulle koordinaattiarraylistille tilaa laudalla
     * ; onko se laudalla, ja onko se menossa liikkumattomien palikoiden päälle
     * @param palikat
     * @return 
     */
    public boolean mahtuuko(ArrayList<int[]> kokeilu) {
        for (int[] koordinaatti : kokeilu) {
            if (!this.laudalla(koordinaatti[0], koordinaatti[1])) return false;
            if (!this.getPalikkaAt(koordinaatti[0], koordinaatti[1]).isEmpty() && this.getPalikkaAt(koordinaatti[0], koordinaatti[1]).isStopped()) return false;
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
