package equationcalculatormain;

import javax.swing.SwingUtilities;

import equationcalculatorui.AppUI;

public class AppMain {

	public static void main(String[] args) {
		
		AppUI ui = new AppUI();
		SwingUtilities.invokeLater(ui);

	}

}
