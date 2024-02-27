// Binaya Rimal

package Test;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.text.ParseException;

import Appointment.AppointmentService;

public class AppointmentServiceTest {
	
	String id = "123";
	String date = "2024-04-30";
	String description = "add";
	@Test
	void testAddOneAppointment() throws ParseException {
			
		AppointmentService appointmentService = new AppointmentService();		
		appointmentService.addAppointment(this.id, this.date, this.description);
		assertEquals("123", appointmentService.getAppointment(id).getId());

	}

	@Test
	void testAddMultipleAppointments() throws ParseException {
			
		AppointmentService appointmentService = new AppointmentService();		
		appointmentService.addAppointment(this.id, this.date, this.description);
		appointmentService.addAppointment("1234", this.date, this.description);
		assertEquals(2, appointmentService.appointmentList.size());

	} 
	 
	@Test
	void testAddAppointmentDuplicateId() throws ParseException {
			
		AppointmentService appointmentService = new AppointmentService();	
		appointmentService.addAppointment(this.id, this.date, this.description);
		
		Exception exception = assertThrows(Exception.class, () -> appointmentService.addAppointment(this.id, this.date, this.description));
		assertEquals("Duplicate Id", exception.getMessage());
	}
	
	 


	@Test
	void testDeleteAppointmentByValidId() throws ParseException {
	
		AppointmentService appointmentService = new AppointmentService();	
		
		appointmentService.addAppointment(this.id, this.date, this.description);
		assertEquals(id, appointmentService.getAppointment(id).getId());
		
		appointmentService.deleteAppointment(id);	
		Exception exception = assertThrows(Exception.class, () -> appointmentService.getAppointment(id));
		assertEquals("No Appointment found with the given Id", exception.getMessage());
	}
	
	@Test
	void testDeleteAppointmentWhenEmptyAppointmentList() {			
		AppointmentService appointmentService = new AppointmentService();	
		
		Exception exception = assertThrows(Exception.class, () -> appointmentService.deleteAppointment("1234"));
		assertEquals("No appointment found with the given Id", exception.getMessage());	
	}
	
	@Test
	void testDeleteAppointmentbyInvalidId() throws ParseException {
			
		AppointmentService appointmentService = new AppointmentService();
		
		appointmentService.addAppointment(this.id, this.date, this.description);
		
		Exception exception = assertThrows(Exception.class, () -> appointmentService.deleteAppointment("1234"));
		assertEquals("No appointment found with the given Id", exception.getMessage());
	}
}
