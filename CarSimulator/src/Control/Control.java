package Control;

import java.awt.Menu;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.SwingUtilities;

import Manager3D.Game;
import Road.PistaTools;
import Road.Road;
import Tools.LeapListener;
import Tools.ThreadManager;
import UI.MenuRoad;

/**
 * 
 */
public class Control {

	private Road RoadObjects = new Road();
	private MenuRoad menu;

    private File roadfile;
    

	public Control() {
		 menu = new MenuRoad(this);
	}

	/**
	 * 
	 */
	public void start(File roadfile){
		
		

		
		
		
		RoadObjects.chargeRoad(	roadfile);

		PistaTools fabrica = new PistaTools();

		int[][] map = fabrica.BuildRoad(RoadObjects.getItemsinroad());
		Simulator sim = new Simulator();
		Game game = new Game(map,sim);

		sim.getSystem().register(game.getCamera());
		game.getCamera().setSubject(sim.getSystem());
		sim.getSystem().register(game.getHud());
		game.getHud().setSubject(sim.getSystem());
		ThreadManager.getInstance().getExecutor().execute(game);
		sim.setGame(game);

		ThreadManager.getInstance().getExecutor().execute(sim);
		
		
		
		
		LeapListener listener = new LeapListener();
		

		Controller controller = new Controller();
		controller.addListener(sim);

		try{
			System.in.read();
		}catch(IOException e){
			e.printStackTrace();
		}

		controller.removeListener(listener);
		
	}
    public static void main(String[] args) {

    	@SuppressWarnings("unused")
		Control Control = new Control();
        
    }

}