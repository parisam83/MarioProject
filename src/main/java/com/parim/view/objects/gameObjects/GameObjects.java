package com.parim.view.objects.gameObjects;

import com.parim.model.Tiling.*;

import java.util.ArrayList;

public class GameObjects {
    private ArrayList<Tile> gameObjects = new ArrayList<>();
    private int gameHeight = 832;
    public GameObjects(){
        for (int i = 0; i < 205 - 4; i++){
            if (i != 38 && i != 39 && i != 114 && i != 115 && i != 116 && i != 143 && i != 144 && i != 183 && i != 184 && i != 185) {
                gameObjects.add(new Floor( 60 * (i - 1), gameHeight - 60 + 40));
                gameObjects.add(new Floor( 60 * (i - 1), gameHeight - 60 * 2 + 40));
                gameObjects.add(new Floor( 60 * (i - 1), gameHeight - 60 * 3 + 40));
            }
        }
        // 573

        gameObjects.add(new Coin(60*11 - 52, gameHeight - 60*7 - 13));
        gameObjects.add(new Coin(60*12 - 52, gameHeight - 60*7 - 13));
        gameObjects.add(new Coin(60*13 - 52, gameHeight - 60*7 - 13));
        gameObjects.add(new Coin(60*14 - 52, gameHeight - 60*7 - 13));
        gameObjects.add(new Coin(60*15 - 52, gameHeight - 60*7 - 13));

        gameObjects.add(new Coin(3000 + 60 - 30, gameHeight - 60*10 - 13));
        gameObjects.add(new Coin(3000 + 60*2 - 30, gameHeight - 60*11 - 13));
        gameObjects.add(new Coin(3000 + 60*3 - 30, gameHeight - 60*12 - 13));
        gameObjects.add(new Coin(3000 + 60*4 - 30, gameHeight - 60*11 - 13));
        gameObjects.add(new Coin(3000 + 60*5 - 30, gameHeight - 60*10 - 13));
        gameObjects.add(new Coin(3000 + 60*6 - 30, gameHeight - 60*9 - 13));
        gameObjects.add(new Coin(3000 + 60*7 - 30, gameHeight - 60*8 - 13));

        gameObjects.add(new OrdinaryBlock( - 60 + 60*7, gameHeight - 60*7 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*11, gameHeight - 60*7 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*12, gameHeight - 60*7 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*13, gameHeight - 60*7 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*14, gameHeight - 60*7 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*15, gameHeight - 60*7 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*13, gameHeight - 60*11 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*46, gameHeight - 60*7 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*47, gameHeight - 60*7 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*48, gameHeight - 60*7 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*49, gameHeight - 60*10 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*50, gameHeight - 60*10 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*51, gameHeight - 60*10 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*71, gameHeight - 60*8 + 40));
        gameObjects.add(new PowerUpBlock (- 60 + 60*72, gameHeight - 60*8 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*73, gameHeight - 60*8 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*74, gameHeight - 60*8 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*75, gameHeight - 60*8 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*138, gameHeight - 60*8 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*139, gameHeight - 60*8 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*140, gameHeight - 60*8 + 40));

        gameObjects.add(new Coin(60 * 174 + 8, gameHeight - 60*9 + 40));
        gameObjects.add(new Coin(60 * 175 + 8, gameHeight - 60*9 + 40));
        gameObjects.add(new Coin(60 * 176 + 8, gameHeight - 60*9 + 40));
        gameObjects.add(new Coin(60 * 177 + 8, gameHeight - 60*9 + 40));
        gameObjects.add(new Coin(60 * 178 + 8, gameHeight - 60*9 + 40));

        gameObjects.add(new OrdinaryBlock( - 60 + 60*173, gameHeight - 60*8 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*174, gameHeight - 60*8 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*175, gameHeight - 60*8 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*176, gameHeight - 60*8 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*177, gameHeight - 60*8 + 40));
        gameObjects.add(new OrdinaryBlock( - 60 + 60*178, gameHeight - 60*8 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*179, gameHeight - 60*8 + 40));
        gameObjects.add(new PowerUpBlock( - 60 + 60*180, gameHeight - 60*8 + 40));

        gameObjects.add(new Stair(20 - 120 + 60*58, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair(20 - 120 + 60*58, gameHeight - 60*6 + 40));
        gameObjects.add(new Stair(20 - 120 + 60*58, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair(20 - 120 + 60*58, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair(20 - 120 + 60*59, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair(20 - 120 + 60*59, gameHeight - 60*4 + 40));

        // I
        gameObjects.add(new Coin(60 * 80 + 8, gameHeight - 60*8 + 40));
        gameObjects.add(new Coin(60 * 81 + 8, gameHeight - 60*8 + 40));
        gameObjects.add(new Coin(60 * 82 + 8, gameHeight - 60*8 + 40));
        gameObjects.add(new Stair( - 120 + 60*82, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*83, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*84, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*83, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*83, gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*82, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*83, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*84, gameHeight - 60*7 + 40));

        // H
        gameObjects.add(new Stair( - 120 + 60*88, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*91, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*88, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*91, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*88, gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*91, gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*88, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*91, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*89, gameHeight - 60*6 + 40 + 30));
        gameObjects.add(new Stair( - 120 + 60*90, gameHeight - 60*6 + 40 + 30));

        // A
        gameObjects.add(new Coin(60 * 91 + 8, gameHeight - 60*8 + 40));
        gameObjects.add(new Coin(60 * 92 + 8, gameHeight - 60*8 + 40));
        gameObjects.add(new Coin(60 * 93 + 8, gameHeight - 60*8 + 40));
        gameObjects.add(new Stair( - 120 + 60*93, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*93, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*93, gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*93, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*94, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*94, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*95, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*95, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*95, gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*95, gameHeight - 60*7 + 40));

        // T
        gameObjects.add(new Stair( - 120 + 60*97, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*98, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*99, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*98, gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*98, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*98, gameHeight - 60*4 + 40));

        // E
        gameObjects.add(new Coin(60 * 99 + 8, gameHeight - 60*8 + 40));
        gameObjects.add(new Coin(60 * 100 + 8, gameHeight - 60*8 + 40));
        gameObjects.add(new Coin(60 * 101 + 8, gameHeight - 60*8 + 40));
        gameObjects.add(new Stair( - 120 + 60*101, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*101, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*101, gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*101, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*102, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*102, gameHeight - 60*5 + 40 - 30));
        gameObjects.add(new Stair( - 120 + 60*102, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*103, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*103, gameHeight - 60*5 + 40 - 30));
        gameObjects.add(new Stair( - 120 + 60*103, gameHeight - 60*7 + 40));

        for (int i = 0; i < 9; i++)
            for (int j = i; j < 9; j++) {
                gameObjects.add(new Stair(-120 + 60 * (193 + j), gameHeight - 60 * (4 + i) + 40));
                gameObjects.add(new Coin( -120 + 60 * (193 + j) + 8, gameHeight - 60 * (4 + i) - 12));
            }
        gameObjects.add(new Stair( - 120 + 60*193, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*194, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*195, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*196, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*197, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*198, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*199, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*200, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*201, gameHeight - 60*4 + 40));

        int x = 14;
        gameObjects.add(new Stair( - 120 + 60*(93+x), gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*(93+x), gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*(93+x), gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*(93+x), gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*(94+x), gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*(94+x), gameHeight - 60*7 + 40));

        gameObjects.add(new Stair( - 120 + 60*(95+x), gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*(95+x), gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*(95+x), gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*(95+x), gameHeight - 60*7 + 40));

        gameObjects.add(new Stair( - 120 + 60*111, gameHeight - 60*4 + 40));
        gameObjects.add(new Stair( - 120 + 60*111, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*111, gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*111, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*112, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*112, gameHeight - 60*7 + 40));
        gameObjects.add(new Stair( - 120 + 60*113, gameHeight - 60*5 + 40));
        gameObjects.add(new Stair( - 120 + 60*113, gameHeight - 60*6 + 40));
        gameObjects.add(new Stair( - 120 + 60*113, gameHeight - 60*7 + 40));

        gameObjects.add(new Pipe(20 - 60 + 60*19 + 10, gameHeight - 60*3 + 40 - 100, 60*2, 100));

        gameObjects.add(new Plant(20 - 60 + 60*30 + 40, gameHeight - 60*4 + 40 - 200));
        gameObjects.add(new Pipe(20 - 60 + 60*30 + 10, gameHeight - 60*3 + 40 - 200, 60*2, 200));
        gameObjects.add(new Coin(60 * 32 + 8, gameHeight - 60*4 + 40));
        gameObjects.add(new Coin(60 * 33 + 8, gameHeight - 60*4 + 40));
        gameObjects.add(new Coin(60 * 34 + 8, gameHeight - 60*4 + 40));
        gameObjects.add(new Coin(60 * 35 + 8, gameHeight - 60*4 + 40));

        gameObjects.add(new Pipe(20 - 60 + 60*65 + 10, gameHeight - 60*3 + 40 - 230, 60*2, 230));

        gameObjects.add(new Coin( 20 - 60 + 60*120 + 40, gameHeight - 60*4 + 40));
        gameObjects.add(new Coin( 20 - 60 + 60*121 + 40, gameHeight - 60*4 + 40));
        gameObjects.add(new Coin( 20 - 60 + 60*122 + 40, gameHeight - 60*4 + 40));
        gameObjects.add(new Coin( 20 - 60 + 60*123 + 40, gameHeight - 60*4 + 40));
        gameObjects.add(new Coin( 20 - 60 + 60*124 + 40, gameHeight - 60*4 + 40));
        gameObjects.add(new Coin( 20 - 60 + 60*125 + 40, gameHeight - 60*4 + 40));
        gameObjects.add(new Plant(20 - 60 + 60*132 + 40, gameHeight - 60*4 + 40 - 200));
        gameObjects.add(new Pipe(20 - 60 + 60*132 + 10, gameHeight - 60*3 + 40 - 200, 60*2, 200));
        gameObjects.add(new Pipe(20 - 60 + 60*153 + 10, gameHeight - 60*3 + 40 - 100, 60*2, 100));
        gameObjects.add(new Pipe(20 - 60 + 60*160 + 10, gameHeight - 60*3 + 40 - 300, 60*3, 300));
    }

    public ArrayList<Tile> getGameObjects() {
        return gameObjects;
    }
}