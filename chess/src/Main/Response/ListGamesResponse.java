package Response;

import Models.GameModel;

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
  private Set<GameModel> games = new HashSet<>();

  /**
   * Message about the status of the request
   */
  private String message;


  /**
   * Constructor for the response to the request to List games
   * @param games Set of games in the database

   * @param message message about the status of the request
   */
  public ListGamesResponse(Set<GameModel> games, String message) {
    this.games = games;
    this.message=message;
  }
  public ListGamesResponse(String message){
    this.message = message;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message=message;
  }
}
