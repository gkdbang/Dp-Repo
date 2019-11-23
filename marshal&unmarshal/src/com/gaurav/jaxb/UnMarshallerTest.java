package com.gaurav.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnMarshallerTest {

	public static void main(String[] args) throws JAXBException{
		
		// Converting from xml to java
		JAXBContext jaxbContext=JAXBContext.newInstance(Employee.class);
		Unmarshaller unMarshaller=jaxbContext.createUnmarshaller();
		Employee employee=(Employee) unMarshaller.unmarshal(new File("employee.xml"));
		System.out.println("Emp No : "+employee.getEmpNo()+", Emp Name : "+employee.getEmpName()+
		", Emp Salary : "+employee.getEmpSalary()+", Emp Address : "+employee.getEmpAddress());
		System.out.println("Unmarshalling Complited");
	}
}
