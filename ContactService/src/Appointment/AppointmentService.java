package Appointment;
import java.text.ParseException;
import java.util.ArrayList;

public class AppointmentService {

	public ArrayList <Appointment> appointmentList = new ArrayList<Appointment>();
	
	
			
	public void addAppointment(String id, String date, String description) throws ParseException{
		
		for(Appointment i: appointmentList) {
			if(i.getId().equals(id)) {
				throw new IllegalArgumentException("Duplicate Id");
			}
		}

		Appointment Appointment = new Appointment(id, date, description);
		appointmentList.add(Appointment);
	}
	
	public void deleteAppointment(String id){
		if (appointmentList.size() == 0) {
			throw new IllegalArgumentException("No appointment found with the given Id");
		}
		for(int i = 0; i < appointmentList.size(); i++) {
			if(appointmentList.get(i).getId().equals(id)) {
				appointmentList.remove(i);
			}else {
				throw new IllegalArgumentException("No appointment found with the given Id");
			}
		}
		
	}

	
	
	public Appointment getAppointment(String id){
		
		for(Appointment i: appointmentList) {
			if(i.getId().equals(id)) {
				return i;
			}
		}
		throw new IllegalArgumentException("No Appointment found with the given Id");
	}
	
	public static void main(String[] args) {
		
	}
	

}