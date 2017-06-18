package Road;

import java.awt.image.BufferedImage;
import java.util.*;

import Car.Obstacles;

/**
 * 
 */
public class Cuatrosesquinas extends Obstacle{

	/**
	 * Default constructor
	 * @return 
	 */
	public int[][] Build(int[][] map){
		PistaTools build = new PistaTools();
		int index = 0;


		while(index!=5){
			int[]add= {4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4};

			map=build.addElement(map, add);
			index++;

		}
		
		return map;

	}
}