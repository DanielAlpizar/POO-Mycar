package Road;

import java.awt.image.BufferedImage;
import java.util.*;

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
		int[]add= {11,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,11};
			return map=build.addElement(map, add);


		
	}

}