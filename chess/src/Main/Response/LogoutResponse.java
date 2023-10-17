package Response;

/**
 * Response to the request to logout
 */

public class LogoutResponse {
  /**
   * Status of the request
   */
  private String message;

  /**
   * Constructor for the response about the request to log-out
   * @param message status of the request
   */
  public LogoutResponse(String message) {
    this.message=message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message=message;
  }
}
