package Handlers;

import Service.JoinGameService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import Request.JoinGameRequest;
import Response.JoinGameResponse;

public class JoinGameHandler {
  public Object service(Request request, Response response){
    Gson gson = new Gson();
    String authToken = request.headers("authorization");
    JoinGameRequest request1 = (JoinGameRequest) gson.fromJson(request.body(),JoinGameRequest.class);
    JoinGameService serv = new JoinGameService();
    JoinGameResponse response1 = serv.JoinGame(request1,authToken);
    updateStatus status = new updateStatus();

    response.status(status.updateResponseStatus(response1.getMessage()));

    return gson.toJson(response1);
  }
}
