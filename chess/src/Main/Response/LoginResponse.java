package Response;

/**
 * Response to the request to login
 */

public class LoginResponse {
  /**
   * status of the request
   */
  private String message;

  /**
   * authorization token given
   */
  private String authToken;

  /**
   * name of the user
   */
  private String username;


  /**
   * Constructor for the response to the request to login
   * @param message status of the request
   * @param authToken authorization token given
   * @param username name of the user
   */
  public LoginResponse(String message, String authToken, String username) {
    this.message=message;
    this.authToken=authToken;
    this.username=username;
  }

  public LoginResponse(String message){
    this.message = message;
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
