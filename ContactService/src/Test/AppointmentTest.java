//Binaya Rimal

package Test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import Appointment.Appointment;

public class AppointmentTest {
	
	String id = "123";
	String date = "2025-12-20";
	String description = "add";
	

	
	@Test
	void testValidAppointment() throws ParseException {
	
		Appointment appointment = new Appointment(this.id, this.date, this.description);
		assertEquals(this.id, appointment.getId());
		assertEquals(this.date, appointment.getDate());
		assertEquals(this.description, appointment.getDescription());

	}
	
	@Test
	void testIdTooLong() {
	
		String invalidId = "123123123123123";
		Exception exception = assertThrows(Exception.class, () -> new Appointment(invalidId, this.date, this.description));
		assertEquals("Invalid Id", exception.getMessage());
	
	}
	
	@Test
	void testEmptyId() {
		String emptyId = "";
		Exception exception = assertThrows(Exception.class, () -> new Appointment(emptyId, this.date, this.description));
		assertEquals("Invalid Id", exception.getMessage());
	
	}
	
	@Test
	void testNullId() {
		
		String nullId = null;
		
		Exception exception = assertThrows(Exception.class, () -> new Appointment(nullId, this.date, this.description));
		assertEquals("Invalid Id", exception.getMessage());
	}
	
	@Test
	void testDatePast() {
		String invalidDate = "2020-02-02";		
		Exception exception = assertThrows(Exception.class, () -> new Appointment(this.id, invalidDate, this.description));
		assertEquals("Invalid date", exception.getMessage());
		
	}
	
	@Test
	void testDateToday() {
		Date curDate = new Date();     
		LocalDate localDate = curDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();		
		String day = String.valueOf(localDate.getDayOfMonth());
		String month = String.valueOf(localDate.getMonthValue());
		String year = String.valueOf(localDate.getYear());
		String formattedCurDate = year+"-"+month+"-"+day;

		
		
		Exception exception = assertThrows(Exception.class, () -> new Appointment(this.id, formattedCurDate, this.description));
		assertEquals("Invalid date", exception.getMessage());
		
	}	
	 
	@Test
	void testDateInvalidFormat(){
		String invalidDate = "2020/02/02";		
		Exception exception = assertThrows(Exception.class, () -> new Appointment(this.id, invalidDate, this.description));
		assertEquals("Unparseable date: \"2020/02/02\"", exception.getMessage());
		
		
	}
	
	@Test
	void testNullDate() {
		
		String nullDate = null;
		
		Exception exception = assertThrows(Exception.class, () -> new Appointment(this.id, nullDate, this.description));
		assertEquals("Invalid date", exception.getMessage());
		
	}
	
	@Test
	void testDescriptionLongerThan50() {
		String InvalidDescription = "add list to appointment add list to appointment "
				+ " appointment appointment appointmentadd list to appointment add list"
				+ " to appointment add list to";
		
		Exception exception = assertThrows(Exception.class, () -> new Appointment(this.id, this.date, InvalidDescription));
		assertEquals("Invalid description", exception.getMessage());
	}
	
	
	@Test
	void testNullDescription() {
		
		String nullDescription = null;
		
		Exception exception = assertThrows(Exception.class, () -> new Appointment(this.id, this.date, nullDescription));
		assertEquals("Invalid description", exception.getMessage());
		
	}
	
	
}