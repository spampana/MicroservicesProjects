package com.helpezee.microservices.ZuulAPIGateway.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class SimpleFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		System.out.println("run called");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println(
				"Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		System.out.println("Should Filter is invoked");
		return true;
	}

	@Override
	public int filterOrder() {
		System.out.println("Filter Order");
		return 0;
	}

	@Override
	public String filterType() {
		System.out.println("Filter type");
		return "pre";
	}

}
