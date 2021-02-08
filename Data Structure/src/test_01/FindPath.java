package test_01;

public class FindPath {
       static final int NOMOVE = 0;  // 0000 = no path
       static final int LEFT = 1000; // 1000 = can go left
       static final int RIGHT = 100; //  100 = can go right
       static final int UP = 10;     //   10 = can go up
       static final int DOWN = 1;    //    1 = can go down
      // 문제를 쉽게하기 위해, 1개의 cell 에서는 한 방향으로만 이동이 가능
       
      public static void main(String[] args) {
         int[][] map1 = { {   0,  100, 0},
                      { 100,   10, 0},
                      {  10,    0, 0}}; // there IS a path from Start to Finish
         int[][] map2 = { {   0, 1000, 0},
                      { 100,   10, 0},
                      {  10,    0, 0}}; // there is NO such a path
         int nROW = 3;
         int nCOL = 3;
         
         int startY = 2, startX = 0;
         int finishY = 0, finishX = 2;
         
         System.out.print("map 1 : ");
         findPath(map1, startY, startX, finishY, finishX, nROW, nCOL);
         System.out.print("map 2 : ");
         findPath(map2, startY, startX, finishY, finishX, nROW, nCOL);
      }
      public static void findPath(int[][] map, int currY, int currX,
                                int endY, int endX, int nRow, int nCol) {
         String suc = "Found a path!";
         String fai = "There is no path!";
         if(currY == endY && currX == endX) System.out.println(suc); //현재 나의 위치가 종료지점인가? 
         if(currX < 0 || currX >= nCol) System.out.println(fai); //현재 나의 X좌표가 지도 밖인가?
         if(currY < 0 || currY >= nRow) System.out.println(fai); //현재 나의 Y좌표가 지도 밖인가?
         
         
         int direction = map[currY][currX];
         if(direction == LEFT) findPath(map, currY, currX-1, endY, endX, nRow, nCol);
         if(direction == RIGHT) findPath(map, currY, currX+1, endY, endX, nRow, nCol);
         if(direction == UP) findPath(map, currY-1, currX, endY, endX, nRow, nCol);
         if(direction == DOWN) findPath(map, currY+1, currX, endY, endX, nRow, nCol);
         if(direction == NOMOVE) {if(currY != endY || currX != endX) System.out.println(fai); }
         
      }
}
