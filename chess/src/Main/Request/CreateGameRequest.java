package Request;

/**
 * Request to create a game
 */

public class CreateGameRequest {
  private String gameName;

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
}
