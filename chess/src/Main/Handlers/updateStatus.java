package Handlers;

import spark.Response;

public class updateStatus {


  public int updateResponseStatus(String message) {
    if (message == null) {
      return 200;
    } else if (message.equals("bad request")) {
      return 400;
    } else if (message.equals("unauthorized")) {
      return 401;
    } else if (message.equals("already taken")) {
      return 403;
    } else if( message.equals("server Error")){
      return 500;
    } else{
      return 200;
    }
  }
}
