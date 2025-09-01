import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.List;
import java.util.ArrayList;

public class Wombat extends Actor
{
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;

    private int direction;
    private int leavesEaten;
    private int stepsTaken;
    private int maxSteps;
    
    public Wombat()
    {
        setDirection(EAST);
        leavesEaten = 0;
        stepsTaken = 0;
        maxSteps = 50;
    }

    /**
     * Do whatever the wombat likes to to just now.
     */
    public void act() {
    if (foundLeaf()) {
        eatLeaf();
    }
    else if (foundStone()) {
        eatStone();
        if (canMove()) {
            move();
        } else {
            turnLeft();
        }
    }
    else if (canMove()) {
        move();
    }
    else {
        turnLeft();
    }
}


    /**
     * Check whether there is a leaf in the same cell as we are.
     */
    public boolean foundLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Eat a leaf.
     */
    public void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            getWorld().removeObject(leaf);
            leavesEaten = leavesEaten + 1; 
            maxSteps += 25;
        }
    }
    
     public boolean foundStone() {
    Actor stone = getOneObjectAtOffset(0, 0, Stone.class);
    return (stone != null);
}
    
    public void eatStone() {
        Actor stone = getOneObjectAtOffset(0, 0, Stone.class);
        if (stone != null && leavesEaten >= 5) {
            getWorld().removeObject(stone);
            leavesEaten -= 5;
    }
}

    
    /**
     * Move one cell forward in the current direction.
     */
    public void move()
    {
        if (!canMove()) {
            return;
        }
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
        stepsTaken++;
        
        if (stepsTaken >= maxSteps) {
            getWorld().removeObject(this);
        }
    }

    /**
     * Test if we can move forward. Return true if we can, false otherwise.
     */
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        
        List<Stone> stones = myWorld.getObjectsAt(x, y, Stone.class);
        if (!stones.isEmpty()) {
            return true;
        }

        return true;
    }

    /**
     * Turns towards the left.
     */
    public void turnLeft()
    {
        switch(direction) {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(NORTH);
                break;
            case NORTH :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(SOUTH);
                break;
        }
    }

    /**
     * Sets the direction we're facing. The 'direction' parameter must
     * be in the range [0..3].
     */
    public void setDirection(int direction)
    {
        if ((direction >= 0) && (direction <= 3)) {
            this.direction = direction;
        }
        switch(direction) {
            case SOUTH :
                setRotation(90);
                break;
            case EAST :
                setRotation(0);
                break;
            case NORTH :
                setRotation(270);
                break;
            case WEST :
                setRotation(180);
                break;
            default :
                break;
        }
    }

    /**
     * Tell how many leaves we have eaten.
     */
    public int getLeavesEaten()
    {
        return leavesEaten;
    }
    
    public int getStepsTaken()
    {
        return stepsTaken;
    }
}