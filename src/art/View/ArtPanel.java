package art.View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import art.Controller.ArtController;

public class ArtPanel extends JPanel
{
	private ArtPanel app;
	private Color currentColor;
	private BufferedImage currentCanvas;
	private int previousX;
	private int previousY;

	public ArtPanel(ArtPanel app)
	{
		super();
		this.app = app;
		this.currentCanvas = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
		setupPanel();
		resetPoint();
	}

	public void resetPoint()
	{
		previousX = Integer.MIN_VALUE;
		previousY = Integer.MIN_VALUE;
	}

	public void setupPanel()
	{
		this.setPreferredSize(new Dimension(700, 700));
		this.setBackground(Color.MAGENTA);
		this.currentColor = Color.GREEN;
	}

	@Override
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(currentCanvas, 0, 0, null);
	}

	private Color randomColor()
	{
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		int alpha = (int) (Math.random() * 256);

		Color randomColor = new Color(red, green, blue, alpha);
		return randomColor;
	}

	public void setCurrentColor(String color)
	{
		if (color.equalsIgnoreCase("Red"))
		{
			currentColor = Color.RED;
		}
		else if (color.equalsIgnoreCase("blue"))
		{
			currentColor = Color.BLUE;
		}
		else if (color.equalsIgnoreCase("yellow"))
		{
			currentColor = Color.YELLOW;
		}
		else if (color.equalsIgnoreCase("Orange"))
		{
			currentColor = Color.ORANGE;
		}
		else if (color.equalsIgnoreCase("green"))
		{
			currentColor = Color.GREEN;
		}
		else if (color.equalsIgnoreCase("violet"))
		{
			currentColor = new Color(75, 0, 130);
		}
		else if (color.equalsIgnoreCase("magenta"))
		{
			currentColor = Color.MAGENTA;
		}
		else
		{
			currentColor = randomColor();
		}
	}

	public void drawDot(int currentX, int currentY, int width)
	{
		Graphics2D current = currentCanvas.createGraphics();
		current.setColor(currentColor);
		current.setStroke(new BasicStroke(width));
		current.drawOval(currentX, currentY, width, width);
		repaint();
	}
	
	public void drawLine(int currentX, int currentY, int width)
	{
		Graphics2D current = currentCanvas.createGraphics();
		current.setColor(currentColor);
		current.setStroke(new BasicStroke(width));
		if (previousX ==  Integer.MIN_VALUE)
		{
			current.drawLine(currentX, currentY, currentX, currentY);
		}
		else
		{
			current.drawLine(previousX, previousY, currentX, currentY);
		}
		previousX = currentX;
		previousY = currentY;
		repaint();
	}
	
	public void saveImage()
	{
		try
		{
			JFileChooser saveDialog = new JFileChooser();
			saveDialog.showSaveDialog(this);
			String savePath = saveDialog.getSelectedFile().getPath();
			if (!savePath.endsWith(".png"))
			{
				savePath += ".png";
			}
			ImageIO.write(currentCanvas, "PNG", new File(savePath));
		}
		catch (IOException error)
		{
			app.handleErrors(error);
		}
		catch (NullPointerException badChoice)
		{
			app.handleErrors(badChoice);
		}
	}
	
	public void loadImage()
	{
		try
		{
			JFileChooser imageChooser = new JFileChooser();
			imageChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileFilter imageFilter = new FileNameExtensionFilter("Image files only", ImageIO.getReaderFileSuffixes());
			imageChooser.setFileFilter(imageFilter);
			
			int result = imageChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION)
			{
				File resultingFile  = imageChooser.getSelectedFile();
				BufferedImage newCanvas = ImageIO.read(resultingFile);
				currentCanvas = newCanvas;
				this.setPreferredSize(new Dimension(currentCanvas.getWidth(),  currentCanvas.getHeight()));
			}
			repaint();
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
	}
}

