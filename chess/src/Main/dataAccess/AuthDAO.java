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
  public AuthTokenModel CreateToken (String token, String username) throws DataAccessException{
    return null;
  }

  /**
   * Reads a token from the database
   * @param token name of the token
   * @throws DataAccessException Invalid token or username
   * @return the token that was specified
   */
  public String GetToken (String token)throws DataAccessException{
    return token;
  }

  /**
   * Update an existing token
   * @param token name of the token
   * @throws DataAccessException Invalid token or username
   * @return the updated token
   */

  public AuthTokenModel UpdateToken (String token)throws DataAccessException{
    return null;
  }

  /**
   * Delete an existing token
   * @param token name of the token
   * @param username username associated with the token
   * @throws DataAccessException Invalid token or username
   * @return whether the token was deleted or not.
   */

  public boolean DeleteToken (String token, String username)throws DataAccessException{
    return false;
  }
}
