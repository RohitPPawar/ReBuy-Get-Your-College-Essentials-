package com.rebuy.exception;

public class ResourseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String resourceName;
//	String filedName;
	long fieldId;

	public ResourseNotFoundException(String resourceName, long fieldId) {
		super(String.format("%s not found with Id : %l", resourceName, fieldId));
		this.resourceName = resourceName;
		this.fieldId = fieldId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public long getFieldId() {
		return fieldId;
	}

	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}
}
