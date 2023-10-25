package Service;

import Models.AuthTokenModel;
import Request.LoginRequest;
import Response.LoginResponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.UserDAO;

import java.util.UUID;

/**
 * Service call to log in
 */

public class LoginService {
  /**
   * Call to log in
   * @param request request to login
   * @return response to the request
   */
    public LoginResponse login(LoginRequest request) {
      //Create Auth token if there is a user with the given password.
      //UUID is just the token ID
      //Auth token model will have the username provided by the request and the UUID will give the string for that auth token
      AuthDAO authDAO = new AuthDAO();
      String uuid =UUID.randomUUID().toString();
      UserDAO userDAO = new UserDAO();
      try {
        //401 Error
        if(!userDAO.verifyUser(request.getUsername(), request.getPassword())){
          return new LoginResponse("unauthorized");
        }else {
          //Success
          return new LoginResponse(null,authDAO.CreateToken(uuid, request.getUsername()), request.getUsername());
        }
      }catch (DataAccessException e){
        return new LoginResponse("server Error");
      }
    }

}
