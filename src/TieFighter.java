import bagel.*;
import bagel.util.*;
import java.util.ArrayList;
public class TieFighter {
    private final DrawOptions scale = new DrawOptions();
    private static Image TIE_SPRITE = new Image("resource/tie.png");
    private int x;
    private int y;
    private int speed = 2;

    public TieFighter() {
        setX(768/2);
        setY(0);
    }

    public void drawSprite() {
        TIE_SPRITE.draw(getX(), getY(), scale.setScale(0.075, 0.075));
    }
    
    public void moveLeft() {
        this.x += speed;
    }

    public void moveRight() {
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
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
