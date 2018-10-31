package pojo;

/**
 * This class maps the position table.
 * 
 * @author Marcello Giovannini
 *
 */

public class Position {

	//this first two attributes coincide with the primary key of the position table
	private Integer idSingle; //foreign key references to single table
	private Integer idChart; //foreign key references to chart table
	private Integer num; //position number in the chart
	
	/* CONSTRUCTORS */
	public Position() {
	}
	public Position(Integer idSingle, Integer idChart, Integer num) {
		this.idSingle = idSingle;
		this.idChart = idChart;
		this.num = num;
	}
	
	/* GETTERS AND SETTERS */
	public Integer getIdSingle() {
		return idSingle;
	}
	public void setIdSingle(Integer idSingle) {
		this.idSingle = idSingle;
	}
	public Integer getIdChart() {
		return idChart;
	}
	public void setIdChart(Integer idChart) {
		this.idChart = idChart;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	/* OTHER METHODS */
	@Override
	public String toString() {
		return getClass().getName() + 
				"[idSingle=" + idSingle + 
				", idChart=" + idChart + 
				", num=" + num + "]";
	}
	
}
