package pojo;

/**
 * This class maps the remake table.
 * 
 * @author Marcello Giovannini
 *
 */

public class Remake {

	//this two attributes coincide with the primary key of the remake table
	private Integer idOriginalSingle; //foreign key references to single table
	private Integer idRemakeSingle; //foreign key references to single table
	
	/* CONSTRUCTORS */
	public Remake() {
	}
	public Remake(Integer idOriginalSingle, Integer idRemakeSingle) {
		this.idOriginalSingle = idOriginalSingle;
		this.idRemakeSingle = idRemakeSingle;
	}
	
	/* GETTERS AND SETTERS */
	public Integer getIdOriginalSingle() {
		return idOriginalSingle;
	}
	public void setIdOriginalSingle(Integer idOriginalSingle) {
		this.idOriginalSingle = idOriginalSingle;
	}
	public Integer getIdRemakeSingle() {
		return idRemakeSingle;
	}
	public void setIdRemakeSingle(Integer idRemakeSingle) {
		this.idRemakeSingle = idRemakeSingle;
	}
	
	/* OTHER METHODS */
	@Override
	public String toString() {
		return getClass().getName() + 
				"[idOriginalSingle=" + idOriginalSingle + 
				", idRemakeSingle=" + idRemakeSingle + "]";
	}
	
}
