package Lecture1;

public class lightQuestion {

	public static void main(String[] args) {

		int[] lights = { 43, 67, 26, 55, 18, 67 };

		int minTime = Integer.MAX_VALUE;
		for (int light : lights) {
			if (light < minTime) {
				minTime = light;
			}
		}

		int time = 2 * minTime;
		int increment = 0;
		do {
			time += increment;
			increment = allLightGreen(lights, time);
		} while (increment != 0);
		System.out.println(time);
	}

	public static int allLightGreen(int[] lights, int time) {
		int increment = 0;
		for (int i = 0; i < lights.length; i++) {
			int rem = time % (2 * lights[i]);
			if (rem >= lights[i] - 5) {
				int tempIncrement = 2 * lights[i] - rem;
				if (tempIncrement > increment) {
					increment = tempIncrement;
				}
			}
		}
		return increment;
	}
}
