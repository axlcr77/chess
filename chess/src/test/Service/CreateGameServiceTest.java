package Service;

import Models.GameModel;
import Response.ClearApplicationResponse;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreateGameServiceTest {

  @Test
  @DisplayName("Positive Create game")
  void PositiveCreateGame() throws DataAccessException {
    GameDAO gameDAO = new GameDAO();
    gameDAO.CreateGame(1,null,null,null,null);
    assertNotNull(gameDAO.GetAllGames());
  }

  @Test
  @DisplayName("Fail Create game")
  void FalseCreateGame() throws DataAccessException {
    GameDAO gameDAO = new GameDAO();

    //No parameters means an empty set
    gameDAO.CreateGame();

    Set<GameModel> set = new HashSet<>();
    assertEquals(set,gameDAO.GetAllGames());
  }
}