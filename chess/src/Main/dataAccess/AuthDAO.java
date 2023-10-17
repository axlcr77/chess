package dataAccess;

import Models.AuthTokenModel;

/**
 * Authorization class to access the database
 */

public class AuthDAO {

  /**
   * Creates a new Token into the database
   * @param token name of the token
   * @param username username to which the token belongs to
   * @throws DataAccessException Invalid token or username
   * @return the new token that was created
   */
  AuthTokenModel CreateToken (String token, String username) throws DataAccessException{
    return null;
  }

  /**
   * Reads a token from the database
   * @param token name of the token
   * @param username username associated with the token
   * @throws DataAccessException Invalid token or username
   * @return the token that was specified
   */
  AuthTokenModel GetToken (String token, String username)throws DataAccessException{
    return null;
  }

  /**
   * Update an existing token
   * @param token name of the token
   * @param username username associated with the token
   * @throws DataAccessException Invalid token or username
   * @return the updated token
   */

  AuthTokenModel UpdateToken (String token, String username)throws DataAccessException{
    return null;
  }

  /**
   * Delete an existing token
   * @param token name of the token
   * @param username username associated with the token
   * @throws DataAccessException Invalid token or username
   * @return whether the token was deleted or not.
   */

  boolean DeleteToken (String token, String username)throws DataAccessException{
    return false;
  }
}
