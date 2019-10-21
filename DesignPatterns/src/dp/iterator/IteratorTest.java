/**
 * 
 */
package dp.iterator;

/**
 * @author DhanunjayaY
 *
 */
public class IteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection coll = new EmployeeCollection();
		EmployeeIterator iterator = coll.iterator();
		
		while(iterator.hasNext()){
			Object name = iterator.next();
			System.out.println((String)name);
		}
		System.out.println("--------------");
		while(iterator.hasPrevious()){
			Object name = iterator.previous();
			System.out.println((String)name);
		}
	}

}
