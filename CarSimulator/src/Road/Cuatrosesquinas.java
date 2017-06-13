package Road;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class Cuatrosesquinas extends Obstacle {

	/**
	 * Default constructor
	 */
	public void Build(int[][] map){
		FabricaPista build = new FabricaPista();
		int index = 0;
		while(index!=4){
			int[] add = {3,0,0,0,0,0,3};

			build.addElement(map, add);

		}

	}
}