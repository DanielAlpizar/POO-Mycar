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
		int index = 0;
		int count = 0;
		
		while(index!=map.length){
			if(map[index][0]==4){
				count++;
			}
			index++;
		}
		count = count/4;
		
		int[]add2= {4,4,4,4,4,4,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,4};
		map=build.addElement(map, add2);

		if(count%2==0 ||  count ==0){
			int[]add= {4,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,4,4,4};

			map=build.addElement(map, add);
		}else{
			int[]add= {4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,4};


			map=build.addElement(map, add);
		}
		
		
		index=0;
		while(index!=3){
			int[]add= {4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4};

			map=build.addElement(map, add);
			index++;

		}
		if(count%2==0 ||  count ==0){
			int[]add= {4,4,4,4,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,4};


			map=build.addElement(map, add);
		}else{
			int[]add= {4,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,4,4,4};

			map=build.addElement(map, add);
		}
		
		return map;
		

	}
	


}