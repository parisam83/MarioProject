package com.parim.model;

public class Mario {
    private int x, y, firstY;
    private static int xVelocity, yVelocity;
    private static final int speed = 8, diff = 240+20;
    private static final int size = 80;
    private final String directory;
    private final Character character;
    private boolean gravity = false, jump = false, intersectDown = true;
    public Mario(int x, int y, Character character){
        this.x = x;
        this.y = y;
        //area = new Area(x, y, size, size);
        this.character = character;
        this.directory = "/characters/" + character.name() + ".png";
    }

    public void move(){
        Scene scene = Scene.getInstance();

        //if (gravity) yVelocity = speed;
        //if (jump) yVelocity = -speed;

        if (scene.intersectDown() && yVelocity > 0) {
            gravity = false;
            jump = false;
            yVelocity = 0;
        }
        if (scene.intersectRight() && xVelocity > 0){
            xVelocity = 0;
        }

        //System.out.println(intersectDown);
        //System.out.println(scene.intersectDown());
        if (intersectDown && !scene.intersectDown()){
            //System.out.println("biu paeiiiin");
            intersectDown = false;
            if (!jump) {
                gravity = true;
                yVelocity = speed;
            }
        }

        if (gravity && !jump && !intersectDown)
            yVelocity = speed;

        if ((xVelocity > 0 && scene.intersectRight()) || (xVelocity < 0 && scene.intersectLeft()))
            xVelocity = 0;
        if (yVelocity > 0 && scene.intersectDown()) {
            //y -= yVelocity*10;
            yVelocity = 0;
            intersectDown = true;
            gravity = false;
        }
        if (scene.intersectUp()) {
            jump = false;
            gravity = true;
        }

        //if (scene.intersectDown())
        //System.out.println("intersectDown: " + intersectDown);

        intersectDown = scene.intersectDown();
        /*
        System.out.println("gravity: " + gravity);
        System.out.println("jump: " + jump);

        System.out.println("intersectUp: " + scene.intersectUp());
        System.out.println("intersectDown: " + scene.intersectDown());
        System.out.println("intersectRight: " + scene.intersectRight());
        System.out.println("intersectLeft: " + scene.intersectLeft() + "\n");
*/
        if (!jump && !gravity) yVelocity = 0;
        if (jump) yVelocity = -Math.abs(yVelocity);
        if (gravity) yVelocity = Math.abs(yVelocity);
        if (jump && y <= firstY - diff) {
            gravity = true;
            jump = false;
        }
        x += xVelocity;
        y += yVelocity;


        /*if (scene.intersectRight()) {
            //x -= xVelocity;
            xVelocity *= -1;
            //return true;
        }
*/

        //scene.intersectRight();

        //if (scene.intersectLeft())
        //    x += xVelocity;

        /*if (scene.intersectDown()) {
            intersectDown = true;
            gravity = false;
            jump = false;
        }*/
        /*
        if (scene.intersectDown())
            yVelocity = 0;
        if (scene.intersectRight() || scene.intersectLeft())
            xVelocity = 0;*/
    }

    public static int getSize() {
        return size;
    }

    public static int getSpeed() {
        return speed;
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

    public static int getXVelocity() {
        return xVelocity;
    }

    public static void setXVelocity(int xVelocity) {
        Mario.xVelocity = xVelocity;
    }

    public static int getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(int yVelocity) {
        if (Mario.yVelocity == 0 && yVelocity < 0) {
            firstY = y;
            jump = true;
            gravity = false;
        }
        Mario.yVelocity = yVelocity;
    }

    public Character getCharacter() {
        return character;
    }
}
