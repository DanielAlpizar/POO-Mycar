package Road;

import java.util.*;

import Car.Obstacles;

/**
 * 
 */
public class FabricaPista {

	/**
	 * Default constructor
	 */
	public int[][] addElement(int[][] a, int[] add) {
	    a  = Arrays.copyOf(a, a.length + 1);
	    a[a.length - 1] = add;
	    return a;
	}
	
	public int[][]  BuildRoad(ArrayList<Obstacle> itemsinroad){
		int[][] map = {};
		
		int index=0;
		while(index!=itemsinroad.size()){
			itemsinroad.get(index).Build(map);
		}
		return map;
		
		
	}

}