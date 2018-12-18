package edu.csuft.yzp.spider;
/**
 * 影片
 * @author Genius尹泽平
 *
 */

public class Film {
	
	/**
	 * 排名
	 */
	
	int id;
	
	/**
	 * 影片名字
	 */
	
	String title;
	
	/**
	 * 相关信息
	 */
	
	String info;
	
	/**
	 * 评分
	 */
	
	double rating;
	
	/**
	 * 评分人数
	 */
	
	int num;
	
	/**
	 * 海报
	 */
	
	String poster;
	
	/**
	 * 短评
	 */
	
	String quote;

	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", quote=" + quote + "]";
	}
	
	
	
	

}
