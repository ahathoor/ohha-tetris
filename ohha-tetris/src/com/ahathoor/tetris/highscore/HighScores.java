// 1. harjoitukset, tehtävä 1.1, Mikko Tamminen
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.highscore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

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
        if (this.hasRoomForScore(game)){
            scores.get(game).put(name, score);
            return;
        }
        if (this.thereIsLower(game, score)){
            kickOutLowest(game);
            scores.get(game).put(name, score);
        }
    }

    @Override
    public String toString() {
        String palautus = "";
        for (String game : scores.keySet()) {
            palautus += (game + ":\n");
            for (String name : scores.get(game).keySet()) {
                palautus += "\t" + name + "   ---   " + scores.get(game).get(name) + "\n";
            }
        }
        return palautus;
    }
    
    public static void main(String[] args) {
        HighScores hs = new HighScores();
        hs.putScore("AlloBallo", "yy", 99999);
        hs.putScore("AlloBallo", "kaa", 199999);
        hs.putScore("AlloBallo", "koo", 199999);
        hs.putScore("AlloBallo", "ne", 199999);
        hs.putScore("AlloBallo", "vi", 199999);
        hs.putScore("AlloBallo", "ku", 199999);
        hs.putScore("AlloBallo", "se", 199999);
        hs.putScore("AlloBallo", "kaas", 199999);
        hs.putScore("AlloBallo", "yys", 199999);
        hs.putScore("AlloBallo", "kyyb", 199999);
        hs.putScore("AlloBallo", "yyto", 199999);
        hs.putScore("AlloBallo", "kaato", 199999);
        hs.writeToFile("data/scores.dat");
        System.out.println(hs.toString());
    }
}
