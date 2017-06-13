package Road;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class Intersection extends Obstacle {
	private int cornerQuantity;

	public void Build(int[][] map){
		PistaTools build = new PistaTools();
		int index = 0;
		while(index!=4){
			int[] add = {2,0,0,0,0,0,2};

			build.addElement(map, add);

		}

	}
	


}