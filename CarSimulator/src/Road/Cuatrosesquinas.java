package Road;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class Cuatrosesquinas extends Obstacle {

	/**
	 * Default constructor
	 * @return 
	 */
	public int[][] Build(int[][] map){
		PistaTools build = new PistaTools();
		int index = 0;
		while(index!=4){
			int[]add= {3,0,0,0,0,0,0,0,0,3,3,0,0,0,0,0,0,0,0,3};

			map=build.addElement(map, add);
			index++;

		}
		return map;

	}
}