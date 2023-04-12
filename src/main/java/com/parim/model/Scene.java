package com.parim.model;

import com.parim.model.Tiling.Area;
import com.parim.model.Tiling.Pipe;
import com.parim.model.Tiling.Tile;

import java.util.ArrayList;

public class Scene {
    transient private static Scene instance;
    private Mario mario;
    private ArrayList<Tile> gameObjects;
    private int marioX = 150, marioY = 832 - 3 * 60 - Mario.getSize() + 40;
    public Scene(){
        instance = this;
    }

    public void addTile(Tile tile){
        gameObjects.add(tile);
    }


    public ArrayList<Tile> getGameObjects() {
        return gameObjects;
    }

    public boolean intersectUp(){
        marioY = mario.getY();
        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            if ((marioX+Mario.getSize() > area.getLeft() && marioX < area.getRight()) &&
                (marioY <= area.getDown() && marioY >= area.getUp())) {
                //System.out.println("Up: \nMario: " + marioX + " " + marioY + "\nTile: " + area.getLeft() + ", " + area.getRight() + ", " + area.getUp() + ", " + area.getDown() + "\n");
                return true;
            }
        }
        return false;
    }
    public boolean intersectDown(){
        marioY = mario.getY();
        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            if ((marioX+Mario.getSize() > area.getLeft() && marioX < area.getRight()) &&
                (marioY+Mario.getSize() <= area.getDown() && marioY+Mario.getSize() >= area.getUp())) {
                mario.setY(area.getUp()-Mario.getSize());
                System.out.println("Down: \nMario: " + marioX + " " + marioY + "\nTile: " + area.getUp() + ", " + area.getDown() + ", " + area.getLeft() + ", " + area.getRight() + "\n");
                return true;
            }
        }
        return false;
    }
    public boolean intersectRight(){
        marioY = mario.getY();

        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            if ((marioY+Mario.getSize() > area.getUp() && marioY < area.getDown()) &&
                (marioX+Mario.getSize() >= area.getLeft() && marioX+Mario.getSize() <= area.getRight())) {
                //if (tile instanceof Pipe)
                //    System.out.println("pipe");
                //System.out.println("Right: \nMario: " + marioX + " " + marioY + "\nTile: " + area.getLeft() + ", " + area.getRight() + ", " + area.getUp() + ", " + area.getDown() + "\n");
                return true;
            }
        }
        return false;
    }
    public boolean intersectLeft(){
        marioY = mario.getY();

        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            if ((marioY+Mario.getSize() > area.getUp() && marioY < area.getDown()) &&
                (marioX <= area.getRight()) && marioX >= area.getLeft()) {
                //System.out.println("Left: " + mario.getX() + "   " + tile.getX() + " -> " + tile);
                return true;
            }
        }
        return false;
    }

    public static Scene getInstance() {
        return instance;
    }

    public Mario getMario() {
        return mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    public void setGameObjects(ArrayList<Tile> gameObjects) {
        this.gameObjects = gameObjects;
    }
}
