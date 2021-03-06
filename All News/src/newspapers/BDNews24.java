package newspapers;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BDNews24 extends Newspaper{

	@Override
	protected List<Headline> getHeadlines(String baseUrl) {
		List<Headline> headlines = new ArrayList<Headline>();

		Document document = connectToTheWebpage(baseUrl);

		Elements elements = document.select("body a");

		for (org.jsoup.nodes.Element element : elements) {
			if (element.attr("href").startsWith(baseUrl) && !element.attr("href").equals(baseUrl)) {
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
		
		return document.getElementsByClass("print-only").text();
	}

	@Override
	public List<Headline> getAllSportsHeadLines() {
		return getHeadlines("http://bdnews24.com/sport/");
	}

	

	@Override
	public List<Headline> getALLPoliticalHeadlines() {
		return getHeadlines("http://bdnews24.com/politics/");
	}


	@Override
	public List<Headline> getALLEntertainmentHeadlines() {
		return getHeadlines("http://bdnews24.com/entertainment/");
	}


	@Override
	public List<Headline> getALLBusinessHeadlines() {
		// TODO Auto-generated method stub
		return getHeadlines("http://bdnews24.com/business/");
	}


}
