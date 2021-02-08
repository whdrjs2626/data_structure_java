package Sort;

public class TimeCompare {
    public static void main(String[] args) {
    	GenData    dg = new GenData();
    	BubbleSort b  = new BubbleSort();
    	Selection  s  = new Selection();
    	Insertion  i  = new Insertion();
    	Merge      m  = new Merge();
    	Quick      q  = new Quick();
    	int[]        arr  = dg.genRandIntArr(10000, 0, 30000); // create an array
    	Comparable[] arr2 = deepCopy(arr);
    	Comparable[] arr3 = deepCopy(arr);
    	Comparable[] arr4 = deepCopy(arr);
    	Comparable[] arr5 = deepCopy(arr);
    	
    	long beforeTime = System.currentTimeMillis(); // start the timer
    	b.doSort(arr); //실행시간을 측정하고자 하는 함수를 여기에 넣으세요
    	long afterTime = System.currentTimeMillis(); // finish the timer
    	long diffTimeMilliSecond = afterTime-beforeTime; // get the diff
    	System.out.println("[BubbleSort] Time diff (ms): " + diffTimeMilliSecond);
    	
    	long beforeTime2 = System.currentTimeMillis(); // start the timer
    	s.sort(arr2); //실행시간을 측정하고자 하는 함수를 여기에 넣으세요
    	long afterTime2 = System.currentTimeMillis(); // finish the timer
    	long diffTimeMilliSecond2 = afterTime2-beforeTime2; // get the diff
    	System.out.println("[SelectionSort] Time diff (ms): " + diffTimeMilliSecond2);
    	
    	long beforeTime3 = System.currentTimeMillis(); // start the timer
    	i.sort(arr3); //실행시간을 측정하고자 하는 함수를 여기에 넣으세요
    	long afterTime3 = System.currentTimeMillis(); // finish the timer
    	long diffTimeMilliSecond3 = afterTime3-beforeTime3; // get the diff
    	System.out.println("[InsertionSort] Time diff (ms): " + diffTimeMilliSecond3);
    	
    	long beforeTime4 = System.currentTimeMillis(); // start the timer
    	m.sort(arr4); //실행시간을 측정하고자 하는 함수를 여기에 넣으세요
    	long afterTime4 = System.currentTimeMillis(); // finish the timer
    	long diffTimeMilliSecond4 = afterTime4-beforeTime4; // get the diff
    	System.out.println("[MergeSort] Time diff (ms): " + diffTimeMilliSecond4);
    	
    	long beforeTime5 = System.currentTimeMillis(); // start the timer
    	q.sort(arr5); //실행시간을 측정하고자 하는 함수를 여기에 넣으세요
    	long afterTime5 = System.currentTimeMillis(); // finish the timer
    	long diffTimeMilliSecond5 = afterTime5-beforeTime5; // get the diff
    	System.out.println("[QuickSort] Time diff (ms): " + diffTimeMilliSecond5);
    }
    
    public static Comparable[] deepCopy(int[] src){
        if(src == null) return null;
        Comparable[] src1 = new Comparable[src.length];
        for(int i = 0; i < src.length; i++) {
        	src1[i] = src[i];
        }
        Comparable[] dest = new Comparable[src.length];
        dest = src1.clone();
        return dest;
      }
}
