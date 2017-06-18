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
			int[]add= {10,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,10};
			return map = build.addElement(map, add);

		}
		else{
			int[]add= {9,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,9};
			return map = build.addElement(map, add);

		}
	}

}