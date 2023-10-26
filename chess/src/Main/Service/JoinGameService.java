package Service;

import Models.UserModel;
import Request.JoinGameRequest;
import Response.JoinGameResponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;

/**
 * Service call to join an existing game
 */

public class JoinGameService {
  /**
   * Join a game call
   * @param request request to join a game
   * @return response to the request
   */
  public JoinGameResponse JoinGame(JoinGameRequest request, String authToken) {
    AuthDAO authDAO=new AuthDAO();
    GameDAO gameDAO=new GameDAO();
    try {
      //Error 401 - Unauthorized (not logged in)
      if (authDAO.GetToken(authToken) == null) {
        return new JoinGameResponse("unauthorized error");

        //400 Error (Request didn't have the correct information)
      } else if (gameDAO.getGame(request.getGameID()) == null) {
        return new JoinGameResponse("bad request error");

        //Error 403 (Name is already taken)
      } else if (request.getTeamColor() != null){
        if (gameDAO.ClaimSpot(authDAO.GetToken(authToken).getUsername(), request.getTeamColor(), request.getGameID()).equals("already taken")) {
        return new JoinGameResponse("already taken error");
      }
      //Success
      } else if (gameDAO.getGame(request.getGameID()) != null && authDAO.GetToken(authToken) != null) {
        return null;
      }
    }catch (DataAccessException e){
      return new JoinGameResponse("server Error");
    }
    return null;
  }
}
