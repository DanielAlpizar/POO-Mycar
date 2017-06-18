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
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Tools.Observer;
import Tools.Subject;

public class Dash implements Observer {
	int Speed = 0;
	boolean direccionalright = false;
	boolean direccionalleft = false;
	boolean Lights = false;
	boolean Windshield = false;
	int MaxSpeed = 0;
	int MinSpeed = 0;
	int gear = 0;

	int Points= 100;
	private Graphics graphics;
	private String name;
	private Subject topic;

	public void render() {
		Font font = new Font("Verdana", Font.BOLD, 12);
		graphics.setFont(font);
		String speedtext = "Speed:";
		speedtext = speedtext + Speed;
		graphics.drawString(speedtext, 10, 450);
		
		
		graphics.setFont(font);
		String GearS = "Gear:";
		GearS = GearS + gear;
		graphics.drawString(GearS, 100, 470);
		
		
		graphics.setFont(font);
		String MinSpeedS = "Min Speed:";
		MinSpeedS = MinSpeedS + MinSpeed;
		graphics.drawString(MinSpeedS, 10, 470);
		
		graphics.setFont(font);
		String MaxSpeedS = "Max Speed:";
		MaxSpeedS = MaxSpeedS + MaxSpeed;
		graphics.drawString(MaxSpeedS, 10, 460);
		
		graphics.setFont(font);
		String SPoints = "Points:";
		SPoints = SPoints + Points;
		graphics.drawString(SPoints, 100, 460);
		
		
		
		if (direccionalright) {
			BufferedImage img;
			try {
				img = ImageIO.read(new File("E://textures//arrowright.png"));
				graphics.drawImage(img, 10, 400, 50, 50, null);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (direccionalleft) {
			BufferedImage img;
			try {
				img = ImageIO.read(new File("E://textures//arrowleft.png"));
				graphics.drawImage(img, 580, 400, 50, 50, null);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

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
			graphics.setFont(font);
			String Wind = "WindShield:";
			Wind = Wind + Windshield;
			graphics.drawString(Wind, 100, 450);
		
	}
	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}


	@Override
	public void update(Object info) {
		Car.CarSystem CarSystem  = (Car.CarSystem) info;
		Points =CarSystem.getPoints();
		ArrayList infoarray= CarSystem.returnActualValues();
		Speed=(int) infoarray.get(3);
		gear=(int)infoarray.get(0);

		direccionalright=(boolean) infoarray.get(10);
		direccionalleft=(boolean) infoarray.get(11);
		Lights=(boolean) infoarray.get(9);
		Windshield=(boolean) infoarray.get(12);
		MaxSpeed=(int)infoarray.get(13);
		MinSpeed=(int)infoarray.get(14);
		
	}
	public void setSubject(Subject sub) {
		this.topic=sub;
	}



}
