package dataAccess;

import Models.UserModel;

import java.util.SplittableRandom;

/**
 * User class to access the database
 */

public class UserDAO {

  /**
   * Create a new user
   * @param username name of the user
   * @param password password for the user
   * @param email email of the new user
   * @throws DataAccessException One or more invalid parameter(s)
   * @return User created
   */

  UserModel CreateUser(String username, String password, String email) throws DataAccessException{
    return null;
  }

  /**
   * Update existing user
   * @param username name of the user to update
   * @param password password of the user
   * @throws DataAccessException One or more invalid parameter(s)
   * @return updated user
   */

  UserModel UpdateUser(String username, String password) throws DataAccessException{
    return null;
  }

  /**
   * Get a user from the database
   * @param username name of the user
   * @throws DataAccessException invalid username
   * @return Desired user
   */
  UserModel GetUser(String username) throws DataAccessException{
    return null;
  }

  /**
   * Delete an existing user from the database
   * @param username name of the user to delete
   * @param password password of the user
   * @throws DataAccessException One or more invalid parameter(s)
   * @return whether the user was deleted or not.
   */
  boolean DeleteUser (String username, String password) throws DataAccessException{
    return false;
  }

  /**
   * verifies the user using the password provided
   * @param username name of the user
   * @param password password for user
   * @return Desired user
   * @throws DataAccessException One or more invalid parameter(s)
   */
  UserModel verifyUser (String username, String password) throws DataAccessException{
    return null;
  }
}
