package Response;

/**
 * Response to the request of joining a game
 */

public class JoinGameResponse {
  /**
   * message about the status of the join game request
   */
  private String message;

  /**
   * Constructor for the response for the request to join a game
   * @param message status of the request
   */
  public JoinGameResponse(String message) {
    this.message=message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message=message;
  }
}
