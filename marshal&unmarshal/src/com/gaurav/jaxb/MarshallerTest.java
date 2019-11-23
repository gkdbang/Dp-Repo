package com.gaurav.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallerTest {

	public static void main(String[] args) {
		// Converting from java to xml
		Employee employee=new Employee();
		employee.setEmpNo(101);
		employee.setEmpName("Gaurav");
		employee.setEmpSalary(20000);
		employee.setEmpAddress("Bangalore");
		
		try{
			JAXBContext jaxbContext=JAXBContext.newInstance(Employee.class);
			Marshaller marshaller=jaxbContext.createMarshaller();
			marshaller.marshal(employee, new File("employee.xml"));
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		System.out.println("Marshalling Complited");
	}

}
