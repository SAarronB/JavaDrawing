package art.View;

import javax.swing.JFrame;
import art.Controller.ArtController;

public class ArtFrame extends JFrame{
	private ArtController app;
	
	public ArtFrame() {
		super();
		setupFrame();
		
	}
	
	private void setupFrame() {
		this.setVisible(true);
	}
}
