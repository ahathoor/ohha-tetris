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
    
    ArrayList<PalikkaRivi> alusta;

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }
    
    public TetrisAlusta() throws Exception{
        /**luo uuden tetrisalustan
         * 
         */
        korkeus = 20;
        leveys = 15;
        //rakennetaan PalikkaRivi kerrallaan alusta
        for (int rivi = 0;rivi<=korkeus;rivi++) {
            alusta.add(new PalikkaRivi(leveys));
        }
        
        
    }
    /**
     * Päivittää laudan palikoiden sijainnit tetriksen sääntöjen mukaisesti
     */
    public void nextStep() {
        // TODO: skannaa kaikki liikkuvat palikat
        //yritä laskea niitä kaikkia alaspäin
        //jos ei onnistu, muuta kaikki palikat liikkumattomiksi
    }
    /**
     * Lisää palikan p kohtaan x,y,
     * jos negatiivinen tai yli laudan ei tee mitään
     */
    public void LisaaPalikka(Palikka p,int x,int y) throws Exception {

        if (x<0) return;
        if (x>leveys)return;
        if (y<0) return;
        if (y>korkeus) return;
        
        getPalikkaAt(x,y).setFilled(true);
    }
    public Palikka getPalikkaAt(int x,int y) throws Exception {

        if (x<0) throw new Exception("Palikkaa koitettiin hakea laudan ulkopuolelta");
        if (x>leveys) throw new Exception("Palikkaa koitettiin hakea laudan ulkopuolelta");
        if (y<0) throw new Exception("Palikkaa koitettiin hakea laudan ulkopuolelta");
        if (y>korkeus) throw new Exception("Palikkaa koitettiin hakea laudan ulkopuolelta");
        
        return alusta.get(y).getPalikat().get(y);
    }
}
