package Library;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;


public class InfoBook extends JPanel {
	
	JLabel name = new JLabel("Name: ");
	static public JLabel nameD = new JLabel("None");
	JLabel author = new JLabel("Author: ");
	static public JLabel authorD = new JLabel("None");
	JLabel rating = new JLabel("Rating: ");
	static public JLabel ratingD = new JLabel("None");
	JLabel summary = new JLabel("Summary: ");
	static public JTextArea summaryD = new JTextArea("None");
		
		
	public InfoBook() {
		
		summaryD.setEditable(false);
		//summaryD.setColumns(20);
		summaryD.setRows(15);
		
		
		setBorder(BorderFactory.createTitledBorder("Info"));
		
		
		this.setLayout(new MigLayout());

		add(name, "split2");
		add(nameD, "wrap");
		add(author, "split2");
		add(authorD, "wrap");
		add(rating, "split2");
		add(ratingD, "wrap");
		add(summary, "top");
		add(new JScrollPane(summaryD), "top, push, grow");
}
	
}
