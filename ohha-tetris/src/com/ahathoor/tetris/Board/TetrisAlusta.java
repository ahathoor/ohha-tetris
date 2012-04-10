/*
 * Hallinnoi ArrayListia jossa säilytetään tetrispalikoiden sijainnit,
 */
package com.ahathoor.tetris.Board;

import com.ahathoor.tetris.Pelinkulku;
import java.util.ArrayList;

/**
 *
 * @author mkctammi
 */
public class TetrisAlusta {
    
    private Pelinkulku kuuluuPeliin;
    private int korkeus;
    private int leveys;
    private ArrayList<PalikkaRivi> alusta = new ArrayList<PalikkaRivi>();

    /**
     * Palauttaa laudan leveyden
     * @return laudan leveys
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     * 
     * @return
     */
    public int getKorkeus() {
        return korkeus;
    }
    /**
     * Lisää uuden palikkamuodon
     * @param muoto
     * @param x vasen yläkulma
     * @param y vasen yläkulma  
     * @param tyyppi
     * @return 
     */
    public boolean lisaaMuoto (ArrayList<int[]> muoto, int x, int y, Palikka tyyppi) {
        ArrayList<int[]> lisays = new ArrayList<int[]>();
        for (int[] c : muoto) {
            lisays.add(new int[] {x - c[0], y - c[1]});
        }
        return lisaaPalikat(lisays, tyyppi);
    }
    /**
     * 
     * @param lisays
     * @param tyyppi
     * @return
     */
    public boolean lisaaPalikat(ArrayList<int[]> lisays, Palikka tyyppi) {
        if (!this.mahtuuko(lisays)) return false;
        for (int [] c : lisays) {
            this.LisaaPalikka(c[0], c[1], tyyppi);
        }
        return true; 
    }
    /**
     * Luo uuden tetrisalustan
     * @param w laudan leveys
     * @param h laudan korkeus
     */
    public TetrisAlusta(int w,int h, Pelinkulku peli) {
        //rakennetaan PalikkaRivi kerrallaan alusta
        if (w<1) w = 5;
        if (h<1) h = 5;
        kuuluuPeliin = peli;
        korkeus = h;
        leveys = w;
        for (int rivi = 0;rivi<korkeus;rivi++) {
            alusta.add(new PalikkaRivi(leveys));
        }        
    }
    /**
     * 
     * @return
     */
    public boolean onkoLiikkuvia() {
        for (int x = 0; x < leveys; x++){
            for (int y=0;y < korkeus;y++) {
                if (!getPalikkaAt(x,y).isStopped()) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Palauttaa laudalta löytyvät liikkuvat blokit
     * 
     * @return liikkuvien palikoiden sijainnit koordinaattipareina
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
    /**
     * 
     */
    public void pysaytaKaikki() {
        ArrayList<int[]> liikkuvat = this.getLiikkuvat();
        for (int[] c : liikkuvat) {
            this.getPalikkaAt(c[0], c[1]).setStopped(true);
        }
    }
    /**
     * Kääntää kaikki liikkuvia palikoita kokonaisuutena vastapäivään
     */
    public void flipBlock() {
        ArrayList<int[]> liikkuvat = this.getLiikkuvat();
        ArrayList<int[]> liikkuvat_trans = new ArrayList<int[]>();
        ArrayList<float[]> relativePositions = new ArrayList<float[]>();
        //find the pivot of transformation of the moving blocks
        float xka;
        float yka;
        int xmax = 0;
        int ymax = 0;
        int xmin = Integer.MAX_VALUE;
        int ymin = Integer.MAX_VALUE;
        for (int[] coords : liikkuvat) {
            if (coords[0]>xmax) xmax = coords[0];
            if (coords[1]>ymax) ymax = coords[1];
            if (coords[0]<xmin) xmin = coords[0];
            if (coords[1]<ymin) ymin = coords[1];
        }
        xka = (xmin+xmax)/2;
        yka = (ymin+ymax)/2;
        //find the relative positions to the center
        for (int i = 0; i<liikkuvat.size();i++){
            float x = liikkuvat.get(i)[0] - xka;
            float y = liikkuvat.get(i)[1] - yka;
            relativePositions.add(new float[] {x,y});
        }
        //flip the x-y values of the relativity array
        for (int i = 0; i<relativePositions.size();i++){
            float x = relativePositions.get(i)[0];
            float y = relativePositions.get(i)[1];
            relativePositions.set(i, new float[] {y,x});
        }
        for (int i = 0; i<liikkuvat.size(); i++) {
            float x = xka - relativePositions.get(i)[0];
            float y = yka + relativePositions.get(i)[1];
            liikkuvat_trans.add(new int[] { (int) x,(int) y});
        }
        //attempt to put this new configuration on the board
        if (!this.mahtuuko(liikkuvat_trans)) return;
        this.siirraPalat(liikkuvat, liikkuvat_trans);
    }
    /**
     * Siirtää palikoita laudalla suhteellisen määrän
     * 
     * törmätessä esteeseen kaikki palikat pysäytetään
     * 
     * @param xshift paljon palikoita siirretään x-akselin suhteen
     * @param yshift paljon palikoita siirretään y-akselin suhteen
     * @return 
     */
    public boolean shiftBlocks(int xshift, int yshift) {
        ArrayList<int[]> liikkuvat = this.getLiikkuvat();
        ArrayList<int[]> liikkuvat_trans = new ArrayList<int[]>();
        
        for (int[] coords : liikkuvat) {
            liikkuvat_trans.add(new int[] {coords[0] + xshift, coords[1] + yshift});
        }
        
        if (!this.mahtuuko(liikkuvat_trans)) {
            return false;
        }
        
        this.siirraPalat(liikkuvat, liikkuvat_trans);
        return true;
    }
    /**
     * siirtää palikat koordinaattilistasta toiseen
     * @param mista mistä siirretään
     * @param minne minne siirretään
     */
    public void siirraPalat (ArrayList<int[]> mista,ArrayList<int[]> minne) {
        ArrayList<Palikka> vanhat = new ArrayList<Palikka>();
        for (int[] c : mista){
            vanhat.add(this.getPalikkaAt(c[0], c[1]).getCopy());
            this.getPalikkaAt(c[0], c[1]).clear();
        }
        int i = 0;
        for (int[] c : minne){
            this.getPalikkaAt(c[0], c[1]).copyAttributes(vanhat.get(i));
            i++;
        }
    }
    /**
     * Poistaa rivin laudalta
     * @param rivi 
     */
    public void poistaRivi(int rivi) {
        for (int i = 0; i<leveys;i++) {
            this.getPalikkaAt(i, rivi).clear();
        }
        for (int j = rivi; j<korkeus;j++) {
            for (int i = 0;i<leveys;i++) {
                if(!this.getPalikkaAt(i, j).isEmpty()) this.getPalikkaAt(i, j).setStopped(false);
            }
        }
    }
    /**
     * Tyhjentää alustan
     */
    public void poistaKaikki() {
        for (PalikkaRivi rivi : alusta) {
            rivi.clear();
        }
    }
    /**
     * Jos rivin jokainen palikka sisältää palikan, palauttaa true
     * @param rivi
     * @return 
     */
    public boolean riviOnTaysi(int rivi) {
        for (int i = 0; i<leveys;i++) {
            if(this.getPalikkaAt(i, rivi).isEmpty()) return false;
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
     * @param kokeilu 
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
     * lisää palikan laudalle
     * @param x 
     * @param y 
     * @param tyyppi palikka josta ominaisuudet kopioidaan
     */
    public void LisaaPalikka(int x,int y, Palikka tyyppi) {
        if (!laudalla(x,y)) return;
        getPalikkaAt(x,y).copyAttributes(tyyppi);
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
     * @param x 
     * @param y
     * @return onko piste laudalla 
     */
    public boolean laudalla(int x,int y){
        
        if (x<0) return false;
        if (x>leveys-1) return false;
        if (y<0)  return false;
        if (y>korkeus-1)  return false;
        return true;
    }

    public Pelinkulku getKuuluuPeliin() {
        return kuuluuPeliin;
    }
}
