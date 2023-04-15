package com.parim.model.Tiling;

public class Coin extends Tile{
    private boolean visible = true;
    public Coin(){}
    public Coin(int x, int y) {
        super(x, y, 45, 45, "/objects/Coin.png");
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
