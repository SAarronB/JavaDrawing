package art.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SpringLayout;

import art.View.ArtPanel;

public class DrawingPanel extends JPanel
{
	private ArtPanel app;
	private DrawingPanel canvas;
	private JPanel colorPanel;
	private JPanel menuPanel;
	private JScrollPane canvasPane;
	private SpringLayout appLayout;
	private JSlider widthSlider;
	private JButton redButton;
	private JButton blueButton;
	private JButton yellowButton;
	private JButton orangeButton;
	private JButton greenButton;
	private JButton violetButton;
	private JButton magentaButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton clearButton;


	private final int MINIMUM_LINE = 1;
	private final int MAXIMUM_LINE = 25;

	public DrawingPanel(ArtPanel app)
	{
		super();
		this.app = app;

		redButton = new JButton("Red");
		blueButton = new JButton("Blue");
		yellowButton = new JButton("Yellow");
		orangeButton = new JButton("Orange");
		greenButton = new JButton("Green");
		violetButton = new JButton("Violet");
		magentaButton = new JButton("Magenta");

		saveButton = new JButton("save panel");
		loadButton = new JButton("load new panel");
		clearButton = new JButton("clear panel");
		widthSlider = new JSlider(MINIMUM_LINE, MAXIMUM_LINE);
		colorPanel = new JPanel(new GridLayout(0, 1));
		menuPanel = new JPanel(new GridLayout(0, 1));

		canvasPane = new JScrollPane();
		
		setupMenuPanel();
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
		setupSlider();
	}

	private void setupSlider()
	{
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

	private void setupMenuPanel()
	{
		colorPanel.setPreferredSize(new Dimension(50, 700));
		menuPanel.setPreferredSize(new Dimension(50, 700));

		violetButton.setForeground(new Color(75, 0, 130));
		blueButton.setForeground(Color.BLUE);
		greenButton.setForeground(Color.GREEN);
		orangeButton.setForeground(Color.ORANGE);
		redButton.setForeground(Color.RED);
		yellowButton.setForeground(Color.YELLOW);

		colorPanel.add(redButton);
		colorPanel.add(blueButton);
		colorPanel.add(yellowButton);
		colorPanel.add(orangeButton);
		colorPanel.add(greenButton);
		colorPanel.add(violetButton);
		colorPanel.add(magentaButton);

		menuPanel.add(widthSlider);
		menuPanel.add(saveButton);
		menuPanel.add(loadButton);
		menuPanel.add(clearButton);
	}

	private void setupScrollPane()
	{
		canvasPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setViewportView(canvas);
	}

	private void setupPanel()
	{

	}

	private void setupLayout()
	{
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

	private void setupListeners()
	{
		canvas.addMouseListener(new MouseListener()
				{
					public void mouseClicked(MouseEvent e)
					{
						canvas.drawDot(e.getX(), e.getY(), widthSlider.getValue());
					}

					public void mousePressed(MouseEvent e)
					{
						
					}
					
					public void mouseReleased(MouseEvent e)
					{
						canvas.resetPoint();
					}
					
					public void mouseEntered(MouseEvent e)
					{
						canvas.resetPoint();
					}
					
					public void mouseExited(MouseEvent e)
					{
						canvas.resetPoint();
					}
					
				});
		
		canvasPane.addMouseMotionListener(new MouseMotionListener()
				{
				
				public void mouseDragged(MouseEvent e)
				{
				canvas.drawLine(e.getX(), e.getY(), widthSlider.getValue());
				}
				
				public void mouseMoved(MouseEvent e)
				{
					
				}
				
				});
		
		saveButton.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent click)
				{
					canvas.saveImage();
				}
				});
//		loadButton.addActionListener(new ActionListener();
//		{
			
//		}
	}
}

