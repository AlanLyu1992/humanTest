package org.struts.action;

import java.util.HashMap;
import java.util.Map;

public class Action {
	private String uriPattern;
	private String className;
	private String methodName;
	private Map<String, String> results 
		= new HashMap<String, String>();
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Map<String, String> getResults() {
		return results;
	}
	public void setResults(Map<String, String> results) {
		this.results = results;
	}
	public String getUriPattern() {
		return uriPattern;
	}
	public void setUriPattern(String uriPattern) {
		this.uriPattern = uriPattern;
	}
	
	
}
