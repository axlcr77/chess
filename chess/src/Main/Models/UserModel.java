package Models;

/**
 *Information about the user such as, name, password, and email.
 */

public class UserModel {
  /**
   * Name of the user
   */
  private String username;
  /**
   * Password associated with the user
   */
  private String password;
  /**
   * Email associated with the user and password
   */
  private String email;

  public UserModel(String username, String password, String email) {
    this.username=username;
    this.password=password;
    this.email=email;
  }

  public UserModel(String username, String password) {
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email=email;
  }
}
