
public class Thread_01 {

	public static void main(String[] args) {
				MyThread process_01 = new MyThread();
				MyThread process_02 = new MyThread("A",20);
				Thread process_03 = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
							for(int i=0 ;i<15 ; i++) {
							System.out.println("B"+"--->"+"(iterator: "+i);
						}
						
					}
				});
				Thread process_04 = new Thread(process_02) ;
				
				
				System.out.println("Name:"+process_01.getName()+" state: "+process_01.getState());
				System.out.println("Name:"+process_02.getName()+" state: "+process_02.getState());
				System.out.println("Name:"+process_03.getName()+" state: "+process_03.getState());
				System.out.println("Name:"+process_04.getName()+" state: "+process_04.getState());
				
				process_01.start();
				process_02.start();
				process_03.start();
				process_04.start();
				
		}


}
