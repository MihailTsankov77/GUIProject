package Library;

import java.awt.Color;
import java.awt.Font;
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

public class AddBookPanel extends JPanel{

	JLabel name = new JLabel("Name: ");
	static JTextField nameD = new JTextField();
	
	JLabel author = new JLabel("Author: ");
	static JTextField authorD = new JTextField();
	
	JLabel rating = new JLabel("Rating: ");
	static JNumberTextField ratingD = new JNumberTextField();
	
	JLabel summary = new JLabel("Saummay: ");
	static JTextArea summaryD = new JTextArea();
	
	JButton add = new JButton("Add");
		
	public AddBookPanel() {
		
		setBorder(BorderFactory.createTitledBorder("Add Book"));
		
		ratingD.setFormat(JNumberTextField.DECIMAL);
		ratingD.setMaxLength(2);
		ratingD.setPrecision(1);
		ratingD.setAllowNegative(false);
		
		
		name.setFont(Main.font);
		nameD.setFont(Main.font);
		author.setFont(Main.font);
		authorD.setFont(Main.font);
		rating.setFont(Main.font);
		ratingD.setFont(Main.font);
		summary.setFont(Main.font);
		summaryD.setFont(Main.font);
		add.setFont(Main.font);
		

		this.setLayout(new MigLayout());

		add(name, "left, sg 1, split2");
		add(nameD, "pushx, growx, wmax 500, wrap");
		add(author, "left, sg 1, split2");
		add(authorD, "pushx, growx, wmax 500, wrap");
		add(rating, "left, sg 1, split2");
		add(ratingD, "pushx, growx, wmax 500, wrap");
		add(summary, "top, split2");
		add(new JScrollPane(summaryD), "top, push, grow, wmax 500, hmax 500, wrap");
		
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
					
					BooksPanel.createButtonForNewBook(book);
					Main.addBookInFile(book);
					
					ToolBar.addBookButton.show();
					ToolBar.backToMain.hide();
					returnToNormal();
					
					Main.cl.show(Main.mainPanel, "Main");
				}
			}		
		});
	}
	
	public static void returnToNormal() {
		
		nameD.setBackground(Color.WHITE);
		nameD.setForeground(Color.BLACK);
		nameD.setText("");
		
		authorD.setBackground(Color.WHITE);
		authorD.setForeground(Color.BLACK);
		authorD.setText("");
		
		ratingD.setBackground(Color.WHITE);
		ratingD.setForeground(Color.BLACK);
		ratingD.setText("");
		
		summaryD.setBackground(Color.WHITE);
		summaryD.setForeground(Color.BLACK);
		summaryD.setText("");		
	}
	
}
