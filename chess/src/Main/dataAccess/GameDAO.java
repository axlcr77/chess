package dataAccess;

import Models.GameModel;
import chess.ChessGame;

import java.util.*;

/**
 * Game class to access the database
 */

public class GameDAO {
  private static Map<Integer, GameModel> GameDAOMap = new TreeMap<>();

  /**
   * Create a new game
   * @param gameID ID of the game
   * @param whiteUsername name for the user with the white pieces
   * @param blackUsername name for the user with the black pieces
   * @param gameName name of the game
   * @param game new game
   * @throws DataAccessException One or more invalid parameter(s)
   * @return Game that was created
   */

  public GameModel CreateGame (int gameID, String whiteUsername, String blackUsername, String gameName, ChessGame game)throws DataAccessException{
    GameModel gameModel = new GameModel(gameID,whiteUsername,blackUsername,gameName,game);
    if(GameDAOMap.containsKey(gameID)){
      return null;
    }else {
      GameDAOMap.put(gameID,gameModel);
      return gameModel;
    }
  }

  /**
   * Get a game from the database with a gameID
   * @param gameID ID of the game
   * @throws DataAccessException Invalid gameID
   * @return desired game
   */
  public GameModel getGame(int gameID) throws DataAccessException{
    //if the method returns the game model then it means that the request was successful
    return GameDAOMap.getOrDefault(gameID, null);
  }

  /**
   * Update an existing game
   * @param game Game to update the existing game with
   * @param gameID ID of the game
   * @throws DataAccessException One or more invalid parameter(s)
   * @return Updated game
   */
  public GameModel UpdateGame(ChessGame game, int gameID)throws DataAccessException{
    if(GameDAOMap.containsKey(gameID)){
    GameModel gameModel = new GameModel(gameID,GameDAOMap.get(gameID).getWhiteUserName(),GameDAOMap.get(gameID).getBlackUserName(),GameDAOMap.get(gameID).getGameName()
    ,game);
      GameDAOMap.replace(gameID,gameModel);
    }
    return null;
  }

  /**
   * Delete a game from the database with a game ID
   * @param gameID  ID of the game
   * @throws DataAccessException Invalid gameID
   * @return whether the game was deleted.
   */
  public boolean DeleteGame (int gameID) throws DataAccessException{
    if(GameDAOMap.containsKey(gameID)){
      GameDAOMap.remove(gameID);
      return true;
    }
    return false;
  }

  /**
   * Return all the games in the database
   */
  public Set<GameModel> GetAllGames () throws DataAccessException{
    Set<GameModel> set = new HashSet<>();
    set.addAll(GameDAOMap.values());
    return null;
  }

  /**
   * Deletes all the games from the database
   */
  public void ClearAllGames(){
    GameDAOMap.clear();
  }

  /**
   * Claims white or black pieces for the game
   * @param username name of the user
   * @param color desired color
   * @return whether the spot was claimed or not.
   */
  public String ClaimSpot(String username, ChessGame.TeamColor color, int gameID){
    if(GameDAOMap.containsKey(gameID)){
      String whiteUser = GameDAOMap.get(gameID).getWhiteUserName();
      String blackUser = GameDAOMap.get(gameID).getBlackUserName();
      if (color == ChessGame.TeamColor.WHITE && whiteUser == null) {
      GameDAOMap.get(gameID).setWhiteUserName(username);
      return "success!";
      } else if (color == ChessGame.TeamColor.BLACK && blackUser == null) {
        GameDAOMap.get(gameID).setBlackUserName(username);
        return "success!";
      }
    }
    return "already taken";
  }
}
