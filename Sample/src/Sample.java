import java.util.HashMap;
import java.util.List;

public class Sample {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Sysout 
		String str = "10";
	
		String[] name = {"zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
		Integer[] value= {0,1,2,3,4,5,6,7,8,9};
		String[] call = {"Thousands","Hundreds","Tens","RS"};
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		
		int length = str.length();
		int call_length =call.length;
		
		String result = "";
		String sub = "";
		StringBuilder builder = new StringBuilder();
		int j=call_length-str.length();
		for(int i=0;i<=length-1;i++) {
			
			char cha = str.charAt(i);
			String c = map.get(Integer.parseInt(Character.toString(cha)));
			
			
		
		//	for(int j=str.length();j<=call.length-1;j++) {
				 sub = call[i+j];
			
		//	}
			builder.append(c).append("  ").append(sub).append("  ");
		}
		System.out.println(builder);
		
		//for()
	}

}
