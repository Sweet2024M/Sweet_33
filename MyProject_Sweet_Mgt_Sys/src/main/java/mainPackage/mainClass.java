package mainPackage;

import ProductionCode.*;
public class mainClass {

	public static void main(String[] args) {
		
		MyApp a= new MyApp();
		
		for (User user : a.users) {
		  System.out.println(user.getName()+" "+user.getPassword());
		}

	}

}
