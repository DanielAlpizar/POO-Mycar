package Control;

import java.io.File;
import java.util.*;

import Manager3D.Game;
import Road.FabricaPista;
import Road.Road;

/**
 * 
 */
public class System {

	Road itemsinroad = new Road();
    private File roadfile;
    

	public System() {
		
		itemsinroad.chargeRoad(roadfile);
		
	}

	/**
	 * 
	 */
	public void start() {
		FabricaPista fabrica = new FabricaPista();
		int[][] map = fabrica.BuildRoad(itemsinroad.getItemsinroad());
		Game game = new Game(map);
	
	}

	/**
	 * @param speed
	 * @param degrees
	 * @param gear
	 */
	/*public void reportNavegation(void speed, void degrees, void gear) {
		// TODO implement here
	}*/

	/**
	 * @param statusRightBlinker
	 * @param statusLeftBlinker
	 * @param statusWindshield
	 * @param statusLight
	 */
	/*public void reportDash(void statusRightBlinker, void statusLeftBlinker, void statusWindshield, void statusLight) {
		// TODO implement here
	}*/

	/**
     * 
     */

	/*returnActualValues() {
        // TODO implement here
    }*/

}