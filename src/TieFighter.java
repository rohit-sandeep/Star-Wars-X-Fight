import bagel.*;
import bagel.util.*;
import java.util.ArrayList;
public class TieFighter {
    private final DrawOptions scale = new DrawOptions();
    private static Image TIE_SPRITE = new Image("resource/tie.png");
    private int x;
    private int y;
    private int speed = 2;
    private int StartY;
    private int StartX;
    private boolean f;
    private boolean g;
    private boolean turn;

    public TieFighter(int x, int y) {
        setX(x);
        setY(y);
        setF(false);
        setG(false);
        setTurn(true);
    }

    public void movement() {
        if (getF() == false) {
            setStartY(this.getY());
            setF(true);
        }
        else {
            if (getY() < getStartY() + 240) {
                moveDown();
            }
            else {
                if (getG() == false) {
                    System.out.println("Hello");
                    System.out.println("Bye");
                    setStartX(this.getX());
                    setG(true);
                }
                if (getTurn()) {
                    if (getX() < getStartX() + 400) {
                        moveRight();
                    }
                    else {
                        setF(false);
                        setG(false);
                        setTurn(false);
                    }
                }
                else {
                    if (getX() > getStartX() - 400) {
                        moveLeft();
                    }
                    else {
                        setF(false);
                        setG(false);
                        setTurn(true);
                    }

                }
            }
        }
    }

    public void drawSprite() {
        TIE_SPRITE.draw(getX(), getY(), scale.setScale(0.125, 0.125));
    }

    public void moveRight() {
        this.x += speed;
    }

    public void moveLeft() {
        this.x -= speed;
    }

    public void moveDown() {
        this.y += speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setStartY(int StartY) {
        this.StartY = StartY;
    }

    public int getStartY() {
        return StartY;
    }

    public void setF(boolean f) {
        this.f = f;
    }

    public boolean getF() {
        return f;
    }

    public void setStartX(int StartX) {
        this.StartX = StartX;
    }

    public int getStartX() {
        return StartX;
    }

    public void setG(boolean g) {
        this.g = g;
    }

    public boolean getG() {
        return g;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean getTurn() {
        return turn;
    }
}
