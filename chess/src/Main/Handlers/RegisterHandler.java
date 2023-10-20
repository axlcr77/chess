package Handlers;

import Service.RegisterService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import Request.RegisterRequest;
import Response.RegisterReponse;

public class RegisterHandler {
  public Object service(Request request, Response response){
    Gson gson = new Gson();
    //Getting the body from the request. This particular one will have the username, password, and email.
    RegisterRequest request1 = (RegisterRequest) gson.fromJson(request.body(),RegisterRequest.class);
    RegisterService serv = new RegisterService();
    //Use the information gathered from the request body to give the service and create a response from there.
    RegisterReponse response1 = serv.register(request1);
    updateStatus status = new updateStatus();

    response.status(status.updateResponseStatus(response1.getMessage()));

    //The response is then returned as Json to the client
    return gson.toJson(response1);
  }
}
