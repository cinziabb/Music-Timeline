package pojo;

public class SingleList {

	private Integer idSingle;
	private String title; 
	private String info;
	private String name;
	private String image;
	private String uri;
	private String nameGenre;
	
	/* CONSTRUCTORS */
	public SingleList(Integer idSingle, String title, String info, String name, String image, String uri,
			String nameGenre) {
		this.idSingle = idSingle;
		this.title = title;
		this.info = info;
		this.name = name;
		this.image = image;
		this.uri = uri;
		this.nameGenre = nameGenre;
	}

	/* OTHER METHODS */
	@Override
	public String toString() {
		return getClass().getName() + 
				"[idSingle=" + idSingle + 
				", title=" + title + 
				", info=" + info + 
				", name=" + name
				+ ", image=" + image + 
				", uri=" + uri + 
				", nameGenre=" + nameGenre + "]";
	}
		
}
