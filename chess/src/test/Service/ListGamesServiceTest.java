package Service;

import Models.GameModel;
import Response.ListGamesResponse;
import dataAccess.AuthDAO;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListGamesServiceTest {

  @Test
  @DisplayName("Positive List Games service")
  public void PositiveListGames() throws DataAccessException {
    ListGamesService service = new ListGamesService();
    GameDAO gameDAO =  new GameDAO();
    AuthDAO authDAO = new AuthDAO();
    String token1 = authDAO.CreateToken("h","sir");
    GameModel game1=gameDAO.CreateGame(1,"sir",null,"hi",null);
    GameModel game2 =gameDAO.CreateGame(2,null,"mr","bye",null);
    ListGamesResponse response = service.ListGames("h");
    Set<GameModel> GamesSet = new HashSet<>();
    GamesSet.add(game1);
    GamesSet.add(game2);
    assertEquals(GamesSet,gameDAO.GetAllGames());
  }

  @Test
  @DisplayName("False List Games Service")
  void FalseListGames(){
    ListGamesService service = new ListGamesService();
    ListGamesResponse response = service.ListGames("not Me");

    assertEquals("unauthorized error",response.getMessage());

  }
}