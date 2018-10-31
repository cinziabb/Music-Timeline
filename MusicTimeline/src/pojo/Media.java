package pojo;

/**
 * This class maps the media table.
 * 
 * @author Marcello Giovannini
 *
 */

public class Media {

	private Integer idMedia; //autoincrement and primary key in DB
	private String type; //audio or video
	private String serviceSrc; //the default value is YouTube
	private String uri; //the URI of the media resource
	private Boolean validityCheck; //true if the resource is available, false otherwise
	private String quality; //the quality of the media resource - optional
	private String format; //the file format of the media resource  - optional
	private boolean live; //true if the media is live, false otherwise
	private Integer idSingle; //foreign key references to single table
	
	/* CONSTRUCTORS */	
	public Media() {
	}
	public Media(String type, String serviceSrc, String uri, Boolean validityCheck, String quality, String format,
			boolean live, Integer idSingle) {
		this.type = type;
		this.serviceSrc = serviceSrc;
		this.uri = uri;
		this.validityCheck = validityCheck;
		this.quality = quality;
		this.format = format;
		this.live = live;
		this.idSingle = idSingle;
	}
	public Media(Integer idMedia, String type, String serviceSrc, String uri, Boolean validityCheck, String quality,
			String format, boolean live, Integer idSingle) {
		this.idMedia = idMedia;
		this.type = type;
		this.serviceSrc = serviceSrc;
		this.uri = uri;
		this.validityCheck = validityCheck;
		this.quality = quality;
		this.format = format;
		this.live = live;
		this.idSingle = idSingle;
	}
	
	/* GETTERS AND SETTERS */
	public Integer getIdMedia() {
		return idMedia;
	}
	public void setIdMedia(Integer idMedia) {
		this.idMedia = idMedia;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getServiceSrc() {
		return serviceSrc;
	}
	public void setServiceSrc(String serviceSrc) {
		this.serviceSrc = serviceSrc;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Boolean getValidityCheck() {
		return validityCheck;
	}
	public void setValidityCheck(Boolean validityCheck) {
		this.validityCheck = validityCheck;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
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
		return getClass().getName() + 
				"[idMedia=" + idMedia + 
				", type=" + type + 
				", serviceSrc=" + serviceSrc + 
				", uri=" + uri + 
				", validityCheck=" + validityCheck + 
				", quality=" + quality + 
				", format=" + format + 
				", live=" + live
				+ ", idSingle=" + idSingle + "]";
	}
	
}
