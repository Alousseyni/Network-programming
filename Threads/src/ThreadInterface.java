
public class ThreadInterface implements Runnable
{
	private int iterator=10; 
	public ThreadInterface() {
		
	}
	
	public int getIterator() {
		return iterator;
	}
	public void setIterator(int iterator) {
		this.iterator = iterator;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0 ;i<this.iterator ; i++) {
			System.out.println("D"+"--->"+"(iterator: "+i);
		}
	}
}
