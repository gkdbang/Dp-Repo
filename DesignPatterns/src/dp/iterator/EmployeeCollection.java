/**
 * 
 */
package dp.iterator;

/**
 * @author DhanunjayaY
 *
 */
public class EmployeeCollection implements Collection {

	private String[] names = {"DY", "Sheethal","Sujatha","Rohit"};
	/* (non-Javadoc)
	 * @see dp.iterator.Collection#iterator()
	 */
	@Override
	public EmployeeIterator iterator() {
		// TODO Auto-generated method stub
		return new EmployeeIteratorImpl();
	}
	
	private class EmployeeIteratorImpl implements EmployeeIterator{

		private int index = 0;
		private int reverseIndex = names.length - 1;
		@Override
		public boolean hasNext() {
			if(index < names.length){
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			 
			return names[index++];
		}

		@Override
		public boolean hasPrevious() {
			if(reverseIndex >= 0){
				return true;
			}
			return false;
		}

		@Override
		public Object previous() {
			// TODO Auto-generated method stub
			return names[reverseIndex--];
		}
		
	}

}
