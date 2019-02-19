package umm3601.todos;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class TodoDatabase {

  private Todo[] allTodos;

  public TodoDatabase(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  /**
   * Get the single todos specified by the given ID. Return
   * `null` if there is no todos with that ID.
   *
   * @param id the ID of the desired todos
   * @return the todos with the given ID, or null if there is no todos
   * with that ID
   */
  public Todo getTodos(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  /**
   * Get an array of all the todoss satisfying the queries in the params.
   *
   * @param queryParams map of required key-value pairs for the query
   * @return an array of all the todoss matching the given criteria
   */
  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;

    // Filter status if defined
    if (queryParams.containsKey("status")) {
      String completedstatus = queryParams.get("status")[0];
      filteredTodos = filterTodosByStatus(filteredTodos, completedstatus);
    }
     if (queryParams.containsKey("contains")) {
      String completedbody = queryParams.get("contains")[0];
      filteredTodos = filterTodosByBody(filteredTodos, completedbody);
    }
    if (queryParams.containsKey("owner")) {
      String completedOwner = queryParams.get("owner")[0];
      filteredTodos = filterTodosByOwner(filteredTodos, completedOwner);
    }
    if (queryParams.containsKey("limit")) {
      int completedLimit = Integer.parseInt(queryParams.get("limit")[0]);
      filteredTodos = filterTodosByLimit(filteredTodos, completedLimit);
    }
    if (queryParams.containsKey("category")) {
      String completedCategory = queryParams.get("category")[0];
      filteredTodos = filterTodosByCategory(filteredTodos, completedCategory);
    }
    // Process other query parameters here...

    return filteredTodos;
  }

  /**
   * Get an array of all the todoss having the target status.
   *
   * @param todos     the list of todoss to filter by status
   * @param status the boolean to look for
   * @return an array of all the todos from the given list that have
   * the status
   */
  public Todo[] filterTodosByStatus(Todo[] todos, String status) {
    if (status.equals("complete")) {
      return Arrays.stream(todos).filter(x -> x.status).toArray(Todo[]::new);
    }
    else if (status.equals("incomplete")) {
      return Arrays.stream(todos).filter(x -> !x.status).toArray(Todo[]::new);
      }
    else {
      return todos;
    }
  }

  public Todo[] filterTodosByBody(Todo[] todos, String body) {
      return Arrays.stream(todos).filter(x -> x.body.contains(body)).toArray(Todo[]::new);
    }

  public Todo[] filterTodosByOwner(Todo[] todos, String Owner) {
    return Arrays.stream(todos).filter(x -> x.owner.contains(Owner)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByLimit(Todo[] todos, int Limit) {
    return Arrays.stream(todos).limit(Limit).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByCategory(Todo[] todos, String Category) {
    return Arrays.stream(todos).filter(x -> x.category.contains(Category)).toArray(Todo[]::new);
  }
}
