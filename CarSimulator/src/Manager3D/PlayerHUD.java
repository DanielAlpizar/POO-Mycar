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

public class PlayerHUD {
	int Speed = 0;
	boolean direccionalright = false;
	boolean direccionalleft = false;
	boolean luz = true;
	boolean escobillas = true;
	
	public PlayerHUD(Graphics graphics) throws IOException {
		Font font = new Font("Verdana", Font.BOLD, 12);
		graphics.setFont(font);
		String speedtext = "Speed:";
		speedtext = speedtext + Speed;
		graphics.drawString(speedtext, 10, 450);
		if (direccionalright) {
			BufferedImage img = ImageIO.read(new File("E://textures//arrowright.png"));
			graphics.drawImage(img, 10, 400, 50, 50, null);
		}

		if (direccionalleft) {
			BufferedImage img = ImageIO.read(new File("E://textures//arrowleft.png"));
			;

			graphics.drawImage(img, 580, 400, 50, 50, null);
		}
		if(luz){
			Graphics2D graphics2d = (Graphics2D)graphics;
			float alpha = (float) 0.5; //draw half transparent
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha);
			graphics2d.setComposite(ac);
			graphics2d.setColor(Color.white);
			graphics2d.fillOval(140, 140, 400, 400);
			
			graphics= (Graphics)graphics2d;

		}
	}
}
