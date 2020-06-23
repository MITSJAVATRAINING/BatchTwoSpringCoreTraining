package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class IntelProcessor implements Processor {
	public void displayProcessorName() {
		System.out.println("We are intel processor");
	}
}
