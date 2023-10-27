package BONG;

import java.awt.*;

public abstract class PlayerRectBase extends GameComponent {
	protected boolean downKeyPressed;
	protected boolean upKeyPressed;

	public void init() {
		setColor(new Color(210, 210, 210, 255));
		upKeyPressed = false;
		downKeyPressed = false;
		setX(Constants.PLAYER_RECT_WIDTH);
		setWidth(Constants.PLAYER_RECT_WIDTH);
		setHeight(Constants.PLAYER_RECT_HEIGHT);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	public void move() {
		if (getY() + getDy() <= 0) {
			return;
		}
		if (getY() + getDy() + getHeight() >= Constants.BOARD_HEIGHT) {
			return;
		}
		setY(getY()+ getDy());
	}
	
	public void keyChanged() {
		if ((upKeyPressed && downKeyPressed) || (!upKeyPressed && !downKeyPressed)) {
			setStopMove();
			return;
		}
		if (upKeyPressed) {
			setMoveUp();
			return;
		}
		if (downKeyPressed) {
			setMoveDown();
			return;
		}
	}
	public void setMoveUp() {
		 setDy(-Constants.KEY_SPEED);
	}

	public void setMoveDown() {
		setDy(Constants.KEY_SPEED);
	}

	public void setStopMove() {
		setDy(0);
	}
	double getRelativeToYCenter(Ball ballarg) {
		Rectangle ball = ballarg.getDBounds();
		double ballYCenter = ball.y + ball.height / 2.0;
		double racketYCenter = getY() + getHeight() / 2.0;

		double diff = Math.abs(ballYCenter - racketYCenter);
		double maxIntersect = (getHeight() / 2.0) + ball.height;
		double percent = diff / maxIntersect;

		return ballYCenter - racketYCenter < 0 ? percent * -1 : percent;
	}
}
