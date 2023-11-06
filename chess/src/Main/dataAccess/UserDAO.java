package dataAccess;

import Models.UserModel;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;
import java.sql.DriverManager;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * User class to access the database
 */

public class UserDAO {
//  private static Map<String, UserModel> userModelMap = new TreeMap<>();

  public Connection conect() throws DataAccessException {
    return Database.getConnection();
  }

  /**
   * Create a new user
   * @param username name of the user
   * @param password password for the user
   * @param email email of the new user
   * @throws DataAccessException One or more invalid parameter(s)
   * @return User created
   */

  public String CreateUser(String username, String password, String email) throws DataAccessException{

    try {
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("INSERT INTO users (username, password, email) VALUES (?,?,?)", RETURN_GENERATED_KEYS);
      preparedStatement.setString(1,username);
      preparedStatement.setString(2,password);
      preparedStatement.setString(3,email);

      preparedStatement.executeUpdate();
      return username;
    }catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    } catch (SQLException e) {
      return null;
    }


//    UserModel userModel = new UserModel(username,password,email);
//    if(userModelMap.containsKey(userModel.getUsername())){
//      return null;
//    }else {
//      userModelMap.put(userModel.getUsername(),userModel);
//      return userModel;
//    }
  }


  /**
   * Get a user from the database
   * @param username name of the user
   * @throws DataAccessException invalid username
   * @return Desired user
   */
  public UserModel getUser(String username) throws DataAccessException{
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("SELECT username, password, email FROM users WHERE username=? ");

      preparedStatement.setString(1,username);

//      preparedStatement.executeUpdate();
      try (var rs = preparedStatement.executeQuery()){
        if(rs.next()){
        var user = rs.getNString("username");
        var pass= rs.getNString("password");
        var email = rs.getNString("email");
//        System.out.printf("username: %s, password: %s, email: %s", user, pass, email);
          return new UserModel(username,pass,email);
        }else{
          return null;
        }
      }
    }catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return null;
    }


//    if(userModelMap.containsKey(username)){
//      return userModelMap.get(username);
//    }
//    return null;
  }

  /**
   * Delete an existing user from the database
   * @param username name of the user to delete
   * @param password password of the user
   * @throws DataAccessException One or more invalid parameter(s)
   */
  public void DeleteUser (String username, String password) throws DataAccessException{
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("DELETE FROM users WHERE username=? password=?");

      preparedStatement.setString(1,username);
      preparedStatement.setString(2,password);
      preparedStatement.executeUpdate();
    }catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    }catch (SQLException e){
      throw new RuntimeException(e);
    }



//    if(verifyUser(username,password)){
//      userModelMap.remove(username);
//      return true;
//    }
  }

  /**
   * verifies the user using the password provided
   * @param username name of the user
   * @param password password for user
   * @return Desired user
   * @throws DataAccessException One or more invalid parameter(s)
   */
  public boolean verifyUser (String username, String password) throws DataAccessException{
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("SELECT username,password FROM users WHERE username=?");

      preparedStatement.setString(1,username);
      var resultset= preparedStatement.executeQuery();
      if(resultset.next()){
        var RealPassword = resultset.getString("password");
        if(password.equals(RealPassword)){
          return true;
        }
      }
      return false;

    } catch (SQLException e) {
      return false;
    } catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    }


//    if(userModelMap.containsKey(username)){
//      return userModelMap.get(username).getPassword().equals(password);
//    }
//    return false;
  }

  public void ClearUsers() throws DataAccessException{
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("TRUNCATE users");
      preparedStatement.executeUpdate();
    }catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    }catch (SQLException e ){
      throw new RuntimeException(e);
    }


    //Clear all the users from the database/ data structure
//    userModelMap.clear();
  }

}
