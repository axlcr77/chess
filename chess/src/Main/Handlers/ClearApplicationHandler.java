package Handlers;


import Response.ClearApplicationResponse;
import Service.ClearApplicationService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;


public class ClearApplicationHandler {

  public Object ClearApplication(Request request, Response response){
    Gson gson = new Gson();
    ClearApplicationService serv = new ClearApplicationService();
    ClearApplicationResponse response1 = serv.clearApp();
    updateStatus status = new updateStatus();

    response.status(status.updateResponseStatus(response1.getMessage()));

    //This is the information in the response
    return gson.toJson(response1);
  }
}
