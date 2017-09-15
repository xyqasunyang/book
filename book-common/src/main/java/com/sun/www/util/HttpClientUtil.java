package com.sun.www.util;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * @author suny
 * @date 2017年6月19日 上午11:13:31
 * @version 1.0
 */
public class HttpClientUtil {

	/**
	 *
	 * @param url
	 * @param param
	 * @param charset 默认utf-8
	 * @return
	 */
	public static String sendPost(String url, HashMap<String, Object> param,String charset) {
		String responseMsg = "";

		// 1.构造HttpClient的实例
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset(charset==null?"UTF-8":charset);

		// 2.构造PostMethod的实例
		PostMethod postMethod = new PostMethod(url);
		// 3.把参数值放入到PostMethod对象中
		if (param != null) {
			for (String key : param.keySet()) {
				postMethod.addParameter(key, String.valueOf(param.get(key)));
			}
		}
		return getString(responseMsg, httpClient, postMethod);
	}

	/**
	 *
	 * @param url
	 * @param param
	 * @param charset 默认utf-8
	 * @return
	 */
	public static String sendGet(String url, HashMap<String, Object> param,String charset) {
		String responseMsg = "";

		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setContentCharset(charset==null?"UTF-8":charset);
		String str = "";
		if (param != null) {
			for (String key : param.keySet()) {
				if (str.equals("")) {
					str = "?" + str + key + "=" + param.get(key);
				} else {
					str = str + "&" + key + "=" + param.get(key);
				}
			}
		}
		GetMethod getMethod = new GetMethod(url + str);
		return getString(responseMsg, httpClient, getMethod);
	}

	private static String getString(String responseMsg, HttpClient httpClient, HttpMethod httpMethod) {
		try {
			httpMethod.setRequestHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");

			httpClient.executeMethod(httpMethod);// 200
			responseMsg = httpMethod.getResponseBodyAsString().trim();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 7.释放连接
			httpMethod.releaseConnection();
		}
		return responseMsg;
	}

}
