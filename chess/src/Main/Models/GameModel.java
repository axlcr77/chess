package Models;

import chess.ChessGame;

/**
 * Information about the Game such as gameID, name of the game, etc.
 */

public class GameModel {
  //Create some data structure to put all these into one thing

  /**
   * ID of the game
   */
  private int gameID;

  /**
   * name of the user with the white pieces
   */
  private String whiteUserName;

  /**
   * name of the user with the black pieces
   */
  private String blackUserName;

  /**
   * name of the game
   */
  private String gameName;
  /**
   * The game implementation
   */
  private ChessGame game;

  public GameModel(int gameID, String whiteUserName, String blackUserName, String gameName, ChessGame game) {
    this.gameID=gameID;
    this.whiteUserName=whiteUserName;
    this.blackUserName=blackUserName;
    this.gameName=gameName;
    this.game=game;
  }

  public int getGameID() {
    return gameID;
  }



  public void setGameID(int gameID) {
    this.gameID=gameID;
  }


  public String getWhiteUserName() {
    return whiteUserName;
  }


  public void setWhiteUserName(String whiteUserName) {
    this.whiteUserName=whiteUserName;
  }


  public String getBlackUserName() {
    return blackUserName;
  }

  public void setBlackUserName(String blackUserName) {
    this.blackUserName=blackUserName;
  }

  public String getGameName() {
    return gameName;
  }

  public void setGameName(String gameName) {
    this.gameName=gameName;
  }

  public ChessGame getGame() {
    return game;
  }

  public void setGame(ChessGame game) {
    this.game=game;
  }
}
