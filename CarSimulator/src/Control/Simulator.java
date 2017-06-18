package Control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.*;
import Car.CarSystem;
import Car.Obstacles;
import Manager3D.Game;
import Tools.Controller;
import Tools.Frame;
import Tools.Hand;
import Tools.LeapListener;
import Tools.Observer;
import Tools.Subject;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

public class Simulator implements KeyListener,  Listener, Runnable {

	
	private CarSystem system = new CarSystem();
	private Game game;
	private boolean left;
	private Evaluator evaluator = new Evaluator();
	private boolean right;
	private boolean breack;

	public Simulator() {
		
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void run() {
		evaluator.setGame(game);

		evaluator.setSystem(system);
		while (true) {
			if (game.getScreen().getSky() == Color.BLACK) {
				system.getObstacles().showDay(false);
			} else if (game.getScreen().getSky() == Color.blue) {
				system.getObstacles().showDay(true);
			}
			if (game.getScreen().getSky() == Color.gray) {
				system.getObstacles().showRain(true);
			} else {
				system.getObstacles().showRain(false);

			}

			try {
				evaluator.evaluate();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public void keyPressed(KeyEvent key) {

		if ((key.getKeyCode() == KeyEvent.VK_LEFT))
			system.getDirection().turnLeft(true);

		if ((key.getKeyCode() == KeyEvent.VK_RIGHT))
			system.getDirection().turnRight(true);
		if ((key.getKeyCode() == KeyEvent.VK_UP)) {
			system.getMotor().accelerate();

		}
		if ((key.getKeyCode() == KeyEvent.VK_DOWN)) {
			system.getMotor().breack();

		}
		if ((key.getKeyCode() == KeyEvent.VK_NUMPAD7)) {
			system.getMotor().setGear(system.getMotor().getGear()+1);

		}
		if ((key.getKeyCode() == KeyEvent.VK_NUMPAD4)) {
			system.getMotor().setGear(system.getMotor().getGear()-1);

		}
		if ((key.getKeyCode() == KeyEvent.VK_NUMPAD0)) {
			if (!system.getElectric().isLights()) {
				system.getElectric().setLights(true);
			} else {
				system.getElectric().setLights(false);

			}
		}
		if ((key.getKeyCode() == KeyEvent.VK_NUMPAD1)) {
			if (!system.getElectric().isLeftBlinker()) {
				system.getElectric().setLeftBlinker(true);
			} else {
				system.getElectric().setLeftBlinker(false);

			}
		}
		if ((key.getKeyCode() == KeyEvent.VK_NUMPAD2)) {
			if (!system.getElectric().isRightBlinker()) {
				system.getElectric().setRightBlinker(true);
			} else {
				system.getElectric().setRightBlinker(false);

			}
		}

		if ((key.getKeyCode() == KeyEvent.VK_NUMPAD3)) {
			if (!system.getElectric().isWindshield()) {
				system.getElectric().setWindshield(true);
			} else {
				system.getElectric().setWindshield(false);

			}
		}

		if ((key.getKeyCode() == KeyEvent.VK_ENTER)) {
			system.start();
		}

		system.setChanged(true);
		system.notifyObservers();

	}

	public CarSystem getSystem() {
		return system;
	}

	public void keyReleased(KeyEvent key) {
		if ((key.getKeyCode() == KeyEvent.VK_LEFT))
			system.getDirection().turnLeft(false);
		if ((key.getKeyCode() == KeyEvent.VK_RIGHT))
			system.getDirection().turnRight(false);
		if ((key.getKeyCode() == KeyEvent.VK_UP))
			system.getMotor().decelerate();

		if ((key.getKeyCode() == KeyEvent.VK_DOWN))
			breack = false;
		system.setChanged(true);
		system.notifyObservers();

	}

	public void start() {
		system.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void onInit(Controller controller){
		System.out.println("Iniciaizado");
	}
	
	public void onConnect(Controller controller){
		System.out.println("Conectado a Motion Sensor");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
		controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
	}
	
	public void onDisconnect(Controller controller){
		System.out.println("Motion Sensor desconectado");
	}
	
	public void onExit(Controller controller){
		System.out.println("Exited");
	}
	
	public void onFrame(Controller controller){
		Frame frame = controller.frame();
		for(Hand hand : frame.hands()){
			String handType = hand.isLeft() ? "Left Hand" : "Right Hand";
			if(frame.hands().count() == 1){
				if(hand.direction().getX() < -0.5){
					system.getDirection().turnLeft(true);
					system.getMotor().accelerate();


				}else if(hand.direction().getX() >= -0.5  && hand.direction().getX() <= 0.5 ){
					system.getMotor().accelerate();

				}else if(hand.direction().getX() > 0.5){
					system.getDirection().turnRight(true);
					system.getMotor().accelerate();
				}
			}else if(frame.hands().count() == 2){
				system.getMotor().breack();
			}
		}	
	}

}