package Road;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class Final extends Obstacle {

	/**
	 * Default constructor
	 * @return 
	 */
	public int[][] Build(int[][] map){
		PistaTools build = new PistaTools();
		int[]add= {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
		return map=build.addElement(map, add);
	}

}