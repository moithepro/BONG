package BONG;

import java.awt.event.KeyEvent;

public class PlayerRectL extends PlayerRectBase {

	public PlayerRectL() {
		init();
		 setX(Constants.PLAYER_RECT_WIDTH);
		setY(Constants.BOARD_HEIGHT - (Constants.BOARD_HEIGHT / 2) - (Constants.PLAYER_RECT_HEIGHT / 2));
	}

	

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			upKeyPressed = true;
		}
		if (key == KeyEvent.VK_S) {
			downKeyPressed = true;
		}
		keyChanged();
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_W) {
			upKeyPressed = false;
		}

		if (key == KeyEvent.VK_S) {
			downKeyPressed = false;
		}
		keyChanged();
	}



	

	public void update() {
		move();
	}
}
