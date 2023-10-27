package BONG;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameComponent {
	public Ball() {
		init();
	}

	public void move() {
		setY(getY() + getDy());
		setX(getX() + getDx());
	}

	private void init() {
		setColor(new Color(210, 210, 210, 255));
		setX(Constants.BOARD_WIDTH - (Constants.BOARD_WIDTH / 2) - (Constants.BALL_RECT_DIM / 2));
		setY(Constants.BOARD_HEIGHT - (Constants.BOARD_HEIGHT / 2) - (Constants.BALL_RECT_DIM / 2));
		setDx(Constants.BALL_X_SPEED * Constants.rand());
		setDy(Constants.rand(1, Constants.MAX_BALL_Y_SPEED) * Constants.rand());
		setWidth(Constants.BALL_RECT_DIM);
		setHeight(Constants.BALL_RECT_DIM);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	public void changeYDirectionDown() {
		if (Constants.isNegative(getDy())) {
			setDy(getDy() * -1);
		}
	}

	public void changeYDirectionUp() {
		if (Constants.isPositive(getDy())) {
			setDy(getDy() * -1);
		}
	}

	public void changeXDirectionRight() {
		if (Constants.isNegative(getDx())) {
			setDx(getDx() * -1);
		}
	}

	public void changeXDirectionLeft() {
		if (Constants.isPositive(getDx())) {
			setDx(getDx() * -1);
		}
	}

	public void progressUp() {
		if (Constants.isPositive(getDx()))
			setDx(getDx() + Constants.BALL_X_SPEED_PROGRESSION);
		if (Constants.isNegative(getDx()))
			setDx(getDx() - Constants.BALL_X_SPEED_PROGRESSION);
		if (Constants.isPositive(getDy()))
			setDy(getDy() + Constants.BALL_Y_SPEED_PROGRESSION);
		if (Constants.isNegative(getDy()))
			setDy(getDy() - Constants.BALL_Y_SPEED_PROGRESSION);
	}

	public void setNewDy(double factor) {
		setDy((int) (Constants.MAX_BALL_Y_INSERT * factor));
	}

	@Override
	public void update() {
		move();
	}

}
