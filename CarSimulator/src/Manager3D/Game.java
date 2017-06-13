package Manager3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public int mapWidth = 15;
	public int mapHeight = 15;
	private Thread thread;
	private boolean running;
	private BufferedImage image;
	public int[] pixels;
	public ArrayList<Texture> textures;
	public Camera camera;
	public Screen screen;
	public static int[][] map;
		
	public Game(int[][] bmap) {
		map=bmap;
		thread = new Thread(this);
		image = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		textures = new ArrayList<Texture>();
		textures.add(Texture.house);
		textures.add(Texture.brick);
		textures.add(Texture.bluestone);
		textures.add(Texture.stone);
		camera = new Camera(1, 4.5, 1, 0, 0, -.66);
		screen = new Screen(map, mapWidth, mapHeight, textures, 640, 480);
		addKeyListener(camera);
		setSize(640, 480);
		setResizable(false);
		setTitle("3D Engine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.blue);
		setLocationRelativeTo(null);
		setVisible(true);
		start();
	}
	private synchronized void start() {
		running = true;
		thread.start();
	}
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		bs.show();
	}
	public void run() {
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;//60 times per second
		double delta = 0;
		requestFocus();
		while(running) {
			long now = System.nanoTime();
			delta = delta + ((now-lastTime) / ns);
			lastTime = now;
			while (delta >= 1)//Make sure update is only happening 60 times a second
			{
				//handles all of the logic restricted time
				screen.update(camera, pixels);
				camera.update(map);
				delta--;
			}
			render();//displays to the screen unrestricted time
		}
	}
	static int[][] addElement(int[][] a, int[] add) {
	    a  = Arrays.copyOf(a, a.length + 1);
	    a[a.length - 1] = add;
	    return a;
	}
	public static void main(String [] args) {
		int[][] map= {{2,2,2,2,2,2,2}};
		
		int index = 0;
		while(index != 1000){
			int[]add= {1,0,0,0,0,0,1};

			map=addElement(map,add);
			
			index++;
		}
		int[]add= {2,2,2,2,2,2,2};

		map=addElement(map,add);

		System.out.println(map[1][1]);
		Game game = new Game(map);
	}
}