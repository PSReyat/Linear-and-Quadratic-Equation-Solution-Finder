package equationcalculatorui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

import appactionlisteners.SolveActionListener;
import appactionlisteners.ToggleListener;

public class AppUI implements Runnable{
	
	private JFrame uiFrame;
	
	//Toggles between solving linear equations and quadratic equations
	private JToggleButton toggleEquationOrder;
	
	// coefficient fields
	private JTextField a;
	private JTextField b;
	private JTextField c;
	
	// equals button
	private JButton solve;
	
	// read-only text field
	private JTextField answer;
	
	public AppUI() {}

	@Override
	public void run() {

		this.uiFrame = new JFrame("Linear and Quadratic Equation Calculator");
		this.uiFrame.setPreferredSize(new Dimension(600, 200));
		this.uiFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createComponents(this.uiFrame.getContentPane());
		this.uiFrame.pack();
		this.uiFrame.setVisible(true);
		
	}
	
	public void createComponents(Container container) {
		
		// Buttons and input fields.
		this.toggleEquationOrder = new JToggleButton("Solve linear equation", false);
		this.a = new JTextField();
		this.b = new JTextField();
		this.c = new JTextField();
		this.solve = new JButton("Solve");
		this.answer = new JTextField();
		
		// Action listeners
		SolveActionListener sal = new SolveActionListener(this.a, this.b, this.c, this.answer);
		this.solve.addActionListener(sal);
		ToggleListener toggle = new ToggleListener(this.a, this.toggleEquationOrder);
		this.toggleEquationOrder.addActionListener(toggle);
		
		// Labels to fill in algebraic terms for the polynomial
		JLabel xSquared = new JLabel("X^2");
		JLabel x = new JLabel("X");
		JLabel constant = new JLabel("Constant");
		JLabel equals = new JLabel("=");
		JLabel zero = new JLabel("0");
		
		// Setting layout of container
		GroupLayout layout = new GroupLayout(container);
		container.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
				
			layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(xSquared)
				.addComponent(this.a))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(this.toggleEquationOrder)
				.addComponent(x)
				.addComponent(this.b)
				.addComponent(this.solve)
				.addComponent(this.answer))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(constant)
				.addComponent(this.c))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(equals))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(zero))
				
		);
		
		layout.setVerticalGroup(
		
			layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(this.toggleEquationOrder))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(xSquared)
				.addComponent(x)
				.addComponent(constant))		
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(this.a)
				.addComponent(this.b)
				.addComponent(this.c)
				.addComponent(equals)
				.addComponent(zero))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(this.solve))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(this.answer))
			
		);
		
		
	}

}
