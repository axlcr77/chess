package Models;

import chess.ChessGame;

import java.util.Objects;

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
  private String whiteUsername;

  /**
   * name of the user with the black pieces
   */
  private String blackUsername;

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
    this.whiteUsername=whiteUserName;
    this.blackUsername=blackUserName;
    this.gameName=gameName;
    this.game=game;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GameModel gameModel=(GameModel) o;
    return gameID == gameModel.gameID && Objects.equals(whiteUsername, gameModel.whiteUsername) && Objects.equals(blackUsername, gameModel.blackUsername) && Objects.equals(gameName, gameModel.gameName) && Objects.equals(game, gameModel.game);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gameID, whiteUsername, blackUsername, gameName, game);
  }

  public int getGameID() {
    return gameID;
  }



  public void setGameID(int gameID) {
    this.gameID=gameID;
  }


  public String getWhiteUserName() {
    return whiteUsername;
  }


  public void setWhiteUserName(String whiteUserName) {
    this.whiteUsername=whiteUserName;
  }


  public String getBlackUserName() {
    return blackUsername;
  }

  public void setBlackUserName(String blackUserName) {
    this.blackUsername=blackUserName;
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
