package art.View;


import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;

import art.Controller.ArtController;

public class DrawingPanel extends JPanel{
	private ArtController app;
	private ArtPanel canvas;
	private Color currentColor;
	private JButton loadButton;
	private BufferedImage currentCanvas;
	private int previousX;
	private int previousY;
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
		this.app = app;
		this.currentCanvas = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
		setupPanel();
		resetPoint();
	}

	
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(Graphics graphics);
		graphics.drawImage(currentCanvas, 0, 0, null);
	}
	
	public void resetPoint() {
		previousX = Integer.MIN_VALUE;
		previousY = Integer.MIN_VALUE;
	}
	
	public void clearImage() {
		this.currentCanvas = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
		this.setBackground(randomColor());
		repaint();
	}
	
	public void loadImage() {
		try {
			JFileChooser imageChooser = new JFileChooser();
			imageChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileFilter imageFilter = new FileNameExtensionFilter("Image Files Only", ImageIO.getReaderFileSuffixes());
			imageChooser.setFileFilter(imageFilter);
			
			int result = imageChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION) {
				File resultingFile = imageChooser.getSelectedFile();
				BufferedImage newCanvas = ImageIO.read(resultingFile);
				currentCanvas = newCanvas;
				this.setPreferredSize(new Dimension(currentCanvas.getWidth(), currentCanvas.getHeight()));
			}
		}catch(IOException errors){
			app.handleErrors(errors);
		}
	}
	
	public void drawLine(int currentX, int currentY, int width) {
		Graphics2D current = currentCanvas.createGraphics();
		current.setColor(currentColor);
		current.setStroke(new BasicStroke(width));
		if(previousX == Integer.MIN_VALUE) {
			current.drawLine(currentX, currentY, currentX, currentY);
		}else {
			current.drawLine(previousX, previousY, currentX, currentY);
		}
		previousX = currentX;
		previousY = currentY;
		repaint();
	}
	
	public void drawDot(int currentX, int currentY, int width) {
		Graphics2D current = currentCanvas.createGraphics();
		current.setColor(currentColor);
		current.setStroke(new BasicStroke(width));
		current.drawOval(currentX, currentY, width, width);
		repaint();
	}
	
	public void saveImage() {
		try {
			JFileChooser saveDialog = new JFileChooser();
			saveDialog.showSaveDialog(this);
			String savePath = saveDialog.getSelectedFile().getPath();
			if(!savePath.endsWith(".png")){
				savePath += ".png";
			}
			ImageIO.write(currentCanvas, "PNG" , new File(savePath));
		}catch(IOException error){
			app.handleErrors(error);
		}catch(NullPointerException badChoice) {
			app.handleErrors(badChoice);
		}
	}
	
	private void randomColor() {
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		int alpha = (int)(Math.random() * 256);
	}

	private void setupScrollPane() {
		canvasPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setViewportView(canvas);
	}
	
	public void setCurrent Color (string color) {
		if(color.equalsIgnoreCase("Black")) {
			currentColor - Color.Black;
		}else if (color.equals("purple")) {
			currentColor = new Color(75, 0 , 130);
		}slse{
			currentColor = randomColor;
		}
	}
	
	private void setupMenuPanels() {
		colorPanel.setPreferredSize(new Dimension(50, 700));
		menuPanel.setPreferredSize(new Dimension(50,700));
				
		purpleButton.setForeground(new Color(75, 0, 130));
		blueButton.setForeground(Color.BLUE);
		greenButton.setForeground(Color.GREEN);
		orangeButton.setForeground(Color.ORANGE);
		redButton.setForeground(Color.RED);
		yellowButton.setForeground(Color.YELLOW);
				
		colorPanel.add(blackButton);
		colorPanel.add(purpleButton);
		colorPanel.add(blueButton);
		colorPanel.add(greenButton);
		colorPanel.add(yellowButton);
		colorPanel.add(orangeButton);
		colorPanel.add(redButton);
		colorPanel.add(whiteButton);
				
		menuPanel.add(widthSlider);
		menuPanel.add(loadButton);
		menuPanel.add(saveButton);
		menuPanel.add(clearButton);
	
	}
		
	private void setupSlider() {
		Hashtable<Integer, JLabel> scaleLabels = new Hashtable<Integer, JLabel>();
		scaleLabels.put(MINIMUM_LINE, new JLabel("<HTML>Small<BR>Line</HTML>"));
		scaleLabels.put(MAXIMUM_LINE, new JLabel("<HTML>Large<BR>Line</HTML>"));
		widthSlider.setLabelTable(scaleLabels);
		widthSlider.setSnapToTicks(true);
		widthSlider.setMajorTickSpacing(5);
		widthSlider.setMinorTickSpacing(1);
		widthSlider.setPaintTicks(true);
		widthSlider.setPaintLabels(true);
		widthSlider.setValue((MAXIMUM_LINE + MINIMUM_LINE) / 2);
	}
	
	private void  setupPanel() {
		
	}
	
	private void  setupLayout() {
		appLayout.putConstraint(SpringLayout.NORTH, colorPanel, 0, SpringLayout.NORTH, canvasPane);
		appLayout.putConstraint(SpringLayout.SOUTH, colorPanel, 0, SpringLayout.SOUTH, canvasPane);
		appLayout.putConstraint(SpringLayout.WEST, colorPanel, 50, SpringLayout.EAST, canvasPane);
		appLayout.putConstraint(SpringLayout.EAST, colorPanel, 0, SpringLayout.WEST, menuPanel);
				
		appLayout.putConstraint(SpringLayout.WEST, menuPanel, 200, SpringLayout.EAST, canvasPane);
		appLayout.putConstraint(SpringLayout.SOUTH, menuPanel, 0, SpringLayout.SOUTH, canvasPane);
		appLayout.putConstraint(SpringLayout.EAST, menuPanel, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, menuPanel, 0, SpringLayout.NORTH, canvasPane);
					
		appLayout.putConstraint(SpringLayout.NORTH, canvasPane, 25, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, canvasPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, canvasPane, -50, SpringLayout.SOUTH, this);
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
