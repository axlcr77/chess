package Request;

/**
 * Request to add a user to the database
 */

public class RegisterRequest {

  /**
   * Name of the user
   */
  private String username;

  /**
   * password associated with the username
   */
  private String password;

  /**
   * email associated with the username and password
   */
  private String email;

  /**
   * Constructor for the request to register a new user
   * @param username name for the new user
   * @param password password for the new user
   * @param email email for the new user
   */

  public RegisterRequest(String username, String password, String email) {
    this.username=username;
    this.password=password;
    this.email=email;
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


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email=email;
  }
}
