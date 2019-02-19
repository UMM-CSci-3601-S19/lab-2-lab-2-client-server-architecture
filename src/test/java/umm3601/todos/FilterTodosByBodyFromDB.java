package umm3601.todos;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByBodyFromDB {

  @Test
  public void filterTodosByStatus() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] bodySuntTodos = db.filterTodosByBody(allTodos, "sunt");
    assertEquals("Incorrect number of todos with body false", 85, bodySuntTodos.length);

    Todo[] bodyExTodos = db.filterTodosByBody(allTodos, "ex");
    assertEquals("Incorrect number of todos with body ex", 176, bodyExTodos.length);
  }

  @Test
  public void listTodosWithBodyFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("body", new String[]{"magna"});
    Todo[] bodyMagnaTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with body magna", 300, bodyMagnaTodos.length);

    queryParams.put("body", new String[]{"Anim"});
    Todo[] bodyAnimTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with body Anim", 300, bodyAnimTodos.length);
  }
}
