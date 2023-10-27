package BONG;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameComponent {
	private Color color;
	private int x;
	private int y;
	private int width;
	private int height;
	private int dx;
	private int dy;
	
	public int getWidth() {
		return width;
	}

	public abstract void paintComponent(Graphics g);

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public abstract void update();

	public abstract void move();

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public Rectangle getDBounds() {
		return new Rectangle(x + dx, y + dy, width, height);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
