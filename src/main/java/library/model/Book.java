package library.model;

public class Book {

	private int id;
	private String name;
	private String genre;
	private String authorName;
	private String description;
	private int year;
	private String imgSource;
	
	
	public Book() {}
	public Book(int id, String name, String genre, String authorName,String description,int year,String imgSource) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.authorName = authorName;
		this.description = description;
		this.year = year;
		this.imgSource = imgSource;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImgSource() {
		return imgSource;
	}


	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}

	


	}
	