import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreditsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditsButton extends Button
{
    /**
     * Act - do whatever the CreditsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        super.act();
    }
    
    public void buttonPressed()
    {
        GoBackButton goBackButton=new GoBackButton();
        SnowCompsWorld world=(SnowCompsWorld)super.getWorld();
        world.cleanWorld();
        world.setBackground("credits.png");
        world.addObject(goBackButton, 720, 540);
    }
}
