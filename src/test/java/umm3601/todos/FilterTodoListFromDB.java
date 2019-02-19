package umm3601.todos;

import org.junit.Test;
import umm3601.todos.TodoDatabase;
import umm3601.todos.Todo;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterTodoListFromDB {

  @Test
  public void totalTodoCount() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    assertEquals("Incorrect total number of todos", 300, allTodos.length);
  }

  @Test
  public void firstUserInFullList() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo firstTodo = allTodos[0];
    assertEquals("Incorrect owner", "Blanche", firstTodo.owner);
    assertEquals("Incorrect status", false, firstTodo.status);
    assertEquals("Incorrect body", "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.", firstTodo.body);
    assertEquals("Incorrect category", "software design", firstTodo.category);
  }
}
