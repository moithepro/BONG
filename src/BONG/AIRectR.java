package BONG;
import java.awt.event.KeyEvent;

public class AIRectR extends PlayerRectR {
	private Ball ball;
	private int countTicks;

	public AIRectR(Ball ball) {
		super();
		this.ball = ball;
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void update() {

		if (Constants.isPositive(ball.getDx()) && countTicks >= Constants.AI_TICK_CYCLE_SPEED) {
			if (Constants.isBetween(ball.getY(), getY(), getY() + getHeight()))
				return;
			setDy(Constants.KEY_SPEED * Constants.getSign(ball.getY() - getY()));
			countTicks = 0;
		}else if(countTicks >= Constants.AI_TICK_CYCLE_SPEED){
			setStopMove();
		}
		countTicks++;
		super.update();
	}

}
