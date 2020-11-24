package appactionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import equationcalculatorlogic.AppLogic;

public class FactoriseActionListener implements ActionListener{

	private JTextField a;
	private JTextField b;
	private JTextField c;
	private JTextField answerBrackets;
	
	private AppLogic logic;
	
	public FactoriseActionListener(JTextField a, JTextField b, JTextField c, JTextField answerBrackets) {
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.answerBrackets = answerBrackets;
		
	}
	
	public void solutions() {
		
		double fa = Double.parseDouble(this.a.getText());
		double fb = Double.parseDouble(this.b.getText());
		double fc = Double.parseDouble(this.c.getText());
		
		this.logic = new AppLogic(fa, fb, fc);
		
		this.logic.setFirstSolution();
		this.logic.setSecondSolution();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		solutions();
		
		double firstSolution = (-1) * this.logic.getFirstSolution();
		double secondSolution = (-1) * this.logic.getSecondSolution();
		
		String first2DP = String.format("%.2f", firstSolution);
		String second2DP = String.format("%.2f", secondSolution);
		
		if(Double.parseDouble(this.a.getText()) != 0) {
			
			if(firstSolution > 0 && secondSolution > 0) {
				
				this.answerBrackets.setText("(x + " + first2DP + ")(x + " + second2DP + ")");
				
			}else if(firstSolution > 0 && secondSolution < 0) {
				
				this.answerBrackets.setText("(x + " + first2DP + ")(x " + second2DP + ")");
				
			}else if(firstSolution < 0 && secondSolution > 0) {
				
				this.answerBrackets.setText("(x " + first2DP + ")(x + " + second2DP + ")");
				
			}else {
				
				this.answerBrackets.setText("(x " + first2DP + ")(x " + second2DP+ ")");
				
			}
			
		}else {
			
			this.answerBrackets.setText("X^2 coefficient must be greater than 0.");
			
		}
		
	}

}
