package Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Response to the request of listing the existing games in the database
 */

public class ListGamesResponse {
  /**
   * Set to contain all the games in the database
   */
  private Set<String> games = new HashSet<>();

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
   * Message about the status of the request
   */
  private String message;


  /**
   * Constructor for the response to the request to List games
   * @param games Set of games in the database
   * @param gameID ID of the game
   * @param whiteUsername name of the user with the white pieces
   * @param blackUsername name of the user with the black pieces
   * @param gameName name of the game
   * @param message message about the status of the request
   */
  public ListGamesResponse(Set<String> games, int gameID, String whiteUsername, String blackUsername, String gameName, String message) {
    this.games=games;
    this.gameID=gameID;
    this.whiteUsername=whiteUsername;
    this.blackUsername=blackUsername;
    this.gameName=gameName;
    this.message=message;
  }

  public Set<String> getGames() {
    return games;
  }

  public void setGames(Set<String> games) {
    this.games=games;
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

  public String getGameName() {
    return gameName;
  }

  public void setGameName(String gameName) {
    this.gameName=gameName;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message=message;
  }
}
