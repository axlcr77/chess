package Service;

import Request.JoinGameRequest;
import Response.JoinGameResponse;
import chess.ChessGame;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoinGameServiceTest {

  @Test
  @DisplayName("Positive Join Game request")
  void PositiveJoinGameRequest() throws DataAccessException {
    GameDAO gameDAO = new GameDAO();
    AuthDAO authDAO = new AuthDAO();
    String token = authDAO.CreateToken("Hello","sir");
    gameDAO.CreateGame(2,null,null,null,null);
    JoinGameService service = new JoinGameService();
    JoinGameRequest request = new JoinGameRequest(2, ChessGame.TeamColor.WHITE);
    JoinGameResponse response = service.JoinGame(request,token);

    //When successful my program returns null
    assertNull(response);
  }

  @Test
  @DisplayName("Negative Join Game request")
  void NegativeJoinGameRequest(){
    JoinGameService service = new JoinGameService();
    JoinGameRequest request =  new JoinGameRequest(1, ChessGame.TeamColor.WHITE);

    //Bad authToken
    JoinGameResponse response = service.JoinGame(request,"");
    assertEquals("unauthorized error",response.getMessage());

  }
}