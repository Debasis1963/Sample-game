/*Author- Ranabir Chakraborty
 * This class showns how to subclass Sprite. 
 * It defines an object that moves vertically and bounces at the borders of the game area.
*/

public class BouncingSprite extends Sprite
{
    public void clocktick()
    {
        super.clocktick();

        if (this.getY() < 0 && this.getDY() < 0)
        {
            this.setMotion(this.getDX(), - this.getDY());
        }
        else
        if ((this.getY() + this.getHeight()) > 600 && this.getDY() > 0)
        {
            this.setMotion(this.getDX(), - this.getDY());
        }
    }
}

