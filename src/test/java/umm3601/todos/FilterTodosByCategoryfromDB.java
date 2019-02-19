package umm3601.todos;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByCategoryFromDB {

  @Test
  public void filterTodosByCategory() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] categoryVideoGamesTodos = db.filterTodosByCategory(allTodos, "video games");
    assertEquals("Incorrect number of todos with category video games", 71, categoryVideoGamesTodos.length);

    Todo[] categorySoftwareDesignTodos = db.filterTodosByCategory(allTodos, "software design");
    assertEquals("Incorrect number of todos with category software design", 74, categorySoftwareDesignTodos.length);
  }

  @Test
  public void listTodosWithCategoryFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("category", new String[]{"video games"});
    Todo[] categoryVideoGamesTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with category video games", 71, categoryVideoGamesTodos.length);

    queryParams.put("category", new String[]{"software design"});
    Todo[] categorySoftwareDesignTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with category software design", 74, categorySoftwareDesignTodos.length);
  }
}
