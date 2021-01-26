package Library;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class BooksPanel extends JPanel{
	
	
	public BooksPanel() {
		
		setBorder(BorderFactory.createTitledBorder("Books"));
		
		// http://www.migcalendar.com/miglayout/mavensite/docs/cheatsheet.html
		setLayout(new MigLayout("", "[grow, fill, sg 1]20[grow, fill, sg 1]", "[grow, fill, sg 2]20[grow, fill, sg 2]"));  
		
		int size = Main.books.size();
		for(int y = 0; y <=Main.books.size()/5 ; y+=1) {
			for(int x = 0; x <5 && size>0; x+=1) {

				if(x==4) {
					add(createButton(Main.books.get(Main.books.size()-size)), "hmax 150, wrap");
				}else {
					add(createButton(Main.books.get(Main.books.size()-size)), "hmax 150");
				}
				
				size--;
			}
		}	
		
	}
	
	private static JButton createButton(Book book) {
		
		JButton button = new JButton(book.getName());
	
		button.setPreferredSize(new Dimension(0, 100));;	
		button.setBackground(new Color(254, 228, 64));
		button.setForeground(Color.BLACK);
		button.setFont(Main.font);
		
		button.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				InfoBookPanel.nameD.setText(book.getName());
				InfoBookPanel.authorD.setText(book.getAuthor());
				InfoBookPanel.ratingD.setText(String.valueOf(book.getRating()));
				InfoBookPanel.summaryD.setText(book.getSummary());
				
				ToolBar.backToMain.show();
				ToolBar.addBookButton.hide();
				
				Main.cl.show(Main.mainPanel, "BookInfo");
			}					
		});
		
		return button;
	}
	
	
	public static void createButtonForNewBook(Book book) {
		
		Main.books.add(book);
		
		if(Main.books.size()%5==0) {
			Main.booksPanel.add(createButton(Main.books.get(Main.books.size()-1)), "hmax 100, wrap");
		}else {
			Main.booksPanel.add(createButton(Main.books.get(Main.books.size()-1)), "hmax 100, wrap");
		}
	}
	
}
