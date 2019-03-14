package GridWorldPart2;

import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
	private int[] turns;
    private int currIndex;
    private int turnIndex; //turn on even, move on odd
	
    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public DancingBug(int[] turns)
    {
        this.turns = turns;
    }

    /**
     * Moves to the next location of the square.
     */
    
    public void turn() {
    	if(currIndex<turns.length-1) {
    		for(int i = 0; i < turns[currIndex]; i++) {
    			super.turn();
    		}
    		currIndex++;
    	}
    	else {
    		for(int i = 0; i < turns[currIndex]; i++) {
    			super.turn();
    		}
    		currIndex = 0;
    	}
    }
    
    public boolean canMove() {
    	turn();
    	return(super.canMove());
    }
    
}