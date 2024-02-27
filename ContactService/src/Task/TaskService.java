package Task;
import java.util.ArrayList;

public class TaskService {

	public ArrayList <Task> taskList = new ArrayList<Task>();
	
	
			
	public void addTask(String id, String name, String description){
		
		for(Task i: taskList) {
			if(i.getId().equals(id)) {
				throw new IllegalArgumentException("Duplicate Id");
			}
		}

		Task Task = new Task(id, name, description);
		taskList.add(Task);
	}
	
	public void deleteTask(String id){
		if (taskList.size() == 0) {
			throw new IllegalArgumentException("No task found with the given Id");
		}
		for(int i = 0; i < taskList.size(); i++) {
			if(taskList.get(i).getId().equals(id)) {
				taskList.remove(i);
			}else {
				throw new IllegalArgumentException("No task found with the given Id");
			}
		}
		
	}
	public void updateTaskName(String id, String name){
		if (taskList.size() == 0) {
			throw new IllegalArgumentException("No task found with the given Id");
		}
		for(Task i: taskList) {
			if(i.getId().equals(id)) {
				i.setName(name);
			}
			else {
				throw new IllegalArgumentException("No task found with the given Id");
			}
		}
		
		
	}
	
	public void updateTaskDescription(String id, String description){
		if (taskList.size() == 0) {
			throw new IllegalArgumentException("No task found with the given Id");
		}
		for(Task i: taskList) {
			if(i.getId().equals(id)) {
				i.setDescription(description);
			}else {
				throw new IllegalArgumentException("No Task found with the given Id");
			}
		}
	}
	
	
	public Task getTask(String id){
		
		for(Task i: taskList) {
			if(i.getId().equals(id)) {
				return i;
			}
		}
		throw new IllegalArgumentException("No Task found with the given Id");
	}
	
	public static void main(String[] args) {
		
	}
	

}