package chess;

import java.util.Collection;
import java.util.HashSet;


public class ChessPieceImp implements ChessPiece{
  private final PieceType type;
  private final ChessGame.TeamColor color;

  public ChessPieceImp(PieceType type, ChessGame.TeamColor color) {
    this.type=type;
    this.color=color;
  }

  @Override
  public ChessGame.TeamColor getTeamColor() {
    return color;
  }

  @Override
  public PieceType getPieceType() {
    return type;
  }

  //Only 1 piece at a time
  @Override
  public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
    if(type == PieceType.PAWN){
      return PawnMoves(board,myPosition);
    }
    if(type == PieceType.ROOK){
      return RookMove(board,myPosition);
    }
    if(type == PieceType.BISHOP){
      return BishopMove(board,myPosition);
    }
    if(type == PieceType.QUEEN){
      return QueenMove(board, myPosition);
    }
    if(type == PieceType.KING){
      return KingMove(board, myPosition);
    }
    if(type == PieceType.KNIGHT){
      return KnightMove(board,myPosition);
    }
    return null;
  }

  //Each piece movement
  public Collection<ChessMove> PawnMoves(ChessBoard board, ChessPosition myPosition){
    ChessGame.TeamColor white = ChessGame.TeamColor.WHITE;
    ChessGame.TeamColor black = ChessGame.TeamColor.BLACK;
    Collection<ChessMove> moves = new HashSet<>();
    //If it's at the starting point then it can potentially move two places for white
    if(color == white){

      //Starting move
      if(myPosition.getRow() == 2){
        moves = startingPawnMove(white, myPosition,board);
        return moves;
      }
      //Any other position that is before the last row (Promotion)
      if(myPosition.getRow() < 8 ) {
        if(myPosition.getRow() <7){
        moves = normalPawnMove(white,myPosition,board);
        }

        //If there is a piece on the square above and to the left then the pawn can take
        //Cannot be a2 pawn
        if(myPosition.getColumn()!=1) {
          ChessPosition takesLeft=new ChessPositionImp(myPosition.getRow() + 1, myPosition.getColumn() - 1);
          if(board.getPiece(takesLeft) != null && board.getPiece(takesLeft).getTeamColor() != white){
            if(myPosition.getRow() == 7){
              ChessPosition PromotesFront = new ChessPositionImp(myPosition.getRow()+1, myPosition.getColumn());
              ChessMove CaptureAndPromote_R = new ChessMoveImp(myPosition,takesLeft,PieceType.ROOK);
              ChessMove CaptureAndPromote_B = new ChessMoveImp(myPosition,takesLeft,PieceType.BISHOP);
              ChessMove CaptureAndPromote_Q = new ChessMoveImp(myPosition,takesLeft,PieceType.QUEEN);
              ChessMove CaptureAndPromote_K = new ChessMoveImp(myPosition,takesLeft,PieceType.KNIGHT);
              ChessMove Promote_R = new ChessMoveImp(myPosition,PromotesFront,PieceType.ROOK);
              ChessMove Promote_B = new ChessMoveImp(myPosition,PromotesFront,PieceType.BISHOP);
              ChessMove Promote_Q = new ChessMoveImp(myPosition,PromotesFront,PieceType.QUEEN);
              ChessMove Promote_K = new ChessMoveImp(myPosition,PromotesFront,PieceType.KNIGHT);

              moves.add(CaptureAndPromote_B);
              moves.add(CaptureAndPromote_R);
              moves.add(CaptureAndPromote_Q);
              moves.add(CaptureAndPromote_K);
              moves.add(Promote_Q);
              moves.add(Promote_R);
              moves.add(Promote_K);
              moves.add(Promote_B);
              return moves;
            }
            ChessMove possMove=new ChessMoveImp(myPosition, takesLeft, null);
            moves.add(possMove);
          }
          if(myPosition.getRow() == 7){
            ChessPosition PromotesFront = new ChessPositionImp(myPosition.getRow()+1, myPosition.getColumn());
            ChessMove Promote_R = new ChessMoveImp(myPosition,PromotesFront,PieceType.ROOK);
            ChessMove Promote_B = new ChessMoveImp(myPosition,PromotesFront,PieceType.BISHOP);
            ChessMove Promote_Q = new ChessMoveImp(myPosition,PromotesFront,PieceType.QUEEN);
            ChessMove Promote_K = new ChessMoveImp(myPosition,PromotesFront,PieceType.KNIGHT);

            moves.add(Promote_Q);
            moves.add(Promote_R);
            moves.add(Promote_K);
            moves.add(Promote_B);

          }
        }

        //If there is a piece on the square above and to the right then the pawn can take
        //Cannot be a2 pawn
        if (myPosition.getColumn() != 8) {
          ChessPosition takesRight=new ChessPositionImp(myPosition.getRow() + 1, myPosition.getColumn() + 1);
          if(board.getPiece(takesRight) != null && board.getPiece(takesRight).getTeamColor() != white){
            if(myPosition.getRow() == 7){
              ChessPosition PromotesFront = new ChessPositionImp(myPosition.getRow()+1, myPosition.getColumn());
              ChessMove CaptureAndPromote_R = new ChessMoveImp(myPosition,takesRight,PieceType.ROOK);
              ChessMove CaptureAndPromote_B = new ChessMoveImp(myPosition,takesRight,PieceType.BISHOP);
              ChessMove CaptureAndPromote_Q = new ChessMoveImp(myPosition,takesRight,PieceType.QUEEN);
              ChessMove CaptureAndPromote_K = new ChessMoveImp(myPosition,takesRight,PieceType.KNIGHT);
              ChessMove Promote_R = new ChessMoveImp(myPosition,PromotesFront,PieceType.ROOK);
              ChessMove Promote_B = new ChessMoveImp(myPosition,PromotesFront,PieceType.BISHOP);
              ChessMove Promote_Q = new ChessMoveImp(myPosition,PromotesFront,PieceType.QUEEN);
              ChessMove Promote_K = new ChessMoveImp(myPosition,PromotesFront,PieceType.KNIGHT);
              moves.add(CaptureAndPromote_B);
              moves.add(CaptureAndPromote_R);
              moves.add(CaptureAndPromote_Q);
              moves.add(CaptureAndPromote_K);
              moves.add(Promote_Q);
              moves.add(Promote_R);
              moves.add(Promote_K);
              moves.add(Promote_B);
              return moves;
            }
            ChessMove possMove=new ChessMoveImp(myPosition, takesRight, null);
            moves.add(possMove);
          }
          if(myPosition.getRow() == 7){
            ChessPosition PromotesFront = new ChessPositionImp(myPosition.getRow()+1, myPosition.getColumn());
            ChessMove Promote_R = new ChessMoveImp(myPosition,PromotesFront,PieceType.ROOK);
            ChessMove Promote_B = new ChessMoveImp(myPosition,PromotesFront,PieceType.BISHOP);
            ChessMove Promote_Q = new ChessMoveImp(myPosition,PromotesFront,PieceType.QUEEN);
            ChessMove Promote_K = new ChessMoveImp(myPosition,PromotesFront,PieceType.KNIGHT);

            moves.add(Promote_Q);
            moves.add(Promote_R);
            moves.add(Promote_K);
            moves.add(Promote_B);
          }
        }
      }
    }
    if(color == black){
      if(myPosition.getRow() == 7){
        moves = startingPawnMove(black,myPosition,board);
        return moves;
      }
      if(myPosition.getRow() > 1){
        if(myPosition.getRow()>2){
        moves = normalPawnMove(black,myPosition,board);
        }
        if(myPosition.getColumn() != 1 && myPosition.getColumn() !=8){
          ChessPosition takesRight=new ChessPositionImp(myPosition.getRow() - 1, myPosition.getColumn() + 1);
          if(board.getPiece(takesRight) != null && board.getPiece(takesRight).getTeamColor() != black){
            if(myPosition.getRow() == 2){
              ChessPosition PromotesFront = new ChessPositionImp(myPosition.getRow()-1, myPosition.getColumn());
              ChessMove CaptureAndPromote_R = new ChessMoveImp(myPosition,takesRight,PieceType.ROOK);
              ChessMove CaptureAndPromote_B = new ChessMoveImp(myPosition,takesRight,PieceType.BISHOP);
              ChessMove CaptureAndPromote_Q = new ChessMoveImp(myPosition,takesRight,PieceType.QUEEN);
              ChessMove CaptureAndPromote_K = new ChessMoveImp(myPosition,takesRight,PieceType.KNIGHT);
              ChessMove Promote_R = new ChessMoveImp(myPosition,PromotesFront,PieceType.ROOK);
              ChessMove Promote_B = new ChessMoveImp(myPosition,PromotesFront,PieceType.BISHOP);
              ChessMove Promote_Q = new ChessMoveImp(myPosition, PromotesFront, PieceType.QUEEN);
              ChessMove Promote_K = new ChessMoveImp(myPosition,PromotesFront,PieceType.KNIGHT);
              moves.add(CaptureAndPromote_B);
              moves.add(CaptureAndPromote_R);
              moves.add(CaptureAndPromote_Q);
              moves.add(CaptureAndPromote_K);
              moves.add(Promote_Q);
              moves.add(Promote_R);
              moves.add(Promote_K);
              moves.add(Promote_B);
              return moves;
            }
            ChessMove possMove=new ChessMoveImp(myPosition, takesRight, null);
            moves.add(possMove);
          }
          if(myPosition.getRow() == 2){
            ChessPosition PromotesFront = new ChessPositionImp(myPosition.getRow()-1, myPosition.getColumn());
            ChessMove Promote_R = new ChessMoveImp(myPosition,PromotesFront,PieceType.ROOK);
            ChessMove Promote_B = new ChessMoveImp(myPosition,PromotesFront,PieceType.BISHOP);
            ChessMove Promote_Q = new ChessMoveImp(myPosition,PromotesFront,PieceType.QUEEN);
            ChessMove Promote_K = new ChessMoveImp(myPosition,PromotesFront,PieceType.KNIGHT);

            moves.add(Promote_Q);
            moves.add(Promote_R);
            moves.add(Promote_K);
            moves.add(Promote_B);
          }
        }
        if(myPosition.getColumn() !=8 && myPosition.getColumn() != 1){
          ChessPosition takesLeft = new ChessPositionImp(myPosition.getRow() -1, myPosition.getColumn()-1);
          if(board.getPiece(takesLeft) != null && board.getPiece(takesLeft).getTeamColor() != black){
            if(myPosition.getRow() == 2){
              ChessPosition PromotesFront = new ChessPositionImp(myPosition.getRow()-1, myPosition.getColumn());
              ChessMove CaptureAndPromote_R = new ChessMoveImp(myPosition,takesLeft,PieceType.ROOK);
              ChessMove CaptureAndPromote_B = new ChessMoveImp(myPosition,takesLeft,PieceType.BISHOP);
              ChessMove CaptureAndPromote_Q = new ChessMoveImp(myPosition,takesLeft,PieceType.QUEEN);
              ChessMove CaptureAndPromote_K = new ChessMoveImp(myPosition,takesLeft,PieceType.KNIGHT);
              ChessMove Promote_R = new ChessMoveImp(myPosition,PromotesFront,PieceType.ROOK);
              ChessMove Promote_B = new ChessMoveImp(myPosition,PromotesFront,PieceType.BISHOP);
              ChessMove Promote_Q = new ChessMoveImp(myPosition,PromotesFront,PieceType.QUEEN);
              ChessMove Promote_K = new ChessMoveImp(myPosition,PromotesFront,PieceType.KNIGHT);
              moves.add(CaptureAndPromote_B);
              moves.add(CaptureAndPromote_R);
              moves.add(CaptureAndPromote_Q);
              moves.add(CaptureAndPromote_K);
              moves.add(Promote_Q);
              moves.add(Promote_R);
              moves.add(Promote_K);
              moves.add(Promote_B);
              return moves;
            }
            ChessMove possMove=new ChessMoveImp(myPosition, takesLeft, null);
            moves.add(possMove);
          }
          if(myPosition.getRow() == 2){
            ChessPosition PromotesFront = new ChessPositionImp(myPosition.getRow()-1, myPosition.getColumn());
            ChessMove Promote_R = new ChessMoveImp(myPosition,PromotesFront,PieceType.ROOK);
            ChessMove Promote_B = new ChessMoveImp(myPosition,PromotesFront,PieceType.BISHOP);
            ChessMove Promote_Q = new ChessMoveImp(myPosition,PromotesFront,PieceType.QUEEN);
            ChessMove Promote_K = new ChessMoveImp(myPosition,PromotesFront,PieceType.KNIGHT);

            moves.add(Promote_Q);
            moves.add(Promote_R);
            moves.add(Promote_K);
            moves.add(Promote_B);

          }
        }
      }
    }

    return moves;
  }

  private Collection<ChessMove> startingPawnMove(ChessGame.TeamColor color, ChessPosition myPosition,ChessBoard board){
    Collection<ChessMove> moves = new HashSet<>();
    if(color == ChessGame.TeamColor.WHITE){
      ChessPosition pos1 = new ChessPositionImp(myPosition.getRow()+1, myPosition.getColumn());
      ChessPosition pos2 = new ChessPositionImp(myPosition.getRow()+2, myPosition.getColumn());
      //checking for pices ahead of this pawn
        if(board.getPiece(pos1) ==null){
          ChessMove possMove = new ChessMoveImp(myPosition,pos1,null);
          moves.add(possMove);
          if(board.getPiece(pos2)==null){
            ChessMove possMove2 = new ChessMoveImp(myPosition,pos2,null);
            moves.add(possMove2);
        }
      }
        ChessPosition captureLeft = new ChessPositionImp(myPosition.getRow()+1, myPosition.getColumn()-1);
        ChessPosition captureRight = new ChessPositionImp(myPosition.getRow()+1, myPosition.getColumn()+1);
        if(myPosition.getColumn() != 1 && myPosition.getColumn() <8){
          if(board.getPiece(captureLeft) != null){
            ChessMove captureleft = new ChessMoveImp(myPosition,captureLeft,null);
            moves.add(captureleft);
          }
          if(board.getPiece(captureRight) != null){
            ChessMove captureright = new ChessMoveImp(myPosition,captureRight, null);
            moves.add(captureright);
          }
        }
        if(myPosition.getColumn() == 1){
          if(board.getPiece(captureRight) != null){
            ChessMove captureright = new ChessMoveImp(myPosition,captureRight, null);
            moves.add(captureright);
          }
        }
        if(myPosition.getColumn() == 8){
          if(board.getPiece(captureLeft) != null){
            ChessMove captureleft = new ChessMoveImp(myPosition,captureLeft,null);
            moves.add(captureleft);
          }
        }
    }
    if(color == ChessGame.TeamColor.BLACK){
      ChessPosition pos1 = new ChessPositionImp(myPosition.getRow()-1, myPosition.getColumn());
      ChessPosition pos2 = new ChessPositionImp(myPosition.getRow()-2, myPosition.getColumn());

      //checking for pices ahead of this pawn
      if(board.getPiece(pos1) == null){
        ChessMove possMove = new ChessMoveImp(myPosition,pos1,null);
        moves.add(possMove);
        if(board.getPiece(pos2) ==null){
          ChessMove possMove2 = new ChessMoveImp(myPosition,pos2,null);
          moves.add(possMove2);
        }
      }
      ChessPosition captureLeft = new ChessPositionImp(myPosition.getRow()-1, myPosition.getColumn()-1);
      ChessPosition captureRight = new ChessPositionImp(myPosition.getRow()-1, myPosition.getColumn()+1);
      if(myPosition.getColumn() != 1 && myPosition.getColumn() <8){
        if(board.getPiece(captureLeft) != null){
          ChessMove captureleft = new ChessMoveImp(myPosition,captureLeft,null);
          moves.add(captureleft);
        }
        if(board.getPiece(captureRight) != null){
          ChessMove captureright = new ChessMoveImp(myPosition,captureRight, null);
          moves.add(captureright);
        }
      }
      if(myPosition.getColumn() == 1){
        if(board.getPiece(captureRight) != null){
          ChessMove captureright = new ChessMoveImp(myPosition,captureRight, null);
          moves.add(captureright);
        }
      }
      if(myPosition.getColumn() == 8){
        if(board.getPiece(captureLeft) != null){
          ChessMove captureleft = new ChessMoveImp(myPosition,captureLeft,null);
          moves.add(captureleft);
        }
      }
    }
    return moves;
  }
  private Collection<ChessMove> normalPawnMove(ChessGame.TeamColor color, ChessPosition myPosition, ChessBoard board){
    Collection<ChessMove> moves = new HashSet<>();
    if(color == ChessGame.TeamColor.WHITE){
      ChessPosition pos1=new ChessPositionImp(myPosition.getRow() + 1, myPosition.getColumn());
      if (board.getPiece(pos1) == null) {
        ChessMove possMove=new ChessMoveImp(myPosition, pos1, null);
        moves.add(possMove);
      }
    }else{
      ChessPosition pos1=new ChessPositionImp(myPosition.getRow() - 1, myPosition.getColumn());
      if(board.getPiece(pos1) == null){
        ChessMove possMove = new ChessMoveImp(myPosition,pos1,null);
        moves.add(possMove);
      }
    }
    return moves;
  }

  public Collection<ChessMove> KingMove(ChessBoard board, ChessPosition myPosition){
    Collection<ChessMove> moves = new HashSet<>();
      ChessPosition RightAndUp=new ChessPositionImp(myPosition.getRow() + 1, myPosition.getColumn() + 1);
      ChessPosition RightAndDown=new ChessPositionImp(myPosition.getRow() - 1, myPosition.getColumn() + 1);
      ChessPosition Right=new ChessPositionImp(myPosition.getRow(), myPosition.getColumn() + 1);
      ChessPosition Left=new ChessPositionImp(myPosition.getRow(), myPosition.getColumn() - 1);
      ChessPosition LeftAndUp=new ChessPositionImp(myPosition.getRow() + 1, myPosition.getColumn() - 1);
      ChessPosition LeftAndDown=new ChessPositionImp(myPosition.getRow() - 1, myPosition.getColumn() - 1);
      ChessPosition inFront=new ChessPositionImp(myPosition.getRow() + 1, myPosition.getColumn());
      ChessPosition Behind=new ChessPositionImp(myPosition.getRow() - 1, myPosition.getColumn());
      int row=myPosition.getRow();
      int col =myPosition.getColumn();
    //If the king is anywhere but the corners or last rows or columns
    if(myPosition.getRow() <8 && myPosition.getColumn() < 8 && row >1 && col >1) {
      if (board.getPiece(RightAndUp) == null) {
        moves.addAll(AddToMoves(moves,myPosition,RightAndUp));
      }
      if (board.getPiece(RightAndUp) != null) {
        if (board.getPiece(RightAndUp).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,RightAndUp));
        }
      }
      if (board.getPiece(RightAndDown) == null) {
        moves.addAll(AddToMoves(moves,myPosition,RightAndDown));
      }
      if (board.getPiece(RightAndDown) != null) {
        if (board.getPiece(RightAndDown).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,RightAndDown));
        }
      }
      if (board.getPiece(Right) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Right));
      }
      if (board.getPiece(Right) != null) {
        if (board.getPiece(Right).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Right));
        }
      }
      if (board.getPiece(LeftAndUp) == null) {
        moves.addAll(AddToMoves(moves,myPosition,LeftAndUp));
      }
      if (board.getPiece(LeftAndUp) != null) {
        if (board.getPiece(LeftAndUp).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,LeftAndUp));
        }
      }
      if (board.getPiece(LeftAndDown) == null) {
        moves.addAll(AddToMoves(moves,myPosition,LeftAndDown));
      }
      if (board.getPiece(LeftAndDown) != null) {
        if (board.getPiece(LeftAndDown).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,LeftAndDown));
        }
      }
      if (board.getPiece(Left) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Left));
      }
      if (board.getPiece(Left) != null) {
        if (board.getPiece(Left).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Left));
        }
      }
      if (board.getPiece(inFront) == null) {
        moves.addAll(AddToMoves(moves,myPosition,inFront));
      }
      if (board.getPiece(inFront) != null) {
        if (board.getPiece(inFront).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,inFront));
        }
      }
      if(board.getPiece(Behind) == null){
        moves.addAll(AddToMoves(moves,myPosition,Behind));
      }
      if(board.getPiece(Behind) != null) {
        if (board.getPiece(Behind).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Behind));
        }
      }
    }

    else if(myPosition.getRow() == 8 && myPosition.getColumn() == 8){
      if (board.getPiece(Left) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Left));
      }
      if (board.getPiece(Left) != null) {
        if (board.getPiece(Left).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Left));
        }
      }
      if (board.getPiece(LeftAndDown) == null) {
        moves.addAll(AddToMoves(moves,myPosition,LeftAndDown));
      }
      if (board.getPiece(LeftAndDown) != null) {
        if (board.getPiece(LeftAndDown).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,LeftAndDown));
        }
      }
      if(board.getPiece(Behind) == null){
        moves.addAll(AddToMoves(moves,myPosition,Behind));
      }
      if(board.getPiece(Behind) != null) {
        if (board.getPiece(Behind).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Behind));
        }
      }
    }
    else if(myPosition.getRow() == 8 && myPosition.getColumn() ==1){
      if(board.getPiece(Behind) == null){
        moves.addAll(AddToMoves(moves,myPosition,Behind));
      }
      if(board.getPiece(Behind) != null) {
        if (board.getPiece(Behind).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Behind));
        }
      }
      if (board.getPiece(Right) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Right));
      }
      if (board.getPiece(Right) != null) {
        if (board.getPiece(Right).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Right));
        }
      }
      if (board.getPiece(RightAndDown) == null) {
        moves.addAll(AddToMoves(moves,myPosition,RightAndDown));
      }
      if (board.getPiece(RightAndDown) != null) {
        if (board.getPiece(RightAndDown).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,RightAndDown));
        }
      }
    }
    else if (myPosition.getRow() ==1 && myPosition.getColumn() ==1){
      if (board.getPiece(Right) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Right));
      }
      if (board.getPiece(Right) != null) {
        if (board.getPiece(Right).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Right));
        }
      }
      if (board.getPiece(inFront) == null) {
        moves.addAll(AddToMoves(moves,myPosition,inFront));
      }
      if (board.getPiece(inFront) != null) {
        if (board.getPiece(inFront).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,inFront));
        }
      }
      if (board.getPiece(RightAndUp) == null) {
        moves.addAll(AddToMoves(moves,myPosition,RightAndUp));
      }
      if (board.getPiece(RightAndUp) != null) {
        if (board.getPiece(RightAndUp).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,RightAndUp));
        }
      }
    }
    else if (myPosition.getRow() ==1 && myPosition.getColumn() ==8){
      if (board.getPiece(Left) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Left));
      }
      if (board.getPiece(Left) != null) {
        if (board.getPiece(Left).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Left));
        }
      }
      if (board.getPiece(inFront) == null) {
        moves.addAll(AddToMoves(moves,myPosition,inFront));
      }
      if (board.getPiece(inFront) != null) {
        if (board.getPiece(inFront).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,inFront));
        }
      }
      if (board.getPiece(LeftAndUp) == null) {
        moves.addAll(AddToMoves(moves,myPosition,LeftAndUp));
      }
      if (board.getPiece(LeftAndUp) != null) {
        if (board.getPiece(LeftAndUp).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,LeftAndUp));
        }
      }
    }
    else if (myPosition.getColumn() == 8){
      if (board.getPiece(Left) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Left));
      }
      if (board.getPiece(Left) != null) {
        if (board.getPiece(Left).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Left));
        }
      }
      if (board.getPiece(inFront) == null) {
        moves.addAll(AddToMoves(moves,myPosition,inFront));
      }
      if (board.getPiece(inFront) != null) {
        if (board.getPiece(inFront).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,inFront));
        }
      }
      if (board.getPiece(LeftAndUp) == null) {
        moves.addAll(AddToMoves(moves,myPosition,LeftAndUp));
      }
      if (board.getPiece(LeftAndUp) != null) {
        if (board.getPiece(LeftAndUp).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,LeftAndUp));
        }
      }
      if(board.getPiece(Behind) == null){
        moves.addAll(AddToMoves(moves,myPosition,Behind));
      }
      if(board.getPiece(Behind) != null) {
        if (board.getPiece(Behind).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Behind));
        }
      }
      if (board.getPiece(LeftAndDown) == null) {
        moves.addAll(AddToMoves(moves,myPosition,LeftAndDown));
      }
      if (board.getPiece(LeftAndDown) != null) {
        if (board.getPiece(LeftAndDown).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,LeftAndDown));
        }
      }
    }
    else if (myPosition.getColumn() ==1){
      if (board.getPiece(Right) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Right));
      }
      if (board.getPiece(Right) != null) {
        if (board.getPiece(Right).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Right));
        }
      }
      if (board.getPiece(inFront) == null) {
        moves.addAll(AddToMoves(moves,myPosition,inFront));
      }
      if (board.getPiece(inFront) != null) {
        if (board.getPiece(inFront).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,inFront));
        }
      }
      if (board.getPiece(RightAndUp) == null) {
        moves.addAll(AddToMoves(moves,myPosition,RightAndUp));
      }
      if (board.getPiece(RightAndUp) != null) {
        if (board.getPiece(LeftAndUp).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,RightAndUp));
        }
      }
      if(board.getPiece(Behind) == null){
        moves.addAll(AddToMoves(moves,myPosition,Behind));
      }
      if(board.getPiece(Behind) != null) {
        if (board.getPiece(Behind).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Behind));
        }
      }
      if (board.getPiece(RightAndDown) == null) {
        moves.addAll(AddToMoves(moves,myPosition,RightAndDown));
      }
      if (board.getPiece(RightAndDown) != null) {
        if (board.getPiece(RightAndDown).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,RightAndDown));
        }
      }
    }
    else if (myPosition.getRow() ==1){
      if (board.getPiece(Left) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Left));
      }
      if (board.getPiece(Left) != null) {
        if (board.getPiece(Left).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Left));
        }
      }
      if (board.getPiece(inFront) == null) {
        moves.addAll(AddToMoves(moves,myPosition,inFront));
      }
      if (board.getPiece(inFront) != null) {
        if (board.getPiece(inFront).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,inFront));
        }
      }
      if (board.getPiece(LeftAndUp) == null) {
        moves.addAll(AddToMoves(moves,myPosition,LeftAndUp));
      }
      if (board.getPiece(LeftAndUp) != null) {
        if (board.getPiece(LeftAndUp).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,LeftAndUp));
        }
      }
      if (board.getPiece(Right) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Right));
      }
      if (board.getPiece(Right) != null) {
        if (board.getPiece(Right).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Right));
        }
      }
      if (board.getPiece(RightAndUp) == null) {
        moves.addAll(AddToMoves(moves,myPosition,RightAndUp));
      }
      if (board.getPiece(RightAndUp) != null) {
        if (board.getPiece(RightAndUp).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,RightAndUp));
        }
      }
    }
    else if(myPosition.getRow() ==8){
      if (board.getPiece(Right) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Right));
      }
      if (board.getPiece(Right) != null) {
        if (board.getPiece(Right).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Right));
        }
      }
      if (board.getPiece(Left) == null) {
        moves.addAll(AddToMoves(moves,myPosition,Left));
      }
      if (board.getPiece(Left) != null) {
        if (board.getPiece(Left).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Left));
        }
      }
      if(board.getPiece(Behind) == null){
        moves.addAll(AddToMoves(moves,myPosition,Behind));
      }
      if(board.getPiece(Behind) != null) {
        if (board.getPiece(Behind).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,Behind));
        }
      }
      if (board.getPiece(RightAndDown) == null) {
        moves.addAll(AddToMoves(moves,myPosition,RightAndDown));
      }
      if (board.getPiece(RightAndDown) != null) {
        if (board.getPiece(RightAndDown).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,RightAndDown));
        }
      }
      if (board.getPiece(LeftAndDown) == null) {
        moves.addAll(AddToMoves(moves,myPosition,LeftAndDown));
      }
      if (board.getPiece(LeftAndDown) != null) {
        if (board.getPiece(LeftAndDown).getTeamColor() != this.color) {
          moves.addAll(AddToMoves(moves,myPosition,LeftAndDown));
        }
      }
    }
    return moves;
  }

  private Collection<ChessMove> AddToMoves(Collection<ChessMove> moves, ChessPosition startPosition, ChessPosition endPosition){
    ChessMove moveToAdd = new ChessMoveImp(startPosition,endPosition,null);
    moves.add(moveToAdd);
    return moves;
  }

  public Collection<ChessMove> KnightMove(ChessBoard board, ChessPosition myPosition){
    HashSet<ChessMove> moves = new HashSet<>();
    if(myPosition.getRow() < 7 && myPosition.getColumn() <7 && myPosition.getRow() > 2 && myPosition.getColumn() >2){
      Right_T(moves,myPosition,board, true,true);
      Left_T(moves,myPosition,board,true,true);
      Front_T(moves,myPosition,board,true,true);
      behind_T(moves,myPosition,board,true,true);
    } else if (myPosition.getRow() == 2 && myPosition.getColumn() == 7) {
      Front_T(moves,myPosition,board,true,true);
      Left_T(moves,myPosition,board,true,true);
    }else if(myPosition.getRow() ==2 && myPosition.getColumn() ==2){
      Front_T(moves,myPosition,board,true,true);
      Right_T(moves,myPosition,board,true,true);
    } else if (myPosition.getRow() ==7 && myPosition.getColumn() ==7) {
      Left_T(moves,myPosition,board,true,true);
      behind_T(moves,myPosition,board,true,true);
    }else if (myPosition.getRow() ==7 && myPosition.getColumn() ==2){
      Right_T(moves,myPosition,board,true,true);
      behind_T(moves,myPosition,board,true,true);
    }else if((myPosition.getRow() == 8 && myPosition.getColumn() > 2 && myPosition.getColumn() < 7)){
      behind_T(moves,myPosition,board,true,true);
      Right_T(moves,myPosition,board,false,true);
      Left_T(moves,myPosition,board,false,true);
    } else if (myPosition.getRow() == 1 && myPosition.getColumn()>2 && myPosition.getColumn()<7) {
      Front_T(moves,myPosition,board,true,true);
      Right_T(moves,myPosition,board,true,false);
      Left_T(moves,myPosition,board,true,false);
    }
    //Edge of the board
    else if(myPosition.getColumn() == 1 && myPosition.getRow() <7 && myPosition.getRow() >2){
      Right_T(moves,myPosition,board, true,true);
      Front_T(moves,myPosition,board,true,false);
      behind_T(moves,myPosition,board,true,false);
    } else if (myPosition.getColumn() == 8 && myPosition.getRow() <7 && myPosition.getRow() >2) {
      Left_T(moves,myPosition,board, true,true);
      Front_T(moves,myPosition,board,false,true);
      behind_T(moves,myPosition,board,false,true);
    } else if (myPosition.getColumn() ==2 && myPosition.getRow()< 7 && myPosition.getRow() > 2) {
      Front_T(moves,myPosition,board,true,true);
      behind_T(moves,myPosition,board,true,true);
      Right_T(moves,myPosition,board, true,true);
    } else if (myPosition.getColumn() ==7 && myPosition.getRow()< 7 && myPosition.getRow() > 2) {
      Front_T(moves,myPosition,board,true,true);
      behind_T(moves,myPosition,board,true,true);
      Left_T(moves,myPosition,board,true,true);
    }else if(myPosition.getRow() == 2 && myPosition.getColumn() <7 && myPosition.getColumn() >2){
      Right_T(moves,myPosition,board, true,true);
      Left_T(moves,myPosition,board,true,true);
      Front_T(moves,myPosition,board,true,true);
    } else if (myPosition.getRow() == 7 && myPosition.getColumn() <7 && myPosition.getColumn()>2) {
      Right_T(moves,myPosition,board, true,true);
      Left_T(moves,myPosition,board,true,true);
      behind_T(moves,myPosition,board,true,true);
    } else if (myPosition.getRow() ==1 && myPosition.getColumn() == 8) {
      Front_T(moves,myPosition,board,false,true);
      Left_T(moves,myPosition,board,true,false);
    }else if(myPosition.getRow() ==8 && myPosition.getColumn() == 8){
      behind_T(moves,myPosition,board,false,true);
      Left_T(moves,myPosition,board,false,true);
    } else if (myPosition.getRow() ==8 && myPosition.getColumn() == 1 ) {
      behind_T(moves,myPosition,board,true,false);
      Right_T(moves,myPosition,board, false,true);
    } else if (myPosition.getRow() == 1 && myPosition.getColumn() ==1) {
      Right_T(moves,myPosition,board, true,false);
      Front_T(moves,myPosition,board,true,false);
    } else if (myPosition.getRow() == 2 && myPosition.getColumn() == 1) {
      Right_T(moves,myPosition,board, true,true);
      Front_T(moves,myPosition,board,true,false);
    } else if (myPosition.getRow() == 1 && myPosition.getColumn() == 2) {
      Front_T(moves,myPosition,board,true,true);
      Right_T(moves,myPosition,board, true,false);
    } else if (myPosition.getRow() == 1 && myPosition.getColumn() == 7) {
      Front_T(moves,myPosition,board,true,true);
      Left_T(moves,myPosition,board,true,false);
    } else if (myPosition.getRow() == 2 && myPosition.getColumn() == 8) {
      Left_T(moves,myPosition,board,true,true);
      Front_T(moves,myPosition,board,false,true);
    } else if (myPosition.getRow() == 7 && myPosition.getColumn() == 8) {
      Left_T(moves,myPosition,board,true,true);
      behind_T(moves,myPosition,board,false,true);
    } else if (myPosition.getRow() == 8 && myPosition.getColumn() == 7) {
      behind_T(moves,myPosition,board,true,true);
      Left_T(moves,myPosition,board,false,true);
    } else if (myPosition.getRow() ==8  && myPosition.getColumn() ==2) {
      behind_T(moves,myPosition,board,true,true);
      Right_T(moves,myPosition,board, false,true);
    } else if (myPosition.getRow() == 7 && myPosition.getColumn() == 1) {
      Right_T(moves,myPosition,board, true,true);
      behind_T(moves,myPosition,board,true,false);
    }
    return moves;
  }
  private Collection<ChessMove> Right_T (Collection<ChessMove> moves, ChessPosition startPosition,ChessBoard board,boolean L_UP,boolean L_Down) {
    ChessPosition L_up = new ChessPositionImp(startPosition.getRow()+1,startPosition.getColumn()+2);
    ChessPosition L_down = new ChessPositionImp(startPosition.getRow()-1,startPosition.getColumn()+2);
    ChessMove Up = new ChessMoveImp(startPosition,L_up,null);
    ChessMove down = new ChessMoveImp(startPosition,L_down,null);
    if(L_UP) {
      if (board.getPiece(L_up) != null) {
        if (board.getPiece(L_up).getTeamColor() != this.color) {
          moves.add(Up);
        }
      } else if (board.getPiece(L_up) == null) {
        moves.add(Up);
      }
    }
    if(L_Down) {
      if (board.getPiece(L_down) != null ) {
        if (board.getPiece(L_down).getTeamColor() != this.color) {
          moves.add(down);
        }
      } else if (board.getPiece(L_down) == null) {
        moves.add(down);
      }
    }
    return moves;
  }
  private Collection<ChessMove> Left_T (Collection<ChessMove> moves, ChessPosition startPosition,ChessBoard board, boolean L_Up,boolean L_Down) {
    ChessPosition L_up = new ChessPositionImp(startPosition.getRow()+1,startPosition.getColumn()-2);
    ChessPosition L_down = new ChessPositionImp(startPosition.getRow()-1,startPosition.getColumn()-2);
    ChessMove Up = new ChessMoveImp(startPosition,L_up,null);
    ChessMove down = new ChessMoveImp(startPosition,L_down,null);
    if(L_Up) {
      if (board.getPiece(L_up) != null ) {
        if (board.getPiece(L_up).getTeamColor() != this.color) {
          moves.add(Up);
        }
      } else if (board.getPiece(L_up) == null) {
        moves.add(Up);
      }
    }
    if(L_Down) {
      if (board.getPiece(L_down) != null) {
        if (board.getPiece(L_down).getTeamColor() != this.color) {
          moves.add(down);
        }
      } else if (board.getPiece(L_down) == null) {
        moves.add(down);
      }
    }
    return moves;
  }
  private Collection<ChessMove> Front_T (Collection<ChessMove> moves, ChessPosition startPosition,ChessBoard board, boolean Right_L, boolean Left_L) {
    ChessPosition L_Right = new ChessPositionImp(startPosition.getRow()+2,startPosition.getColumn()+1);
    ChessPosition L_Left= new ChessPositionImp(startPosition.getRow()+2,startPosition.getColumn()-1);
    ChessMove Right = new ChessMoveImp(startPosition,L_Right,null);
    ChessMove Left = new ChessMoveImp(startPosition,L_Left,null);
    if(Right_L) {
      if (board.getPiece(L_Right) != null) {
        if (board.getPiece(L_Right).getTeamColor() != this.color) {
          moves.add(Right);
        }
      } else if (board.getPiece(L_Right) == null ) {
        moves.add(Right);
      }
    }
    if(Left_L) {
      if (board.getPiece(L_Left) != null ) {
        if (board.getPiece(L_Left).getTeamColor() != this.color) {
          moves.add(Left);
        }
      } else if (board.getPiece(L_Left) == null) {
        moves.add(Left);
      }
    }
    return moves;
  }
  private Collection<ChessMove> behind_T (Collection<ChessMove> moves, ChessPosition startPosition,ChessBoard board,boolean Right_L, boolean Left_L) {
    ChessPosition L_Right = new ChessPositionImp(startPosition.getRow()-2,startPosition.getColumn()+1);
    ChessPosition L_Left= new ChessPositionImp(startPosition.getRow()-2,startPosition.getColumn()-1);
    ChessMove Right = new ChessMoveImp(startPosition,L_Right,null);
    ChessMove Left = new ChessMoveImp(startPosition,L_Left,null);
    if(Right_L) {
      if (board.getPiece(L_Right) != null ) {
        if (board.getPiece(L_Right).getTeamColor() != this.color) {
          moves.add(Right);
        }
      } else if (board.getPiece(L_Right) == null) {
        moves.add(Right);
      }
    }
    if(Left_L) {
      if (board.getPiece(L_Left) != null) {
        if (board.getPiece(L_Left).getTeamColor() != this.color) {
          moves.add(Left);
        }
      } else if (board.getPiece(L_Left) == null) {
        moves.add(Left);
      }
    }
    return moves;
  }


  public Collection<ChessMove> BishopMove(ChessBoard board, ChessPosition myPosition){
    Collection<ChessMove> moves = new HashSet<>();
    int UpAndLeft =Math.min(9-myPosition.getRow(), myPosition.getColumn()) -1;
    int DownAndLeft =8 - Math.max(9 - myPosition.getRow(), 9-myPosition.getColumn());
    int UpAndRight= 8 - Math.max(myPosition.getRow(), myPosition.getColumn());
    int DownAndRight = Math.min(myPosition.getRow(), 9 - myPosition.getColumn())-1;
      for(int i = 1; i <= UpAndRight; i++){
        ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow() +i, myPosition.getColumn()+i);
        if(board.getPiece(check_i_square) != null){
          if(board.getPiece(check_i_square).getTeamColor() !=this.color) {
            ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
            moves.add(capture);
            break;
          }
          break;
        }
        ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
        moves.add(availSquare);
      }
      for(int i = 1; i <= UpAndLeft; i++){
        ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow() +i, myPosition.getColumn()-i);
        if(board.getPiece(check_i_square) != null){
          if(board.getPiece(check_i_square).getTeamColor() !=this.color) {
            ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
            moves.add(capture);
            break;
          }
          break;
        }
        ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
        moves.add(availSquare);
      }

      for(int i = 1; i <= DownAndLeft; i++){
        ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow() -i, myPosition.getColumn()-i);
        if(board.getPiece(check_i_square) != null){
          if(board.getPiece(check_i_square).getTeamColor() !=this.color) {
            ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
            moves.add(capture);
            break;
          }
          break;
        }
        ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
        moves.add(availSquare);
      }
      for(int i = 1; i <= DownAndRight; i++){
        ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow() -i, myPosition.getColumn()+i);
        if(board.getPiece(check_i_square) != null){
          if(board.getPiece(check_i_square).getTeamColor() !=this.color) {
            ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
            moves.add(capture);
            break;
          }
          break;
        }
        ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
        moves.add(availSquare);
      }

    return moves;
  }
  public Collection<ChessMove> QueenMove(ChessBoard board, ChessPosition myPosition){
    Collection<ChessMove> moves = new HashSet<>();
    moves.addAll(RookMove(board, myPosition));
    moves.addAll(BishopMove(board, myPosition));
    return moves;
  }
  public Collection<ChessMove> RookMove(ChessBoard board, ChessPosition myPosition){
    Collection<ChessMove> moves = new HashSet<>();
    ChessGame.TeamColor white = ChessGame.TeamColor.WHITE;
    ChessGame.TeamColor black = ChessGame.TeamColor.BLACK;
    if(color == white) {
      //Moving up and down
      int spacesAbove = 8-myPosition.getRow();
      int spacesBelow = myPosition.getRow() -1;
      //Spacing above
      for(int i = 1; i<= spacesAbove; i++){
        ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow() +i, myPosition.getColumn());
        if(board.getPiece(check_i_square) != null){
          if(board.getPiece(check_i_square).getTeamColor() !=white) {
            ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
            moves.add(capture);
            break;
          }
          break;
        }
        ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
        moves.add(availSquare);
//        moveRook(board,myPosition, myPosition.getRow()+i, myPosition.getColumn(), moves);
      }

      //spacing below
      for(int i = 1; i<= spacesBelow;i++){
          ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow() -i, myPosition.getColumn());
          if(board.getPiece(check_i_square) != null){
            if(board.getPiece(check_i_square).getTeamColor() !=white) {
              ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
              moves.add(capture);
              break;
            }
            break;
          }
          ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
          moves.add(availSquare);
//        moveRook(board,myPosition, myPosition.getRow()-i, myPosition.getColumn(), moves);
        }



      //Moving Across
      int spacesToRight = 8- myPosition.getColumn();
      int spacesToLeft =myPosition.getColumn() - 1;

      for(int i= 1; i<=spacesToRight;i++){
        ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow(), myPosition.getColumn()+i);
        if(board.getPiece(check_i_square) != null){
          if(board.getPiece(check_i_square).getTeamColor() !=white) {
            ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
            moves.add(capture);
            break;
          }
          break;
        }
        ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
        moves.add(availSquare);
      }
      for(int i =1; i<= spacesToLeft;i++){
        ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow(), myPosition.getColumn()-i);
        if(board.getPiece(check_i_square) != null){
          if(board.getPiece(check_i_square).getTeamColor() !=white) {
            ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
            moves.add(capture);
            break;
          }
          break;
        }
        ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
        moves.add(availSquare);
      }


      }
    if(color == black){
//      if(myPosition.getRow() ==8){
//        for(int i=7; i>0;i--){
//          ChessPosition check_i_square = new ChessPositionImp(i, myPosition.getColumn());
//          if(board.getPiece(check_i_square)!= null){
//            break;
//          }
//          ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
//          moves.add(availSquare);
//        }
//
//      }

        int spacesAbove = 8-myPosition.getRow();
        int spacesBelow = myPosition.getRow() -1;
        //Spacing above
        for(int i = 1; i<= spacesAbove; i++){
          ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow() +i, myPosition.getColumn());
          if(board.getPiece(check_i_square) != null){
            if(board.getPiece(check_i_square).getTeamColor() !=black) {
              ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
              moves.add(capture);
              break;
            }
            break;
          }
          ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
          moves.add(availSquare);
  //        moveRook(board,myPosition, myPosition.getRow()+i, myPosition.getColumn(), moves);
        }

        //spacing below
        for(int i = 1; i<= spacesBelow;i++){
          ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow() -i, myPosition.getColumn());
          if(board.getPiece(check_i_square) != null){
            if(board.getPiece(check_i_square).getTeamColor() !=black) {
              ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
              moves.add(capture);
              break;
            }
            break;
          }
          ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
          moves.add(availSquare);
  //        moveRook(board,myPosition, myPosition.getRow()-i, myPosition.getColumn(), moves);
        }



        //Moving Across
        int spacesToRight = 8- myPosition.getColumn();
        int spacesToLeft =myPosition.getColumn() - 1;

        for(int i= 1; i<=spacesToRight;i++){
          ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow(), myPosition.getColumn()+i);
          if(board.getPiece(check_i_square) != null){
            if(board.getPiece(check_i_square).getTeamColor() !=black){
              ChessMove capture = new ChessMoveImp(myPosition,check_i_square,null);
              moves.add(capture);
              break;
            }
            break;
          }
          ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
          moves.add(availSquare);
        }
        for(int i =1; i<= spacesToLeft;i++){
          ChessPosition check_i_square = new ChessPositionImp(myPosition.getRow(), myPosition.getColumn()-i);
          if(board.getPiece(check_i_square) != null){
            if(board.getPiece(check_i_square).getTeamColor() !=black) {
              ChessMove capture=new ChessMoveImp(myPosition, check_i_square, null);
              moves.add(capture);
              break;
            }
            break;
          }
          ChessMove availSquare = new ChessMoveImp(myPosition,check_i_square,null);
          moves.add(availSquare);
        }
      }
    return moves;
  }


}
