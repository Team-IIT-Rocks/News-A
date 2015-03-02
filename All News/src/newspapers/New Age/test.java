package newspapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
	public static void main(String[] args) throws Exception{
		Document document=Jsoup.connect("http://newagebd.net/category/sport").get();
		String title=document.title();
		
		System.out.println("Title: "+title);
		Elements links = document.select("h2 a");  
		for (Element link : links) {  
		    System.out.println("\nlink : " + link.attr("href"));  
		    System.out.println("text : " + link.text());  
		} 
	}

}
