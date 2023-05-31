import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class menu {
    mouseHandler mh;

    public menu (mouseHandler mH) {
        this.mh = mH;
    }

    public void update() {
        if (mh.clicked == true) {
            GamePanel.currentState = 1;
        }
        mh.clicked = false;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.GREEN);
        g2.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
        g2.drawString("Snake Game!", (GamePanel.SCREEN_WIDTH/2) - 295, 150);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Comic Sans MS", Font.BOLD, 85));
        g2.drawString("Play", (GamePanel.SCREEN_WIDTH/2) -70, 400);

    }
}