package BONG;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CustomPanel extends JPanel {
	private Timer timer;
	private static final long serialVersionUID = 660785896511271295L;
	private Color backgroundColor = new Color(20, 20, 20, 255);
	private PlayerRectL playerRectL;
	private PlayerRectR playerRectR;
	private Ball ball;
	private boolean inGame;
	private int delayCount;
	private boolean delayed;

	public CustomPanel() {
		initVars();
		initLayout();
	}

	public void initVars() {
		timer = new Timer(Constants.GAME_SPEED_TIME_MS, new Loop(this));
		ball = new Ball();
		playerRectL = new AIRectL(ball);
		playerRectR = new PlayerRectR();
		delayCount = 0;
		inGame = false;
		delayed = false;
		repaint();
	}

	private void initLayout() {
		addKeyListener(new KeyActions(this));
		setFocusable(true);
		setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
		setBackground(backgroundColor);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.paintComponent(g);
		playerRectL.paintComponent(g);
		playerRectR.paintComponent(g);
	}

	public void doOneLoop() {
		if (delayed) {
			if (delayCount < Constants.START_DELAY_TICK) {
				delayCount++;
				return;
			}
		}

		update();
		repaint();
	}

	private void update() {
		playerRectL.update();
		playerRectR.update();
		ball.update();
		checkColision();

	}

	public void checkColision() {
		PlayerRectBase racket = null;
		if (ball.getDBounds().intersects(playerRectL.getDBounds())) {
			ball.changeXDirectionRight();
			racket = playerRectL;
		} else if (ball.getDBounds().intersects(playerRectR.getDBounds())) {
			ball.changeXDirectionLeft();
			racket = playerRectR;
		}

		if (racket != null) {
			double factor = racket.getRelativeToYCenter(ball);
			ball.setNewDy(factor);
			if (Constants.randB() || ball.getDy() == 0) {
				ball.progressUp();
			}
		}

		if (ball.getY() + ball.getDy() < 0) {
			ball.changeYDirectionDown();
		} else if (ball.getY() + ball.getDy() + ball.getHeight() > Constants.BOARD_HEIGHT) {
			ball.changeYDirectionUp();
		}

		if (ball.getX() + ball.getDx() < 0 || ball.getX() + ball.getDx() + ball.getWidth() > Constants.BOARD_WIDTH) {
			stopGame();
			initVars();
		}
	}

	public Boolean isInGame() {
		return inGame;
	}

	public void stopGame() {
		timer.stop();
		inGame = false;
		repaint();
	}

	public void startGame() {
		timer.start();
		inGame = true;
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (inGame) {
				stopGame();
			} else {
				startGame();
			}
			return;
		}
		if (!inGame) {
			initVars();
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
				startGame();
				return;
			}
			if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
				playerRectR = new AIRectR(ball);
				playerRectL = new PlayerRectL();
				startGame();
				return;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				playerRectL = new PlayerRectL();
				delayed = true;
				startGame();
				return;
			}
			if (e.getKeyCode() == KeyEvent.VK_1) {
				playerRectR = new AIRectR(ball);
				startGame();
				return;
			}

		} else {
			playerRectL.keyPressed(e);
			playerRectR.keyPressed(e);
		}
	}

	public void keyReleased(KeyEvent e) {
		playerRectL.keyReleased(e);
		playerRectR.keyReleased(e);
	}

}
