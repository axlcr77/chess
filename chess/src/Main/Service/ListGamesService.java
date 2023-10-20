package Service;

import Response.ListGamesResponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;

import java.util.HashSet;
import java.util.Set;

/**
 * Service call to list all the existing games in the database
 */
public class ListGamesService {



  /**
   * Call to list the games from the database

   * @return response to the request
   */
  public ListGamesResponse ListGames (String Authtoken) throws DataAccessException {
    AuthDAO authDAO = new AuthDAO();
    String tokenString = authDAO.GetToken(Authtoken);
    try{
      //Checking for error 401
      if(Authtoken == null || tokenString == null){
        return new ListGamesResponse("unauthorized");
        //Success case
      }else if(authDAO.GetToken(Authtoken) != null){
        return null;
      }
      //Catch is for error 500
    }catch (DataAccessException e){
      return new ListGamesResponse("sever issue");
    }
    return null;
  }
}
