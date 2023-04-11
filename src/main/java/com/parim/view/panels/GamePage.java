package com.parim.view.panels;

import com.parim.model.Game;
import com.parim.model.Mario;
import com.parim.model.Scene;
import com.parim.model.Tiling.*;
import com.parim.model.User;
import com.parim.view.MainFrame;
import com.parim.view.objects.gameObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePage extends JPanel implements Runnable{
    private static final int gameWidth = MainFrame.getGameWidth(), gameHeight = MainFrame.getGameHeight();
    private Scene scene = new Scene();
    // private Mario mario = scene.getMario();
    // private ArrayList<Tile> gameObjects = scene.getGameObjects();

    ArrayList<Tile> gameObjects = new ArrayList<>();
    Mario mario;
    // 380 452
    public GamePage(Game game, User user){
        mario = new Mario(50, gameHeight - 3*60 - Mario.getSize() + 40, user.getCurrentCharacter());
        for (int i = 0; i < 30; i++){
            gameObjects.add(new Floor(20 + 60*(i-1), gameHeight - 60 + 40));
            gameObjects.add(new Floor(20 + 60*(i-1), gameHeight - 60 * 2 + 40));
            gameObjects.add(new Floor(20 + 60*(i-1), gameHeight - 60 * 3 + 40));
        }
        gameObjects.add(new OrdinaryBlock(20 - 60 + 60*7, gameHeight - 60*7 + 40));
        gameObjects.add(new OrdinaryBlock(20 - 60 + 60*11, gameHeight - 60*7 + 40));
        gameObjects.add(new OrdinaryBlock(20 - 60 + 60*12, gameHeight - 60*7 + 40));
        gameObjects.add(new OrdinaryBlock(20 - 60 + 60*13, gameHeight - 60*7 + 40));
        gameObjects.add(new OrdinaryBlock(20 - 60 + 60*14, gameHeight - 60*7 + 40));
        gameObjects.add(new PowerUpBlock(20 - 60 + 60*15, gameHeight - 60*7 + 40));
        gameObjects.add(new OrdinaryBlock(20 - 60 + 60*13, gameHeight - 60*11 + 40));

        gameObjects.add(new Pipe(20 - 60 + 60*19 + 10, gameHeight - 60*3 + 40 - 100, 60*2, 100));


        /*for (Tile tile : gameObjects)
            if (tile.getWidth() != 60 || tile.getHeight() != 60)
                System.out.println(tile + " " + tile.getWidth() + " " + tile.getHeight());*/
        scene.setMario(mario);
        scene.setGameObjects(gameObjects);

        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setBackground(new Color(107, 135, 254));
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());

        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    public void move(){
        mario.move();
        for (Tile gameObject : gameObjects)
            gameObject.move();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(860, 452, 60, 60);
        g.drawImage(GameObjectsImages.getImage(mario), mario.getX(), mario.getY(), Mario.getSize(), Mario.getSize(), null);
        g.drawRect(mario.getX(), mario.getY(), Mario.getSize(), Mario.getSize());
        for (Tile gameObject : gameObjects)
            g.drawImage(GameObjectsImages.getImage(gameObject), gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight(), null);
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
                mario.setYVelocity(-Mario.getSpeed());
            //else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            //    Mario.setYVelocity(Mario.getSpeed());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT)
                Mario.setXVelocity(0);
        }
    }
}
