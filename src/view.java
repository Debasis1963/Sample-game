import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class GameView extends JComponent
{
    private AbstractGameState state;
    private Timer timer;
    
    public GameView()
    {
        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseMotionHandler());
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
        this.transferFocus();
    }
    
    public void setState(AbstractGameState state)
    {
        this.state = state;
        this.repaint();
    }

    public void paintComponent(Graphics g)
    {
        state.drawOn(g);
    }
    
    public void startClock(int milliseconds)
    {
        timer = new Timer(milliseconds, new TimerHandler());
        timer.start();
    }
    
    public void stopClock()
    {
        this.timer.stop();
    }
    
    class MouseHandler extends MouseAdapter
    {
        public void mousePressed(MouseEvent event)
        {
            state.handleMousePressed(event.getX(), event.getY());
        }
    }

    class MouseMotionHandler extends MouseMotionAdapter
    {
        public void mouseMoved(MouseEvent event)
        {
            state.handleMouseMoved(event.getX(), event.getY());
        }
    }
    
    class KeyHandler extends KeyAdapter
    {
        public void keyPressed(KeyEvent event)
        {
            state.handleKeyPressed(event.getKeyCode());
        }
    }
    
    class TimerHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            state.clocktick();
            repaint();
        }
    }
}
