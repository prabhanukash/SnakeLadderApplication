package com.company;

public class Player {
    String playerName;
    int playerId;
    public Player(String playerName,int playerId)
    {
        this.playerId=playerId;
        this.playerName=playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
