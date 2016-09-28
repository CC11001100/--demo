package org.cc.ems.utils;

/**
 * 字符串格式化类
 * @author CC11001100
 *
 */
public class StringFormat {

	/**
	 * 将n补齐为length
	 * @param n
	 * @param length
	 * @return
	 */
	public static String formatInt(int n,int length){
		return String.format("%0"+length+"d",n);
	}
	
}
