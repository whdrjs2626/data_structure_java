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
         
         int score=0; //���� OX���ڿ��� �Ѿ �� ���� �ʱ�ȭ
         
         for(int f=0;f<quiz[i].length();f++) {
            if(quiz[i].charAt(f)!='O') {
               score = 0; //X�� ������ �� �������� �ʱ�ȭ
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