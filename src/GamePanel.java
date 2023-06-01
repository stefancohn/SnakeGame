import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, ActionListener {
    JFrame frame = new JFrame();
    final static int SCREEN_HEIGHT = 780;
    final static int SCREEN_WIDTH = 1435; 
    final int FPS = 10;
    final static int UNIT_SIZE = 30;
    Random random = new Random();

    Thread GameThread;
    KeyHandler keyH = new KeyHandler();
    mouseHandler mH = new mouseHandler();

    snake Snake = new snake(keyH);
    apple Apple = new apple(Snake);

    public static int currentState = 0;
    menu Menu = new menu(mH);

    JButton playAgain = new JButton();
    JPanel lostPanel = new JPanel();
    JLabel lostText = new JLabel();

    GamePanel() {
        // panel set up
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(mH);
    }

    //starts the thread!
    public void startGameThread() { 
        GameThread = new Thread(this);
        GameThread.start();
    } 

    /*public void endGame() {
        playAgain.addActionListener(this);

        lostText.setText("You Lost");
        lostText.setForeground(Color.white);
        lostText.setOpaque(false);
        lostText.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
        lostText.setHorizontalAlignment(JLabel.CENTER);
        lostText.setBounds(500, 500, 500, 500);

        playAgain.setForeground(Color.blue);
        playAgain.setBackground(Color.WHITE);
        playAgain.setFont(new Font("Comic Sans MS", Font.PLAIN, 75));
        playAgain.setText("Play Again?");
        playAgain.setOpaque(true);
        playAgain.setBorderPainted(false);
        playAgain.setPreferredSize(new Dimension(250, 250));

        this.add(lostText, BorderLayout.CENTER);
        this.add(playAgain, BorderLayout.SOUTH);
    } */

    @Override
    public void run() {
        /* this is the game loop. drawinterval = one second (in the form of nanoseconds)
         * divided by the FPS so that we get the amount (0.16 in seconds) the game should update per sec.
         * We get the current time, subtract it by the last system time, divide that by this drawinterval
         * which will be a very small decimal that is added to delta. Once delta is one or over, we can
         * actually update the game.
         */
        double drawInterval = 1000000000/FPS;
        double delta = 0; 
        long lastTime = System.nanoTime();
        long currentTime; 
        long timer = 0;
        int drawTime = 0;

        while (GameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawTime++;
            }

            if (timer >= 1000000000) {
                //System.out.println("FPS: " + drawTime);
                drawTime = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        if (currentState == 1) {
            Apple.checkCollision();
            Snake.update();
            Snake.checkSnakeCollision();
        }
        else if (currentState == 0) {
            Menu.update();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);

        // grid draw
        // for (int i = 0; i < (SCREEN_HEIGHT/UNIT_SIZE); i++) {
            //g2.drawLine(0, i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
        //}
        //for (int i = 0; i < SCREEN_WIDTH/UNIT_SIZE; i++) {
            //g2.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
        //}
        if (currentState == 1) { 
            Snake.draw(g2);
            Apple.draw(g2); 
        }
        else if (currentState == 0) {
            Menu.draw(g2);
        }
        else if (currentState == 2){
            g2.setColor(Color.GREEN);
            g2.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
            g2.drawString("You Lost :(", (GamePanel.SCREEN_WIDTH/2) - 255, 420);
        }
            
        g2.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playAgain) {
            
       }
    }
}