package GridWorldPart2;

/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int numTurns;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        super.turn();
        super.turn();
    }

    /**
     * Moves to the next location of the square.
     */
    
    public void turn() {
    	if(!canMove()) {
    		return;
    	}
    	
    	if(numTurns==0) {
    		super.turn();
    		super.turn();
    		super.turn();
    	}
    	else if(numTurns==1) {
    		super.turn();
    		super.turn();
    		super.turn();
    		super.turn();
    		super.turn();
    	}
    	else {
    		return;
    	}
    	numTurns++;
    	steps = 0;
    }
    
    public boolean canMove() {
    	return (steps < sideLength && super.canMove() && numTurns < 3);
    }
    
    public void move() {
    	super.move();
    	steps++;
    }
    
    
}
