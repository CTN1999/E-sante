package project.back.untils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author a459079
 * CHEIKH TIDIANE NDONGO - SAMBA DIARRA DIOUF - MAMADOU DIALLO
 */
public class Utilitaire {
	/**
	 * @param component
	 * Cette fonction configure le look and feel de l'application.
	 */
	public static void setLookAndFeel (Component component) { 
		try { 
		   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		   // force chaque composant de la fen�tre � appeler sa m�thode updateUI 
		   SwingUtilities.updateComponentTreeUI(component);
		} catch (InstantiationException | ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException e) {
			System.err.println("Error while setting Look and Feel");
		}
	}
	
	/**
	 * @param component
	 * @param dimension
	 * Cette fonction positionne le composant au centre de l'�cran.
	 */
	public static void center (Component component, Dimension dimension) {
		component.setSize(dimension);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = component.getSize();

		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;

		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;

		component.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}

	/**
	 * @param message
	 * @return
	 * Cette fonction affiche une boite de dalogue JOptionPane pour demander la confirmation d'une une action
	 */
	public static int showConfirmationMessage(String message) {
		int response = JOptionPane.showConfirmDialog ( null, message,
	             "Confirmation", JOptionPane.YES_NO_OPTION);

		return response;
	}
	
	/**
	 * @param errorMessage
	 * Cette fontion affiche un message d'erreur dans une bo�te de dialogue ...
	 */
	public static void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * @param message
	 * Cette fonction affiche un message de notification dans une bo�te de dialogue.
	 */
	public static void displayNotification(String message) {
		JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	public static boolean ConfirmMessage (String message) {
		if(JOptionPane.YES_OPTION == showConfirmationMessage(message)) {
			return true;
			
		}
		return false;
	}
	
	
	

	
}