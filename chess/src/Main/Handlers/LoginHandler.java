package Handlers;

import Service.LoginService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import Request.LoginRequest;
import Response.LoginResponse;

import java.util.UUID;


public class LoginHandler {
  public Object service(Request request, Response response){
    Gson gson = new Gson();
    //Extracting the HTTP information from the request object to then pass to the service.
    LoginRequest request1 = (LoginRequest) gson.fromJson(request.body(),LoginRequest.class);

    LoginService service1 = new LoginService();

    LoginResponse response1 = service1.login(request1);
    updateStatus status = new updateStatus();

    response.status(status.updateResponseStatus(response1.getMessage()));


    return gson.toJson(response1);
  }
}
