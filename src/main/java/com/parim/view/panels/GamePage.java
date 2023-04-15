package com.parim.view.panels;

import com.parim.access.UserAccess;
import com.parim.model.*;
import com.parim.model.Tiling.*;
import com.parim.view.MainFrame;
import com.parim.view.objects.gameObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePage extends JPanel implements Runnable{
    private static final int gameWidth = MainFrame.getGameWidth(), gameHeight = MainFrame.getGameHeight();

    private transient ArrayList<Tile> gameObjects;
    private Mario mario;
    private int calculateSec = 0;
    private Game game;
    private User user;
    private boolean runningGame = true;
    public GamePage(Game game, User user){
        Time.setSec(game.getSec());
        this.user = user;
        this.game = game;
        gameObjects = game.getGameObjects();
        mario = game.getMario();
        Mario.setXVelocity(0);
        mario.setYVelocity(0);

        this.setFocusable(true);
        this.addKeyListener(new AL());
        //this.setBackground(Color.white);
        this.setBackground(new Color(107, 135, 254));
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getScreenSize());
    }

    public void move(){
        mario.move();
        for (Tile gameObject : gameObjects) {
            if (mario.getX() - game.getMaxMarioX() >= 0 /*&& !(game.getMaxMarioX() >= 1500 * 7 + 150)*/)
                gameObject.move();
            else if (gameObject instanceof Plant) {
                Plant plant = (Plant) gameObject;
                gameObject.setY(gameObject.getY() + (((plant.getNumberOfCalls()/120) % 2 == 0) ? (1) : (-1)));
                plant.updateNumberOfCalls();
            }
        }
    }

    public void startAgain(){
        System.out.println("start Again");
        Time.setSec(game.getSec());
        runningGame = true;
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GameLogs.draw(g, game.getTotalScore(), game.getTotalCoins(), game.calculateState(), Time.getSec(), game.getHearts());

        game.setMaxMarioX(Math.max(game.getMaxMarioX(), mario.getX()));
        int diff = mario.getX() - game.getMaxMarioX();
        if (/*mario.getX() < 7*1500 && */diff < -150){
            mario.setX(game.getMaxMarioX() - 150);
            diff = -150;
        }
        /*if (game.getMaxMarioX() >= 1500*7 + 150) game.setMarioX(mario.getX() - 1500*7);
        else*/ game.setMarioX(150 + Math.min(0, diff));
        g.drawImage(GameObjectsImages.getImage(mario), game.getMarioX(), mario.getY(), Mario.getSize(), Mario.getSize(), null);
        for (Tile gameObject : gameObjects)
            if (!(gameObject instanceof Coin) || ((Coin) gameObject).isVisible())
                g.drawImage(GameObjectsImages.getImage(gameObject), gameObject.getX(), gameObject.getY(), gameObject.getWidth(), gameObject.getHeight(), null);
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (runningGame) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                calculateSec++;
                if (calculateSec % (int) amountOfTicks == 0) {
                    Time.updateSec();
                    game.setSec(Time.getSec());
                }
                repaint();
                revalidate();
                requestFocus();
                game.checkTime();
                game.checkGameStatus();
                move();
                if (game.isGameEnded()){
                    runningGame = false;
                    user.addGame(game, null);
                    fixCoinsAndScore();
                }
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
            else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                runningGame = false;
                game.setSec(Time.getSec());
                new UserAccess().add(user);
                MainFrame.getInstance().setMenuPage();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT)
                Mario.setXVelocity(0);
        }
    }

    public void fixCoinsAndScore(){
        user.addCoins(game.getTotalCoins());
        user.setMaxScore(game.getTotalScore());
    }
}
