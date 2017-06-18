package Tools;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

import Car.CarSystem;

public class LeapListener extends Listener {
	
	
	private CarSystem system ;
	public CarSystem getSystem() {
		return system;
	}

	public void setSystem(CarSystem system) {
		this.system = system;
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
					system.accelerate();
					system.TurnLeft();
				}else if(hand.direction().getX() >= -0.5  && hand.direction().getX() <= 0.5 ){
					system.accelerate();
				}else if(hand.direction().getX() > 0.5){
					system.accelerate();
					system.turnRight();
					}
			}else if(frame.hands().count() == 2){
					system.deaccelerate();
			}
		}	
	}
}
