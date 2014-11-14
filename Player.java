import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage []moveRight;
    private GreenfootImage []moveLeft;
    private GreenfootImage []jumpLeft;
    private GreenfootImage []jumpRight;
    private GreenfootImage []jumpDown;
    private GreenfootImage []shootRight;
    private GreenfootImage []shootLeft;
    
    private Counter msgScore;
    private Counter msgLifes;
    private CounterLifes countLifes;
    
    private GreenfootImage walkRight1 =new GreenfootImage("nickRight1.png");
    private GreenfootImage walkRight2 =new GreenfootImage("nickRight2.png");
    private GreenfootImage walkRight3 =new GreenfootImage("nickRight3.png");
        
    private GreenfootImage walkLeft1 =new GreenfootImage("nickLeft1.png");
    private GreenfootImage walkLeft2 =new GreenfootImage("nickLeft2.png");
    private GreenfootImage walkLeft3 =new GreenfootImage("nickLeft3.png");
        
    private GreenfootImage jumpLeft1 =new GreenfootImage("jumpLeft.png");
    private GreenfootImage jumpLeft2 =new GreenfootImage("jumpLeft1.png");
    private GreenfootImage jumpLeft3 =new GreenfootImage("jumpLeft2.png");
    private GreenfootImage jumpLeft4 =new GreenfootImage("jumpLeft3.png");
    private GreenfootImage jumpLeft5 =new GreenfootImage("jumpLeft4.png");
    private GreenfootImage jumpLeft6 =new GreenfootImage("nickLeft1.png");
        
    private GreenfootImage jumpRight1 =new GreenfootImage("jumpRight.png");
    private GreenfootImage jumpRight2 =new GreenfootImage("jumpRight1.png");
    private GreenfootImage jumpRight3 =new GreenfootImage("jumpRight2.png");
    private GreenfootImage jumpRight4 =new GreenfootImage("jumpRight3.png");
    private GreenfootImage jumpRight5 =new GreenfootImage("jumpRight4.png");
    private GreenfootImage jumpRight6 =new GreenfootImage("nickRight1.png");
        
    private GreenfootImage jumpDown1= new GreenfootImage("jumpDown.png");
    private GreenfootImage jumpDown2= new GreenfootImage("jumpDown2.png");
    private GreenfootImage jumpDown3= new GreenfootImage("nickRight.png");
    
    private GreenfootImage shootRight1=new GreenfootImage("shootRight1.png");
    private GreenfootImage shootRight2=new GreenfootImage("shootRight2.png");
    private GreenfootImage shootRight3=new GreenfootImage("shootRight3.png");
    
    private GreenfootImage shootLeft1=new GreenfootImage("shootLeft1.png");
    private GreenfootImage shootLeft2=new GreenfootImage("shootLeft2.png");
    private GreenfootImage shootLeft3=new GreenfootImage("shootLeft3.png");
    
    private int score=0;
    private int lifes=3;
    
    private boolean isDirectionRight;
    private boolean isTurnDown;
    private String direction;
    
    private int countMoveRight;
    private int countMoveLeft;
    private int countJumpLeft;
    private int countJumpRight;
    
    public Player()
    {
        moveRight= new GreenfootImage[3];
        moveLeft= new GreenfootImage[3];
        jumpLeft= new GreenfootImage[6];
        jumpRight=new GreenfootImage[6];
        jumpDown=new GreenfootImage[3];
        shootRight=new GreenfootImage[3];
        shootLeft=new GreenfootImage[3];
        
        moveRight[0]=walkRight1;
        moveRight[1]=walkRight2;
        moveRight[2]=walkRight3;
        
        moveLeft[0]=walkLeft1;
        moveLeft[1]=walkLeft2;
        moveLeft[2]=walkLeft3;
        
        jumpLeft[0]=jumpLeft1;
        jumpLeft[1]=jumpLeft2;
        jumpLeft[2]=jumpLeft3;
        jumpLeft[3]=jumpLeft4;
        jumpLeft[4]=jumpLeft5;
        jumpLeft[5]=jumpLeft6;
        
        jumpRight[0]=jumpRight1;
        jumpRight[1]=jumpRight2;
        jumpRight[2]=jumpRight3;
        jumpRight[3]=jumpRight4;
        jumpRight[4]=jumpRight5;
        jumpRight[5]=jumpRight6;
        
        jumpDown[0]=jumpDown1;
        jumpDown[1]=jumpDown2;
        jumpDown[2]=jumpDown3;
        
        shootRight[0]=shootRight1;
        shootRight[1]=shootRight2;
        shootRight[2]=shootRight3;
        
        shootLeft[0]=shootLeft1;
        shootLeft[1]=shootLeft2;
        shootLeft[2]=shootLeft3;
        
        isDirectionRight=true;
        isTurnDown=false;
        direction="right";
        
        msgLifes=new Counter();
        msgScore=new Counter("Score:");
        countLifes=new CounterLifes();
    
        countMoveRight=0;
        countMoveLeft=0;
        countJumpLeft=0;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void act() 
    {
        // Add your action code here.
        getWorld().addObject(msgScore,400,30);
        getWorld().addObject(countLifes,50, 30);
        getWorld().addObject(msgLifes,120,30);
        
        isTurnDown=false;
        msgScore.setValue(score);
        msgLifes.setValue(lifes);
 
        if(Greenfoot.isKeyDown("right"))
        {
            isDirectionRight=true;
            direction="right";
            
            if(countMoveRight>2)
            {
                countMoveRight=0;
            }
            
            if(getX()<770 && isTouching(Block.class))
            {
                setLocation(getX()+5,getY());
                setImage(moveRight[countMoveRight]);
                countMoveRight++;
            }
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            isDirectionRight=false;
            direction="left";
            
            if(countMoveLeft>2)
            {
                countMoveLeft=0;
            }
            
            if(getX()>20 && isTouching(Block.class))
            {
                setLocation(getX()-5,getY());
                setImage(moveLeft[countMoveLeft]);
                countMoveLeft++;
            }
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            if(isDirectionRight!=true)
            {
                for(int i=0;i<6;i++)
                {
                    Greenfoot.delay(1);
                    setLocation(getX(),getY()-12);
                    setImage(jumpLeft[i]);
                }
            }
            
            else
            {
                for(int i=0;i<6;i++)
                {
                    Greenfoot.delay(1);
                    setLocation(getX(),getY()-12);
                    setImage(jumpRight[i]);
                }
            }
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+15);
        }
        
        if(Greenfoot.isKeyDown("Enter") && isTurnDown==false)
        {
            SnowBall aSnowBall;
            
             
            if(isDirectionRight==true)
            {
                aSnowBall=new SnowBall("right");
                
                for(int i=0;i<3;i++)
                {
                    Greenfoot.delay(1);
                    setImage(shootRight[i]);
                }
                
                getWorld().addObject(aSnowBall,getX()+20,getY());
            }
            
            else
            {
                aSnowBall=new SnowBall("left");
                
                for(int i=0;i<3;i++)
                {
                    Greenfoot.delay(1);
                    setImage(shootLeft[i]);
                }
                
                getWorld().addObject(aSnowBall,getX()-20,getY());
            }
            
            if(aSnowBall.shootPredator()==true)
            {
                score++;
            }
        }
        
        if(isTouching(Block.class)!=true && getY()<550)
        {
            isTurnDown=true;
            setLocation(getX(),getY()+10);
            setImage(jumpDown[1]);
            
            if(getY()>500)
            {
                setLocation(getX(),550);
                setImage(walkRight1);
            }
        }
        
        if(isTouching(Predator.class))
        {
            setLocation(100,550);
            lifes--;
        }
    }
    
    public boolean isAtEdge()
    {
        SnowCompsWorld myWorld;
        myWorld=(SnowCompsWorld)getWorld();
        
        GreenfootImage myImage=this.getImage();
        
        if(getX()-myImage.getWidth()/2<=1 || getX()+myImage.getWidth()>=myWorld.getWidth())
        return(true);
        
        if(getY()-myImage.getHeight()<=1 || getY()+myImage.getHeight()>=myWorld.getHeight())
        return(true);
        
       return(false);
    }
    
    public String getDirection()
    {
        return direction;
    }
}