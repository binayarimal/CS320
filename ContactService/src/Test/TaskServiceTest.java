// Binaya Rimal

package Test;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import Task.TaskService;

public class TaskServiceTest {
	
	String id = "123";
	String name = "Binaya";
	String description = "Rimal";
	@Test
	void testAddOneTask() {
			
		TaskService taskService = new TaskService();		
		taskService.addTask(this.id, this.name, this.description);
		assertEquals("123", taskService.getTask(id).getId());

	}

	@Test
	void testAddMultipleTasks() {
			
		TaskService taskService = new TaskService();		
		taskService.addTask(this.id, this.name, this.description);
		taskService.addTask("1234", this.name, this.description);
		assertEquals(2, taskService.taskList.size());

	} 
	 
	@Test
	void testAddTaskDuplicateId() {
			
		TaskService taskService = new TaskService();	
		taskService.addTask(this.id, this.name, this.description);
		
		Exception exception = assertThrows(Exception.class, () -> taskService.addTask(this.id, this.name, this.description));
		assertEquals("Duplicate Id", exception.getMessage());
	}
	
	
	@Test
	void testGetTaskByValidId() {
		
		TaskService taskService = new TaskService();		
		taskService.addTask(this.id, this.name, this.description);
		
		assertEquals(id, taskService.getTask(this.id).getId());
		assertEquals(name, taskService.getTask(this.id).getName());
		assertEquals(description, taskService.getTask(this.id).getDescription());

	}
	
@Test
void testGetTaskWithIvalidId() {
	
	TaskService taskService = new TaskService();		
	taskService.addTask(this.id, this.name, this.description);
	
	Exception exception = assertThrows(Exception.class, () -> taskService.getTask("1234"));
	assertEquals("No Task found with the given Id", exception.getMessage());
    

}
	@Test
	void testGetTaskWhenListEmpty() {
		
		TaskService taskService = new TaskService();
 	
		Exception exception = assertThrows(Exception.class, () -> taskService.getTask("1234"));
		assertEquals("No Task found with the given Id", exception.getMessage());
        

	}
	
	@Test
	void testUpdateTaskNameByValidId() {
		TaskService taskService = new TaskService();
		taskService.addTask(this.id, this.name, this.description);
		
		taskService.updateTaskName(this.id, "newName");
		assertEquals("newName", taskService.getTask(this.id).getName());


	}
	
	
	@Test
	void testUpdateTaskNameByInValidId() {
		

	
			
		TaskService taskService = new TaskService();
		taskService.addTask(this.id, this.name, this.description);

		Exception exception = assertThrows(Exception.class, () -> taskService.updateTaskName("1234", "newname"));
		assertEquals("No task found with the given Id", exception.getMessage());


	}
	
	@Test
	void testUpdateTaskNameWhenListEmpty() {
					
		TaskService taskService = new TaskService();

		Exception exception = assertThrows(Exception.class, () -> taskService.updateTaskName("1234", "newname"));
		assertEquals("No task found with the given Id", exception.getMessage());


	}
	
	@Test
	void testUpdateTaskDescriptionByValidId() {
		

			
		TaskService taskService = new TaskService();
		taskService.addTask(this.id, this.name, this.description);
		
		taskService.updateTaskDescription(this.id, "new description");
		assertEquals("new description", taskService.getTask(this.id).getDescription());


	}
	
	
	@Test
	void testUpdateTaskDescriptionByInValidId() {		
		TaskService taskService = new TaskService();
		taskService.addTask(this.id, this.name, this.description);

		Exception exception = assertThrows(Exception.class, () -> taskService.updateTaskDescription("1234","newdescription"));
		assertEquals("No Task found with the given Id", exception.getMessage());


	}
	
	@Test
	void testUpdateTaskDescriptionWhenListEmpty() {
				
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(Exception.class, () -> taskService.updateTaskDescription("1234","newdescription"));
		assertEquals("No task found with the given Id", exception.getMessage());

	}
	
	@Test
	void testDeleteTaskByValidId() {
	
		TaskService taskService = new TaskService();	
		
		taskService.addTask(this.id, this.name, this.description);
		assertEquals(id, taskService.getTask(id).getId());
		
		taskService.deleteTask(id);	
		Exception exception = assertThrows(Exception.class, () -> taskService.getTask(id));
		assertEquals("No Task found with the given Id", exception.getMessage());
	}
	
	@Test
	void testDeleteTaskWhenEmptyTaskList() {
				
		
		TaskService taskService = new TaskService();
		
		Exception exception = assertThrows(Exception.class, () -> taskService.deleteTask("1234"));
		assertEquals("No task found with the given Id", exception.getMessage());	
	}
	
	@Test
	void testDeleteTaskbyInvalidId() {
			
		TaskService taskService = new TaskService();
		
		taskService.addTask(this.id, this.name, this.description);
		
		Exception exception = assertThrows(Exception.class, () -> taskService.deleteTask("1234"));
		assertEquals("No task found with the given Id", exception.getMessage());
	}
}
