package com.plus.blakesroad.lemmings;

/**
 * Created by ben on 09/06/16.
 */
public class Lemming {

    private final int id;
    private int direction;
    private int position;

    public Lemming(final int id, int position, int direction) {
        this.id = id;
        this.position = position;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void changeDirection() {
        this.direction = this.direction == 1 ? -1 : 1;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position+=direction;
    }

    @Override
    public String toString() {
        return "Lemming " + getId() + " pos " + position + " dir " + direction;
    }

    public int getId() {
        return id;
    }
}
