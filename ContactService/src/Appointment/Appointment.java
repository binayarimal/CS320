package Appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Appointment {
	private String appointmentId;
	private String date;
	private String description;
	
	public Appointment(String appointmentId, String date , String description) throws ParseException {
		this.appointmentId= this.validateId(appointmentId);
		this.date=this.validateDate(date);
		this.description=this.validateDescription(description);
		
	}
	
	public boolean validDate(String date) throws ParseException {
		
		Date curDate = new Date();
	
        
		LocalDate localDate = curDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String day = String.valueOf(localDate.getDayOfMonth());
		String month = String.valueOf(localDate.getMonthValue());
		String year = String.valueOf(localDate.getYear());
		
		String formattedCurDate = year+"-"+month+"-"+day;
		
		Date date1 = simpleDateFormat.parse(formattedCurDate);
		Date date2 = simpleDateFormat.parse(date);
		System.out.println(date1);
		return date1.before(date2); 
	}

	public String validateId(String id) {
		if(id == null || id.length() > 10 || id.length() == 0){
			 throw new IllegalArgumentException("Invalid Id");
		}else {
			return id;
		}
	}
	
	public String validateDate(String date) throws ParseException{
		if(date == null || !validDate(date)){			
			 throw new IllegalArgumentException("Invalid date");
		}else {
			return date;
		}		
	}
	
	
	public String validateDescription (String description) {
		if(description == null || description.length() > 50 ){
			 throw new IllegalArgumentException("Invalid description");
		}else {
			return description;
		}		
	}
	
	
	public String getId() {
		return this.appointmentId;
	}
	
	public String getDate() {
		return this.date;
	}

	public String getDescription() {
		return this.description;
	}

	
	
}


