package Control;

import java.awt.Color;
import java.util.*;
import Tools.IConstants;
import UI.GameOver;
import Car.CarSystem;
import Car.Obstacles;
import Manager3D.Game;

public class Evaluator implements IConstants {

	private int actualScore = 100;
	private int maximumScore = 100;
	private CarSystem system;
	private Game game;

	public Evaluator() {

	}

	public void evaluate() throws InterruptedException {
		Double posX = game.getCamera().getxPos();

		if (actualScore >= 0) {
			if ((int) system.returnActualValues().get(2) > 10) {
				Thread.sleep(5000);
				if ((int) system.returnActualValues().get(2) > 10) {
					actualScore -= LOST_POINTS;
				}

			} else if ((int) system.returnActualValues().get(3) < (int) system.returnActualValues().get(14)) {
				Thread.sleep(5000);
				if ((int) system.returnActualValues().get(3) < (int) system.returnActualValues().get(14)) {
					actualScore -= LOST_POINTS;
				}

			} else if ((int) system.returnActualValues().get(3) > (int) system.returnActualValues().get(13)) {
				Thread.sleep(5000);
				if ((int) system.returnActualValues().get(3) > (int) system.returnActualValues().get(13)) {
					actualScore -= LOST_POINTS;
				}

			} else if ((boolean) system.returnActualValues().get(15) == false
					&& (int) system.returnActualValues().get(7) > 5) {
				Thread.sleep(5000);
				if ((boolean) system.returnActualValues().get(15) == false
						&& (int) system.returnActualValues().get(7) > 5) {

					actualScore -= LOST_POINTS;

				}
			} else if ((boolean) system.returnActualValues().get(16) == false
					&& (int) system.returnActualValues().get(8) > 5) {
				Thread.sleep(5000);

				if ((boolean) system.returnActualValues().get(16) == false
						&& (int) system.returnActualValues().get(8) > 5) {
					actualScore -= LOST_POINTS;
				}

			}
			
			else if ((boolean) system.returnActualValues().get(5)!=(boolean) system.returnActualValues().get(10)){
				actualScore -= LOST_POINTS;

				Thread.sleep(5000);

			}
			else if ((boolean) system.returnActualValues().get(6)!=(boolean) system.returnActualValues().get(11)){
				actualScore -= LOST_POINTS;
				Thread.sleep(5000);

			}

			else if(game.getMap()[posX.intValue()][0]==4&&(int) system.returnActualValues().get(3)>10){
				actualScore -= LOST_POINTS;
				Thread.sleep(15000);

			}
		}
		system.setPoints(actualScore);
		if (actualScore == 0) {
			game.dispose();
			GameOver over = new GameOver();
			over.setVisible(true);
		}
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setSystem(CarSystem system) {
		this.system = system;
	}

}