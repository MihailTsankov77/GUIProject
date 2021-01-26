package Library;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
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


public class Main {
	
	
	final static Font font = new Font("Verdana", Font.PLAIN, 25);
	final static String fileName = "books.txt";
	final static String buffer = "-x-x-x-x-";
	final static CardLayout cl = new CardLayout();

	public static List<Book> books = new ArrayList<Book>();
	
	JFrame frame = new JFrame("Library");
	
	static JPanel mainPanel = new JPanel();
	public static JPanel booksPanel ;
	public static JPanel infoBook;
	public static JPanel addBook;
	
	public static JToolBar tlBar;
	
	
	public Main() {
		
		booksPanel = new BooksPanel();
		infoBook = new InfoBookPanel();
		addBook = new AddBookPanel();
		tlBar = new ToolBar();
		
		// CardLayout
		
		mainPanel.setLayout(cl);
		
		mainPanel.add(new JScrollPane(Main.booksPanel), "Main");
		mainPanel.add(infoBook, "BookInfo");
		mainPanel.add(addBook, "AddBook");
		
		cl.show(mainPanel, "Main");
		
		//frame
		
		frame.setLayout(new BorderLayout());
		frame.add(mainPanel, BorderLayout.CENTER);
		frame.add(tlBar, BorderLayout.NORTH);
		
		frame.setSize(700, 700);
//		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	
	public static void addBookInFile(Book newBook) {
		
		File booksFile = new File(Main.fileName);
		
	    try {
	      
			Scanner myReader = new Scanner(booksFile);
			String data = "";
			  
			while (myReader.hasNextLine()) 
				data += myReader.nextLine()  +"\n";
			  
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
		
		File booksFile = new File(Main.fileName);
		
		String name = "";
		String author = "";
		double rating = -1;
		String summary = "";
		
		
	    try {
	      
	      Scanner myReader = new Scanner(booksFile);
	 
	      while (myReader.hasNextLine()){
	    	  
	    	  name = myReader.nextLine();
	    	  author = myReader.nextLine();
	    	  rating  = Double.parseDouble(myReader.nextLine());
	    	  
	    	  String data = myReader.nextLine();
	    	  summary = "";
	    	  
	    	  while (!Main.buffer.equals(data)){
	    		  summary+= data + "\n";
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

		importBooks();
		
		SwingUtilities.invokeLater( new Runnable() {
			@Override
			public void run(){
				
				new Main();
			}
		});
	}

}
