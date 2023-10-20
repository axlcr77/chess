package Handlers;

import Service.CreateGameService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import Request.CreateGameRequest;
import Response.CreateGameResponse;

public class CreateGameHandler {
  public Object service(Request request, Response response){
    Gson gson = new Gson();
    String authToken = request.headers("authorization");
    CreateGameRequest request1 = (CreateGameRequest) gson.fromJson(request.body(),CreateGameRequest.class);
    CreateGameService serv = new CreateGameService();
    CreateGameResponse response1 = serv.CreateGame(request1,authToken);
    updateStatus status = new updateStatus();

    //Update the status according to the message received by the service response
    response.status(status.updateResponseStatus(response1.getMessage()));
//    if(response1.getMessage() == null){
//      response.status(200);
//    } else if (response1.getMessage().equals("bad request")) {
//      response.status(400);
//    } else if (response1.getMessage().equals("unauthorized")) {
//      response.status(401);
//    }else{
//      response.status(500);
//    }
    return gson.toJson(response1);
  }
}
