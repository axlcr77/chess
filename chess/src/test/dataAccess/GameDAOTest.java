package dataAccess;

import Models.GameModel;
import chess.ChessBoardImp;
import chess.ChessGame;
import chess.ChessGameImp;
import chess.ChessPiece;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameDAOTest {

  private GameDAO gameDAO;

  @BeforeEach
  void setup()throws DataAccessException{
    gameDAO= new GameDAO();
    gameDAO.ClearAllGames();
  }


  @AfterEach
  void cleanup()throws DataAccessException{
    gameDAO.ClearAllGames();
  }


  @Test
  @DisplayName("Valid Game Creation")
  void valid_CreateGame() throws DataAccessException {
    GameModel game =gameDAO.CreateGame(1,"paul","saul","Battle for the ages", new ChessGameImp());
    assertNotNull(gameDAO.GetAllGames());
    assertEquals("paul",game.getWhiteUserName());
    assertEquals("saul", game.getBlackUserName());
    assertEquals("Battle for the ages",game.getGameName());
  }

  @Test
  @DisplayName("Invalid Game Creation")
  void invalid_createGame()throws DataAccessException{
    gameDAO.CreateGame(1,null,"siri",null,new ChessGameImp());

    //Game with no name will not be added to the data base
    Set<GameModel> set = new HashSet<>();

    //An empty set will be returned instead.
    assertEquals(set,gameDAO.GetAllGames());
  }

  @Test
  @DisplayName("Valid Game Fetch")
  void valid_getGame() throws DataAccessException {
    GameModel game = gameDAO.CreateGame(3,"sus",null,"among us",new ChessGameImp());
    GameModel getgame = gameDAO.getGame(3);
    assertEquals(getgame.getGameName(),game.getGameName());
  }

  @Test
  @DisplayName("Invalid Game Fetch")
  void invalid_getGame()throws DataAccessException{
    //A game that doesn't exist will return null when called
    assertNull(gameDAO.getGame(3));
  }

  @Test
  @DisplayName("Valid Update Game")
  void valid_updateGame() throws DataAccessException{
    GameModel game1 = gameDAO.CreateGame(2,null,"Artemis","Sly",null);
//    GameModel getgame = gameDAO.getGame(2);
    ChessGameImp ChessGame = new ChessGameImp();
//    ChessBoardImp chessBoardImp = new ChessBoardImp();
//    chessBoardImp.resetBoard();
//    ChessGame.setBoard(chessBoardImp);
    gameDAO.UpdateGame(ChessGame,2);
////    GameModel gameModel = gameDAO.getGame(2);
//   assertNotEquals(getgame.getGame(),game1.getGame());
    assertNotNull(gameDAO.getGame(2).getGame());
  }


  @Test
  @DisplayName("Invalid Update")
  void invalid_updateGame() throws DataAccessException {
    GameModel game1 = gameDAO.CreateGame(2,"T","Jul","mo",null);

    //Invalid ID
    gameDAO.UpdateGame(new ChessGameImp(),5);

    assertNull(game1.getGame());
  }




  @Test
  @DisplayName("Valid Game deletion")
  void valid_deleteGame()throws DataAccessException {
    gameDAO.CreateGame(1, "kuai","bi","MK",new ChessGameImp());
    gameDAO.DeleteGame(1);

    Set<GameModel> set = new HashSet<>();

    //Empty set means that the game was successfully deleted
    assertEquals(set,gameDAO.GetAllGames());
  }

  @Test
  @DisplayName("Invalid Game deletion")
  void invalid_deleteGame()throws DataAccessException {
    gameDAO.CreateGame(1, "kuai","bi","MK",new ChessGameImp());
    gameDAO.DeleteGame(3);

    Set<GameModel> set = new HashSet<>();

    //Empty set and set containing a game due to bad game ID
    assertNotEquals(set,gameDAO.GetAllGames());
  }


  @Test
  void getAllGames()throws DataAccessException {
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
  void clearAllGames() throws DataAccessException{
    GameModel game1 =gameDAO.CreateGame(1, "kuai","bi","MK",new ChessGameImp());
    GameModel game2 =gameDAO.CreateGame(2, "raiden","liu","MK1",new ChessGameImp());
    gameDAO.ClearAllGames();

    Set<GameModel> set = new HashSet<>();

    assertEquals(set,gameDAO.GetAllGames());

  }

  @Test
  @DisplayName("Correctly Claming a spot")
  void True_claimSpot()throws DataAccessException {
    gameDAO.CreateGame(2,null,"lee","240",new ChessGameImp());
    gameDAO.ClaimSpot("bluey", ChessGame.TeamColor.WHITE,2);
    assertNotNull(gameDAO.getGame(2).getWhiteUserName());
  }
  @Test
  @DisplayName("Incorrectly Claming a spot")
  void false_claimSpot()throws DataAccessException {
    GameModel gameModel = gameDAO.CreateGame(4,"good","better","best", new ChessGameImp());
    gameDAO.ClaimSpot("Really Bad", ChessGame.TeamColor.BLACK, 4);

    assertEquals("good",gameDAO.getGame(4).getWhiteUserName());
  }
}