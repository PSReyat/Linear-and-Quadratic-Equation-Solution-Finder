package appactionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ToggleListener implements ActionListener{
	
	private JToggleButton toggle;
	private JTextField xSquared;
	
	public ToggleListener(JTextField xSquared, JToggleButton toggle) {
		
		this.xSquared = xSquared;
		this.toggle = toggle;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.xSquared.setText("0");
		this.xSquared.setEditable(!this.toggle.isSelected());
		
	}
	
	

}
