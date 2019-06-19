package com.helpezee.microservices.EurekaServiceDiscovery;

import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class AppConfiguration {

	public AppConfiguration() {
	}

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl(false ,"/employees");
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}
}
