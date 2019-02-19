package umm3601.todos;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByOwnerFromDB {

  @Test
  public void filterTodosByOwner() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] ownerFryTodos = db.filterTodosByOwner(allTodos, "Fry");
    assertEquals("Incorrect number of todos with owner Fry", 61, ownerFryTodos.length);

    Todo[] ownerBlancheTodos = db.filterTodosByOwner(allTodos, "Blanche");
    assertEquals("Incorrect number of todos with owner Blanche", 43, ownerBlancheTodos.length);
  }

  @Test
  public void listTodosWithOwnerFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("owner", new String[]{"Fry"});
    Todo[] ownerFryTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with owner Fry", 61, ownerFryTodos.length);

    queryParams.put("owner", new String[]{"Blanche"});
    Todo[] ownerBlancheTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with owner Blanche", 43, ownerBlancheTodos.length);
  }
}
