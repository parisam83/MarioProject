package com.parim.model.Tiling;

public class PowerUpBlock extends Block{
    private boolean coinPowerUp = true;
    public PowerUpBlock(int x, int y) {
        super(x, y, "/objects/PowerUpBlock.png");
    }

    public boolean isCoinPowerUp() {
        return coinPowerUp;
    }

    public void setCoinPowerUp(boolean coinPowerUp) {
        this.coinPowerUp = coinPowerUp;
    }
}
