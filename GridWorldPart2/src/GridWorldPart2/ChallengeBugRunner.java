package GridWorldPart2;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class ChallengeBugRunner {
	
	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        ChallengeBug alice = new ChallengeBug();
        alice.setColor(Color.ORANGE);
        ChallengeBug robert = new ChallengeBug();
        ChallengeBug kevin = new ChallengeBug();
        kevin.setColor(Color.YELLOW);
        world.add(new Location(5, 5), alice);
        world.add(new Location(1, 2), kevin);
        world.add(new Location(7, 8), robert);
        world.add(new Location(9, 4), new Rock());
        world.add(new Location(0, 2), new Flower());
        world.add(new Location(5, 9), new Actor());
        world.add(new Location(4, 0), new Rock());
        world.show();
    }

}
