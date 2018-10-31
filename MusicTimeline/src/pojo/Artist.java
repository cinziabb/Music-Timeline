package pojo;

/**
 * This class maps the artist table.
 * 
 * @author Marcello Giovannini
 *
 */

public class Artist {

	private Integer idArtist; //autoincrement and primary key in DB
	private String name; //artist name
	private String country; //optional in DB
	private String type; //solo or group
	private String image; //link to the artist image
	
	
	/* CONSTRUCTORS */
	public Artist() {
	}
	public Artist(String name, String country, String type, String image) {
		this.name = name;
		this.country = country;
		this.type = type;
		this.image = image;
	}
	public Artist(Integer idArtist, String name, String country, String type, String image) {
		this.idArtist = idArtist;
		this.name = name;
		this.country = country;
		this.type = type;
		this.image = image;
	}
		
	/* GETTERS AND SETTERS */
	public Integer getIdArtist() {
		return idArtist;
	}
	public void setIdArtist(Integer idArtist) {
		this.idArtist = idArtist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	/* OTHER METHODS */
	@Override
	public String toString() {
		return getClass().getName() + 
				"[idArtist=" + idArtist + 
				", name=" + name + 
				", country=" + country + 
				", type=" + type
				+ ", image=" + image + "]";
	}
	
}
