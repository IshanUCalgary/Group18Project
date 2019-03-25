import org.lwjgl.Sys;

public class Time {
	
	
	public static float deltaTime = 0, multiplier = 1;
	public static long lastFrame, totalTime;
	
	
	
	// returns current time
	public static long getTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
	
	
	// returns the time between current time and the last update to the game
	public static float getDelta() {
		long currentTime = getTime();
		int delta = (int)(currentTime - lastFrame);
		lastFrame = getTime();
		return delta * (float)0.001;
	}
	
	
	public static float Delta() {
		return deltaTime * multiplier;
	}
	
	
	
	public static float getTotalTime() {
		return totalTime;
	}
	
	public static float getMultiplier() {
		return multiplier;
	}
	
	public static void Update() {
		deltaTime = getDelta();
		totalTime += deltaTime;
	}
	
	public static void setMultiplier(int change) {
		if (multiplier + change > -1 && multiplier + change < 7) {
			multiplier += change;
		} 
	}
	
}
