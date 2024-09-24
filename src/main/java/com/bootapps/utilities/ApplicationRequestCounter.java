package com.bootapps.utilities;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="application",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ApplicationRequestCounter {
	
	private Integer Counter=0;

	public Integer getCounter() {
		return Counter;
	}

	public void setCounter() {
		Counter++;
	}
	
	

}
