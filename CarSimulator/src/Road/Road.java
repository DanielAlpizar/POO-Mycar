package Road;

import java.io.File;
import java.util.*;

import Tools.FileManager;

/**
 * 
 */
public class Road {

	public ArrayList<Obstacle> itemsinroad = new ArrayList();

	public void chargeRoad(File archive) {
		String Textroad;
		FileManager read = new FileManager();
		Textroad = read.readText(archive);
		int indexletter = 0;
		RoadFactory factory = new RoadFactory();

		while (indexletter != Textroad.length()) {
			char letter = Textroad.charAt(indexletter);
			if (factory.getShape(Character.toString(letter)) != null) {
				itemsinroad.add(factory.getShape(Textroad));

			} else if (Character.toString(letter) == "m" || Character.toString(letter) == "M") {
				int interindex = 1;
				char inletter = Textroad.charAt(indexletter + interindex);
				String speed = "";

				while (Character.isDigit(inletter)) {
					speed += Character.toString(inletter);
					interindex++;
					inletter = Textroad.charAt(indexletter + interindex);
				}
				SpeedLimit speedlimit = (SpeedLimit) factory.getShape("S");
				if (Character.toString(letter) == "m") {
					int min = Integer.valueOf(speed);
					speedlimit.setMinimumSpeed(min);
					
					itemsinroad.add(speedlimit);
				}

				else if (Character.toString(letter) == "M") {
					int max = Integer.valueOf(speed);
					speedlimit.setMaximumSpeed(max);
					itemsinroad.add(speedlimit);
				}
				indexletter = +interindex;

			}

		}
		itemsinroad.add(factory.getShape("F"));

	}

	public ArrayList<Obstacle> getItemsinroad() {
		return itemsinroad;
	}

	public void repeatRoad() {
		itemsinroad.remove(itemsinroad.size());
		itemsinroad.addAll(itemsinroad);
		itemsinroad.add(new Final());
	}

}