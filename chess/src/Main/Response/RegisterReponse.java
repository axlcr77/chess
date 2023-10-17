package Response;

/**
 * Response to the request to register a new user
 */

public class RegisterReponse {

  /**
   * Status of the request
   */
  private String message;

  /**
   * Authorization token given
   */
  private String authToken;
  /**
   * name of the user
   */
  private String username;

  /**
   * Constructor for the responses to the Register request
   * @param message status of the request
   * @param authToken authorization token given
   * @param username name of the user
   */
  public RegisterReponse(String message, String authToken, String username) {
    this.message=message;
    this.authToken=authToken;
    this.username=username;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message=message;
  }

  public String getAuthToken() {
    return authToken;
  }

  public void setAuthToken(String authToken) {
    this.authToken=authToken;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username=username;
  }
}
