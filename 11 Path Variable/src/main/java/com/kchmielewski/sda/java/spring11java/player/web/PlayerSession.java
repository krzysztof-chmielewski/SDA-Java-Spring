package com.kchmielewski.sda.java.spring11java.player.web;

import com.kchmielewski.sda.java.spring11java.player.model.Player;

public class PlayerSession {
    private int counter;
    private Player mostRecentPlayer;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Player getMostRecentPlayer() {
        return mostRecentPlayer;
    }

    public void setMostRecentPlayer(Player mostRecentPlayer) {
        this.mostRecentPlayer = mostRecentPlayer;
    }
}
