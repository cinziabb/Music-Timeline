package pojo;

/**
 * This class maps the chart genre.
 * 
 * @author Marcello Giovannini
 *
 */

public class Genre {

	private String nameGenre; //primary key in DB
	private String description; //optional
	
	/* CONSTRUCTORS */
	public Genre() {
	}
	public Genre(String nameGenre, String description) {
		this.nameGenre = nameGenre;
		this.description = description;
	}
	
	/* GETTERS AND SETTERS */
	public String getNameGenre() {
		return nameGenre;
	}
	public void setNameGenre(String nameGenre) {
		this.nameGenre = nameGenre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* OTHER METHODS */
	@Override
	public String toString() {
		return getClass().getName() + 
				"[nameGenre=" + nameGenre + 
				", description=" + description + "]";
	}
	
	
}
