package dataAccess;

import Models.AuthTokenModel;
import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;
import java.sql.DriverManager;

/**
 * Authorization class to access the database
 */

public class AuthDAO {
//  private static Map<String,AuthTokenModel> AuthTokenMap = new TreeMap<>();

  public Connection conect() throws DataAccessException {
    return Database.getConnection();
  }

  public void CloseConnection(Connection connection) throws DataAccessException{
    Database.closeConnection(connection);
  }
  /**
   * Creates a new Token into the database
   * @param token name of the token
   * @param username username to which the token belongs to
   * @throws DataAccessException Invalid token or username
   * @return the new token that was created
   */
  public String CreateToken (String token, String username) throws DataAccessException{
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("INSERT INTO auth (token, username) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1,token);
      preparedStatement.setString(2,username);

      preparedStatement.executeUpdate();
      return token;
    }
    catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }


//    AuthTokenModel authTokenModel = new AuthTokenModel(token,username);
//    if(AuthTokenMap.containsKey(token)){
//      return null;
//    }else{
//      AuthTokenMap.put(token,authTokenModel);
//      return token;
//    }

  }

  /**
   * Reads a token from the database
   * @param token name of the token
   * @throws DataAccessException Invalid token or username
   * @return the token that was specified
   */
  public AuthTokenModel GetToken (String token)throws DataAccessException{
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("SELECT * FROM auth WHERE token=?");
      preparedStatement.setString(1,token);
      try(var rs = preparedStatement.executeQuery()){
        if(rs.next()){
          var Token = rs.getString("token");
          var username  = rs.getString("username");
          return new AuthTokenModel(Token,username);
        }else{
          return null;
        }
      }
    } catch (SQLException e) {
      return null;
    }

//
//    //Check that this should return the correct thing
//    return AuthTokenMap.getOrDefault(token, null);
  }


  /**
   * Delete an existing token
   * @param token name of the token
   * @throws DataAccessException Invalid token or username
   */

  public void DeleteToken (String token)throws DataAccessException{
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("DELETE FROM auth WHERE token=?");
      preparedStatement.setString(1,token);
      preparedStatement.executeUpdate();
      CloseConnection(connection);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

//    if(AuthTokenMap.containsKey(token)){
//      AuthTokenMap.remove(token);
//      return true;
//    }
//    return false;
  }

  public void ClearTokens() throws DataAccessException{
    try{
      Connection connection= conect();
      var preparedStatement = connection.prepareStatement("TRUNCATE auth");

      preparedStatement.executeUpdate();
      CloseConnection(connection);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
//    AuthTokenMap.clear();
  }
}
