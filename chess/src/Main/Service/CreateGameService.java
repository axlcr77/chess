package Service;

import Models.GameModel;
import Request.CreateGameRequest;
import Response.CreateGameResponse;
import chess.ChessGameImp;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;
import dataAccess.UserDAO;

/**
 * Service call to create a new game in the database
 */

public class CreateGameService {
  /**
   * Create a new game call to the database
   * @param request request to create a game into the database
   * @return the response of the request
   */
  public CreateGameResponse CreateGame(CreateGameRequest request, String authToken){
    AuthDAO authDAO = new AuthDAO();
    GameDAO gameDAO = new GameDAO();
    try{
      //Error 401
      if(authDAO.GetToken(authToken) == null){
        return new CreateGameResponse("unauthorized error");

        //Error 400
      } else if (request.getGameName() == null) {
        return new CreateGameResponse("bad request error");

      //Success
      } else if (request.getGameName() != null && authDAO.GetToken(authToken) != null) {
        //Create a game before returning null. This method is in charge of adding this game to the database/data structure
        //Create a way to track amount of map and assign that as the gameID
        System.out.printf("token: %s, username: %s \n",authToken,authDAO.GetToken(authToken).getUsername());
        int gameID =gameDAO.getMapSize_And_increase()+1;
        gameDAO.CreateGame(gameID,null, null
                ,request.getGameName(),new ChessGameImp());
        return new CreateGameResponse(null, gameID);
      }
      //Error 500
    }catch (DataAccessException e){
      return new CreateGameResponse("server Error");
    }
    return null;
  }
}
