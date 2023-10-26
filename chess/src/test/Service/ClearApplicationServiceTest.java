package Service;

import Response.ClearApplicationResponse;
import dataAccess.DataAccessException;
import dataAccess.GameDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClearApplicationServiceTest {

  @Test
  void clearApp() throws DataAccessException {
    GameDAO gameDAO = new GameDAO();
    ClearApplicationService service = new ClearApplicationService();
    gameDAO.CreateGame(1,null,null,null,null);
    ClearApplicationResponse response = service.clearApp();


    assertNull(response.getMessage());
    assertNull(gameDAO.getGame(1));
  }
}