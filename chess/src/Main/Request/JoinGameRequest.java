package Request;

import chess.ChessGame;

/**
 * Request to join an existing game
 */
public class JoinGameRequest {

  private ChessGame.TeamColor teamColor;
  /**
   * ID of the current game
   */
  private int gameID;

  /**
   * Constructor for the request to join the game
   * @param gameID ID for the game to join
   */
  public JoinGameRequest(int gameID) {
    this.gameID=gameID;
  }


  public int getGameID() {
    return gameID;
  }


  public void setGameID(int gameID) {
    this.gameID=gameID;
  }

  public ChessGame.TeamColor getTeamColor() {
    return teamColor;
  }

  public void setTeamColor(ChessGame.TeamColor teamColor) {
    this.teamColor=teamColor;
  }
}
