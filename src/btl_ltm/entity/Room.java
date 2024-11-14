/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_ltm.entity;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Room implements Serializable{
    private static final long serialVersionUID = 2L;
    
    private int id;
    private int bestScore;
    private String winner;
    private int enable;
    private int totalCompleted;
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public int getBestScore() {
        return bestScore;
    }

    public String getWinner() {
        return winner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(int totalCompleted) {
        this.totalCompleted = totalCompleted;
    }
    
    
}
