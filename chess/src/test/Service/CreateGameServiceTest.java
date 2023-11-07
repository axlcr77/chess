package Service;

import Models.GameModel;
import Request.CreateGameRequest;
import Response.ClearApplicationResponse;
import Response.CreateGameResponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreateGameServiceTest {
  private CreateGameService service;
  private GameDAO gameDAO;
  private AuthDAO authDAO;
  private CreateGameRequest request;




  @BeforeEach
  void setup(){
    service = new CreateGameService();
    gameDAO = new GameDAO();
    authDAO = new AuthDAO();
    request = new CreateGameRequest("testGame");
  }

  @AfterEach
  void cleanUP() throws DataAccessException {
    gameDAO.ClearAllGames();
    authDAO.ClearTokens();
  }

  @Test
  @DisplayName("Positive Create game")
  void PositiveCreateGame() throws DataAccessException {
//    GameDAO gameDAO = new GameDAO();
    String token = authDAO.CreateToken("la","Shabu");
//    gameDAO.CreateGame(1,null,null,null,null);
    CreateGameResponse response = service.CreateGame(request,token);
    assertNotEquals("unauthorized error",response.getMessage());
    assertNotEquals("bad request error", response.getMessage());
    assertNotNull(gameDAO.GetAllGames());
  }

  @Test
  @DisplayName("Fail Create game")
  void FalseCreateGame() throws DataAccessException {
    GameDAO gameDAO = new GameDAO();

    //No parameters means an empty set
    gameDAO.CreateGame();

    Set<GameModel> set = new HashSet<>();
    assertIterableEquals(set, gameDAO.GetAllGames());
  }
}