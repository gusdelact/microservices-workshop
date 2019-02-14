package com.gfi.microservicios;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.util.StreamUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.springframework.stereotype.Component;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

/**
 * @author Spencer Gibb
 */
 @Component
public class ZuulCorsFilter extends ZuulFilter {
	public String filterType() {
		return "post";
	}

	public int filterOrder() {
		return 0;
	}

	public boolean shouldFilter() {
		RequestContext context = getCurrentContext();
		System.out.println( context.getRequest().getMethod() );
		return context.getRequest().getMethod() == "OPTIONS";
	}

	public Object run() {
		try {
			RequestContext context = getCurrentContext();
			System.out.println( context.getRequest().getMethod() );
			context.setResponseBody(" ");
		}
		catch (Exception e) {
			rethrowRuntimeException(e);
		}
		return null;
	}
}