package umm3601.todos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import static umm3601.Util.buildFailJsonResponse;
import static umm3601.Util.buildSuccessJsonResponse;

public class TodoController {
  private final Gson gson;
  private TodoDatabase database;

  /**
   * Construct a controller for todos.
   * <p>
   * This loads the "database" of todos info from a JSON file and
   * stores that internally so that (subsets of) todos can be returned
   * in response to requests.
   *
   * @param database the database containing todos data
   */
  public TodoController(TodoDatabase database) {
    gson = new Gson();
    this.database = database;
  }

  /**
   * Get the single todos specified by the `id` parameter in the request.
   *
   * @param req the HTTP request
   * @param res the HTTP response
   * @return a success JSON object if the todos with that ID is found, a fail
   * JSON object if no todos with that ID is found
   */
  public JsonObject getTodo(Request req, Response res) {
    res.type("application/json");
    String id = req.params("id");
    Todo todo = database.getTodos(id);
    if (todo != null) {
      return buildSuccessJsonResponse("todo", gson.toJsonTree(todo));
    } else {
      String message = "Todo with ID " + id + " wasn't found.";
      return buildFailJsonResponse("id", message);
    }
  }

  /**
   * Get a JSON response with a list of all the todos in the "database".
   *
   * @param req the HTTP request
   * @param res the HTTP response
   * @return a success JSON object containing all the todoss
   */
  public JsonObject getTodos(Request req, Response res) {
    res.type("application/json");
    Todo[] todos = database.listTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("todos", gson.toJsonTree(todos));
  }
}
