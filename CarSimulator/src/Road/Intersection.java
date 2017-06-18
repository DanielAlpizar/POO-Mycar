package Road;

import java.awt.image.BufferedImage;
import java.util.*;

import Car.Obstacles;

/**
 * 
 */
public class Intersection extends Obstacle {

	public int[][] Build(int[][] map){
		PistaTools build = new PistaTools();
	int index=0;
	while(index!=4){
		int[]add= {4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,4,4};


		map=build.addElement(map, add);
		index++;

	}
	index=0;
	
	while(index!=20){

		int[]add= {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1};


		map=build.addElement(map, add);
		index++;
	}
	index=0;

	while(index!=4){
		int[]add= {4,4,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4};


		map=build.addElement(map, add);
		index++;

	}
		

		return map;
		

	}

}