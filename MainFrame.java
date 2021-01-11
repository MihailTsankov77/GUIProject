package Library;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;


public class MainFrame {

	
	//static List<Book> books;
	
	JFrame frame = new JFrame("Library");
	static JPanel mainPanel = new JPanel();
	JPanel booksPanel = new BooksPanel();
	JPanel infoBook = new InfoBook();
	JPanel addBook = new AddBook();
	JToolBar tlBar = new ToolBar();
	
	static CardLayout cl = new CardLayout();

	public MainFrame () {
		
		// CardLayout
		
		mainPanel.setLayout(cl);
		mainPanel.add(new JScrollPane(booksPanel), "Main");
		mainPanel.add(infoBook, "BookInfo");
		mainPanel.add(addBook, "AddBook");
		
		cl.show(mainPanel, "Main");
		
		
		//frame
		frame.setLayout(new BorderLayout());
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.add(tlBar, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		Dimension size = frame.getSize();
		frame.setSize(size.width+20, 750);
		frame.setVisible(true);
	}
	
	
	
//	public static void addBook() {
//		MainFrame.books.add(MainFrame.books.size(), new Book());
//	}
//	
//	public static void addBook(String name, String author, int rating, String summary) {
//		MainFrame.books.add(0, new Book(name, author, rating, summary));
//	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater( new Runnable() {
			@Override
			public void run(){
				new MainFrame();
			}
		});
	}
	
	

}
