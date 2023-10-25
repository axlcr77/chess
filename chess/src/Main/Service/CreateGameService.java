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
      if(authToken == null || authDAO.GetToken(authToken) == null){
        return new CreateGameResponse("unauthorized");

        //Error 400
      } else if (gameDAO.getGame(request.getGameID()) == null) {
        return new CreateGameResponse("bad request");


      //Success
      } else if (gameDAO.getGame(request.getGameID()) != null && authDAO.GetToken(authToken) != null) {
        //Create a game before returning null. This method is in charge of adding this game to the database/data structure
        gameDAO.CreateGame(request.getGameID(), request.getWhiteUsername(), request.getBlackUsername()
                ,request.getGameName(),new ChessGameImp());
        return new CreateGameResponse(null, request.getGameID());
      }
      //Error 500
    }catch (DataAccessException e){
      return new CreateGameResponse("server Error");
    }
    return null;
  }
}
