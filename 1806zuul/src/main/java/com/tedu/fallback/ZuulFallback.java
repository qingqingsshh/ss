package com.tedu.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component  //包扫描，这个既不是controller也不是service。用component，实际上 controller和service都是component包里的
public class ZuulFallback implements ZuulFallbackProvider{

	@Override  //获取路由，application.name
	public String getRoute() {
		
		return "provider-user";
	}

	@Override  //设置返回值，通常用json体现，utf-8格式，防止中文乱码
	public ClientHttpResponse fallbackResponse() {
		
		return new ClientHttpResponse() {
			
			@Override //请求响应头信息，contentType和字符类型
			public HttpHeaders getHeaders() {
				//返回类型为json，字符集为utf-8
				HttpHeaders headers=new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				
				return headers;
			}
			
			@Override  //响应体，具体返回内容
			public InputStream getBody() throws IOException {
			   String returnValue="tony8";
				return new ByteArrayInputStream(returnValue.getBytes());
			}
			
			@Override  //返回文字描述
			public String getStatusText() throws IOException {
				
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
			
			@Override  //返回状态码
			public HttpStatus getStatusCode() throws IOException {
				
				return HttpStatus.BAD_REQUEST;
			}
			
			@Override  //返回的二进制状态码
			public int getRawStatusCode() throws IOException {
				
				return HttpStatus.BAD_REQUEST.value();
			}
			
			@Override  //关闭释放资源
			public void close() {
				
				
			}
		};
	}

}
