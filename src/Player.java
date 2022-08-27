import bagel.Image;
import bagel.Input;
import bagel.Keys;

public class Player {
    private final int MAX_HEALTH = 3;
    private int movementSpeed=3;
    private int currHealth;
    private double x_coordinate;
    private double y_coordinate;
    private final Image ship= new Image("resource/falcon.png");
    public Player(double height, double width ) {
        this.x_coordinate= width;
        this.y_coordinate=height;
        this. currHealth=this.getMAX_HEALTH();
    }

    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public double getX_coordinate() {
        return x_coordinate;
    }

    public double getY_coordinate() {
        return y_coordinate;
    }

    public Image getShip() {
        return ship;
    }

    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    void move(Input input){
        double currX=this.getX_coordinate();
        double currY=this.getY_coordinate();
        if(input.isDown(Keys.LEFT)){
            this.setX_coordinate(currX-this.getMovementSpeed());
        }
        if (input.isDown(Keys.RIGHT)){
            this.setX_coordinate(currX+this.getMovementSpeed());
        }
        if(input.isDown(Keys.UP)){
            this.setY_coordinate(currY-this.getMovementSpeed());
        }
        if(input.isDown(Keys.DOWN)){
            this.setY_coordinate(currY+this.getMovementSpeed());
        }
    }
}

