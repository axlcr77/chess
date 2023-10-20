package Service;

import Response.LogoutResponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;

/**
 * Service call to log out
 */

public class LogoutService {
  /**
   * Call to log-out
   * @return response to the request
   */
  public LogoutResponse logout(String authToken){
    AuthDAO authDAO = new AuthDAO();
    try {
      if(authToken == null || authDAO.GetToken(authToken) == null){
        //401 Error
        return new LogoutResponse("unauthorized");
      }
      //Add success response
      if(authDAO.GetToken(authToken) != null){
        return null;
      }
      //A data access exception would mean a server issue aka response status of 500
    } catch (DataAccessException e) {
      return new LogoutResponse("Server Error");
    }
    return new LogoutResponse("Server Error");
  }
}
