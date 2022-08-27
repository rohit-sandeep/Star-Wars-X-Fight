import bagel.*;
import bagel.util.Point;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class StarWars extends AbstractGame {
    private final static int WINDOW_WIDTH = 768;
    private final static int WINDOW_HEIGHT = 1024;
    private final static String GAME_TITLE = "StarWars x Fight: Horizon Odyssey";
    private final Image BACKGROUND = new Image("resource/space_background.png");

    private static int MESSAGE1_COORD = 402;
    private final static int MESSAGE2_COORD = 472;
    private final static int MESSAGE3_COORD = 542;

    private final DrawOptions scale = new DrawOptions();
    private final DrawOptions color = new DrawOptions();

    
    private final Font starwars_font;
    private final String FONT_STYLE = "resource/starwars.otf";
    Player player = new Player(Window.getHeight()/2+200,Window.getWidth()/2);
    private final static int FONT_SIZE = 40;

    private final String START_MESSAGE = "PRESS SPACE TO START";
    private final String TITLE_MESSAGE = "STARWARS X FIGHT: HORIZON ODYSSEY";

    private boolean game_end = false;

    private boolean pressed_enter = false;
    
    private ArrayList<TieFighter> ties = new ArrayList<>();

    public StarWars() {
        super(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_TITLE);
        starwars_font = new Font(FONT_STYLE, FONT_SIZE);
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        StarWars game = new StarWars();
        game.run();
    }

    public void addEnemies() {
        ties.add(new TieFighter(768/4, 0));
        ties.add(new TieFighter(768/4, 0));
        ties.add(new TieFighter(768/4, 0));
        ties.add(new TieFighter(768/4, 0));
    }
    
    public void drawMessage(Input input) {
        if (input.wasPressed(Keys.SPACE)) {
            pressed_enter = true;
        } else {
            starwars_font.drawString(TITLE_MESSAGE, (WINDOW_WIDTH - starwars_font.getWidth
                    (TITLE_MESSAGE))/2, MESSAGE1_COORD, color.setBlendColour(1,1,0));
            starwars_font.drawString(START_MESSAGE, (WINDOW_WIDTH - starwars_font.getWidth
                    (START_MESSAGE))/2, MESSAGE2_COORD, color.setBlendColour(1,1,0));
        }
    }

    private int frames = 0;
    @Override
    public void update(Input input) {
        BACKGROUND.draw(Window.getWidth()/2.0, Window.getHeight()/2.0, scale.setScale(1.5, 2));
        if (!pressed_enter) {
            drawMessage(input);
            addEnemies();
        }
        else {
<<<<<<< HEAD
            PLAYER.draw(Window.getWidth()/2, Window.getHeight()/2 + 200, scale.setScale(0.5, 0.5));
            if (frames > 50) {
                ties.get(0).drawSprite();
                ties.get(0).movement();
=======
            player.getShip().draw(player.getX_coordinate(),player.getY_coordinate(), scale.setScale(0.5, 0.5));
            player.move(input);
            tiefighter.drawSprite();
            if (frames <= 100) {
                tiefighter.moveDown();
>>>>>>> 79a9969a3be3a13c9b97411431a890c8f79adccf
            }
            if (frames > 100) {
                ties.get(1).drawSprite();
                ties.get(1).movement();
            }
            if (frames > 150) {
                ties.get(2).drawSprite();
                ties.get(2).movement();
            }
            if (frames > 200) {
                ties.get(3).drawSprite();
                ties.get(3).movement();
            }
            for (TieFighter fighters : ties) {
                if (fighters.getY() == WINDOW_HEIGHT) {
                    fighters.setX(768/4);
                    fighters.setY(0);
                    fighters.setF(false);
                    fighters.setG(false);
                    fighters.setTurn(true);
                }
            }
            frames++;
        }
    }
}