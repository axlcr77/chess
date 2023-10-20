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
    } else {
      return 500;
    }
  }
}
