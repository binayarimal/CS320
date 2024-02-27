//Binaya Rimal

package Contact;

public class Contact {
	
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		this.contactId= this.validateId(contactId);
		this.firstName=this.validateFirstName(firstName);
		this.lastName=this.validateLastName(lastName);
		this.phoneNumber=this.validatePhoneNumber(phoneNumber);
		this.address=this.validateAddress(address);
		
	}
	private String validateId(String id) {
		if(id == null || id.length() > 10){
			 throw new IllegalArgumentException("Invalid Id");
		}else {
			return id;
		}
	}
	
	private String validateFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10 ){
			 throw new IllegalArgumentException("Invalid First Name");
		}else {
			return firstName;
		}		
	}
	
	private String validateLastName(String lastName) {
		if(lastName == null || lastName.length() > 10){
			 throw new IllegalArgumentException("Invalid Last Name");
		}else {
			return lastName;
		}		
	}
	
	private String validatePhoneNumber(String phoneNumber) {
		try {
			Integer.parseInt(phoneNumber);
			
			if(phoneNumber.toString().length()  != 10){
				 throw new IllegalArgumentException("Invalid Phone Number");
			}else{
				return phoneNumber;
			}
			
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}

		
	}
	
	private String validateAddress(String address) {
		if(address == null || address.length() > 30){
			 throw new IllegalArgumentException("Invalid Address");
		}else {
			return address;
		}		
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getId() {
		return this.contactId;
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getAddress() {
		return this.address;
	}
}
