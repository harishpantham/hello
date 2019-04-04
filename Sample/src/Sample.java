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
=====================Service Impl================
	
	public class ServiceImpl {
	
public String getObject(String actualObject,String convertToObject) {
		
		
		String filePath = "D:/Workspace/TodayOffers/src/main/java/com/today/offers/dto/ProductDTO.java";
		String finalString = "";
		String methodName="";
		try {
			//private Product getProduct(ProductDTO productDTO, Product product) {
			Scanner scanner = new Scanner(new File(filePath));
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(line.contains("return")) {
					String str = line.replace("return ", "").trim();
					String arr[] = str.split(";");
					String sactualObject = actualObject.substring(0,1).toLowerCase()+actualObject.substring(1);
					String sconvertToObject = convertToObject.substring(0,1).toLowerCase()+convertToObject.substring(1);
					 methodName ="        private "+actualObject+" get"+actualObject+"("+actualObject+" "+sactualObject+", "+convertToObject+" "+sconvertToObject+") {";
					
					for(String word: arr) {
						String variable =  word.substring(0,1).toUpperCase()+ word.substring(1);
						String str1 = "        if(!StringUtils.isEmpty("+sconvertToObject+".get"+variable+"())) {\n        "+sactualObject+".set"+variable+"("+sconvertToObject+".get"+variable+"());"+"\n"+"        }\n";
						 finalString = finalString+str1+"\n";
					
						}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return methodName+"\n"+finalString;
		
	}

		public static void main(String args[]) {
			String response = "OffersResponse";
			String sresponse = "offersResponse";
			String entity = "Product";
			String sentity = "product";
			
			ServiceImpl impl = new ServiceImpl();
			
			System.out.println(
					"@Service\r\n"+
					"public class "+entity+"ServiceImpl implements "+entity+"ServiceI{\r\n" + 
					"	\r\n" + 
					"	@Autowired\r\n" + 
					"	"+entity+"Repository "+sentity+"Repository;\r\n" + 
					"	\r\n" + 
					"	@Autowired\r\n" + 
					"	Messages messageService;\r\n" + 
					"\r\n" + 
					"	@Override\r\n" + 
					"	public "+response+" getAll"+entity+"s() {\r\n" + 
					"\r\n" + 
					"		List<"+entity+"> "+sentity+"List = "+sentity+"Repository.findAll();\r\n" + 
					"		"+response+" "+sresponse+" = new "+response+"();\r\n" + 
					"		if(!StringUtils.isEmpty("+sentity+"List)) {\r\n" + 
					"			List<"+entity+"DTO> "+sentity+"DTOList = get"+entity+"DTOList("+sentity+"List);\r\n" + 
					"			"+sresponse+".setMessage(messageService.getMessage(\"success.message\"));\r\n" + 
					"			"+sresponse+".setStatus(HttpStatus.OK.value());\r\n" + 
					"			"+sresponse+".setPayLoad("+sentity+"DTOList);\r\n" + 
					"			return "+sresponse+";\r\n" + 
					"		}\r\n" + 
					"		else {\r\n" + 
					"			"+sresponse+".setMessage(messageService.getMessage(\""+sentity+".no\"));\r\n" + 
					"			"+sresponse+".setStatus(HttpStatus.OK.value());\r\n" + 
					"			return "+sresponse+";\r\n" + 
					"		}\r\n" + 
					"		\r\n" + 
					"	}\r\n" + 
					"\r\n" + 
					impl.getObject("ProductDTO", "Product") +"\r\n" + 
					"	@Override\r\n" + 
					"	public "+response+" get"+entity+"ById(Long "+sentity+"Id) {\r\n" + 
					"		"+response+" "+sresponse+" = new "+response+"();\r\n" + 
					"		if(!StringUtils.isEmpty("+sentity+"Id)) {\r\n" + 
					"			Optional<"+entity+"> optional"+entity+" = "+sentity+"Repository.findById("+sentity+"Id);\r\n" + 
					"			if(optional"+entity+".isPresent()) {\r\n" + 
					"				List<"+entity+"> "+sentity+"List = new ArrayList<>();\r\n" + 
					"				"+entity+" "+sentity+" = optional"+entity+".get();\r\n" + 
					"				"+sentity+"List.add("+sentity+");\r\n" + 
					"				List<"+entity+"DTO> "+sentity+"DTOList = get"+entity+"DTOList("+sentity+"List);\r\n" + 
					"				"+sresponse+".setMessage(\"success.message\");\r\n" + 
					"				"+sresponse+".setStatus(HttpStatus.OK.value());\r\n" + 
					"				"+sresponse+".setPayLoad("+sentity+"DTOList);\r\n" + 
					"			}\r\n" + 
					"			else {\r\n" + 
					"				"+sresponse+".setMessage(messageService.getMessage(\""+sentity+".no\"));\r\n" + 
					"				"+sresponse+".setStatus(HttpStatus.OK.value());\r\n" + 
					"			}\r\n" + 
					"		}\r\n" + 
					"		else {\r\n" + 
					"			"+sresponse+".setMessage(messageService.getMessage(\"invalid.data\"));\r\n" + 
					"			"+sresponse+".setStatus(HttpStatus.BAD_REQUEST.value());\r\n" + 
					"		}\r\n" + 
					"		\r\n" + 
					"		return "+sresponse+";\r\n" + 
					"	}\r\n" + 
					"\r\n" + 
					"	@Override\r\n" + 
					"	public "+response+" save"+entity+"("+entity+"DTO "+sentity+"DTO) {\r\n" + 
					"		"+response+" "+sresponse+" = new "+response+"();\r\n" + 
					"		if("+sentity+"DTO != null) {\r\n" + 
					"			"+entity+" "+sentity+" = new "+entity+"();\r\n" + 
					"			"+sentity+" = get"+entity+"("+sentity+"DTO,"+sentity+");\r\n" + 
					"			"+sentity+"Repository.save("+sentity+");\r\n" + 
					"			"+sresponse+".setStatus(HttpStatus.OK.value());\r\n" + 
					"			"+sresponse+".setMessage(messageService.getMessage(\""+sentity+".save\"));\r\n" + 
					"		}\r\n" + 
					"		else {\r\n" + 
					"			"+sresponse+".setStatus(HttpStatus.BAD_REQUEST.value());\r\n" + 
					"			"+sresponse+".setMessage(messageService.getMessage(\"invalid.data\"));\r\n" + 
					"		}\r\n" + 
					"		return null;\r\n" + 
					"	}\r\n" + 
					"\r\n" + 
					"	@Override\r\n" + 
					"	public "+response+" update"+entity+"("+entity+"DTO "+sentity+"DTO) {\r\n" + 
					"		"+response+" "+sresponse+" = new "+response+"();\r\n" + 
					"		if("+sentity+"DTO !=null) {\r\n" + 
					"			Optional<"+entity+"> optional"+entity+" = "+sentity+"Repository.findById("+sentity+"DTO.get"+entity+"Id());\r\n" + 
					"			if(optional"+entity+".isPresent()) {\r\n" + 
					"				"+entity+" "+sentity+" = get"+entity+"("+sentity+"DTO, optional"+entity+".get());\r\n" + 
					"			    "+sentity+"Repository.save("+sentity+");\r\n" + 
					"			    "+sresponse+".setStatus(HttpStatus.OK.value());\r\n" + 
					"			    "+sresponse+".setMessage(messageService.getMessage(\""+sentity+".update\"));\r\n" + 
					"			}\r\n" + 
					"			else {\r\n" + 
					"				"+sresponse+".setStatus(HttpStatus.NOT_FOUND.value());\r\n" + 
					"				"+sresponse+".setMessage(messageService.getMessage(\""+sentity+".not.found\"));\r\n" + 
					"			}\r\n" + 
					"		}\r\n" + 
					"		else {\r\n" + 
					"			"+sresponse+".setStatus(HttpStatus.BAD_REQUEST.value());\r\n" + 
					"			"+sresponse+".setMessage(messageService.getMessage(\"invalid.data\"));\r\n" + 
					"		}\r\n" + 
					"		return "+sresponse+";\r\n" + 
					"	}\r\n" + 
					"\r\n" + 
					impl.getObject("Product", "ProductDTO")+ 
					"\r\n" +
					"	@Override\r\n" + 
					"	public "+response+" delete"+entity+"(Long "+sentity+"Id) {\r\n" + 
					"		"+response+" "+sresponse+" = new "+response+"();\r\n" + 
					"		"+sentity+"Repository.deleteById("+sentity+"Id);\r\n" + 
					"		"+sresponse+".setMessage(messageService.getMessage(\""+sentity+".update\"));\r\n" + 
					"		return "+sresponse+";\r\n" + 
					"	}\r\n" + 
					"	\r\n" + 
					"}\r\n" + 
					"");

		}
	}




	
