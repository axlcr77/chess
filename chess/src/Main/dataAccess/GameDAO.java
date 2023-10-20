package dataAccess;

import Models.GameModel;
import chess.ChessGame;

/**
 * Game class to access the database
 */

public class GameDAO {

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
    return null;
  }

  /**
   * Get a game from the database with a gameID
   * @param gameID ID of the game
   * @throws DataAccessException Invalid gameID
   * @return desired game
   */
  public GameModel GetGame (int gameID)throws DataAccessException {
    return null;
  }

  /**
   * Update an existing game
   * @param game Game to update the existing game with
   * @param gameID ID of the game
   * @throws DataAccessException One or more invalid parameter(s)
   * @return Updated game
   */
  public GameModel UpdateGame(ChessGame game, int gameID)throws DataAccessException{
    return null;
  }

  /**
   * Delete a game from the database with a game ID
   * @param gameID  ID of the game
   * @throws DataAccessException Invalid gameID
   * @return whether the game was deleted.
   */
  public boolean DeleteGame (int gameID) throws DataAccessException{
    return false;
  }

  /**
   * Return all the games in the database
   */
  public void GetAllGames (){

  }

  /**
   * Deletes all the games from the database
   */
  public void ClearAllGames(){
  }

  /**
   * Claims white or black pieces for the game
   * @param username name of the user
   * @param color desired color
   * @return whether the spot was claimed or not.
   */
  public boolean ClaimSpot(String username, ChessGame.TeamColor color){
    return false;
  }
}
