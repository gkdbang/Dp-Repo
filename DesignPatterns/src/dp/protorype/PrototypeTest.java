/**
 * 
 */
package dp.protorype;

import java.util.List;

/**
 * @author DhanunjayaY
 *
 */
public class PrototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Company com = new Company();
		List<String> employees = com.loadEmployees();
		
		Company com1 =  (Company) com.clone();
		List<String> clonedEmp = com1.getEmployees();
		System.out.println("cloned List before modification");
		System.out.println(clonedEmp);
		
		employees.remove(0);
		System.out.println("ModifiedList");
		System.out.println(employees);
		System.out.println("Cloned List");
		System.out.println(clonedEmp);
	}
}
