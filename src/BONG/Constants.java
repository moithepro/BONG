package BONG;

public class Constants {
	private Constants() {
	}

	public static final String TITLE = "BONG";
	public static final int BOARD_WIDTH = 1600;
	public static final int BOARD_HEIGHT = 900;
	public static final String ICON_IMAGE_URL = "src/images/icon.png";
	public static final int PLAYER_RECT_WIDTH = 40;
	public static final int PLAYER_RECT_HEIGHT = 144;
	public static final int BALL_RECT_DIM = 20;
	public static final int GAME_SPEED_TIME_MS = 15;
	public static final int START_DELAY_TICK = 120;
	public static final int KEY_SPEED = 7;
	public static final int BALL_X_SPEED = 6;
	public static final int MAX_BALL_Y_SPEED = 7;
	public static final int MAX_BALL_Y_INSERT = 8;
	public static final int BALL_Y_SPEED_PROGRESSION = 1;
	public static final int BALL_X_SPEED_PROGRESSION = 1;
	public static final int AI_TICK_CYCLE_SPEED = 20;

	public static final int rand(int min, int max) {
		return (int) (Math.random() * (max - min) + min) + 1;
	}

	public static final int rand() {
		int[] n = { -1, 1 };
		return n[(int) (Math.random() * (2 - 0) + 0)];
	}

	public static final boolean randB() {
		return (int) (Math.random() * (2 - 0) + 0) == 1;
	}

	public static final boolean isPositive(int a) {
		return a > 0;
	}

	public static final boolean isNegative(int a) {
		return a < 0;
	}

	public static final int getSign(int a) {
		if (isPositive(a))
			return 1;
		if (isNegative(a))
			return -1;
		return 0;
	}

	public static final boolean isBetween(int x, int a, int b) {
		if (x > Math.min(a, b) && x < Math.max(a, b)) {
			return true;
		}
		return false;
	}
}
