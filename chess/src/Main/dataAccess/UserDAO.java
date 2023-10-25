package dataAccess;

import Models.UserModel;

import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;
import java.util.TreeMap;

/**
 * User class to access the database
 */

public class UserDAO {
  private static Map<String, UserModel> userModelMap = new TreeMap<>();

  /**
   * Create a new user
   * @param username name of the user
   * @param password password for the user
   * @param email email of the new user
   * @throws DataAccessException One or more invalid parameter(s)
   * @return User created
   */

  public String CreateUser(String username, String password, String email) throws DataAccessException{
    UserModel userModel = new UserModel(username,password,email);
    if(userModelMap.containsKey(userModel.getUsername())){
      return null;
    }else {
      userModelMap.put(userModel.getUsername(),userModel);
      return "Success!";
    }
  }


  /**
   * Get a user from the database
   * @param username name of the user
   * @throws DataAccessException invalid username
   * @return Desired user
   */
  public UserModel getUser(String username) throws DataAccessException{
    if(userModelMap.containsKey(username)){
      return userModelMap.get(username);
    }
    return null;
  }

  /**
   * Delete an existing user from the database
   * @param username name of the user to delete
   * @param password password of the user
   * @throws DataAccessException One or more invalid parameter(s)
   * @return whether the user was deleted or not.
   */
  public boolean DeleteUser (String username, String password) throws DataAccessException{
    if(verifyUser(username,password)){
      userModelMap.remove(username);
      return true;
    }
    return false;
  }

  /**
   * verifies the user using the password provided
   * @param username name of the user
   * @param password password for user
   * @return Desired user
   * @throws DataAccessException One or more invalid parameter(s)
   */
  public boolean verifyUser (String username, String password) throws DataAccessException{
    if(userModelMap.containsKey(username)){
      return userModelMap.get(username).getPassword().equals(password);
    }
    return false;
  }

  public void ClearUsers() throws DataAccessException{
    //Clear all the users from the database/ data structure
    userModelMap.clear();
  }

}
