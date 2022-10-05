

import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class CalculatorView extends JFrame{

	private JTextField firstNumber  = new JTextField(20);
	private JLabel additionLabel = new JLabel("+");
    private JTextField secondNumber = new JTextField(20);
	private JButton calculateButton = new JButton("Calculate (PES1UG19CS446)");
	private JTextField calcSolution = new JTextField(20);

   
	
	CalculatorView(){
		
		
		
		JPanel calcPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 500);
		
		calcPanel.add(firstNumber);
		calcPanel.add(additionLabel);
        calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		this.add(calcPanel);
		
		
	}
	
	public int getFirstNumber(){
		
		return Integer.parseInt(firstNumber.getText());
        
		
	}
	
	public int getSecondNumber(){
		
		return Integer.parseInt(secondNumber.getText());
		
	}
	
	public int getCalcSolution(){
		
		return Integer.parseInt(calcSolution.getText());
		
	}
	
	public void setCalcSolution(int solution){
		
		calcSolution.setText(Integer.toString(solution));
		
	}

	
	void addCalculateListener(ActionListener listenForCalcButton){
		
		calculateButton.addActionListener(listenForCalcButton);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
			PreparedStatement stmt = con.prepareStatement("insert into test values(?,?,?)");
			stmt.setInt(1,getFirstNumber());
			stmt.setInt(2,getSecondNumber());
			stmt.setInt(3,getCalcSolution());
			}
			catch (Exception e){
			System.out.println("Error");
			}
				
	}    
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
}