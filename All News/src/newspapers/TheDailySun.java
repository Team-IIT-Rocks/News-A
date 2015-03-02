package newspapers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TheDailySun extends Newspaper{

	List<String> ignoredList = new ArrayList<String>();
	@Override
	public List<Headline> getAllSportsHeadLines() {
		return getHeadlines("http://www.daily-sun.com/online/sports");
	}

	@Override
	public List<Headline> getALLPoliticalHeadlines() {
		return getHeadlines("http://www.daily-sun.com/online/politics");
	}

	@Override
	public List<Headline> getALLEntertainmentHeadlines() {
		return getHeadlines("http://www.daily-sun.com/online/entertainment");
	}

	@Override
	public List<Headline> getALLBusinessHeadlines() {
		return getHeadlines("http://www.daily-sun.com/online/business");
	}

	@Override
	protected List<Headline> getHeadlines(String baseUrl) {
		List<Headline> headlines = new ArrayList<Headline>();
		
		Document document = connectToTheWebpage(baseUrl);
		Elements elements = document.getElementsByAttributeValue("class", "col-lg-8 col-xs-8").select("a");
		
		for (Element element : elements) {
			Headline headline = new Headline(element.text(), element.attr("href"));
			headlines.add(headline);
		}
		Set<Headline> headLineSet = new HashSet<Headline>(headlines);
		
		headlines = new ArrayList<Headline>();
		headlines.addAll(headLineSet);
		
		return headlines;
	}

	@Override
	protected String getNews(Headline headline) {
		Document document = connectToTheWebpage(headline.getUrl());
		try {
			String paragraph = document.getElementById("myText").text();
			return paragraph;
		} catch (Exception e) {
			return "This page contains no description.";
		}
		
	}

}
