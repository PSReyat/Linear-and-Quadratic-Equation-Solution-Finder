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
		
		double linearA = Double.parseDouble(this.a.getText());
		double linearB = Double.parseDouble(this.b.getText());
		double linearC = Double.parseDouble(this.c.getText());
		
		this.logic = new AppLogic(linearA, linearB, linearC);
		
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
			
			if(this.a.getText().isEmpty()) {
				
				
				
			}else {
				
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
