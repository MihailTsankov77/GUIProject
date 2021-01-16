package Library;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BooksPanel extends JPanel{
	
	public BooksPanel() {
		
		setBorder(BorderFactory.createTitledBorder("Butoni"));
		
		
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.insets = new Insets(10, 10, 10, 10);
	
		gc.anchor = GridBagConstraints.CENTER;

		
		int size = MainFrame.books.size();
		
		for(int y = 0; y <=MainFrame.books.size()/5 ; y+=1) {
			
			for(int x = 0; x <5 && size>0; x+=1) {
				
				gc.gridx = x;
				gc.gridy = y;
				
				add(this.createButton(MainFrame.books.get(MainFrame.books.size()-size)), gc);
				
				size--;
			}
			
			
		}
		
		
		
		
	}
	
	private JButton createButton(Book book) {
		
		JButton button = new JButton(book.getName());
		
		button.setPreferredSize(new Dimension(100, 100));;

		button.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				InfoBook.nameD.setText(book.getName());
				InfoBook.authorD.setText(book.getAuthor());
				InfoBook.ratingD.setText(String.valueOf(book.getRating()));
				InfoBook.summaryD.setText(book.getSummary());
				
				ToolBar.backToMain.show();
				ToolBar.addBookButton.hide();
				
				MainFrame.cl.show(MainFrame.mainPanel, "BookInfo");
				
			}	
				
				
		});
		return button;
	}
}
