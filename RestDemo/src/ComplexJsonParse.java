import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js= new JsonPath(payload.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//print purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		String titleFirstCourse=js.get("courses[0].title");
		System.out.println(titleFirstCourse);
		
		//print all course title and their respective prices
		
		for(int i=0;i<count;i++)
		{
			String courseTitles=js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			
			System.out.println(courseTitles);
		}
		//to get rpa course copies
		for(int i=0;i<count;i++)
		{
			String courseTitles=js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("Cypress"))
			{
				int copies=js.get("courses["+i+"].copies");
						System.out.println("number of copies RPA" +copies);
				break;
			}
			
		}

	}

}
