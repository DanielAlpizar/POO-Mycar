package Road;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class Final extends Obstacle {

	/**
	 * Default constructor
	 */
	public void Build(int[][] map){
		FabricaPista build = new FabricaPista();
		int[] add = {4,4,4,4,4,4,4};
		build.addElement(map, add);
	}

}