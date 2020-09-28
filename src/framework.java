import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame 
{
    public GameFrame() 
    {
        this.setTitle("Game Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocation(50,50);
        this.setResizable(false);
        
        GameView view = new GameView();
        view.setState(new IntroState(view));
        this.add(view, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        new GameFrame();
   }
}
