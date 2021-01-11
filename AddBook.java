package Library;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddBook extends JPanel{

	JLabel name = new JLabel("Name: ");
	JTextField nameD = new JTextField();
	JLabel author = new JLabel("Author: ");
	JTextField authorD = new JTextField();
	JLabel rating = new JLabel("Rating: ");
	JTextField ratingD = new JTextField();
	JLabel summary = new JLabel("Saummay: ");
	JTextArea summaryD = new JTextArea();
	JButton add = new JButton("Add");
		
	public AddBook() {
		
		nameD.setColumns(10);
		authorD.setColumns(10);
		ratingD.setColumns(10);
		summaryD.setColumns(10);
		summaryD.setRows(5);
		
		setBorder(BorderFactory.createTitledBorder("Add"));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.insets = new Insets(10, 10, 10, 10);
	
		gc.anchor = GridBagConstraints.LINE_START;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(name, gc);
		gc.gridx = 1;
		add(nameD, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(author, gc);
		gc.gridx = 1;
		add(authorD, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(rating, gc);
		gc.gridx = 1;
		add(ratingD, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(summary, gc);
		gc.gridx = 1;
		add(new JScrollPane(summaryD), gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		gc.gridwidth = 2;
		add(add, gc);
	
	}
}
