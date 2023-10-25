package Service;

import Response.ListGamesResponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;

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
  public ListGamesResponse ListGames (String Authtoken){
    AuthDAO authDAO = new AuthDAO();
    GameDAO gameDAO = new GameDAO();
    try{
      //Checking for error 401
      if(Authtoken == null || authDAO.GetToken(Authtoken) == null){
        return new ListGamesResponse("unauthorized");
        //Success case 200
      }else if(authDAO.GetToken(Authtoken) != null){
        return new ListGamesResponse(gameDAO.GetAllGames(),null);
      }
      //Catch is for error 500
    }catch (DataAccessException e){
      return new ListGamesResponse("server Error");
    }
    return null;
  }
}
