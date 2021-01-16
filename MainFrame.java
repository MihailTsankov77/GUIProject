package Library;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;


public class MainFrame {
	
	final static String fileName = "books.txt";
	final static String buffer = "-x-x-x-x-";
	
	
	static List<Book> books = new ArrayList<Book>();
	
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
	
	
	
	public static void addBookInFile(Book newBook) {
		File booksFile = new File(MainFrame.fileName);
		
	    try {
	      
	      Scanner myReader = new Scanner(booksFile);
	      String data = "";
	      
	      while (myReader.hasNextLine()) {
	        data += myReader.nextLine()  +"\n";
	      }
	      myReader.close();
	      
	      	PrintWriter prw = new PrintWriter(booksFile);
			prw.print(data);
			
			
			prw.println(newBook.getName());
			prw.println(newBook.getAuthor());
			prw.println(newBook.getRating());
			prw.println(newBook.getSummary());
			prw.println(buffer);
			
			prw.close();
	      
	    } catch (FileNotFoundException e) {
	      System.out.println("Error from adding a book!");
	      e.printStackTrace();
	    }
	    
	}
	
	
	public static void importBooks() {
		
		File booksFile = new File(MainFrame.fileName);
		
		String name = "";
		String author = "";
		int rating = -1;
		String summary = "";
		
		
	    try {
	      
	      Scanner myReader = new Scanner(booksFile);
	 
	      while (myReader.hasNextLine()){
	    	  
	    	  name = myReader.nextLine();
	    	  author = myReader.nextLine();
	    	  rating  = Integer.parseInt(myReader.nextLine());
	    	  
	    	  String data = myReader.nextLine();
	    	  while (!MainFrame.buffer.equals(data)){
	    		  summary+= data;
	    		  data = myReader.nextLine();
	    	  }
	    	 books.add(new Book(name, author, rating, summary));
	    	
	    	
	      }
		
	      
	    } catch (FileNotFoundException e) {
		      System.out.println("Error from importing a books!");
		      e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		importBooks();
		
		SwingUtilities.invokeLater( new Runnable() {
			@Override
			public void run(){
				new MainFrame();
			}
		});
	}
	
	

}
