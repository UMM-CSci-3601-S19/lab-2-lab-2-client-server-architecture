// Why do we use the `var getAllTodos = function()` syntax
// for the first definition, and the named function syntax
// for the second definition?

/**
 * Function to get all the todos!
 */
function getAllTodos() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos", function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByStatus() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?status=" + document.getElementById("status").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByBody() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?contains=" + document.getElementById("body").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByOwner() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?owner=" + document.getElementById("owner").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByLimit() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?limit=" + document.getElementById("limit").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByCategory() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?category=" + document.getElementById("category").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByOrder() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos?orderBy=" + document.getElementById("orderBy").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

/**
 * Wrapper to make generating http requests easier. Should maybe be moved
 * somewhere else in the future!.
 *
 * Based on: http://stackoverflow.com/a/22076667
 * Now with more comments!
 */
function HttpClient() {
  // We'll take a URL string, and a callback function.
  this.get = function (aUrl, aCallback) {
    var anHttpRequest = new XMLHttpRequest();

    // Set a callback to be called when the ready state of our request changes.
    anHttpRequest.onreadystatechange = function () {

      /**
       * Only call our 'aCallback' function if the ready state is 'DONE' and
       * the request status is 200 ('OK')
       *
       * See https://httpstatuses.com/ for HTTP status codes
       * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
       *  for XMLHttpRequest ready state documentation.
       *
       */
      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
