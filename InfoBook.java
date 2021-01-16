package Library;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoBook extends JPanel {
	
	JLabel name = new JLabel("Name: ");
	static public JLabel nameD = new JLabel("None");
	JLabel author = new JLabel("Author: ");
	static public JLabel authorD = new JLabel("None");
	JLabel rating = new JLabel("Rating: ");
	static public JLabel ratingD = new JLabel("None");
	JLabel summary = new JLabel("Saummay: ");
	static public JLabel summaryD = new JLabel("None");
		
		
	public InfoBook() {
		
		setBorder(BorderFactory.createTitledBorder("Info"));
		
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
		add(summaryD, gc);
	
}
	
}
