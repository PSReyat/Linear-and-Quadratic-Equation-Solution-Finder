package appactionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ToggleListener implements ActionListener{
	
	private JToggleButton toggle;
	private JTextField xSquared;
	private JButton factorise;
	private JTextField answerBrackets;
	
	public ToggleListener(JTextField xSquared, JToggleButton toggle, JButton factorise, JTextField answerBrackets) {
		
		this.xSquared = xSquared;
		this.toggle = toggle;
		this.factorise = factorise;
		this.answerBrackets = answerBrackets;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.xSquared.setText("0");
		this.xSquared.setEditable(!this.toggle.isSelected());
		this.factorise.setEnabled(!this.toggle.isSelected());
		this.answerBrackets.setEnabled(!this.toggle.isSelected());
		
	}
	
	

}
