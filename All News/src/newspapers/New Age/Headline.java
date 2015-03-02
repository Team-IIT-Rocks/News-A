package newspapers;

public class Headline {

	public Headline(String heading, String url) {
		Heading = heading;
		Url = url;
	}

	public String getHeading() {
		return Heading;
	}

	public String getUrl() {
		return Url;
	}

	public String Heading;
	private String Url;
}
