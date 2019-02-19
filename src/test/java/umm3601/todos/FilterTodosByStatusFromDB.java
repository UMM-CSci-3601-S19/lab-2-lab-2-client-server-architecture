package umm3601.todos;

import org.junit.Test;
import umm3601.todos.TodoDatabase;
import umm3601.todos.Todo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByStatusFromDB {

  @Test
  public void filterTodosByStatus() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] statusFalseTodos = db.filterTodosByStatus(allTodos, "complete");
    assertEquals("Incorrect number of todos with status false", 143, statusFalseTodos.length);

    Todo[] statusTrueTodos = db.filterTodosByStatus(allTodos, "incomplete");
    assertEquals("Incorrect number of todos with status true", 157, statusTrueTodos.length);
  }

  @Test
  public void listTodosWithStatusFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("status", new String[]{"complete"});
    Todo[] statusFalseTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with status false", 143, statusFalseTodos.length);

    queryParams.put("status", new String[]{"incomplete"});
    Todo[] statusTrueTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with status true", 157, statusTrueTodos.length);
  }
}
