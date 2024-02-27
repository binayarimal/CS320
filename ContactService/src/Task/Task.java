package Task;

public class Task {
	private String taskId;
	private String name;
	private String description;
	
	public Task(String taskId, String name, String description) {
		this.taskId= this.validateId(taskId);
		this.name=this.validateName(name);
		this.description=this.validateDescription(description);
		
	}

	public String validateId(String id) {
		if(id == null || id.length() > 10 || id.length() == 0){
			 throw new IllegalArgumentException("Invalid Id");
		}else {
			return id;
		}
	}
	
	public String validateName(String name) {
		if(name == null || name.length() > 20 ){
			 throw new IllegalArgumentException("Invalid name");
		}else {
			return name;
		}		
	}
	
	public String validateDescription(String description) {
		if(description == null || description.length() > 50 ){
			 throw new IllegalArgumentException("Invalid description");
		}else {
			return description;
		}		
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getId() {
		return this.taskId;
	}
	
	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	
	
}
