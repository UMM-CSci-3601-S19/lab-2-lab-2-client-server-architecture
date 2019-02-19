package umm3601.todos;
import org.junit.Test;
import umm3601.user.Database;
import umm3601.user.User;

import java.io.IOException;
import static junit.framework.TestCase.assertEquals;

public class GetTodoByIDfromDB {
  @Test
  public void getFry() throws IOException {
    TodoDatabase db  = new TodoDatabase("src/main/data/todos.json");
    Todo todo = db.getTodos("58895985c1849992336c219b");
    assertEquals("Incorrect owner", "Fry", todo.owner);
  }

  @Test
  public void getBarry() throws IOException {
    TodoDatabase db  = new TodoDatabase("src/main/data/todos.json");
    Todo todo = db.getTodos("58895985847a6c1445ec4048");
    assertEquals("Incorrect owner", "Barry", todo.owner);
  }
}
