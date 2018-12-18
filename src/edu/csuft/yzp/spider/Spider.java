package edu.csuft.yzp.spider;
/**
 * 抓取页面一影片信息的爬虫（任务）
 * @author Genius尹泽平
 *
 */

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider implements Runnable{

	/**
	 * 页面的路径（url）
	 */
	String url ="";
	
	/**
	 * 存储抓取的数据
	 */
	ArrayList<Film> list;
	
	/**
	 * 创建爬虫
	 * @param url 页面的路径
	 * @param list 存储数据的列表
	 */
	public Spider(String url, ArrayList<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		//获得执行该任务的线程的名称
		String name = Thread.currentThread().getName();
		System.out.println(name +"线程.完成: " + url);
		
		//jsoup
		try {
			Document doc = Jsoup.connect(url).get();
			
			//从文档中查找结点
			Elements es = doc.select(".grid_view .item");
			//便利元素列表
			
			for(Element e: es)
			{
				Film f = new Film();
				
				//每一部影片
				f.id=Integer.parseInt(e.select(".pic em").first().text());
				f.poster=e.select("img").first().attr("src");
				f.info=e.select(".bd p").first().text();
				f.title=e.select(".title").first().text();
				f.rating =Double.parseDouble(e.select(".star .rating_num").first().text());
				String num=e.select(".star span").last().text();
				f.num=Integer.parseInt(num.substring(0, num.length() - 3)); //数值参数不用引号
				f.quote=e.select(".quote span").text();
				System.out.println(name + ":" + f);
				list.add(f);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
