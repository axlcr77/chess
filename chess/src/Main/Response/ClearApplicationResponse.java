package Response;




/**
 * Response to the request of Clearing the database
 */

public class ClearApplicationResponse  {
  /**
   * Message about the status of the Clear Application request
   */
  private String message;

  /**
   * Constructor for the response to the Clear Application request
   * @param message Message about the status of the request
   */
  public ClearApplicationResponse(String message) {
    this.message=message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message=message;
  }
}
