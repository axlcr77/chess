package Service;

import Request.RegisterRequest;
import Response.RegisterReponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.UserDAO;

import javax.xml.crypto.Data;
import java.util.UUID;

/**
 * Service call to register a new user to the database
 */

public class RegisterService {
  /**
   * Call to register a new user to the database
   * @param request request to register a new user
   * @return response to the request
   */
  public RegisterReponse register(RegisterRequest request){
    AuthDAO authDAO = new AuthDAO();
    UserDAO userDAO =  new UserDAO();
    String uuid =UUID.randomUUID().toString();

    try{
      //401 Error
      if(request.getUsername() == null || request.getPassword() == null || request.getEmail() == null){
        return new RegisterReponse("bad request");

        //403 Error
        //Maybe add email
      } else if(userDAO.getUser(request.getUsername())!= null){
        return new RegisterReponse("already taken");

        //success
      } else if (userDAO.getUser(request.getUsername()) ==null) {
        return new RegisterReponse(userDAO.CreateUser(request.getUsername(), request.getPassword(), request.getEmail()),
                authDAO.CreateToken(uuid, request.getUsername()));
      }

    }catch (DataAccessException e ){
      return new RegisterReponse("server Error");
    }
    return null;
  }

}
