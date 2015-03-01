package newspapers;

import java.io.ObjectInputStream.GetField;
import java.util.List;

public class Main {
  
	public static void main(String[] args) {
		INewspaper newspaper=new BDNews24();
		newspaperTest(newspaper);
		/*INewspaper newspaper=new TheDailyStar();
		List<Headline>headlines =newspaper.getAllSportsHeadLines();
		//System.out.println(newspaper.getSportsNews(headlines.get(1)));
		
		headlines=newspaper.getALLBusinessHeadlines();
		System.out.println(newspaper.getBusinessNews(headlines.get(0)));
		
		headlines=newspaper.getALLEntertainmentHeadlines();
		System.out.println(newspaper.getEntertainmentNews(headlines.get(0)));
		*//*
		headlines=newspaper.getALLPoliticalHeadlines();
		System.out.println(newspaper.getPoliticalNews(headlines.get(0)));
	   */
	}

	private static void newspaperTest(INewspaper newspaper) {
		List<Headline>headlines=newspaper.getAllSportsHeadLines();
		/*for (Headline headline : headlines) {
			System.out.println(headline.getHeading()+" "+headline.getUrl());
		}*/
		System.out.println(newspaper.getSportsNews(headlines.get(0)));
		
		headlines =newspaper.getALLBusinessHeadlines();
		System.out.println(newspaper.getBusinessNews(headlines.get(0)));
		
		headlines=newspaper.getALLEntertainmentHeadlines();
		System.out.println(newspaper.getEntertainmentNews(headlines.get(0)));
		
		headlines=newspaper.getALLPoliticalHeadlines();
		System.out.println(newspaper.getPoliticalNews(headlines.get(0)));
	}
	
	
}
