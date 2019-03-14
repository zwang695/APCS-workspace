package GridWorldPart2;

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class DancingBugRunner {

	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        int[] f = {1, 2, 2, 3, 3, 2, 2, 1};
        DancingBug alice = new DancingBug(f);
        alice.setColor(Color.RED);
        
        world.add(new Location(5, 5), alice);
        world.show();
    }
	
}
