package Service;

import Models.GameModel;
import Response.ListGamesResponse;
import chess.ChessGameImp;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListGamesServiceTest {
  private GameDAO gameDAO;
  private ListGamesService service;
  private AuthDAO authDAO;

  @BeforeEach
  void setup() throws DataAccessException {
    gameDAO  = new GameDAO();
    service = new ListGamesService();
    authDAO = new AuthDAO();
    gameDAO.ClearAllGames();
    authDAO.ClearTokens();
  }

  @AfterEach
  void cleanup() throws DataAccessException {
    gameDAO.ClearAllGames();
    authDAO.ClearTokens();
  }

  @Test
  @DisplayName("Positive List Games service")
  public void PositiveListGames() throws DataAccessException {
//    GameDAO gameDAO =  new GameDAO();
//    AuthDAO authDAO = new AuthDAO();

    //This is more like a DAO test than a service test
    String token1 = authDAO.CreateToken("h","sir");
    GameModel game1=gameDAO.CreateGame(1,"sir",null,"hi",null);
    GameModel game2 =gameDAO.CreateGame(2,null,"mr","bye",null);
    GameModel game3 =gameDAO.CreateGame(3,null,"mr","bye",null);

    Set<GameModel> GamesSet = new HashSet<>();
    GamesSet.add(game1);
    GamesSet.add(game2);
    GamesSet.add(game3);
    assertIterableEquals(GamesSet,gameDAO.GetAllGames());
  }

  @Test
  @DisplayName("False List Games Service")
  void FalseListGames(){
//    ListGamesService service = new ListGamesService();
    ListGamesResponse response = service.ListGames("not Me");

    assertEquals("unauthorized error",response.getMessage());

  }
}