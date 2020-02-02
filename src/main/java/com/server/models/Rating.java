package com.server.models;

import java.io.Serializable;

public class Rating implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Source;
	private String Value;
	
	public Rating(String source, String value) {
		super();
		Source = source;
		Value = value;
	}
	
	public String getSource() {
		return Source;
	}
	
	public void setSource(String source) {
		Source = source;
	}
	
	public String getValue() {
		return Value;
	}
	
	public void setValue(String value) {
		Value = value;
	}
}