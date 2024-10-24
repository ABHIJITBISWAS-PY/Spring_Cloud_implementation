package Account.com.service.Accountservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class serviceClassTest {

	
	serviceClass serviceclass = new serviceClass();
	@Test
	void test() {
		String a = serviceclass.name();
		System.out.println(a);
		assertEquals("Abhi", a);
	}
	
	@BeforeAll
	static void beforeAll() {
		account acnt = new account();
		acnt.setA(1);
		System.out.println("vlaue of a = " + acnt.getA());
		assertEquals(1, acnt.getA());
	}
	
//	@AfterEach
	@Disabled
	@Test
	void aftereach() {
		System.out.println("print after Each");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("print before Each");
	}


}
