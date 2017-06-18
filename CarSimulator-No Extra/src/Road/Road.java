package Road;

import java.io.File;
import java.util.*;

import Car.Obstacles;
import Tools.FileManager;

/**
 * 
 */
public class Road {

	private ArrayList<Obstacle> itemsinroad = new ArrayList();

	public void chargeRoad(File archive) {
		String Textroad;
		FileManager read = new FileManager();
		Textroad = read.readText(archive);
		int indexletter = 0;
		RoadFactory factory = new RoadFactory();

		while (indexletter != Textroad.length()) {
			char letter = Textroad.charAt(indexletter);
			if (factory.getPiece(Character.toString(letter)) != null) {
				Obstacle piece = factory.getPiece(Character.toString(letter));
				itemsinroad.add(piece);

			} 
			else if (Character.toString(letter).equals("m") || Character.toString(letter).equals("M")) {
				int interindex = 1;
				char inletter = Textroad.charAt(indexletter + interindex);
				String speed = "";

				while (Character.isDigit(inletter)&&Textroad.length()-1!=interindex){
					speed += Character.toString(inletter);
					interindex++;
					inletter = Textroad.charAt(indexletter + interindex);
				}
				//speed += Character.toString(inletter);

				SpeedLimit speedlimit = (SpeedLimit) factory.getPiece("S");
				if (Character.toString(letter).equals("m")) {
					int min = Integer.valueOf(speed);
					speedlimit.setMinimumSpeed(min);

					itemsinroad.add(speedlimit);
				}

				else if (Character.toString(letter).equals( "M")) {
					int max = Integer.valueOf(speed);
					speedlimit.setMaximumSpeed(max);
					itemsinroad.add(speedlimit);
				}
				indexletter = +interindex;

			}
			indexletter++;

		}
		itemsinroad.add(factory.getPiece("F"));

	}

	public ArrayList<Obstacle> getItemsinroad() {
		return itemsinroad;
	}

	public void repeatRoad() {
		itemsinroad.remove(itemsinroad.size() - 1);
		itemsinroad.addAll(itemsinroad);
		itemsinroad.add(new Final());
	}

}