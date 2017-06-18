package Road;

import java.awt.image.BufferedImage;
import java.util.Random;

import Car.Obstacles;

public class Street extends Obstacle {
	public int[][] Build(int[][] map){
		PistaTools build = new PistaTools();
		int index = 0;
		while(index!=10){

			int[]add= {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1};


			map=build.addElement(map, add);
			index++;
		}
		return map;

	}
}
