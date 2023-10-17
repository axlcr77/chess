package Models;

/**
 * Information about authorization tokens
 */

public class AuthTokenModel {
  /**
   * Name of the token
   */
  private String authToken;

  /**
   * Username associated with the token
   */
  private String username;


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
