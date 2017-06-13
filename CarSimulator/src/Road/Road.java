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
		while (indexletter != Textroad.length()) {
			char letter = Textroad.charAt(indexletter);
			if (Character.toString(letter) == ".") {
				itemsinroad.add(new Street());
			} else if (Character.toString(letter) == "T") {
				itemsinroad.add(new Intersection());
			} else if (Character.toString(letter) == "+") {
				itemsinroad.add(new Cuatrosesquinas());
			} else if (Character.toString(letter) == "D") {
				itemsinroad.add(new Day(true, false));
			} else if (Character.toString(letter) == "N") {
				itemsinroad.add(new Day(false, true));

			} else if (Character.toString(letter) == "R") {
				itemsinroad.add(new Rain());

			} else if (Character.toString(letter) == "m") {
				int interindex = 1;
				char inletter = Textroad.charAt(indexletter + interindex);
				String minimun = "";

				while (Character.isDigit(inletter)) {
					minimun += Character.toString(inletter);
					interindex++;
					inletter = Textroad.charAt(indexletter + interindex);
				}
				int min = Integer.valueOf(minimun);
				itemsinroad.add(new SpeedLimit(min, 0));

				indexletter = +interindex;

			} else if (Character.toString(letter) == "M") {
				int interindex = 1;
				char inletter = Textroad.charAt(indexletter + interindex);
				String maxim = "";

				while (Character.isDigit(inletter)) {
					maxim += Character.toString(inletter);
					interindex++;
					inletter = Textroad.charAt(indexletter + interindex);
				}
				int max = Integer.valueOf(maxim);
				itemsinroad.add(new SpeedLimit(0, max));
			}
			indexletter++;
		}
		itemsinroad.add(new Final());
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