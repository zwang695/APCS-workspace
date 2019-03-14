package GridWorldPart2;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class ChallengeBug extends Bug
{
    private int turnCount;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ChallengeBug()
    {
        super();
    }

    public void act() {
    	if(canMove() && ( hasToMove() || wantsToMove())) {
    		move();
    	}
    	else {
    		turn();
    	}
    }
    
    public Boolean hasToMove() {
    	if(turnCount>=8) return true;
    	return false;
    }
    
    public Boolean wantsToMove() {
    	Grid<Actor> gr = getGrid();
    	Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
    	Actor neighbor = gr.get(next);
        return !(neighbor instanceof Flower);
    }
    
    public void turn() {
    	turnCount++;
    	super.turn();
    }
    
    public void move() {
    	turnCount = 0;
    	super.move();
    }
}