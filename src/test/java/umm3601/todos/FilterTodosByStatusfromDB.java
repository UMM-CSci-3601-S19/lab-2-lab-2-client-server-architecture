package umm3601.todos;
import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByStatusfromDB {
  @Test
  public void FilterTodosByStatusTrue() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] statustrueTodos = db.filterTodosByStatus(allTodos, "true");
    assertEquals("Incorrect number of todo with status true", 300, statustrueTodos.length);
  }
  @Test
  public void FilterTodosByStatusFalse() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] statusFalseTodos = db.filterTodosByStatus(allTodos, "false");
    assertEquals("Incorrect number of todo with status false", 300, statusFalseTodos.length);
  }
}
