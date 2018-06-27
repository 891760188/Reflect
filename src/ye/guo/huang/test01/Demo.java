package ye.guo.huang.test01;

public class Demo<T> {
	private T t;
	
	public Demo(T t){
		this.t = t ;
	}
	/**
	 * 
	 */
	public void echo(){
		System.out.println(t.getClass().getName());
	}
}
