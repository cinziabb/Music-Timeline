package pojo;

import java.sql.Timestamp;

/**
 * This class maps the single table.
 * 
 * @author Marcello Giovannini
 *
 */

public class Single {

	private Integer idSingle; //autoincrement and primary key in DB
	private String title; //title of the single
	private Integer year; //year of publication
	private String language; //language of the single
	private Timestamp insertDate; //current timestamp at the moment of the insertion into DB
	private String type; //original or remake
	private String cover; //link to the image cover - optional
	private Integer idArtist; //foreign key references to artist table
	
	/* CONSTRUCTORS */	
	public Single() {
	}
	public Single(String title, Integer year, String language, Timestamp insertDate, String type, String cover,
			Integer idArtist) {
		this.title = title;
		this.year = year;
		this.language = language;
		this.insertDate = insertDate;
		this.type = type;
		this.cover = cover;
		this.idArtist = idArtist;
	}
	public Single(Integer idSingle, String title, Integer year, String language, Timestamp insertDate, String type,
			String cover, Integer idArtist) {
		this.idSingle = idSingle;
		this.title = title;
		this.year = year;
		this.language = language;
		this.insertDate = insertDate;
		this.type = type;
		this.cover = cover;
		this.idArtist = idArtist;
	}
	
	/* GETTERS AND SETTERS */
	public Integer getIdSingle() {
		return idSingle;
	}
	public void setIdSingle(Integer idSingle) {
		this.idSingle = idSingle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Timestamp getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Integer getIdArtist() {
		return idArtist;
	}
	public void setIdArtist(Integer idArtist) {
		this.idArtist = idArtist;
	}
	
	/* OTHER METHODS */
	@Override
	public String toString() {
		return getClass().getName() + 
				"[idSingle=" + idSingle + 
				", title=" + title + 
				", year=" + year + 
				", language=" + language
				+ 
				", insertDate=" + insertDate + 
				", type=" + type + 
				", cover=" + cover + 
				", idArtist=" + idArtist + "]";
	}
	
}
