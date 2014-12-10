package com.homework.entity;

public class FunctionInfo {
	private String name;
	private int referencedbyCount;
	private int referenceCount;

	public FunctionInfo(String name, int referenceCount, int referencedbyCount) {
		this.name = name;
		this.referencedbyCount = referencedbyCount;
		this.referenceCount = referenceCount;
	}

	public String getName() {
		return this.name;
	}

	public int getReferencedbyCount() {
		return this.referencedbyCount;
	}

	public int getReferenceCount() {
		return this.referenceCount;
	}
}
