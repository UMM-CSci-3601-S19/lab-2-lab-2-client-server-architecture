package umm3601.todos;

import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByCategoryfromDB {
  @Test
  public void FilterTodosByCategory() throws IOException {
    TodoDatabase db  = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());
    Todo[] catagorySDTodos= db.filterTodosByCategory(allTodos,"software design");
    assertEquals("Incorrect number of todo with catagory software design", 74, catagorySDTodos.length);
    Todo[] catagoryVGTodos= db.filterTodosByCategory(allTodos,"video games");
    assertEquals("Incorrect number of todo with catagory software design", 71, catagoryVGTodos.length);
  }

  @Test
  public void listTodosWithCategoryFilter() throws IOException {
    TodoDatabase db  = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("category", new String[]{"software design"});
    Todo[] catagorySDTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with catagory software design", 74,catagorySDTodos.length);

    queryParams.put("category", new String[]{"video games"});
    Todo[] catagoryVGTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with catagory software design", 71,catagoryVGTodos.length);

  }
}
