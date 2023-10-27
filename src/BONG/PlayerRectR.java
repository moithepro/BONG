package BONG;

import java.awt.event.KeyEvent;

public class PlayerRectR extends PlayerRectBase {

	public PlayerRectR() {
		init();
		setX(Constants.BOARD_WIDTH - Constants.PLAYER_RECT_WIDTH * 2);
		setY(Constants.BOARD_HEIGHT - (Constants.BOARD_HEIGHT / 2) - (Constants.PLAYER_RECT_HEIGHT / 2));
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			upKeyPressed = true;
		}
		if (key == KeyEvent.VK_DOWN) {
			downKeyPressed = true;
		}
		keyChanged();
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			upKeyPressed = false;
		}

		if (key == KeyEvent.VK_DOWN) {
			downKeyPressed = false;
		}
		keyChanged();
	}

	

	

	@Override
	public void update() {
		move();
	}
}
