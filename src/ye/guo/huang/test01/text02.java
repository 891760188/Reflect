package ye.guo.huang.test01;

import java.util.ArrayList;
import java.util.List;

public class text02 {
	public static void main(String[] args)  {
		List<String> list = new ArrayList<String>();
		List<? extends String> list1 = new ArrayList<String>();
		
		Demo<String> demo = new Demo<String>("love you") ;
		demo.echo();
		new text02().init(list);
		new text02().init1(list);
		new text02().init2(list);
		
		List<String> aa = null;
	}
	
	public void init(List<?> list){
		
	}
	public void init1(List<? extends String> list){
		
	}
	public void init2(List<? super String> list){
		
	}

}
