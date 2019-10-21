/**
 * 
 */
package dp.protorype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DhanunjayaY
 *
 */
public class Company implements Cloneable{
	
	private String companyName;
	private List<String> employees;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<String> getEmployees() {
		return employees;
	}
	
	
	public void setEmployees(List<String> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", employees="
				+ employees + "]";
	}
	
	public List<String> loadEmployees() {
		List<String> list = new ArrayList<String>();
		list.add("DY");
		list.add("Sheethal");
		list.add("Rahul");
		list.add("Sujatha");
		setEmployees(list);
		return list;
	}
	
	public Object clone() throws CloneNotSupportedException{
		/*List<String> list = new ArrayList<String>();
		for (String name : employees) {
			list.add(name);
		}
		Company com = new Company();
		com.setEmployees(list);
		return com; */
		return super.clone();
	}
	
}
