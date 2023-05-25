import java.util.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Purchase implements ActionListener {
	JLabel phoneNumber = new JLabel("Enter the phone number");
	JTextField phoneField = new JTextField(20);
	JLabel customerID = new JLabel("Enter the customer ID");
	JButton done = new JButton("Enter here to check");
	JRadioButton discount = new JRadioButton("Click here for discount");
	JLabel itemid = new JLabel("Item : 1 Apple $10.23 per KG , 2 Orange $6 per KG");
	JLabel quantity = new JLabel("Enter the quantity purchased");
	JTextField quant = new JTextField(20);
	JLabel option = new JLabel("Enter the option number");
	JTextField optionno = new JTextField(20);
	JButton totalamt = new JButton("Click here to see bill");
	HashMap<String,String> custtoid = new HashMap<>();
	HashMap<Double,Double> item = new HashMap<>();
	Purchase(){
		String uname = JOptionPane.showInputDialog(null , "Enter the username");
		String pname = JOptionPane.showInputDialog(null, "Enter the password");
		if(uname.equals("msrit123") && pname.equals("ise123")) {
			JFrame f= new JFrame();
			f.setSize(20,20);
			f.setLayout(new FlowLayout());
			f.setVisible(true);
			f.add(phoneNumber);
			f.add(phoneField);
			f.add(done);
			done.addActionListener(this);
			f.add(discount);
			f.add(itemid);
			f.add(quantity);
			f.add(quant);
			f.add(option);
			f.add(optionno);
			f.add(totalamt);
			totalamt.addActionListener(this);
		}
		else {
			JOptionPane.showMessageDialog(null, "Incorrect Password");
		}
		
	}

	public static void main(String args[]) {
		Purchase customer = new Purchase();
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==done) {
			String p1 = phoneField.getText();
			if(custtoid.containsKey(p1)) {
				JOptionPane.showMessageDialog(null, "Customer Already Registered with 124");
			}
			else {
				custtoid.put(p1,"124");
				JOptionPane.showMessageDialog(null, "Customer Registered with 124");
			}
		}
		else {
		    int choice = Integer.parseInt(optionno.getText());
		    double amt =1;
		    if(choice==1) {
		        amt =  Double.parseDouble(quant.getText());
		        amt = 10.23*amt;
		    }
		    else {
		        amt =  Double.parseDouble(quant.getText());
		        amt = 6*amt;
		    }
		    if(discount.isSelected()) {
		        amt = amt-(amt*0.3);
		    }
		    String totalAmount = "Total amount is "+amt;
		    JOptionPane.showMessageDialog(null, totalAmount);
		}

		
	}
	
}
