package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc= new Scanner(System.in);
        System.out.println("Input the Size of Board: ");
        int boardSize= sc.nextInt();
        System.out.println("Input the no of dices : ");
        int noOfdices=sc.nextInt();
        Dice d= new Dice(noOfdices);
        Player p1= new Player("bhanu",1);
        Player p2= new Player("Prakash", 2);
      //  Player p3= new Player("Srinivas", 3);

        Queue<Player>allPlayers=new LinkedList<>();
        allPlayers.offer(p1);
        allPlayers.offer(p2);
     //   allPlayers.offer(p3);
        System.out.println("Input the no of Snakes int the Board: ");
        int noOfSnakes=sc.nextInt();
        List<Jumper> snakes= new ArrayList<>(noOfSnakes);
        for(int i=0;i<noOfSnakes;i++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            snakes.add(new Jumper(x,y));
        }
        System.out.println("Input the no of Ladders int the Board: ");
        int noOfLadders=sc.nextInt();
        List<Jumper> ladders= new ArrayList<>(noOfLadders);
        for(int i=0;i<noOfLadders;i++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            ladders.add(new Jumper(x,y));
        }
        Map<String,Integer> playerCurrentPosition = new HashMap<>();
        playerCurrentPosition.put("bhanu",0);
        playerCurrentPosition.put("Prakash",0);
      //  playerCurrentPosition.put("Srinivas",0);
        Board b= new Board(d,allPlayers,snakes,ladders,playerCurrentPosition,boardSize);
        b.startGame();
    }
}
