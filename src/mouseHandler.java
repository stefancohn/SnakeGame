import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mouseHandler implements MouseListener, MouseMotionListener {
    Boolean clicked = false;
    int x;
    int y;

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
    //this doesn't work?
    public void mouseEntered(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
        //if (x >= ((GamePanel.SCREEN_WIDTH/2) -110) && y >= 325 && x <= ((GamePanel.SCREEN_WIDTH/2) +110) && y <= 425) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //if (x < ((GamePanel.SCREEN_WIDTH/2) - 140) || y < 300 || x > ((GamePanel.SCREEN_WIDTH/2) + 100) || y > 585) {
    } 

    public double getX() { return this.x; }
    public double getY() { return this.y; }

    public boolean clicked() { return this.clicked; }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }
}
