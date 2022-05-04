public class MyThread extends Thread
{
	private int iterator=10; 
	public MyThread() {
		
	}
	public MyThread(String name,int iterat){
		super(name);
		this.iterator =iterat;
		
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
			System.out.println(super.getName()+"--->"+"(iterator: "+i);
			try {
				//sleep(1000);
				if (i==5) {
					throw new RuntimeException();
				}
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
