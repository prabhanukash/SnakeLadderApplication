package com.company;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Board {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String,Integer> playerCurrentPosition;
    int boardSize;
    public Board(Dice dice,Queue<Player>nextTurn,List<Jumper> snakes,List<Jumper> ladders,Map<String,Integer> playerCurrentPosition,int boardSize)
    {
        this.dice=dice;
        this.nextTurn=nextTurn;
        this.snakes=snakes;
        this.ladders=ladders;
        this.playerCurrentPosition=playerCurrentPosition;
        this.boardSize=boardSize;
    }
    void startGame()
    {
        while (nextTurn.size()>1)
        {
            Player player=nextTurn.poll();
            int currentPosition=playerCurrentPosition.get(player.getPlayerName());
            int diceValue=dice.rollDice();
            int nextcell=currentPosition+diceValue;
            if(nextcell>boardSize)nextTurn.offer(player);
            else if (nextcell==boardSize)
            {
            System.out.println(player.getPlayerName()+" Won the game");
            }
            else
            {
                int nextPosition=nextcell;
                boolean flg=false;
                for(Jumper j:snakes)
                {
                    int startPosition= j.startPosition;
                    if(startPosition==nextcell)
                    {
                        nextPosition=j.endPosition;
                        break;
                    }
                }
                if (nextPosition!=nextcell)System.out.println(player.getPlayerName()+" Bitten by the snake at : "+nextcell);
                for(Jumper j:ladders)
                {
                    int startPosition= j.startPosition;
                    if(startPosition==nextcell)
                    {
                        nextPosition=j.endPosition;
                        flg=true;
                        break;
                    }
                }
                if (nextPosition!=nextcell && flg==true)System.out.println(player.getPlayerName()+" Got Ladder Present at : "+nextcell+" by rolling "+diceValue);
                if (boardSize==nextPosition)
                {
                    System.out.println(player.getPlayerName()+" Won the game");
                }
                else
                {
                    playerCurrentPosition.put(player.getPlayerName(),nextPosition);
                    System.out.println(player.getPlayerName()+" rolled a "+diceValue+" and moved from "+currentPosition+" to " + nextPosition);
                    nextTurn.offer(player);
                }
            }
        }
    }
}
