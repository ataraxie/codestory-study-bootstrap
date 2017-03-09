import java.util.Date;

public class JsonLog {

	private Date timestamp;
	private String message;

	public JsonLog(Date timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}
}
