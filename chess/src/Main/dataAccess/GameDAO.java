package dataAccess;

import Models.GameModel;
import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessGameImp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Game class to access the database
 */

public class GameDAO {
//  private static Map<Integer, GameModel> GameDAOMap = new TreeMap<>();
//  private static int mapSize =1;
  public Connection conect() throws DataAccessException {
    return Database.getConnection();
  }
  public void closeConnection(Connection connection) throws DataAccessException{
     Database.closeConnection(connection);
  }

  /**
   * Create a new game
   * @param gameID ID of the game
   * @param whiteUsername name for the user with the white pieces
   * @param blackUsername name for the user with the black pieces
   * @param gameName name of the game
   * @param game new game
   * @throws DataAccessException One or more invalid parameter(s)
   * @return Game that was created
   */

  public GameModel CreateGame (int gameID, String whiteUsername, String blackUsername, String gameName, ChessGame game)throws DataAccessException{
    Gson gson = new Gson();
    String JsonGame = gson.toJson(game);
      try {
        Connection connection = conect();
        var preparedStatement = connection.prepareStatement("INSERT INTO chess (gameid, gameName, white_UserName, black_UserName, game) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,gameID);
        preparedStatement.setString(2,gameName);
        preparedStatement.setString(3,whiteUsername);
        preparedStatement.setString(4,blackUsername);
        preparedStatement.setString(5,JsonGame);
        preparedStatement.executeUpdate();

//        var resultSet = preparedStatement.getGeneratedKeys();
//        var ID = 0;
//        if(resultSet.next()){
//          ID = resultSet.getInt(1);
//        }

        try(var prepStatement = connection.prepareStatement("Select game FROM chess WHERE gameid=?")) {
          prepStatement.setInt(1, gameID);
          try (var rs=prepStatement.executeQuery()) {
            if (rs.next()) {
              var json=rs.getString("game");
              var builder=new GsonBuilder();
              builder.registerTypeAdapter(ChessBoard.class, new ChessAdapter());
              var gameFromJson=builder.create().fromJson(json, ChessGameImp.class);
              closeConnection(connection);
              return new GameModel(gameID, whiteUsername, blackUsername, gameName, gameFromJson);
            }
          }
        }
      }catch (DataAccessException e){
        throw new DataAccessException(e.getMessage());
      } catch (SQLException e) {
        return null;
      }



//    GameModel gameModel = new GameModel(gameID,whiteUsername,blackUsername,gameName,game);
//    if(GameDAOMap.containsKey(gameID)){
//      return null;
//    }else {
//      GameDAOMap.put(gameID,gameModel);
//      return gameModel;
//    }
    return null;
  }

  /**
   * Get a game from the database with a gameID
   * @param gameID ID of the game
   * @throws DataAccessException Invalid gameID
   * @return desired game
   */
  public GameModel getGame(int gameID) throws DataAccessException{

    Gson gson = new Gson();
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("SELECT * FROM chess WHERE gameid=?");
      preparedStatement.setInt(1,gameID);
      try(var rs = preparedStatement.executeQuery()){
          if(rs.next()){
            //Type adapters
          var gameid = rs.getInt("gameid");
          var gameName = rs.getString("gameName");
          var whiteUsername = rs.getString("white_UserName");
          var blackUsername = rs.getString("black_UserName");
          var game = rs.getString("game");

          var json=rs.getString("game");
          var builder=new GsonBuilder();
          builder.registerTypeAdapter(ChessBoard.class, new ChessAdapter());
          var gameFromJson=builder.create().fromJson(json, ChessGameImp.class);
          System.out.printf("Game ID: %d, Game Name: %s, white Username: %s, black Username: %s, game: %s",gameid,gameName,whiteUsername,blackUsername,game);
          return  new GameModel(gameid,whiteUsername,blackUsername,gameName,gameFromJson);
          }else {
            return null;
          }
      }

    }catch (DataAccessException e){
      throw  new DataAccessException(e.getMessage());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    //if the method returns the game model then it means that the request was successful
//    return GameDAOMap.getOrDefault(gameID, null);
  }

  /**
   * Update an existing game
   * @param game Game to update the existing game with
   * @param gameID ID of the game
   * @throws DataAccessException One or more invalid parameter(s)
   */
  public void UpdateGame(ChessGame game, int gameID)throws DataAccessException{
    Gson gson = new Gson();
    String JSonGame = gson.toJson(game);
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("UPDATE chess SET game=? WHERE gameid=?");

      preparedStatement.setString(1,JSonGame);
      preparedStatement.setInt(2,gameID);

      preparedStatement.executeUpdate();

    }catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

//    if(GameDAOMap.containsKey(gameID)){
//    GameModel gameModel = new GameModel(gameID,GameDAOMap.get(gameID).getWhiteUserName(),GameDAOMap.get(gameID).getBlackUserName(),GameDAOMap.get(gameID).getGameName()
//    ,game);
//      GameDAOMap.replace(gameID,gameModel);
//    }
//    return null;
  }

  /**
   * Delete a game from the database with a game ID
   * @param gameID  ID of the game
   * @throws DataAccessException Invalid gameID
   */
  public void DeleteGame (int gameID) throws DataAccessException{
    try{
      Connection connection = conect();
      var preparedStatement= connection.prepareStatement("DELETE FROM chess WHERE gameid=?");
      preparedStatement.setInt(1,gameID);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    }


//    if(GameDAOMap.containsKey(gameID)){
//      GameDAOMap.remove(gameID);
//      return true;
//    }
//    return false;
  }

  /**
   * Return all the games in the database
   */
  public Set<GameModel> GetAllGames () throws DataAccessException{
    Gson gson = new Gson();
    Set<GameModel> set = new HashSet<>();
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("SELECT * FROM chess");

      //Maybe deserialize the games and put them into a gamemodel so I can add them to a set?
      try(var rs = preparedStatement.executeQuery()) {
        while (rs.next()){
          var gameid = rs.getInt("gameid");
          var gameName = rs.getString("gameName");
          var whiteUsername = rs.getString("white_UserName");
          var blackUsername = rs.getString("black_UserName");
          var game = rs.getString("game");
          System.out.printf("Game ID: %d, Game Name: %s, white Username: %s, black Username: %s, game: %s",gameid,gameName,whiteUsername,blackUsername,game);
          var json=rs.getString("game");
          var builder=new GsonBuilder();
          builder.registerTypeAdapter(ChessBoard.class, new ChessAdapter());
          var gameFromJson=builder.create().fromJson(json, ChessGameImp.class);
          GameModel gameModel = new GameModel(gameid,whiteUsername,blackUsername,gameName,gameFromJson);
          set.add(gameModel);
        }
      }
    }catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }



    return set;
  }

  /**
   * Deletes all the games from the database
   */
  public void ClearAllGames() throws DataAccessException {
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("TRUNCATE chess");
      preparedStatement.executeUpdate();
      closeConnection(connection);
    }catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
//    GameDAOMap.clear();
  }

  /**
   * Claims white or black pieces for the game
   * @param username name of the user
   * @param color desired color
   * @return whether the spot was claimed or not.
   */
  public String ClaimSpot(String username, ChessGame.TeamColor color, int gameID){
    try{
      Connection connection= conect();
      var preparedStatement = connection.prepareStatement("SELECT white_UserName, black_UserName FROM chess WHERE gameid=?");
        preparedStatement.setInt(1,gameID);

      try(var rs = preparedStatement.executeQuery()){
        if(rs.next()){
          var white=rs.getString("white_UserName");
          var black = rs.getString("black_UserName");
          if(color == ChessGame.TeamColor.WHITE && white ==null){
            try(var prepStatement2 = connection.prepareStatement("UPDATE chess SET white_UserName=? WHERE gameid=?")) {
              prepStatement2.setString(1, username);
              prepStatement2.setInt(2, gameID);
              prepStatement2.executeUpdate();
              closeConnection(connection);
              return username;
            }
          }
          if(color == ChessGame.TeamColor.BLACK && black == null){
            try(var prepStatement2 = connection.prepareStatement("UPDATE chess SET black_UserName=? WHERE gameid=?")){
              prepStatement2.setString(1,username);
              prepStatement2.setInt(2,gameID);
              prepStatement2.executeUpdate();
              closeConnection(connection);
              return username;
            }
          }
        }
      }
      closeConnection(connection);
    } catch (DataAccessException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      return "already taken";
    }
//    if(GameDAOMap.containsKey(gameID)){
//      String whiteUser = GameDAOMap.get(gameID).getWhiteUserName();
//      String blackUser = GameDAOMap.get(gameID).getBlackUserName();
//      if (color == ChessGame.TeamColor.WHITE && whiteUser == null) {
//      GameDAOMap.get(gameID).setWhiteUserName(username);
//      return username;
//      } else if (color == ChessGame.TeamColor.BLACK && blackUser == null) {
//        GameDAOMap.get(gameID).setBlackUserName(username);
//        return username;
//      }
//    }
    return "already taken";
  }


  ///This is a problem
  public int getMapSize_And_increase() throws DataAccessException{
    try{
      Connection connection = conect();
      var preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM chess");


      try (var rs = preparedStatement.executeQuery()){
        if(rs.next()){
        return rs.getInt(1);
        }else{
          return 0;
        }
      }
//    return mapSize++;
    }catch (DataAccessException e){
      throw new DataAccessException(e.getMessage());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void CreateGame() {
  }
}
