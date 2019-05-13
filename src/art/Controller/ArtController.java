package art.Controller;

import java.io.IOException;

import javax.swing.JOptionPane;

public class ArtController
{
	public void start()
	{
		
	}

	public void handleErrors(Exception error)
	{
		JOptionPane.showMessageDialog(appGUI, "Error received:" + error.getMessage());
	}
}
