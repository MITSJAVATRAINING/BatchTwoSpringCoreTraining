package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class DellHardDrive implements HardDrive{

	@Value("512")
	int size;
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}

	public void dispayHardDriveName() {
		System.out.println("We are Dell Harddrive with size "+ size);
	}
}
