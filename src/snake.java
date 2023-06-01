import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class snake {
    KeyHandler kh;
    int length = 0;
    int xHead = 30;
    int yHead = 30;
    ArrayList<Integer[]> bodyParts = new ArrayList<Integer[]>();
    apple myApple = new apple(this);

    public snake(KeyHandler kh) {
        this.kh = kh;
    } 

    public void increaseLength() {
        Integer[] newBodyPart = {xHead, yHead};
        bodyParts.add(newBodyPart);
        this.length++;
    }

    //not finished
    public void checkSnakeCollision() {
        for (int i = 1; i < bodyParts.size(); i++) {
            Integer[] cords = bodyParts.get(i);
            int xBody = cords[0];
            int yBody = cords[1];
            if (xHead == xBody && yHead == yBody) {
                GamePanel.currentState = 2;
            }
        }
        if (xHead < 0 || xHead > GamePanel.SCREEN_WIDTH || yHead < 0 || yHead > GamePanel.SCREEN_HEIGHT) {
            GamePanel.currentState = 2;
        }
    }

    public void update(){
        if (kh.direction == ("up")) {
            yHead -= 30;
        } else if (kh.direction == ("down")) {
            yHead += 30;
        } else if (kh.direction == ("left")) {
            xHead -= 30;
        } else if (kh.direction == ("right")) {
            xHead += 30;
        }

        for (int i = bodyParts.size() - 1; i > 0; i--) {
            Integer[] currentBodyPart = bodyParts.get(i);
            Integer[] previousBodyPart = bodyParts.get(i - 1);
            currentBodyPart[0] = previousBodyPart[0];
            currentBodyPart[1] = previousBodyPart[1];
        }
        
        // Update the first body part to the head position
        if (bodyParts.size() > 0) {
            Integer[] firstBodyPart = bodyParts.get(0);
            if (kh.direction == "up") {
                firstBodyPart[0] = xHead;
                firstBodyPart[1] = yHead + GamePanel.UNIT_SIZE;
            } else if (kh.direction == "down") {
                firstBodyPart[0] = xHead;
                firstBodyPart[1] = yHead - GamePanel.UNIT_SIZE;
            } else if (kh.direction == "left") {
                firstBodyPart[0] = xHead + GamePanel.UNIT_SIZE; 
                firstBodyPart[1] = yHead;
            } else if (kh.direction == "right") {
                firstBodyPart[0] = xHead - GamePanel.UNIT_SIZE;
                firstBodyPart[1] = yHead;
            }
        }
    }

    public void draw(Graphics2D g2) {
        //draw snake
        g2.setColor(Color.GREEN);
        g2.fillRect(xHead, yHead, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE); 
        g2.setColor(Color.WHITE);
        g2.drawRect(xHead, yHead, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE); 
        for (Integer[] cords : bodyParts) {
            int x = cords[0];
            int y = cords[1];
            g2.setColor(Color.GREEN);
            g2.fillRect(x, y, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
            g2.setColor(Color.WHITE);
            g2.drawRect(x, y, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
        }
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        g2.drawString("Score: " + length, (GamePanel.SCREEN_WIDTH/2) - 110, 50);
    }
}
