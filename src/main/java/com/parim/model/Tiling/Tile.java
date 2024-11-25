/*
TODO:
    Maybe it's good to divide move function into two functions moveX and moveY
    Maybe it's good to implement intersect function in Tile.java to ba able to override for each game object
*/

package com.parim.model.Tiling;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.parim.model.Mario;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Stair.class, name = "Stair"),
        @JsonSubTypes.Type(value = Block.class, name = "Block"),
        @JsonSubTypes.Type(value = Pipe.class, name = "Pipe"),
        @JsonSubTypes.Type(value = Floor.class, name = "Floor"),
        @JsonSubTypes.Type(value = Enemy.class, name = "Enemy"),
        @JsonSubTypes.Type(value = Coin.class, name = "Coin")
})
public class Tile {
    protected int x, y;
    protected int width, height;
    @JsonIgnore
    protected Area area;
    protected String directory;
    public Tile(){}
    public Tile(int x, int y, String directory){
        this.x = x;
        this.y = y;
        this.directory = directory;
        width = height = 60;
        //this.area = new Area(x, y, width, height);
    }
    public Tile(int x, int y, int width, int height, String directory){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.directory = directory;
        //this.area = new Area(x, y, width, height);
    }

    public void move(){
        x -= Mario.getXVelocity();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Area getArea() {
        area = new Area(x, y, width, height);
        return area;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getDirectory() {
        return directory;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}
