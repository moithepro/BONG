package BONG;

import javax.swing.JFrame;

public class CustomFrame extends JFrame {

	private static final long serialVersionUID = -5763319334266549575L;

	public CustomFrame() {
		initLayout();
	}

	private void initLayout() {
		add(new CustomPanel());
		setTitle(Constants.TITLE);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
