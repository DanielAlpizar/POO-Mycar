package Road;

import java.awt.image.BufferedImage;
import java.util.Random;

import Car.Obstacles;

public class Street extends Obstacle {
	public int[][] Build(int[][] map){
		PistaTools build = new PistaTools();
		Random r = new Random();
		int index = 0;
		while(index!=4){
			int textureid = r.nextInt(3)+1;

			int[]add= {textureid,0,0,0,0,0,textureid,0,0,0,0,0,0,0,0,textureid,0,0,0,0,0,textureid};


			map=build.addElement(map, add);
			index++;
		}
		return map;

	}
}
