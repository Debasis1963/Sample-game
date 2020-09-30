import java.awt.*;
import java.awt.event.*;

public class IntroState extends AbstractGameState
{
    public IntroState(GameView view)
    {
        super(view);
    }
    
    public void drawOn(Graphics g)
    {
        Rectangle bounds = this.getView().getBounds();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, bounds.width, bounds.height);
        g.setColor(Color.WHITE);
        Font font = new Font("Sans-Serif", Font.BOLD, 50);
        g.setFont(font);
        g.drawString("Press SPACE to start game!", 50, 250);
    }
            
    public void handleKeyPressed(int keyCode)
    {
	// check and compare the keycode
        if (keyCode == KeyEvent.VK_SPACE)
        {
            this.getView().setState(new PlayState(this.getView()));
        }
    }
}
