package com.parim.view.objects.gameObjects;

import com.parim.view.loaders.FontLoader;

import java.awt.*;

public class GameLogs {
    private static final int buttonLeftGridGap = 30, buttonUpGridGap = 50;
    private static final int buttonHorizontalGap = 350, buttonVerticalGap = 45;
    public static void draw(Graphics g, int score, int coins, String gameState, int time, int hearts){
        g.setFont(FontLoader.buttonFont);
        g.setColor(Color.BLACK);

        g.drawString("SCORE", buttonLeftGridGap + 10, buttonUpGridGap);
        g.drawString(convertToString(score), buttonLeftGridGap, buttonUpGridGap + buttonVerticalGap);

        g.drawString("COINS", buttonLeftGridGap + buttonHorizontalGap + 17, buttonUpGridGap);
        g.drawString(convertToString(coins), buttonLeftGridGap + buttonHorizontalGap, buttonUpGridGap + buttonVerticalGap);

        g.drawString("WORLD", buttonLeftGridGap + buttonHorizontalGap*2, buttonUpGridGap);
        g.drawString(gameState, buttonLeftGridGap + buttonHorizontalGap*2 + 25, buttonUpGridGap + buttonVerticalGap);

        g.drawString("TIME", buttonLeftGridGap + buttonHorizontalGap*3, buttonUpGridGap);
        g.drawString(convertToString(time), buttonLeftGridGap + buttonHorizontalGap*3 - 28, buttonUpGridGap + buttonVerticalGap);

        g.drawString("LIVES", buttonLeftGridGap + buttonHorizontalGap*4 - 40, buttonUpGridGap);
        g.drawString(String.valueOf(hearts), buttonLeftGridGap + buttonHorizontalGap*4 - 10, buttonUpGridGap + buttonVerticalGap);
    }

    private static String convertToString(int x){
        String tmp = String.valueOf(x);
        StringBuilder ans = new StringBuilder();
        for (int i = tmp.length(); i < 6; i++)
            ans.append("0");
        ans.append(tmp);
        return String.valueOf(ans);
    }
}
