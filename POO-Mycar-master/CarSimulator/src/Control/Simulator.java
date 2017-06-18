package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import Car.System;
import Tools.Observer;
import Tools.Subject;

public class Simulator implements KeyListener {

	System system = new System();

	private boolean accelerate;
	private boolean left;
	private boolean right;
	private boolean breack;

	public void keyPressed(KeyEvent key) {
		if ((key.getKeyCode() == KeyEvent.VK_LEFT))
			system.getMotor().getDirection().turnLeft(true);
		if ((key.getKeyCode() == KeyEvent.VK_RIGHT))
			system.getMotor().getDirection().turnRight(true);

		if ((key.getKeyCode() == KeyEvent.VK_UP))
			accelerate = true;
		while (accelerate) {
			system.getMotor().accelerate();
		}
		if ((key.getKeyCode() == KeyEvent.VK_DOWN))
			while (accelerate) {
				system.getMotor().breack();
			}
		
		if ((key.getKeyCode() == KeyEvent.VK_NUMPAD0)){
			if(!system.getElectric().getElectric().isLights()){
				system.getElectric().setLights(true);
			}else{
				system.getElectric().setLights(false);

			}
		}
		if ((key.getKeyCode() == KeyEvent.VK_NUMPAD1)){
			if(!system.getElectric().getElectric().isLeftBlinker()){
				system.getElectric().setLeftBlinker(true);
			}else{
				system.getElectric().setLeftBlinker(false);

			}
		}
		if ((key.getKeyCode() == KeyEvent.VK_NUMPAD1)){
			if(!system.getElectric().getElectric().isRightBlinker()){
				system.getElectric().setRightBlinker(true);
			}else{
				system.getElectric().setRightBlinker(false);

			}
		}
			
			if ((key.getKeyCode() == KeyEvent.VK_NUMPAD3)){
				if(!system.getElectric().getElectric().isWindshield()){
					system.getElectric().setWindshield(true);
				}else{
					system.getElectric().setWindshield(false);

				}
		}

		
		
		
		
	}

	public System getSystem() {
		return system;
	}

	public void keyReleased(KeyEvent key) {
		if ((key.getKeyCode() == KeyEvent.VK_LEFT))
			system.getMotor().getDirection().turnLeft(false);
		if ((key.getKeyCode() == KeyEvent.VK_RIGHT))
			system.getMotor().getDirection().turnRight(false);
		if ((key.getKeyCode() == KeyEvent.VK_UP))
			accelerate=false;
		if ((key.getKeyCode() == KeyEvent.VK_DOWN))
			breack = false;
	}

	public void start() {
		system.start();
	}

	public void accelerate(int speed) {

	}

	public void breack(int speed) {

	}

	public void turnRight(int degrees) {

	}

	public void turnLeft(int degrees) {

	}

	public void turnOnLights() {

	}

	public void turnOffLights() {

	}

	public void turnOnRightBlinker() {

	}

	public void turnOffRightBlinker() {

	}

	public void turnOnLeftBlinker() {

	}

	public void turnOffLeftBlinker() {

	}

	public void turnOnWndshield() {

	}

	public void turnOffWindshield() {

	}

	public void changeGear(int gear) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}