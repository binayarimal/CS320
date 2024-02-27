//Binaya Rimal
package Test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import Task.Task;

public class TaskTest {
	String id = "123";
	String name = "addList";
	String description = "add list to task";
	
	@Test
	void testValidTask() {
	
		Task task = new Task(this.id, this.name, this.description);
		assertEquals(this.id, task.getId());
		assertEquals(this.name, task.getName());
		assertEquals(this.description, task.getDescription());

	}
	
	@Test
	void testInvalidIdLongerThan10() {
	
		String invalidId = "123123123123123";
		Exception exception = assertThrows(Exception.class, () -> new Task(invalidId, this.name, this.description));
		assertEquals("Invalid Id", exception.getMessage());
	
	}
	
	@Test
	void testEmptyId() {
		String emptyId = "";
		Exception exception = assertThrows(Exception.class, () -> new Task(emptyId, this.name, this.description));
		assertEquals("Invalid Id", exception.getMessage());
	
	}
	
	@Test
	void testNullId() {
		
		String nullId = null;
		
		Exception exception = assertThrows(Exception.class, () -> new Task(nullId, this.name, this.description));
		assertEquals("Invalid Id", exception.getMessage());
	}
	
	@Test
	void testInvalidNameLongerThan20() {
		String invalidName = "invalidNameinvalidNameinvalidNameinvalidName";		
		Exception exception = assertThrows(Exception.class, () -> new Task(this.id, invalidName, this.description));
		assertEquals("Invalid name", exception.getMessage());
		
	}
	
	@Test
	void testNullName() {
		
		String nullName = null;
		
		Exception exception = assertThrows(Exception.class, () -> new Task(this.id, nullName, this.description));
		assertEquals("Invalid name", exception.getMessage());
		
	}
	
	@Test
	void testInvalidDescriptionLongerThan50() {
		String InvalidDescription = "add list to task add list to task add list to task add list to task add list to task add list to task add list to task";
		
		Exception exception = assertThrows(Exception.class, () -> new Task(this.id, this.name, InvalidDescription));
		assertEquals("Invalid description", exception.getMessage());
	}
	
	@Test
	void testNullDescription() {
		String nullDescription = null;
		Exception exception = assertThrows(Exception.class, () -> new Task(this.id, this.name, nullDescription));
		assertEquals("Invalid description", exception.getMessage());
		
	}
	
	
}
