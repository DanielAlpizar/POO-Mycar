package Road;

import java.awt.image.BufferedImage;
import java.util.*;

import Car.Obstacles;

/**
 * 
 */
public class Day extends Obstacle {
	private boolean day;
	private boolean night;

	public Day(boolean bday, boolean bnight) {
		day = bday;
		night = bnight;
	}

	public int[][] Build(int[][] map) {
		PistaTools build = new PistaTools();
		
		if (day) {
			int[]add= {2,2,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,2,2};
			return map = build.addElement(map, add);

		}
		else{
			int[]add= {3,3,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,3,3};
			return map = build.addElement(map, add);

		}
	}

}