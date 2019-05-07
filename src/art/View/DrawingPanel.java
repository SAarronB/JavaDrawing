package art.View;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import art.Controller.ArtController;

public class DrawingPanel extends JPanel{
	private ArtController app;
	private ArtPanel canvas;
	private JPanel colorPanel;
	private JButton loadButton;
	private JPanel menuPanel;
	private JScrollPane canvasPane;
	private SpringLayout appLayout;
	private JSlider widthSlider;
	private JButton redButton;
	private JButton saveButton;
	private JButton blueButton;
	private JButton orangeButton;
	private JButton yellowButton;
	private JButton greenButton;
	private JButton violetButton;
	private JButton magentaButton;
	private JButton clearButton;

	
	public DrawingPanel(ArtController app) {
		super();
		saveButton = new JButton("Save Panel");
		
		redButton = new JButton("Red");
		blueButton = new JButton("Blue");
		orangeButton = new JButton("orange");
		yellowButton = new JButton("Yellow");
		greenButton = new JButton("green");
		violetButton = new JButton("violet");
		magentaButton = new JButton("Magenta");
		clearButton = new JButton("Clear");
		menuPanel.add(widthSlider);
		menuPanel.add(loadButton);
		menuPanel.add(saveButton);
		
		
		setupScrollPane();
		setupMenuPanels();
		setupPanel();
		setupLayout();
		setupListeners();
		
		this.app = app;
	}
	
	private void setupScrollPane() {
		canvasPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setViewportView(canvas);
	}
	
	private void setupMenuPanels() {
		this.add(redButton);
		this.add(blueButton);
		this.add(orangeButton);d
		this.add(yellowButton);
		this.add(greenButton);
		this.add(violetButton);
		this.add(magentaButton);
		
		colorPanel.setPreferredSize(new Dimension(50,700));
		menuPanel.setPreferredSize(new Dimension(50,700));
		
	    violetButton.setForeground(new Color(75, 0, 130));
		blueButton.setForeground(Color.BLUE);;
		greenButton.setForeground(Color.GREEN);
		orangeButton.setForeground(Color.ORANGE);
	
	private void setupSlider() {
		Hashtable<Integer, JLabel> scaleLabels new Hashtable <Integer, JLabel>();
		scaleLabels.put(MAXIMUM_LINE, new JLabel("<HTML>Small<BR>Line</HTML>"));
		scaleLabels.put(MAXIMUM_LINE, new JLabel("<HTML>Large<BR>Line</HTML>"));
		widthSlider.setLabelTable(scaleLabelsj);
		widthSlider.setSnapToTicks(true);
		widthSlider.setMajorTickSpacing(5);
		widthSlider.setMinorTickSpacing(1);
		widthSlider.setPaintTicks(true);
		widthSlider.setPaintTicks(true);
		widthSlider.setValues((MAXIMUM_LINE + MINIMUM)/2);
	}
	
	private void  setupPanel() {
		
	}
	
	private void  setupLayout() {
		
	}
	
	private void  setupListeners() {
		canvas.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				
			}
			
			public void mouseReleased(MouseEvent e) {
				
			}
			
			public void Entered(MouseEvent e)
			
			public void Exited(MouseEvent e)
		}
	}
}
