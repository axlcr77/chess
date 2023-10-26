package Response;

/**
 * Response to the request of Creating a new game in the database
 */

public class CreateGameResponse {

  /**
   * Message about the status for the request to create a game
   */
  private String message;

  /**
   * ID for the game
   */
  private Integer gameID = null;

  /**
   * Constructor for the Response to the create game request
   * @param message Status of the request
   * @param gameID ID of the game
   */
  public CreateGameResponse(String message, int gameID) {
    this.message=message;
    this.gameID=gameID;
  }
  public CreateGameResponse(String message){
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message=message;
  }

  public int getGameID() {
    return gameID;
  }

  public void setGameID(Integer gameID) {
    this.gameID=gameID;
  }
}
