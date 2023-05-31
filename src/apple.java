import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class apple {
    Random random = new Random();
    snake duck;

    int appleX = GamePanel.UNIT_SIZE * random.nextInt(GamePanel.SCREEN_WIDTH/GamePanel.UNIT_SIZE);
    int appleY = GamePanel.UNIT_SIZE * random.nextInt(GamePanel.SCREEN_HEIGHT/GamePanel.UNIT_SIZE);

    public apple(snake duck) {
        this.duck = duck;
    }

    public void checkCollision() {
        if (duck.xHead == appleX && duck.yHead == appleY) {
            duck.increaseLength();
            update();
        }
    }

    public int getAppleX() {
        return appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public void AppleSpawn() {
        //doesnt work still
        Boolean appleNotOK = false;
        while (appleNotOK == false) {
            int holdX = GamePanel.UNIT_SIZE * random.nextInt(GamePanel.SCREEN_WIDTH / GamePanel.UNIT_SIZE);
            int holdY = GamePanel.UNIT_SIZE * random.nextInt(GamePanel.SCREEN_HEIGHT / GamePanel.UNIT_SIZE);

            for (Integer[] bodyPart : duck.bodyParts) {
                if (holdX == bodyPart[0] && holdY == bodyPart[1] || (holdX == duck.xHead && holdY == duck.yHead)) {
                    appleNotOK = true;
                    break;
                }
            }
    
            if (!appleNotOK) {
                appleX = holdX;
                appleY = holdY;
            }
        }
    }

    public void update() {
        AppleSpawn();
    }

    public void draw(Graphics2D g2) {
        //draw apple
        g2.setColor(Color.RED);
        g2.fillRect(appleX, appleY, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE); 
    }

}
