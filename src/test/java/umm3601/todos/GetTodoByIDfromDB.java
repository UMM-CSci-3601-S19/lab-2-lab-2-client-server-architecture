package umm3601.todos;

import org.junit.Test;
import umm3601.todos.TodoDatabase;
import umm3601.todos.Todo;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByIDFromDB {

  @Test
  public void getFry() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo todos = db.getTodos("58895985c1849992336c219b");
    assertEquals("Incorrect name", "Fry", todos.owner);
  }

  @Test
  public void getDawn() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo todos = db.getTodos("58895985fb6db34b6ecc33b5");
    assertEquals("Incorrect name", "Dawn", todos.owner);
  }
}
