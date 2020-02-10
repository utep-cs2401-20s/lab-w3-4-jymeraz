import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GOTester {
  @Test
  public void testNeighbors1() {
    int[][] a =
        {{0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0},
         {0, 1, 1, 1, 0},
         {0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0}};
    GameOfLife testOne = new GameOfLife(a);
    assertEquals(3, testOne.neighbors(1, 2));
//    System.out.print(testOne.neighbors(1, 2));
  }
  @Test
  public void testNeighbors2() {
    int[][] a =
        {{0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 1, 1, 1, 0},
         {0, 1, 1, 1, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0}};
    GameOfLife testOne = new GameOfLife(a);
    assertEquals(4, testOne.neighbors(3, 3));
//    System.out.print(testOne.neighbors(3, 3));
  }

  @Test
  public void testOneStep1() {
    int[][] a =
        {{0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0},
         {0, 1, 1, 1, 0},
         {0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0}};
    GameOfLife testOne = new GameOfLife(a);
    testOne.oneStep();

    int[][] b =
        {{0, 0, 0, 0, 0},
         {0, 0, 1, 0, 0},
         {0, 0, 1, 0, 0},
         {0, 0, 1, 0, 0},
         {0, 0, 0, 0, 0}};

    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a.length; j++){
        assertEquals(b[i][j], testOne.getBoard()[i][j]);
      }
    }
//    for (int i = 0; i < a.length; i++){
//      for (int j = 0; j < a.length; j++){
//        System.out.print(b[i][j]);
//      }
//      System.out.println();
//    }
  }
  @Test
  public void testOneStep2() {
    int[][] a =
        {{0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 1, 1, 1, 0},
         {0, 1, 1, 1, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0}};

    GameOfLife testTwo = new GameOfLife(a);
    testTwo.oneStep();

    int[][] b =
        {{0, 0, 0, 0, 0, 0},
         {0, 0, 0, 1, 0, 0},
         {0, 1, 0, 0, 1, 0},
         {0, 1, 0, 0, 1, 0},
         {0, 0, 1, 0, 0, 0},
         {0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a.length; j++){
        assertEquals(b[i][j], testTwo.getBoard()[i][j]);
      }
    }
  }
  @Test
  public void testOneStep3() {
    int[][] a =
        {{0, 0, 0, 0, 0, 0},
         {0, 1, 1, 0, 0, 0},
         {0, 1, 1, 0, 0, 0},
         {0, 0, 0, 1, 1, 0},
         {0, 0, 0, 1, 1, 0},
         {0, 0, 0, 0, 0, 0}};

    GameOfLife testThree = new GameOfLife(a);
    testThree.oneStep();

    int[][] b =
        {{0, 0, 0, 0, 0, 0},
         {0, 1, 1, 0, 0, 0},
         {0, 1, 0, 0, 0, 0},
         {0, 0, 0, 0, 1, 0},
         {0, 0, 0, 1, 1, 0},
         {0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a.length; j++){
        assertEquals(b[i][j], testThree.getBoard()[i][j]);
      }
    }
  }
  @Test
  public void testOneStep5() {
    int[][] a =
        {{1, 1, 0},
         {1, 0, 0}};

    GameOfLife testFour = new GameOfLife(a);
    testFour.oneStep();

    int[][] b =
        {{1, 1, 0},
         {1, 1, 0}};

    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a[i].length; j++){
        System.out.print(testFour.getBoard()[i][j]);
      }
      System.out.println();
    }

    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a[i].length; j++){
        assertEquals(b[i][j], testFour.getBoard()[i][j]);
      }
    }
  }
  @Test
  public void testOneStep4() {
    int[][] a =
        {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
         {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
         {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
         {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
         {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    GameOfLife testFour = new GameOfLife(a);
    testFour.oneStep();

    int[][] b =
        {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
         {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
         {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a[i].length; j++){
        System.out.print(testFour.getBoard()[i][j]);
      }
      System.out.println();
    }

    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a[i].length; j++){
        assertEquals(b[i][j], testFour.getBoard()[i][j]);
      }
    }
  }
  @Test
  public void testEvolution1() {
    int[][] a =
        {{0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0},
         {0, 1, 1, 1, 0},
         {0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0}};

    GameOfLife testOne = new GameOfLife(a);
    testOne.evolution(4);

    int[][] b =
        {{0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0},
         {0, 1, 1, 1, 0},
         {0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0}};

    int[][] c = testOne.getBoard();

    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a.length; j++){
        System.out.print(c[i][j]);
      }
      System.out.println();
    }

    for (int i = 0; i < a.length; i++){
      for (int j = 0; j < a.length; j++){
        assertEquals(b[i][j], c[i][j]);
      }
    }

  }
  @Test
  public void testTorusNeighbors1() {
    int[][] a =
        {{1, 1, 1, 1},
         {1, 1, 1, 1},
         {1, 1, 1, 1},
         {1, 1, 1, 1}};

    TorusGameOfLife testOne = new TorusGameOfLife(a);
    System.out.print(testOne.neighbors(0, 0));
    assertEquals(8, testOne.neighbors(0, 0));
    //System.out.print(testOne.neighbors(0, 0));
  }
}
