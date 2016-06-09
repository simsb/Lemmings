package com.plus.blakesroad.lemmings;

/**
 * Created by ben on 09/06/16.
 */
public class LemmingsRunner {

    public static void main(String [] args) {
        final Plank plank = new Plank(9999);
        plank.newGame();
        int highMoves = 0;
        for (int i = 0; i < 1; i++) {
            final int moves = plank.runLemmings();
            if (moves > highMoves) {
                highMoves = moves;
            }
        }
        System.out.println("Lemmings longest was " + highMoves);

    }
}
