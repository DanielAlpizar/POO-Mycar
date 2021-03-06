package Manager3D;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Tools.Observer;
import Tools.Subject;

public class PlayerHUD implements Observer {
	int Speed = 0;
	boolean direccionalright = false;
	boolean direccionalleft = false;
	boolean Lights = true;
	boolean Windshield = true;
	int MaxSpeed = 0;
	int MinSpeed = 0;

	private String name;
	private Subject topic;
	
	public PlayerHUD(Graphics graphics) throws IOException {
		Font font = new Font("Verdana", Font.BOLD, 12);
		graphics.setFont(font);
		String speedtext = "Speed:";
		speedtext = speedtext + Speed;
		graphics.drawString(speedtext, 10, 450);
		
		graphics.setFont(font);
		String MinSpeedS = "Min Speed:";
		MinSpeedS = MinSpeedS + MinSpeed;
		graphics.drawString(MinSpeedS, 10, 470);
		
		graphics.setFont(font);
		String MaxSpeedS = "Max Speed:";
		MaxSpeedS = MaxSpeedS + MaxSpeed;
		graphics.drawString(MaxSpeedS, 10, 460);
		
		
		
		if (direccionalright) {
			BufferedImage img = ImageIO.read(new File("E://textures//arrowright.png"));
			graphics.drawImage(img, 10, 400, 50, 50, null);
		}

		if (direccionalleft) {
			BufferedImage img = ImageIO.read(new File("E://textures//arrowleft.png"));
			;

			graphics.drawImage(img, 580, 400, 50, 50, null);
		}
		if(Lights){
			Graphics2D graphics2d = (Graphics2D)graphics;
			float alpha = (float) 0.5; //draw half transparent
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha);
			graphics2d.setComposite(ac);
			graphics2d.setColor(Color.white);
			graphics2d.fillOval(0, 250, 400, 400);
			graphics2d.fillOval(250, 250, 400, 400);
			graphics= (Graphics)graphics2d;

		}
		if(Windshield){
			
		}
	}



	@Override
	public void update(Object info) {
		Car.System CarSystem  = (Car.System) info;
		Speed=CarSystem.getMotor().getSpeed();
		direccionalright=CarSystem.getElectric().isRightBlinker();
		direccionalleft=CarSystem.getElectric().isLeftBlinker();
		Lights=CarSystem.getElectric().isLights();
		Windshield=CarSystem.getElectric().isWindshield();
		MaxSpeed=CarSystem.getObstacles().getMaximumSpeed();
		MinSpeed=CarSystem.getObstacles().getMinimumSpeed();
		
	}
	public void setSubject(Subject sub) {
		this.topic=sub;
	}



}
