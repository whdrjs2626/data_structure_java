package test_01;
import java.util.Scanner;

public class OX {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      String[] quiz = new String[N];
      int[] allscore = new int[N];
      // ASCII CODE. O= 79, X=88 

      for(int i = 0; i<N;i++) {
    	  quiz[i] = sc.nextLine();
         
         int score=0; //다음 OX문자열로 넘어갈 때 점수 초기화
         
         for(int f=0;f<quiz[i].length();f++) {
            if(quiz[i].charAt(f)!='O') {
               score = 0; //X를 만났을 때 연승점수 초기화
            }
            if(quiz[i].charAt(f)=='O') {
               score++;
               allscore[i] += score;
            }            
         }
      }
      for(int a =0;a<N;a++) {
         System.out.println(allscore[a]);
      }
   }
}