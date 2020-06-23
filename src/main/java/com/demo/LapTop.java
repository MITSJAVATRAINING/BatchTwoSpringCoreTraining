package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class LapTop {

	HardDrive hardDrive;

	Processor processor;

//	public LapTop(@Autowired @Qualifier("dellHardDrive") HardDrive hardDrive,
//			@Autowired @Qualifier("intelProcessor") Processor processor) {
//		super();
//		this.hardDrive = hardDrive;
//		this.processor = processor;
//	}

	public HardDrive getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(HardDrive hardDrive) {
		this.hardDrive = hardDrive;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public void display() {
		System.out.println("Laptop Created with ");
		hardDrive.dispayHardDriveName();
		processor.displayProcessorName();
	}
}
