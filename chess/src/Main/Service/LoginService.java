package Service;

import Models.AuthTokenModel;
import Request.LoginRequest;
import Response.LoginResponse;
import dataAccess.AuthDAO;

import java.util.UUID;

/**
 * Service call to log in
 */

public class LoginService {
  /**
   * Call to login
   * @param request request to login
   * @return response to the request
   */
    public LoginResponse login(LoginRequest request) {
      //Create Auth token if there is a user with the given password.
      //UUID is just the token ID
      //Auth token model will have the username provided by the request and the UUID will give the string for that auth token
      AuthDAO authDAO = new AuthDAO();
//      if(authDAO.GetToken() == null);
      String uuid =UUID.randomUUID().toString();

      return null;
    }

}
