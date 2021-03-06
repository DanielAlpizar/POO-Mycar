package Manager3D;

import java.util.ArrayList;
import java.awt.Color;

public class Screen {
	private int[][] map;

	public Color getSky() {
		return sky;
	}

	public void setSky(Color sky) {
		this.sky = sky;
	}

	private int mapWidth, mapHeight, width, height;
	private ArrayList<Texture> textures;
	private Color sky = Color.BLUE;

	public Screen(int[][] m, int mapW, int mapH, ArrayList<Texture> tex, int w, int h) {
		map = m;
		mapWidth = mapW;
		mapHeight = mapH;
		textures = tex;
		width = w;
		height = h;
	}

	public int[] update(Camera camera, int[] pixels) {

		for (int n = 0; n < pixels.length / 2; n++) {
			if (pixels[n] != sky.getRGB())
				pixels[n] = sky.getRGB();
		}
		for (int i = pixels.length / 2; i < pixels.length; i++) {
			if (pixels[i] != Color.gray.getRGB())
				pixels[i] = Color.gray.getRGB();
		}
		for (int x = 0; x < width; x = x + 1) {
			double cameraX = 2 * x / (double) (width) - 1;
			double rayDirX = camera.getxDir() + camera.getxPlane() * cameraX;
			double rayDirY = camera.getyDir() + camera.getyPlane() * cameraX;
			// Map position
			int mapX = (int) camera.getxPos();
			int mapY = (int) camera.getyPos();
			// length of ray from current position to next x or y-side
			double sideDistX;
			double sideDistY;
			// Length of ray from one side to next in map
			double deltaDistX = Math.sqrt(1 + (rayDirY * rayDirY) / (rayDirX * rayDirX));
			double deltaDistY = Math.sqrt(1 + (rayDirX * rayDirX) / (rayDirY * rayDirY));
			double perpWallDist;
			// Direction to go in x and y
			int stepX, stepY;
			boolean hit = false;// was a wall hit
			int side = 0;// was the wall vertical or horizontal
			// Figure out the step direction and initial distance to a side
			if (rayDirX < 0) {
				stepX = -1;
				sideDistX = (camera.getxPos() - mapX) * deltaDistX;
			} else {
				stepX = 1;
				sideDistX = (mapX + 1.0 - camera.getxPos()) * deltaDistX;
			}
			if (rayDirY < 0) {
				stepY = -1;
				sideDistY = (camera.getyPos() - mapY) * deltaDistY;
			} else {
				stepY = 1;
				sideDistY = (mapY + 1.0 - camera.getyPos()) * deltaDistY;
			}
			// Loop to find where the ray hits a wall
			while (!hit) {
				// Jump to next square
				if (sideDistX < sideDistY) {
					sideDistX += deltaDistX;
					mapX += stepX;
					side = 0;
				} else {
					sideDistY += deltaDistY;
					mapY += stepY;
					side = 1;
				}
				// Check if ray has hit a wall
				// System.out.println(mapX + ", " + mapY + ", " +
				// map[mapX][mapY]);
				if (map[mapX][mapY] > 0)
					hit = true;
			}
			// Calculate distance to the point of impact
			if (side == 0)
				perpWallDist = Math.abs((mapX - camera.getxPos() + (1 - stepX) / 2) / rayDirX);
			else
				perpWallDist = Math.abs((mapY - camera.getyPos() + (1 - stepY) / 2) / rayDirY);
			// Now calculate the height of the wall based on the distance from
			// the camera
			int lineHeight;
			if (perpWallDist > 0)
				lineHeight = Math.abs((int) (height / perpWallDist));
			else
				lineHeight = height;
			// calculate lowest and highest pixel to fill in current stripe
			int drawStart = -lineHeight / 2 + height / 2;
			if (drawStart < 0)
				drawStart = 0;
			int drawEnd = lineHeight / 2 + height / 2;
			if (drawEnd >= height)
				drawEnd = height - 1;
			// add a texture
			int texNum = map[mapX][mapY] - 1;
			double wallX;// Exact position of where wall was hit
			if (side == 1) {// If its a y-axis wall
				wallX = (camera.getxPos() + ((mapY - camera.getyPos() + (1 - stepY) / 2) / rayDirY) * rayDirX);
			} else {// X-axis wall
				wallX = (camera.getyPos() + ((mapX - camera.getxPos() + (1 - stepX) / 2) / rayDirX) * rayDirY);
			}
			wallX -= Math.floor(wallX);
			// x coordinate on the texture
			int texX = (int) (wallX * (textures.get(texNum).getSIZE()));
			if (side == 0 && rayDirX > 0)
				texX = textures.get(texNum).getSIZE() - texX - 1;
			if (side == 1 && rayDirY < 0)
				texX = textures.get(texNum).getSIZE() - texX - 1;
			// calculate y coordinate on texture
			for (int y = drawStart; y < drawEnd; y++) {
				int texY = (((y * 2 - height + lineHeight) << 6) / lineHeight) / 2;
				int color;
				if (side == 0)
					color = textures.get(texNum).getPixels() [texX + (texY * textures.get(texNum).getSIZE())];
				else
					color = (textures.get(texNum).getPixels() [texX + (texY * textures.get(texNum).getSIZE())] >> 1) & 8355711;// Make
																													// y
																													// sides
																													// darker
				pixels[x + y * (width)] = color;
			}
		}
		Double posX = camera.getxPos();
		if(map[posX.intValue()][0]==3){
			setSky(Color.black);
		}
		else if(map[posX.intValue()][0]==2){
			setSky(Color.blue);
		}
		else if(map[posX.intValue()][0]==5){
			setSky(Color.darkGray);
		}
		return pixels;
	}
}
