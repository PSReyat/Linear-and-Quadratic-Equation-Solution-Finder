package appactionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import equationcalculatorlogic.AppLogic;

public class SolveActionListener implements ActionListener{

	private JTextField a;
	private JTextField b;
	private JTextField c;
	private JTextField answer;
	private boolean isSqrtPossible;
	private AppLogic logic;
	
	public SolveActionListener(JTextField a, JTextField b, JTextField c, JTextField answer) {
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.answer = answer;
		
	}
	
	public void linearSolution() {
		
		double linearB = Double.parseDouble(this.b.getText());
		double linearC = Double.parseDouble(this.c.getText());
		
		this.logic = new AppLogic(linearB, linearC);
		this.logic.setLinearSolution();
		
	}
	
	public void quadraticSolution() {
		
		double quadA = Double.parseDouble(this.a.getText());
		double quadB = Double.parseDouble(this.b.getText());
		double quadC = Double.parseDouble(this.c.getText());
		
		this.logic = new AppLogic(quadA, quadB, quadC);
		
		this.isSqrtPossible = this.logic.isSqrtPossible();
		this.logic.setFirstSolution();
		this.logic.setSecondSolution();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean empty = this.a.getText().equals("0");
		
		if(empty) {
			
			linearSolution();
			
		}else {
			
			if(!this.a.getText().isEmpty()) {
				
				quadraticSolution();
				
			}
			
		}
		
		if(this.isSqrtPossible == true || empty) {
			
			this.answer.setText(this.logic.toString());
			
		}else {
			
			this.answer.setText("Error.");
			
		}
		
	}

}
