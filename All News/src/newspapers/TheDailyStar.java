package newspapers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Element;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TheDailyStar extends Newspaper {

	@Override
	protected List<Headline> getHeadlines(String baseUrl) {
		List<Headline> headlines = new ArrayList<Headline>();

		Document document = connectToTheWebpage(baseUrl);

		Elements elements = document.select("body a");

		for (org.jsoup.nodes.Element element : elements) {
			if (element.attr("href").startsWith(baseUrl + "/")) {
				Headline headline = new Headline(element.text(),
						element.attr("href"));
				headlines.add(headline);
			}
		}
		return headlines;
	}

	@Override
	protected String getNews(Headline headline) {
		Document document = connectToTheWebpage(headline.getUrl());
		return document.getElementById("content").text().toString();
	}

	@Override
	public List<Headline> getAllSportsHeadLines() {

		return getHeadlines("http://www.thedailystar.net/sports");
	}

	@Override
	public List<Headline> getALLPoliticalHeadlines() {
		return getHeadlines("http://bd.thedailystar.net/country");
	}

	@Override
	public List<Headline> getALLEntertainmentHeadlines() {
		return getHeadlines("http://www.thedailystar.net/entertainment");
	}

	@Override
	public List<Headline> getALLBusinessHeadlines() {
		return getHeadlines("http://www.thedailystar.net/business");
	}


}
