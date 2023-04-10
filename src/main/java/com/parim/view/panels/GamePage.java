package com.parim.view.panels;

import com.parim.model.Game;
import com.parim.model.Tiling;
import com.parim.model.User;
import com.parim.view.MainFrame;
import com.parim.view.objects.gameObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePage extends JPanel implements Runnable{
    private static final int width = MainFrame.getGameWidth(), height = MainFrame.getGameHeight(), objectSize = Tiling.getObjectSize();
    private Mario graphicalMario;
    private ArrayList<Floor> floors = new ArrayList<>();
    private ArrayList<OrdinaryBlock> ordinaryBlocks = new ArrayList<>();
    private ArrayList<PowerUpBlock> powerUpBlocks = new ArrayList<>();
    private Pipe ordinaryPipe = new Pipe(20 - objectSize + objectSize*19 + 10, height - objectSize*3 + 40 - 100, objectSize*2, 100);
    public GamePage(Game game, User user){

        for (int i = 0; i < 30; i++){
            floors.add(new Floor(20 - objectSize + objectSize*i, height - objectSize + 40));
            floors.add(new Floor(20 - objectSize + objectSize*i, height - objectSize * 2 + 40));
            floors.add(new Floor(20 - objectSize + objectSize*i, height - objectSize * 3 + 40));
        }
        powerUpBlocks.add(new PowerUpBlock(20 - objectSize + objectSize*7, height - objectSize*7 + 40));
        ordinaryBlocks.add(new OrdinaryBlock(20 - objectSize + objectSize*11, height - objectSize*7 + 40));
        powerUpBlocks.add(new PowerUpBlock(20 - objectSize + objectSize*12, height - objectSize*7 + 40));
        ordinaryBlocks.add(new OrdinaryBlock(20 - objectSize + objectSize*13, height - objectSize*7 + 40));
        powerUpBlocks.add(new PowerUpBlock(20 - objectSize + objectSize*14, height - objectSize*7 + 40));
        ordinaryBlocks.add(new OrdinaryBlock(20 - objectSize + objectSize*15, height - objectSize*7 + 40));
        powerUpBlocks.add(new PowerUpBlock(20 - objectSize + objectSize*13, height - objectSize*11 + 40));

        graphicalMario = new Mario(50, height - 3*objectSize - Tiling.getMarioSize() + 40, user.getCurrentCharacter());

        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setBackground(new Color(107, 135, 254));
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(ordinaryPipe);
        arrayList.add(floors.get(0));

        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    public void move(){
        graphicalMario.move();
        for (OrdinaryBlock ordinaryBlock : ordinaryBlocks)
            ordinaryBlock.move();
        for (PowerUpBlock powerUpBlock : powerUpBlocks)
            powerUpBlock.move();
        ordinaryPipe.move();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphicalMario.draw(g);
        for (Floor floor : floors)
            floor.draw(g);
        for (OrdinaryBlock ordinaryBlock : ordinaryBlocks)
            ordinaryBlock.draw(g);
        for (PowerUpBlock powerUpBlock : powerUpBlocks)
            powerUpBlock.draw(g);
        ordinaryPipe.draw(g);
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                repaint();
                revalidate();
                requestFocus();
                move();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                Mario.setXVelocity(Mario.getSpeed());
            else if (e.getKeyCode() == KeyEvent.VK_LEFT)
                Mario.setXVelocity(-Mario.getSpeed());
            else if (e.getKeyCode() == KeyEvent.VK_UP)
                Mario.setYVelocity(-Mario.getSpeed());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT)
                Mario.setXVelocity(0);
        }
    }
}
