public class GameOfLife {
  int size;
  int[][] board;
  int[][] previous;

  // Default constructor.
  public GameOfLife(){ }

  // Constructor that takes size as input.
  public GameOfLife(int s){
    size = s;
    board = new int[size][size];
    previous = new int[size][size];
  }

  // Constructor that takes a 2D array as input.
  // Size of array will be the size of the board and previous.
  public GameOfLife(int[][] inputArray){
    size = inputArray.length;

    board = new int[size][size];
    previous = new int[size][size];

    for(int i = 0; i < size; i++){
      for(int j = 0; j < inputArray[i].length; j++){
        previous[i][j] = inputArray[i][j];
      }
    }
  }

  // Getter returns the current board.
  public int[][] getBoard(){
    return this.board;
  }

  // Transforms the current board into the next shape.
  // Updates the previous board to the current.
  public void oneStep(){
    for (int i = 0; i < previous.length; i++){
      for (int j = 0; j < previous[i].length; j++){
        int neighborQuantity = neighbors(i, j);
        if (previous[i][j] == 1 && (neighborQuantity == 2 || neighborQuantity == 3)){
          board[i][j] = 1;
        } else if (previous[i][j] == 0 && neighborQuantity == 3){
          board[i][j] = 1;
        } else {
          board[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < previous.length; i++) {
      for (int j = 0; j < previous[i].length; j++) {
        previous[i][j] = board[i][j];
      }
    }
  }

  // Computes the number of neighbors.
  public int neighbors(int row, int col){
    int neighborQuantity = 0;

    if (row == 0 && col == 0){
      return neighborQuantity = previous[row][col + 1] + previous[row + 1][col + 1] + previous[row + 1][col];
    } else if (row == 0 && col == previous[row].length - 1){
      return neighborQuantity = previous[row][col - 1] + previous[row + 1][col - 1] + previous[row + 1][col];
    }  else if (row == 0){
      return neighborQuantity = previous[row][col - 1] + previous[row + 1][col - 1] + previous[row + 1][col] + previous[row + 1][col + 1] + previous[row][col + 1];
    } else if (row == previous.length - 1 && col == 0){
      return neighborQuantity = previous[row - 1][col] + previous[row - 1][col + 1] + previous[row][col + 1];
    } else if(col == 0){
      return neighborQuantity = previous[row - 1][col] + previous[row - 1][col + 1] + previous[row][col + 1] + previous[row + 1][col + 1] + previous[row + 1][col];
    } else if (row == previous.length - 1 && col == previous[row].length - 1){
      return neighborQuantity = previous[row][col - 1] + previous[row - 1][col - 1] + previous[row - 1][col];
    } else if (col == previous[row].length - 1){
      return neighborQuantity = previous[row - 1][col] + previous[row - 1][col - 1] + previous[row][col - 1] + previous[row + 1][col - 1] + previous[row + 1][col];
    } else if (row == previous.length - 1){
      return neighborQuantity = previous[row][col - 1] + previous[row - 1][col - 1] + previous[row - 1][col] + previous[row - 1][col + 1] + previous[row][col + 1];
    } else {
      return neighborQuantity = previous[row - 1][col - 1] + previous[row - 1][col] + previous[row - 1][col + 1] + previous[row][col + 1] + previous[row + 1][col + 1] + previous[row + 1][col] + previous[row + 1][col - 1] + previous[row][col - 1];
    }
  }

  // Transforms the board after n steps of evolution.
  public void evolution(int steps){
    for (int i = 1; i <= steps; i++){
      oneStep();
    }
  }
}
