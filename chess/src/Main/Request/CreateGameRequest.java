package Request;

import chess.ChessGame;

/**
 * Request to create a game
 */

public class CreateGameRequest {
  private String gameName;
//  private String userName;
  private int gameID;
  private String whiteUsername;
  private String blackUsername;
  private ChessGame game;

  /**
   * Constructor
   * @param gameName name of the game
   */

  public CreateGameRequest(String gameName) {
    this.gameName=gameName;
  }


  public String getGameName() {
    return gameName;
  }


  public void setGameName(String gameName) {
    this.gameName=gameName;
  }

  public int getGameID() {
    return gameID;
  }

  public void setGameID(int gameID) {
    this.gameID=gameID;
  }

  public String getWhiteUsername() {
    return whiteUsername;
  }

  public void setWhiteUsername(String whiteUsername) {
    this.whiteUsername=whiteUsername;
  }

  public String getBlackUsername() {
    return blackUsername;
  }

  public void setBlackUsername(String blackUsername) {
    this.blackUsername=blackUsername;
  }

  public ChessGame getGame() {
    return game;
  }

  public void setGame(ChessGame game) {
    this.game=game;
  }

  //  public String getUserName() {
//    return userName;
//  }
//
//  public void setUserName(String userName) {
//    this.userName=userName;
//  }
}
