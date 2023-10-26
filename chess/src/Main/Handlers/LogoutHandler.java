package Handlers;

import Service.LogoutService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import Response.LogoutResponse;

public class LogoutHandler {
  public Object service(Request request, Response response){
    Gson gson = new Gson();
    LogoutService serv = new LogoutService();
    LogoutResponse response1 =  serv.logout(request.headers("authorization"));
    updateStatus status = new updateStatus();
    if(response1 == null){
      response.status(200);
      return "{}";
    }
    response.status(status.updateResponseStatus(response1.getMessage()));

    return gson.toJson(response1);
  }
}
