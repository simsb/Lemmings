package com.plus.blakesroad.lemmings;

import java.util.*;

/**
 * Created by ben on 09/06/16.
 */
public class Plank {
    private ArrayList<Lemming> lemmings;
    private Random random = new Random();
    private final int resolution;

    public Plank(final int resolution) {
        this.resolution = resolution;
        lemmings = new ArrayList<Lemming>();
    }

    public void newGame() {
        for (int i = 0; i<10; i++) {
            lemmings.clear();
            final Lemming lemming = new Lemming(i, pickRandomPosition(), pickRandomDirection());
            System.out.println(lemming.toString());
            lemmings.add(lemming);
        }
    }

    public int runLemmings() {
        int moves = 0;
        while (!lemmings.isEmpty()) {
            moveLemmings();
            checkCollisions();
            discardJumpers();
            moves++;
        }
        return moves;
        //System.out.println("Lemmings in the water after " + moves);

    }

    private void discardJumpers() {
        ArrayList<Lemming> stillOnPlank = new ArrayList<Lemming>();
        for (int i = 0; i< lemmings.size(); i++) {
            final Lemming lemming = lemmings.get(i);
            if (lemming.getPosition() > 0 && lemming.getPosition() <= resolution) {
                stillOnPlank.add(lemming);
            }
        }
        lemmings.clear();
        lemmings.addAll(stillOnPlank);
    }

    private void checkCollisions() {
        ArrayList<Integer> changers = new ArrayList<Integer>();
        for (final Lemming lemming : lemmings) {
            for (final Lemming other : lemmings) {
                if (lemming.getId() != other.getId() && lemming.getPosition() == other.getPosition()) {
                    if (!changers.contains(lemming.getId())) {
                        lemming.changeDirection();
                        changers.add(lemming.getId());
                    }
                    if (!changers.contains(other.getId())) {
                        other.changeDirection();
                        changers.add(other.getId());
                    }
                }
            }
        }
    }

    private void moveLemmings() {
        for (final Lemming lemming : lemmings) {
            lemming.move();
        }
    }

    private int pickRandomPosition() {
        return (int)(Math.random() * resolution);
    }

    private int pickRandomDirection() {
        return random.nextBoolean() ? 1 : -1;
    }
}
