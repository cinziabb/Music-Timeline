package pojo;

public class Rating {
	
	//this two attributes coincide with the primary key of the rating table
	private Integer idUser;
	private Integer idSingle;
	
	/* CONSTRUCTORS */
	public Rating(Integer idUser, Integer idSingle) {
		this.idUser = idUser;
		this.idSingle = idSingle;
	}
	
	/* GETTERS AND SETTERS */
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getIdSingle() {
		return idSingle;
	}
	public void setIdSingle(Integer idSingle) {
		this.idSingle = idSingle;
	}
	
	/* OTHER METHODS */
	@Override
	public String toString() {
		return "Rating [idUser=" + idUser + ", idSingle=" + idSingle + "]";
	}
	
	

}
