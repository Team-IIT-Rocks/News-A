package newspapers;

import java.io.ObjectInputStream.GetField;
import java.util.List;

public class Main {
  
	public static void main(String[] args) {
		newspaperTest(new NewAge());	
	}

	private static void newspaperTest(INewspaper newspaper) {
		List<Headline>headlines=newspaper.getAllSportsHeadLines();
		
		System.out.println(headlines.get(0).Heading);
		System.out.println(newspaper.getSportsNews(headlines.get(0)));
		System.out.println();
		
		headlines=newspaper.getALLPoliticalHeadlines();
		System.out.println(headlines.get(0).Heading);
		System.out.println(newspaper.getPoliticalNews(headlines.get(0)));	
		System.out.println();
		
		headlines=newspaper.getALLEntertainmentHeadlines();
		System.out.println(headlines.get(0).Heading);
		System.out.println(newspaper.getEntertainmentNews(headlines.get(0)));
		System.out.println();
		
		headlines=newspaper.getALLBusinessHeadlines();
		System.out.println(headlines.get(0).Heading);
		System.out.println(newspaper.getEntertainmentNews(headlines.get(0)));
	}
	
	
}
