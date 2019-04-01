package com.example.counter.controllers;

public class Counter {

	private Long number = 0L;

	
	
	public Counter() {
	}

	public Counter(long number) {
		this.number = number;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Counter [number=" + number + "]";
	}
	
	
	
	
	
}
