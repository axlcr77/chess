package Handlers;

import spark.Response;

public class updateStatus {


  public int updateResponseStatus(String message) {
    if (message == null) {
      return 200;
    } else if (message.equals("bad request error")) {
      return 400;
    } else if (message.equals("unauthorized error")) {
      return 401;
    } else if (message.equals("already taken error")) {
      return 403;
    } else if( message.equals("server Error")){
      return 500;
    } else{
      return 200;
    }
  }
}
