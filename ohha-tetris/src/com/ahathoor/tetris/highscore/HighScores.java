/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.highscore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author User
 */
public class HighScores {
    private HashMap<String,HashMap<String,Integer>> scores;
    private int scoresPerGame = 10;

    public HighScores() {
        scores = new HashMap<String,HashMap<String,Integer>>();
    }

    public HighScores(String path) {
        this();
        readFromFile(path);
    }
    /**
     * Returns the nth highest score
     * @param game
     * @param position
     * @return 
     */
    public ArrayList<Score> sortedScore(String game){
        ArrayList<Score> palautus = new ArrayList<Score>();
        if (!scores.containsKey(game)) {
            palautus.add(new Score("Nosuchgame - " + game,666));
            return palautus;
        }
        int size = scores.get(game).size();
        //Kootaan arvoparit kahteen taulukkoon
        String[] nimet = new String[size];
        String[] nimet_sort = new String[size];
        int[] scoret = new int[size];
        int[] scoret_sort = new int[size];
        int f = 0;
        for (Entry<String,Integer> pari : scores.get(game).entrySet()) {
            nimet[f] = pari.getKey();
            scoret[f] = pari.getValue();
            f++;
        }
        //Järjestetään taulukot
        for (int i=0; i<size; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int j=0;j<size;j++) {
                if (scoret[j]>max) {
                    max = scoret[j];
                    maxIndex = j;
                }
            }
            scoret_sort[i] = scoret[maxIndex];
            scoret[maxIndex] = Integer.MIN_VALUE;
            nimet_sort[i] = nimet[maxIndex];
        }
        for (int i = 0;i<size;i++) {
            palautus.add(new Score(nimet_sort[i].split("%split%")[1],scoret_sort[i]));
        }
        return palautus;
    }
    public boolean readFromFile(String path) {
        HashMap<String,HashMap<String,Integer>> map = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try
        {
            fis = new FileInputStream(path);
            in = new ObjectInputStream(fis);
            map = (HashMap<String,HashMap<String,Integer>>)in.readObject();
            in.close();
        }
        catch(Exception ex) {
            return false;
        }
        scores = map;
        return true;
    }
    public boolean writeToFile(String path) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try
        {
            fos = new FileOutputStream(path);
            out = new ObjectOutputStream(fos);
            out.writeObject(scores);
            out.close();
        }
        catch(Exception ex) {
            return false;
        }
        return true;
    }
    public boolean canTakeScore(String game,int score) {
        if (thereIsLower(game,score)) return true;
        if (hasRoomForScore(game)) return true;
        return false;
    }
    private boolean thereIsLower(String game, int score) {
        if(scores.containsKey(game)){
            for (int value : scores.get(game).values()){
                if(value<score) return true;
            }
        }
        else {
            scores.put(game, new HashMap<String,Integer>());
            return true;
        }
        return false;
        
    }
    private boolean hasRoomForScore(String game) {
        if(scores.containsKey(game)){
            if (scores.get(game).size()<this.scoresPerGame)
                return true;
        }
        else {
            scores.put(game, new HashMap<String,Integer>());
            return true;
        }
        return false;
    }
    private void kickOutLowest(String game) {
        int min = Integer.MAX_VALUE;
        String minkey = "";
        for (Entry<String,Integer> pair : scores.get(game).entrySet()){
            if(pair.getValue()<min) {
                min = pair.getValue();
                minkey = pair.getKey();
            }
        }
        scores.get(game).remove(minkey);
    }
    public void putScore(String game, String name, int score) {
        Calendar cal = Calendar.getInstance();
        String time = cal.getTime().toString();
        if (this.hasRoomForScore(game)){
            scores.get(game).put(time + "%split%" + name , score);
            return;
        }
        if (this.thereIsLower(game, score)){
            kickOutLowest(game);
            scores.get(game).put(time + "%split%" + name, score);
        }
    }
    @Override
    public String toString() {
        String palautus = "";
        for (String game : scores.keySet()) {
            palautus += (game + ":\n");
            for (String name : scores.get(game).keySet()) {
                palautus += "\t" + name.split("%split%")[1] + "   ---   " + scores.get(game).get(name) + "\n";
            }
        }
        return palautus;
    }
    
    public static void main(String[] args) {
    }
}
