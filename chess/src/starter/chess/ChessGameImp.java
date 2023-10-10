package chess;

import java.util.Collection;
import java.util.HashSet;

public class ChessGameImp implements ChessGame{
  private ChessBoard board;
  private ChessGame.TeamColor color;

  public ChessGameImp() {
    board = new ChessBoardImp();
    color = null;
  }


  @Override
  public TeamColor getTeamTurn() {
    return color;
  }

  @Override
  public void setTeamTurn(TeamColor team) {
    color = team;
  }

  @Override
  public Collection<ChessMove> validMoves(ChessPosition startPosition) {
    Collection<ChessMove> moves = new HashSet<>();
    Collection<ChessMove> finalMoves = new HashSet<>();
    ChessBoard tempBoard = makeTempBoard(board);
    //get the piece at the position specified and then grab its moves
    ChessPiece piece =  board.getPiece(startPosition);
    //Any move that LEAVES or PUTS the King in check would be invalid
    moves = piece.pieceMoves(board,startPosition);
    //Check to see if any of the moves would END with the King being in check
    for(var at : moves){
      //Make the move manually, check if that position leaves the king in check
      //If it does do not add that move to final moves
      //If it doesn't then add the move to final moves
      tempBoard.MakeMove(at.getStartPosition(), at.getEndPosition(), piece);
      if(!isInCheckHelper(piece.getTeamColor(),tempBoard)){
        finalMoves.add(at);
      }
      tempBoard = makeTempBoard(board);
    }

    return finalMoves;
  }
  private ChessBoard makeTempBoard(ChessBoard board){
    ChessBoard tempBoard  = new ChessBoardImp();
    for(int row = 1; row < 9 ; row++){
      for (int col = 1 ; col < 9; col++){
        ChessPosition currPosition = new ChessPositionImp(row,col);
        if(board.getPiece(currPosition)!= null){
          ChessPiece currPiece =board.getPiece(currPosition);
          tempBoard.addPiece(currPosition,currPiece);
        }
      }
    }
    return tempBoard;
  }


  @Override
  public void makeMove(ChessMove move) throws InvalidMoveException {
    ChessPiece piece = board.getPiece(move.getStartPosition());
    if(color == piece.getTeamColor()) {
      if (validMoves(move.getStartPosition()).contains(move)) {
        if(move.getPromotionPiece() != null){
          board.promoteAndMove(move.getStartPosition(), move.getEndPosition(), move.getPromotionPiece(),piece);
        }else {
          board.MakeMove(move.getStartPosition(), move.getEndPosition(), piece);
        }
        if(color == TeamColor.WHITE){
          setTeamTurn(TeamColor.BLACK);
        }else{
          setTeamTurn(TeamColor.WHITE);
        }
      }else{
        throw new InvalidMoveException("Invalid move");
      }
    }else {
      throw new InvalidMoveException("Invalid move");
    }
  }

  @Override
  public boolean isInCheck(TeamColor teamColor) {
    //Iterate through the other teams valid moves and see if they are in the path to the current team's king
    return isInCheckHelper(teamColor,board);
  }
  private boolean isInCheckHelper(TeamColor teamColor, ChessBoard board){
    Collection<ChessMove> possibleMoves = new HashSet<>();
    ChessPosition KingPosition = new ChessPositionImp(1,1);
    for(int row = 1; row <9;row++ ){
      for(int col = 1; col <9; col++){
        ChessPosition curr = new ChessPositionImp(row,col);
        if(board.getPiece(curr) != null && board.getPiece(curr).getPieceType() == ChessPiece.PieceType.KING && board.getPiece(curr).getTeamColor() == teamColor){
          KingPosition = curr;
        }
          ChessPiece currPiece = board.getPiece(curr);
        if(currPiece != null && teamColor != currPiece.getTeamColor()){
          if(currPiece.getPieceType() != null) {
            possibleMoves.addAll(currPiece.pieceMoves(board, curr));
          }
        }
      }
    }
    for(var moves : possibleMoves){
      if(moves.getEndPosition().getColumn() ==  KingPosition.getColumn() && moves.getEndPosition().getRow() == KingPosition.getRow()){
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isInCheckmate(TeamColor teamColor) {
    if(isInCheck(teamColor)){
      Collection<ChessMove> moves = new HashSet<>();
      for(int row = 1; row< 9 ; row++){
        for(int col = 1; col < 9; col++){
          ChessPosition currPos = new ChessPositionImp(row,col);
          if(board.getPiece(currPos) != null && board.getPiece(currPos).getPieceType() == ChessPiece.PieceType.KING && board.getPiece(currPos).getTeamColor() == teamColor) {
            moves = validMoves(currPos);
            if(moves.isEmpty()){
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  @Override
  public boolean isInStalemate(TeamColor teamColor) {
    if(!isInCheck(teamColor)){
      Collection<ChessMove> moves = new HashSet<>();
      for(int row = 1 ; row<9; row++){
        for(int col = 1; col < 9; col++){
          ChessPosition currPos = new ChessPositionImp(row,col);
          if(board.getPiece(currPos) != null && board.getPiece(currPos).getTeamColor() == teamColor){
            moves.addAll(validMoves(currPos));
            if(moves.isEmpty()){
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  @Override
  public void setBoard(ChessBoard board) {
    this.board = board;
  }

  @Override
  public ChessBoard getBoard() {
    return board;
  }
}
