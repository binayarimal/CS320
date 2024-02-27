//Binaya Rimal

package Test;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import Contact.Contact;

public class ContactTest {
	
	@Test
	void testValidContact() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
		
		
		Contact contact = new Contact(id, firstName, lastName, phone, address);
		
		assertEquals(id, contact.getId());
		assertEquals(firstName, contact.getFirstName());
		assertEquals(lastName, contact.getLastName());
		assertEquals(phone, contact.getPhoneNumber());
		assertEquals(address, contact.getAddress());
		
	}
	
	@Test
	void testInvalidIdLongerThan10() {
		
		String id = "123333333333";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
		
		Exception exception = assertThrows(Exception.class, () -> new Contact(id, firstName, lastName, phone, address));
		assertEquals("Invalid Id", exception.getMessage());
		
	}
	
	
	@Test
	void testNullId() {
		
		String id = null;
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
		
		Exception exception = assertThrows(Exception.class, () -> new Contact(id, firstName, lastName, phone, address));
		assertEquals("Invalid Id", exception.getMessage());
		
	}
	
	@Test
	void testInvalidFirstNameLongerThan10() {
		
		String id = "123";
		String firstName = "BinayaRimalRimal";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
		Exception exception = assertThrows(Exception.class, () -> new Contact(id, firstName, lastName, phone, address));
		assertEquals("Invalid First Name", exception.getMessage());
		
	}
	
	@Test
	void testNullFirstName() {
		
		String id = "123";
		String firstName = null;
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
		
		Exception exception = assertThrows(Exception.class, () -> new Contact(id, firstName, lastName, phone, address));
		assertEquals("Invalid First Name", exception.getMessage());
		
	}
	
	@Test
	void testInvalidLastNameLongerThan10() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "RimalRimalRimal";
		String phone = "1234567890";
		String address = "Jupiter";
		
		Exception exception = assertThrows(Exception.class, () -> new Contact(id, firstName, lastName, phone, address));
		assertEquals("Invalid Last Name", exception.getMessage());
		
	}
	
	@Test
	void testNullLastName() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = null;
		String phone = "1234567890";
		String address = "Jupiter";
		
		Exception exception = assertThrows(Exception.class, () -> new Contact(id, firstName, lastName, phone, address));
		assertEquals("Invalid Last Name", exception.getMessage());
		
	}
	
	@Test
	void testInvalidPhoneNot10() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "124567";
		String address = "Jupiter";
		
		Exception exception = assertThrows(Exception.class, () -> new Contact(id, firstName, lastName, phone, address));
		assertEquals("Invalid Phone Number", exception.getMessage());
		
	}
	
	@Test
	void testNullPhone() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = null;
		String address = "Jupiter";
		
		Exception exception = assertThrows(Exception.class, () -> new Contact(id, firstName, lastName, phone, address));
		assertEquals("Invalid Phone Number", exception.getMessage());
		
	}
	
	@Test
	void testInvalidAddressLongerThan30() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "JupiterJupiterJupiterJupiterJupiter"
				+ "JupiterJupiterJupiterJupiterJupiterJupiterJupiter";
		
		Exception exception = assertThrows(Exception.class, () -> new Contact(id, firstName, lastName, phone, address));
		assertEquals("Invalid Address", exception.getMessage());
		
	}
	
	@Test
	void testNullAddress() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = null;
		
		Exception exception = assertThrows(Exception.class, () -> new Contact(id, firstName, lastName, phone, address));
		assertEquals("Invalid Address", exception.getMessage());
		
	}
	
	
}
