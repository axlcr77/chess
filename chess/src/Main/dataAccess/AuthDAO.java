package dataAccess;

import Models.AuthTokenModel;

import java.util.Map;
import java.util.TreeMap;

/**
 * Authorization class to access the database
 */

public class AuthDAO {
  private static Map<String,AuthTokenModel> AuthTokenMap = new TreeMap<>();

  /**
   * Creates a new Token into the database
   * @param token name of the token
   * @param username username to which the token belongs to
   * @throws DataAccessException Invalid token or username
   * @return the new token that was created
   */
  public String CreateToken (String token, String username) throws DataAccessException{
    AuthTokenModel authTokenModel = new AuthTokenModel(token,username);
    if(AuthTokenMap.containsKey(token)){
      return null;
    }else{
      AuthTokenMap.put(token,authTokenModel);
      return token;
    }
  }

  /**
   * Reads a token from the database
   * @param token name of the token
   * @throws DataAccessException Invalid token or username
   * @return the token that was specified
   */
  public AuthTokenModel GetToken (String token)throws DataAccessException{
    //Check that this should return the correct thing
    return AuthTokenMap.getOrDefault(token, null);
  }


  /**
   * Delete an existing token
   * @param token name of the token
   * @throws DataAccessException Invalid token or username
   * @return whether the token was deleted or not.
   */

  public boolean DeleteToken (String token)throws DataAccessException{
    if(AuthTokenMap.containsKey(token)){
      AuthTokenMap.remove(token);
      return true;
    }
    return false;
  }

  public void ClearTokens() throws DataAccessException{
    AuthTokenMap.clear();
  }
}
