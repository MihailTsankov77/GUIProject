package Library;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class AddBook extends JPanel{

	JLabel name = new JLabel("Name: ");
	JTextField nameD = new JTextField();
	JLabel author = new JLabel("Author: ");
	JTextField authorD = new JTextField();
	JLabel rating = new JLabel("Rating: ");
	JNumberTextField ratingD = new JNumberTextField();
	JLabel summary = new JLabel("Saummay: ");
	JTextArea summaryD = new JTextArea();
	JButton add = new JButton("Add");
		
	public AddBook() {
		
//		nameD.setColumns(10);
//		authorD.setColumns(10);
		
		ratingD.setFormat(JNumberTextField.DECIMAL);
		ratingD.setMaxLength(2);
		ratingD.setPrecision(1);
		ratingD.setAllowNegative(false);		
	
		
		setBorder(BorderFactory.createTitledBorder("Add"));

		

		this.setLayout(new MigLayout());

		add(name, "left, sg 1, split2");
		add(nameD, "pushx, growx, wrap");
		add(author, "left, sg 1, split2");
		add(authorD, "pushx, growx, wrap");
		add(rating, "left, sg 1, split2");
		add(ratingD, "pushx, growx, wrap");
		add(summary, "top, split2");
		add(new JScrollPane(summaryD), "top, push, grow, wrap");
		
		add(add, "span2, pushx, growx, wrap");
		
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				boolean add = true;
				
				
				if(nameD.getText().equals("")) {
					nameD.setBackground(Color.RED);
					nameD.setForeground(Color.WHITE);
					add=false;
				}
				
				if(authorD.getText().equals("")) {
					authorD.setBackground(Color.RED);
					authorD.setForeground(Color.WHITE);
					add=false;
				}

				if(ratingD.getText().equals("") || Double.parseDouble(ratingD.getText())<0 || Double.parseDouble(ratingD.getText())>10) {
					
						ratingD.setBackground(Color.RED);
						ratingD.setForeground(Color.WHITE);
						ratingD.setText("");
						add=false;
					
				}
				
				if(summaryD.getText().equals("")) {
					summaryD.setBackground(Color.RED);
					summaryD.setForeground(Color.WHITE);
					add=false;
				}
				
				
				if(add) {
					Book book = new Book(nameD.getText(), authorD.getText(), Double.parseDouble(ratingD.getText()) , summaryD.getText());
					
					MainFrame.addBookInFile(book);
					MainFrame.cl.show(MainFrame.mainPanel, "Main");
				}
			}		
		});
	
	}
}
