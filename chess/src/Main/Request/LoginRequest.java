package Request;

/**
 * Request to login
 */
public class LoginRequest {

  /**
   * Name of the user
   */
  private String username;

  /**
   * Password for the user
   */
  private String password;

  /**
   * Constructor for the request to log in
   * @param username name of the user to log in
   * @param password password for the user to log in
   */
  public LoginRequest(String username, String password) {
    this.username=username;
    this.password=password;
  }

  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username=username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password=password;
  }
}
