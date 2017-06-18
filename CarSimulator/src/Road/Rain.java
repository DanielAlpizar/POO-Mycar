package Road;

import java.awt.image.BufferedImage;
import java.util.*;

import Car.Obstacles;

/**
 * 
 */
public class Rain extends Obstacle {

	/**
	 * Default constructor
	 * @return 
	 */
	public int[][] Build(int[][] map){
		PistaTools build = new PistaTools();
		int[]add= {5,5,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,5,5};
			return map=build.addElement(map, add);


		
	}

}