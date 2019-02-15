package com.gfi.microservicios;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulCorsFilter extends ZuulFilter {

	public static Logger LOG = LoggerFactory.getLogger(ZuulCorsFilter.class);

	public String filterType() {
		return "route";
	}

	public int filterOrder() {
		return 0;
	}

	public boolean shouldFilter() {
		//RequestContext context = getCurrentContext();
		//LOG.debug(context.getRequest().getMethod());
		//return "OPTIONS".equals(context.getRequest().getMethod());
		return Boolean.TRUE;
	}

	public Object run() {
		RequestContext context = getCurrentContext();

		context.addZuulResponseHeader("Access-Control-Allow-Origin", "*");
		context.addZuulResponseHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		context.addZuulResponseHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Cache-Control");
		// context.setSendZuulResponse(false);
//		context.sendZuulResponse();

		if ("OPTIONS".equals(context.getRequest().getMethod())) {
			context.setRouteHost(null);
			context.setResponseStatusCode(200);
		}

		return null;
	}
}