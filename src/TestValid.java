public class TestValid {
public static void main(String[] args){
  System.out.println(validateType(new StringBuilder("H").toString()));
}
  public static boolean validateType(String type) {
    if (type.equals(PieceType.BISHOP) || type.equals(PieceType.HORSE) || type.equals(PieceType.KING)
        || type.equals(PieceType.PAWN) || type.equals(PieceType.QUEEN) || type
        .equals(PieceType.ROOK)) {
      return true;
    } else {
      return false;
    }
  }
}
