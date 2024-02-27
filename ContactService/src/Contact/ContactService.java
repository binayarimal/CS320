//Binaya Rimal

package Contact;
import java.util.ArrayList;

public class ContactService {

	public ArrayList <Contact> contactList = new ArrayList<Contact>();
	
	
			
	public void addContact(String id, String firstName, String lastName, String phone, String address){
		
		for(Contact i: contactList) {
			if(i.getId().equals(id)) {
				throw new IllegalArgumentException("Duplicate Id");
			}
		}

		Contact contact = new Contact(id, firstName, lastName, phone, address);
		contactList.add(contact);
	}
	
	public void deleteContact(String id){
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i).getId().equals(id)) {
				contactList.remove(i);
			}else {
				throw new IllegalArgumentException("No contact found with the given Id");
			}
		}
		
	}
	public void updateFirstName(String id, String firstName){
		for(Contact i: contactList) {
			if(i.getId().equals(id)) {
				i.setFirstName(firstName);
			}
			else {
				throw new IllegalArgumentException("No contact found with the given Id");
			}
		}
		
		
	}
	
	public void updateLastName(String id, String lastName){
		for(Contact i: contactList) {
			if(i.getId().equals(id)) {
				i.setLastName(lastName);
			}else {
				throw new IllegalArgumentException("No contact found with the given Id");
			}
		}
	}
	
	public void updatePhone(String id, String phone){
		for(Contact i: contactList) {
			if(i.getId().equals(id)) {
				i.setPhoneNumber(phone);
			}else {
				throw new IllegalArgumentException("No contact found with the given Id");
			}
		}
	}
	
	public void updateAddress(String id, String address){
		for(Contact i: contactList) {
			if(i.getId().equals(id)) {
				i.setAddress(address);
			}else {
				throw new IllegalArgumentException("No contact found with the given Id");
			}
		}
	}
	
	public Contact getContact(String id){
		for(Contact i: contactList) {
			if(i.getId().equals(id)) {
				return i;
			}
		}
		throw new IllegalArgumentException("No contact found with the given Id");
	}
	
	public static void main(String[] args) {
		
	}
	


}
