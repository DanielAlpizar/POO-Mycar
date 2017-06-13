package Road;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class Rain extends Obstacle {

	/**
	 * Default constructor
	 */
	public void Build(int[][] map){
		FabricaPista build = new FabricaPista();
			int[] add = {5,0,0,0,0,0,5};
			build.addElement(map, add);


		
	}

}