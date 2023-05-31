import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseHandler implements MouseListener {
    Boolean clicked = false;
    Boolean hover = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x >= ((GamePanel.SCREEN_WIDTH/2) -140) && y >= 300 && x <= ((GamePanel.SCREEN_WIDTH/2) +100) && y <= 585) {
            clicked = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x >= ((GamePanel.SCREEN_WIDTH/2) -140) && y >= 300 && x <= ((GamePanel.SCREEN_WIDTH/2) +100) && y <= 585) {
            hover = true;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x <= ((GamePanel.SCREEN_WIDTH/2) -140) && y <= 300 && x >= ((GamePanel.SCREEN_WIDTH/2) +100) && y >= 585) {
            hover = false;
        }
    }
    
}
