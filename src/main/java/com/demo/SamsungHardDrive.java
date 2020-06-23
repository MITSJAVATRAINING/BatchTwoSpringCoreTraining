package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class SamsungHardDrive implements HardDrive {

	@Value("1024")
	int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void dispayHardDriveName() {
		System.out.println("We are samsung Harddrive with size "+ size);
	}
}
