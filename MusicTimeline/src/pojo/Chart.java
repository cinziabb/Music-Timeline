package pojo;

/**
 * This class maps the chart table.
 * 
 * @author Marcello Giovannini
 *
 */

public class Chart {

	private Integer idChart; //autoincrement and primary key in DB
	private String nameChart;
	private String link; //optional
	
	/* CONSTRUCTORS */
	public Chart() {
	}
	public Chart(String nameChart, String link) {
		this.nameChart = nameChart;
		this.link = link;
	}
	public Chart(Integer idChart, String nameChart, String link) {
		this.idChart = idChart;
		this.nameChart = nameChart;
		this.link = link;
	}
	
	/* GETTERS AND SETTERS */
	public Integer getIdChart() {
		return idChart;
	}
	public void setIdChart(Integer idChart) {
		this.idChart = idChart;
	}
	public String getNameChart() {
		return nameChart;
	}
	public void setNameChart(String nameChart) {
		this.nameChart = nameChart;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	/* OTHER METHODS */
	@Override
	public String toString() {
		return getClass().getName() + 
				"[idChart=" + idChart + 
				", nameChart=" + nameChart + 
				", link=" + link + "]";
	}
	
	
}
