package com.parim.model;

import com.parim.model.Tiling.Area;
import com.parim.model.Tiling.Tile;

import java.util.ArrayList;

public class Scene {
    transient private static Scene instance;
    private Mario mario;
    private ArrayList<Tile> gameObjects;
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
        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            /*if (tile instanceof PowerUpBlock){
                System.out.println("Tileee: \nMario: " + mario.getX() + " " + mario.getY() + "\nTile: " + area.getUp() + ", " + area.getDown() + ", " + area.getLeft() + ", " + area.getRight() + "\n");
                return false;
            }*/
            if ((mario.getX()+Mario.getSize() >= area.getLeft() && mario.getX() <= area.getRight()) &&
                (mario.getY() <= area.getDown() && mario.getY() >= area.getUp())) {
                System.out.println("Up: \nMario: " + mario.getX() + " " + mario.getY() + "\nTile: " + area.getUp() + ", " + area.getDown() + ", " + area.getLeft() + ", " + area.getRight() + "\n");
                return true;
            }
        }
        return false;
    }
    public boolean intersectDown(){
        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            if ((mario.getX()+Mario.getSize() >= area.getLeft() && mario.getX() <= area.getRight()) &&
                (mario.getY()+Mario.getSize() <= area.getDown() && mario.getY()+Mario.getSize() >= area.getUp())) {
                //System.out.println("Down: \nMario: " + mario.getX() + " " + mario.getY() + "\nTile: " + area.getUp() + ", " + area.getDown() + ", " + area.getLeft() + ", " + area.getRight() + "\n");
                //mario.setY(area.getUp() - Mario.getSize());
                return true;
            }
        }
        return false;
    }
    public boolean intersectRight(){
        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            if ((mario.getY()+Mario.getSize() > area.getUp() && mario.getY() < area.getDown()) &&
                (mario.getX()+Mario.getSize() > area.getLeft() && mario.getX()+Mario.getSize() < area.getRight())) {
                //System.out.println("Right: " + (mario.getX()+Mario.getSize()) + "   " + area.getLeft() + " -> " + tile);
                return true;
            }
        }
        return false;
    }
    public boolean intersectLeft(){
        for (Tile tile : gameObjects) {
            Area area = tile.getArea();
            if ((mario.getY() > area.getUp() && mario.getY() < area.getDown()) &&
                (mario.getX() < area.getRight()) && mario.getX() > area.getLeft()) {
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
