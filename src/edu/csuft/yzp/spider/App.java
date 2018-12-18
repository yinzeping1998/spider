package edu.csuft.yzp.spider;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 程序的入口
 * 
 * @author Genius尹泽平
 *
 */
public class App {
	
	//alt + / 
	
	public static void main(String[] args) {
		
		
		/**
		 * 三种方法
		 */
		//线程池
		//固定大小
		ExecutorService pool = Executors.newFixedThreadPool(8);
		//无限缓存
		pool = 	Executors.newCachedThreadPool();
		//一个线程
	//	pool = Executors.newSingleThreadExecutor();
		ArrayList<Film> list =new ArrayList<>();
		String url = "https://movie.douban.com/top250?start=";
		for(int i=0;i<10;i++)
		{
			String path = String.format("%s%d",url,25*i );
			pool.submit(new Spider(path, list));
		}
		

	}
}
