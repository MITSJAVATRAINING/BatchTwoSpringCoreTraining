package com.demo;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
    //	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
//    	LapTop t1 = (LapTop) context.getBean("laptop");
    	// LapTop t1 = new LapTop();

    	//LapTop t2 = context.getBean(LapTop.class);
    	
    	//Processor p1 = (Processor) context.getBean("processor");
    	//HardDrive h1 = (HardDrive) context.getBean("hardDrive");
    	
//    	Processor p2 = context.getBean(SnapDragonProcessor.class);
//    	HardDrive h2 = context.getBean(SamsungHardDrive.class);
    	
//    	t2.setHardDrive(h2);
//    	t2.setProcessor(p2);
    	
//    	t1.display();
    	
    //	DataSource ds = (DataSource)context.getBean("datasource");
    	
 //   	JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemplate");
    	EmployeeOperation e1 = (EmployeeOperation) context.getBean("employeeOperation");
    	e1.modify();
    }
}
