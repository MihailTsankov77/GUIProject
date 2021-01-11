package Library;

public class Book {
	
	private String Name = "NONE";
	private String Author = "NONE";
	private int Rating = -1 ;
	private String Summary = "NONE";
	
	public Book(){
	}
	
	public Book (String name, String author, int rating, String summary) {
		this.setAuthor(author);
		this.setName(name);
		this.setRating(rating);
		this.setSummary(summary);
	}

	public String getName() {
		return Name;
	}

	private void setName(String name) {
		Name = name;
	}

	public String getAuthor() {
		return Author;
	}

	private void setAuthor(String author) {
		Author = author;
	}

	public int getRating() {
		return Rating;
	}

	private void setRating(int rating) {
		Rating = rating;
	}

	public String getSummary() {
		return Summary;
	}

	private void setSummary(String summary) {
		Summary = summary;
	}
}
