import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed = false;
    public boolean downPressed = false;
    public boolean rightPressed = false;
    public boolean leftPressed = false;
    public String direction;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if (i == KeyEvent.VK_D) {
            rightPressed = true;
            direction = "right";
        }
        if (i == KeyEvent.VK_A) {
            leftPressed = true;
            direction = "left";
        }
        if (i == KeyEvent.VK_S) {
            downPressed = true;
            direction = "down";
        }
        if (i == KeyEvent.VK_W) {
            upPressed = true;
            direction = "up";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int i = e.getKeyCode();
        if (i == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (i == KeyEvent.VK_A){
            leftPressed = false;
        }
        if (i == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (i == KeyEvent.VK_W) {
            upPressed = false;
        } 
    }

}