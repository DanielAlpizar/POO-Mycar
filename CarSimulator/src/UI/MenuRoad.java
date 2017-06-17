package UI;

import java.io.File;

import javax.swing.JFileChooser;

public class MenuRoad {
	
	
	public MenuRoad(Control.Control Control){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Track");
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			Control.start(file);
		}



	
	}


}
