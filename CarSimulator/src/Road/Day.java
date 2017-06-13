package Road;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 
 */
public class Day extends Obstacle {
	private boolean day;
	private boolean night;
	public Day(boolean bday,boolean bnight){
		day=bday;
		night=bnight;
	}
	public void Build(int[][] map){
		PistaTools build = new PistaTools();
		int[] add = {6,0,0,0,0,0,6};
		build.addElement(map, add);
	}




}