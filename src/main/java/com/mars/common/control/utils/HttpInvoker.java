package com.mars.common.control.utils;

import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mars.common.control.WexinControl;

public class HttpInvoker {
	public static final Logger logger = LoggerFactory.getLogger(WexinControl.class);
	public static String post(String targetURL) {
		HttpMethodBase method = null;
		try {
			HttpClient client = new HttpClient();
			method = new PostMethod(targetURL);

			byte[] array1 = getContent(client, method);
			String result = new String(array1, "UTF-8");
			return result;
		} catch (Exception e) {
			logger.error("post method error", e);
			return null;
		}finally{
			if(method != null){
				method.releaseConnection();
			}
		}

	}
	
	public static String get(String targetURL) {
		HttpMethodBase method = null;
		try {
			HttpClient client = new HttpClient();
			method = new GetMethod(targetURL);

			byte[] array1 = getContent(client, method);
			String result = new String(array1, "UTF-8");
			return result;
		} catch (Exception e) {
			logger.error("post method error", e);
			return null;
		}finally{
			if(method != null){
				method.releaseConnection();
			}
		}

	}
	
	private static byte[] getContent(HttpClient client, HttpMethodBase method)
			throws Exception {
		client.executeMethod(method);

		InputStream input = method.getResponseBodyAsStream();

		int length = input.available();
		byte[] array = new byte[length];
		input.read(array);

		input.close();
		return array;
	}
	
	public static void main(String[] args) {
		System.out.println(post("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxe2ddd86f6e5138f7&secret=79a7df5812628485e4b5454b9d751e2e"));
	}

}
