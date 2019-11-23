package com.gaurav.jaxb;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallerTest2 {

	public static void main(String[] args)throws JAXBException {
		
		Employee employee=new Employee();
		employee.setEmpNo(101);
		employee.setEmpName("Gaurav");
		employee.setEmpSalary(20000);
		employee.setEmpAddress("Bangalore");
		
		JAXBContext jaxbContext=JAXBContext.newInstance(Employee.class);
		Marshaller marshaller=jaxbContext.createMarshaller();
		// xml data in String format
		StringWriter writer=new StringWriter();
		marshaller.marshal(employee, writer);
		String xml=writer.toString();
		System.out.println("Xml data in String format : "+xml);
	}

}
