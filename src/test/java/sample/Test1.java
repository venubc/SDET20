package sample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	
	public void Contact() {
		System.out.println("contact created");
	}
	
	@BeforeMethod
	public void Contact1() {
		
		System.out.println("contact created1");
		System.out.println("contact created2");
	}

}
