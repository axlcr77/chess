package Handlers;

import Service.ListGamesService;
import com.google.gson.Gson;
import dataAccess.DataAccessException;
import spark.Request;
import spark.Response;
import Response.ListGamesResponse;

public class ListGamesHandler {
  public Object service(Request request, Response response) throws DataAccessException {
    Gson gson = new Gson();
    ListGamesService serv = new ListGamesService();
    //Passing in the authorization header information to the service. (Skipping the request)
    ListGamesResponse response1 =serv.ListGames(request.headers("authorization"));
    updateStatus status = new updateStatus();

    response.status(status.updateResponseStatus(response1.getMessage()));

    return gson.toJson(response1);
  }
}
