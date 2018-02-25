package com.my.movie.omProtal.util;

import java.util.List;

import com.my.omCollect.util.JsoupUtil;

/**
 * 类型转换工具类
 * @author ST
 *
 */
public class TypeConUtil {
	//判断字符串是否是数字，存在漏洞，如：001234
	public static Boolean StringJudge(String string) {
		boolean result = string.matches("[0-9]+");
		return result;
	}
	
}
