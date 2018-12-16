package edu.csuft.yzp.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 程序的入口
 * 
 * @author Genius尹泽平
 *
 */
public class App {
	
	//alt + / 
	
	public static void main(String[] args) {
		
		//目标：URL
		String url="https://movie.douban.com/top250";
		
		//使用JSOUP抓取文档
		try {
			Document doc = Jsoup.connect(url).get();
			
			Elements es = doc.select(".grid_view .item");
			//查找类需要在前面加一个.  类后面的需要一个空格表示范围
			System.out.println(es.size());
			
			//创建一个影片的列表
			ArrayList<Film> list = new ArrayList<>();
			
			for(Element e: es)
			{
				Film f = new Film();
				
				//每一部影片
				Element t = e.select(".title").first();
				String num = e.select(".star span").last().text();
				System.out.println(t.text() + "  " + num.replace("人评价", ""));
				
//				f.id
//				f.title
				list.add(f);
				
				
			}
			
//			String title =doc.title();
//			String data = doc.data();
//			
//			
//			System.out.println(title);
//			System.out.println(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
