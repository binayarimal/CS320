// Binaya Rimal
 
package Test;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import Contact.ContactService;

public class ContactServiceTest {
	
	@Test
	void testAddOneContact() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();		
		contactService.addContact(id, firstName, lastName, phone, address);
		assertEquals(1, contactService.contactList.size());

	}

	@Test
	void testAddMultipleContacts() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();		
		contactService.addContact(id, firstName, lastName, phone, address);
		contactService.addContact("1234", firstName, lastName, phone, address);
		assertEquals(2, contactService.contactList.size());

	}
	
	@Test
	void testAddContactDuplicateId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();		
		contactService.addContact(id, firstName, lastName, phone, address);
		
		Exception exception = assertThrows(Exception.class, () -> contactService.addContact(id, firstName, lastName, phone, address));
		assertEquals("Duplicate Id", exception.getMessage());	
	}
	
	@Test
	void testGetContactByValidId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
		
		ContactService contactService = new ContactService();		
		contactService.addContact(id, firstName, lastName, phone, address);
		
		assertEquals(id, contactService.getContact(id).getId());
		assertEquals(firstName, contactService.getContact(id).getFirstName());
		assertEquals(lastName, contactService.getContact(id).getLastName());
		assertEquals(phone, contactService.getContact(id).getPhoneNumber());
		assertEquals(address, contactService.getContact(id).getAddress());

	}
	
	@Test
	void testGetContactByInvalidId() {
				
		ContactService contactService = new ContactService();
		Exception exception = assertThrows(Exception.class, () -> contactService.getContact("1"));
		assertEquals("No contact found with the given Id", exception.getMessage());


	}
	
	@Test
	void testUpdateFirstNameByValidId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();
		contactService.addContact(id, firstName, lastName, phone, address);
		
		contactService.updateFirstName(id, "newName");
		assertEquals("newName", contactService.getContact(id).getFirstName());


	}
	
	
	@Test
	void testUpdateFirstNameByInValidId() {
			
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();
		contactService.addContact(id, firstName, lastName, phone, address);
		Exception exception = assertThrows(Exception.class, () -> contactService.updateFirstName("1", "new"));
		assertEquals("No contact found with the given Id", exception.getMessage());	


	}
	
	@Test
	void testUpdateLastNameByValidId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();
		contactService.addContact(id, firstName, lastName, phone, address);
		
		contactService.updateLastName(id, "newName");
		assertEquals("newName", contactService.getContact(id).getLastName());


	}
	
	
	@Test
	void testUpdateLastNameByInValidId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();
		contactService.addContact(id, firstName, lastName, phone, address);

		Exception exception = assertThrows(Exception.class, () -> contactService.updateLastName("1", "new"));
		assertEquals("No contact found with the given Id", exception.getMessage());	


	}
	
	
	@Test
	void testUpdateAddressByValidId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();
		contactService.addContact(id, firstName, lastName, phone, address);
		contactService.updateAddress("123", "newAddress");
		assertEquals("newAddress", contactService.getContact(id).getAddress());

	}
	
	@Test
	void testUpdateAddressByInValidId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();
		contactService.addContact(id, firstName, lastName, phone, address);

		Exception exception = assertThrows(Exception.class, () -> contactService.updateAddress("1", "new"));
		assertEquals("No contact found with the given Id", exception.getMessage());	

	}
	
	@Test
	void testUpdatePhoneByValidId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();
		contactService.addContact(id, firstName, lastName, phone, address);
		contactService.updatePhone("123", "123456787");
		assertEquals("123456787", contactService.getContact(id).getPhoneNumber());

	}
	
	@Test
	void testUpdatePhoneByInvalidId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
		
		
		ContactService contactService = new ContactService();
		contactService.addContact(id, firstName, lastName, phone, address);

		Exception exception = assertThrows(Exception.class, () -> contactService.updatePhone("1", "new"));
		assertEquals("No contact found with the given Id", exception.getMessage());	

	}
	
	@Test
	void testDeleteContactByValidId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();
		
		contactService.addContact(id, firstName, lastName, phone, address);
		assertEquals(id, contactService.getContact(id).getId());
		
		contactService.deleteContact(id);	
		Exception exception = assertThrows(Exception.class, () -> contactService.getContact("1"));
		assertEquals("No contact found with the given Id", exception.getMessage());	
	}
	
	@Test
	void testDeleteContactByInvalidId() {
		
		String id = "123";
		String firstName = "Binaya";
		String lastName = "Rimal";
		String phone = "1234567890";
		String address = "Jupiter";
			
		ContactService contactService = new ContactService();
		contactService.addContact(id, firstName, lastName, phone, address);
		
		Exception exception = assertThrows(Exception.class, () -> contactService.deleteContact("1"));
		assertEquals("No contact found with the given Id", exception.getMessage());		
	}
}
