package Road;

import java.awt.image.BufferedImage;

public class Street extends Obstacle {
	public void Build(int[][] map){
		FabricaPista build = new FabricaPista();
		int index = 0;
		while(index!=4){
			int[] add = {1,0,0,0,0,0,1};

			build.addElement(map, add);

		}

	}
}
