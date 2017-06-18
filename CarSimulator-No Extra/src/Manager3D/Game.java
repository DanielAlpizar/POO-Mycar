package Manager3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

import Control.Evaluator;
import Control.Simulator;

public class Game extends JFrame implements Runnable {

	public static int[][] getMap() {
		return map;
	}

	public static void setMap(int[][] map) {
		Game.map = map;
	}


	private static int[][] map;

	private int mapWidth = 15;
	private int mapHeight = 15;
	private Thread thread;
	private boolean running;
	private BufferedImage image;
	private int[] pixels;
	private ArrayList<Texture> textures;
	private Camera camera;
	private Screen screen;
	private Dash hud = new Dash();
	public Dash getHud() {
		return hud;
	}


	private Texture house = new Texture("house.jpg", 64);
	private Texture house2 = new Texture("house2.jpg", 64);
	private Texture brick = new Texture("brickwall2.jpg", 64);
	
	private Texture wood = new Texture("wood.jpg", 64);
	private Texture wood2 = new Texture("wood2.jpg", 64);
	private Texture brick2 = new Texture("brickwall.jpg", 64);

	public Game(int[][] bmap,Simulator sim) {

		map = bmap;
		thread = new Thread(this);
		image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		textures = new ArrayList<Texture>();
		textures.add(house);
		textures.add(brick);
		textures.add(brick2);

		textures.add(house2);
		textures.add(wood);
		textures.add(wood2);

		camera = new Camera(2, 10, 1, 0, 0, -.66);
		screen = new Screen(map, mapWidth, mapHeight, textures, 640, 480);
		addKeyListener(sim);
		setSize(640, 480);
		setResizable(false);
		setTitle("Car Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.blue);
		setLocationRelativeTo(null);
		setVisible(true);
		//start();
	}

	private synchronized void start() {
		running = true;
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics screenG = bs.getDrawGraphics();

		screenG.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		hud.setGraphics(screenG);
		hud.render();
		bs.show();
	}

	public void run() {
		running = true;
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;// 60 times per second
		double delta = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta = delta + ((now - lastTime) / ns);
			lastTime = now;
			
			while (delta >= 1)// Make sure update is only happening 60 times a
								// second
			{
				// handles all of the logic restricted time
				screen.update(camera, pixels);
				camera.update(map);
				delta--;
			}
			render();// displays to the screen unrestricted time
		}
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	static int[][] addElement(int[][] a, int[] add) {
		a = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = add;
		return a;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

}
