package art.View;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import art.Controller.ArtController;

public class DrawingPanel extends JPanel{
	private ArtController app;
	
	private JButton redButton;
	private JButton blueButton;
	private JButton orangeButton;
	private JButton yellowButton;
	private JButton greenButton;
	private JButton violetButton;
	private JButton magentaButton;
	
	public DrawingPanel(ArtController app) {
		super();
		redButton = new JButton("Red");
		blueButton = new JButton("Blue");
		orangeButton = new JButton("orange");
		yellowButton = new JButton("Yellow");
		greenButton = new JButton("green");
		violetButton = new JButton("violet");
		magentaButton = new JButton("Magenta");
		
		setupScrollPane();
		setupMenuPanels();
		setupPanel();
		setupLayout();
		setupListeners();
		
		this.app = app;
	}
	
	private void setupScrollPane() {
		
	}
	
	private void setupMenuPanels() {
		this.add(redButton);
		this.add(blueButton);
		this.add(orangeButton);
		this.add(yellowButton);
		this.add(greenButton);
		this.add(violetButton);
		this.add(magentaButton);
	}
	
	private void  setupPanel() {
		
	}
	
	private void  setupLayout() {
		
	}
	
	private void  setupListeners() {
		
	}
}
