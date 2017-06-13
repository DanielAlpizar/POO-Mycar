package Road;

public class RoadFactory {
	public Obstacle getShape(String ObstacleType) {
		if (ObstacleType == null) {
			return null;
		}
		if (ObstacleType.equalsIgnoreCase("R")) {
			return new Rain();

		} else if (ObstacleType.equalsIgnoreCase(".")) {
			return new Street();

		} else if (ObstacleType.equalsIgnoreCase("T")) {
			return new Intersection();
			
		} else if (ObstacleType.equalsIgnoreCase("+")) {
			return new Cuatrosesquinas();
			
		} else if (ObstacleType.equalsIgnoreCase("D")) {
			return new Day(true, false);
		} else if (ObstacleType.equalsIgnoreCase("N")) {
			return new Day(false, true);
		} else if (ObstacleType.equalsIgnoreCase("F")) {
			return new Final();
		}else if (ObstacleType.equalsIgnoreCase("S")) {
			return new Final();
		}


		return null;
	}
}
