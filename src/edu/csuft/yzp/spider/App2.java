package edu.csuft.yzp.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * qq空间
 * @author Genius尹泽平
 *
 */
public class App2 {
	
	
	public static void main(String[] args) {
		String url ="https://read.douban.com/ebooks/?dcs=book-nav&dcm=douban";
		try {
			Document d = Jsoup.connect(url).get();
			Elements mo = d.select(".main .bd li");
			System.out.println(mo.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
