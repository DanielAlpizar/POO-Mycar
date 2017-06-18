package Road;

import java.util.*;

import Car.Obstacles;

/**
 * 
 */
public class PistaTools {

	/**
	 * Default constructor
	 */
	public int[][] addElement(int[][] a, int[] add) {
		a = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = add;
		return a;
	}

	public int[][] BuildRoad(ArrayList<Obstacle> itemsinroad) {
		int[][] map = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		int index = 0;
		while (index != itemsinroad.size()) {
			map = itemsinroad.get(index).Build(map);
			index++;
		}
		printRoad(map);
		return map;

	}

	public void printRoad(int[][] map) {
		int index = 0;

		while (index != map.length) {
			int index2 = 0;
			while (index2 != map[index].length) {
				System.out.print(map[index][index2]);
				
				index2++;
			}
			System.out.println("\n");
			index++;
		}
	}

}