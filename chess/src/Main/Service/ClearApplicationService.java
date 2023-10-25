package Service;

import Response.ClearApplicationResponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;
import dataAccess.UserDAO;

/**
 * Service call to clear the database
 */

public class ClearApplicationService {

  /**
   * Clear application call to the database
   * @return the response for the request to clear the application
   */
  public ClearApplicationResponse clearApp(){
    AuthDAO authDAO = new AuthDAO();
    UserDAO userDAO = new UserDAO();
    GameDAO gameDAO = new GameDAO();

    try{
      authDAO.ClearTokens();
      userDAO.ClearUsers();
      gameDAO.ClearAllGames();
    }catch (DataAccessException e){
      return new ClearApplicationResponse("server Error");
    }

    //This is success
    return new ClearApplicationResponse(null);
  }
}
