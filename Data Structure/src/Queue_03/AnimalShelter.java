package Queue_03;

import java.util.NoSuchElementException;

import SLL.Node;

public class AnimalShelter <E> {
	private Node<E> Dfront, Drear, Cfront, Crear, front, rear;
    private int size, Csize, Dsize;
    public AnimalShelter() {
    	Dfront = Drear = null; //개만 저장할 큐
    	Cfront = Crear = null; //고양이만 저장할 큐
    	front = rear = null; //둘다 저장될 큐
    	size = 0; //공용큐의 크기
    	Dsize = 0; //개 큐의 크기
    	Csize = 0; //고양이 큐의 크기
    }
    public int size() { return size; }
    public int Dsize() { return Dsize; }
    public int Csize() { return Csize; }
    public boolean isEmpty() { return size() == 0; }
    public boolean DisEmpty() { return Dsize() == 0; }
    public boolean CisEmpty() { return Csize() == 0; }
    
    public void add(E newItem) { //아이템 추가 메소드
    	Node newNode = new Node(newItem, null);
    	if (isEmpty()) front = newNode;
    	else rear.setNext(newNode);
    	rear = newNode;
    	size++;
    }
    
    public E remove() { //아이템 삭제 메소드
    	if (isEmpty()) throw new NoSuchElementException();
    	E frontItem = front.getItem();
    	front = front.getNext();
    	size--;
    	if(isEmpty()) rear = null;
    	return frontItem;
    }
    
    public void addDog(E newItem) { //개를 추가하는 메소드
        E newItem2 = (E)((String)newItem + " (Dog)"); //입력받은 newItem에 (Dog)를 추가함
    	Node newNode = new Node(newItem2, null); 
    	if (DisEmpty()) Dfront = newNode; //개만의 큐에 추가
    	else Drear.setNext(newNode);
    	Drear = newNode;
    	Dsize++;
    	this.add(newItem2); //공용 큐에 추가
    }
    
    public void addCat(E newItem) { //고양이를 추가하는 메소드
    	E newItem2 = (E)((String)newItem + " (Cat)"); //입력받은 newItem에 (Cat)을 추가함
    	Node newNode = new Node(newItem2, null);
    	if (CisEmpty()) Cfront = newNode; //고양이만의 큐에 추가
    	else Crear.setNext(newNode);
    	Crear = newNode;
    	Csize++;
    	this.add(newItem2); //공용 큐에 추가
    }
    
    public E adoptAny() { //고양이, 개 둘중 가장 먼저 들어온 동물을 입양 보내는 메소드
    	E q = this.remove(); //공용 큐에서 삭제 후 q에 저장해 놓음
    	if (q == Dfront.getItem()) { //삭제한 q가 개면 개만의 큐에서도 삭제함
    		Dfront = Dfront.getNext();
    		Dsize--;
    		if (isEmpty()) rear = null;
    	}
    	else { // 삭제한 q가 고양이면 고양이만의 큐에서도 삭제함
    		Cfront = Cfront.getNext();
    		Csize--;
    		if (isEmpty()) rear = null;
    	}
    	return q;
    }
    
    public E adoptDog() { //가장 먼저 들어온 개를 입양 보내는 메소드
    	if (isEmpty()) throw new NoSuchElementException();
    	Node<E> q = front;
    	while(true) { //계속 반복시킴
    		if(Dfront.getItem() == q.getItem()) { //맨 앞이 개라면 바로 입양보내는 조건문 
    			front = front.getNext();
    			size--;
    			break; //조건문 통과 후 반복문 탈출
    		}
    		else { //맨 앞이 고양이 일때 고양이 뒤에 있는 개를 입양보내는 조건문 
    			q = q.getNext(); //공용의 큐의 front가 개가 아니였기 때문에 다음 노드로 간다.
    			if(Dfront.getItem() == q.getItem()) { //다음노드로 간 후 개인지 확인  ->개라면 입양보내고 반복문 탈출, ->개가 아니면 다시반복
    				q = q.getNext();
    				front.setNext(q);
        			size--;
        			break;	
    			}
    		}
    	}
    	E DfrontItem = Dfront.getItem(); //개만의 큐에서도 입양을 보낸다.
    	Dfront = Dfront.getNext();
    	Dsize--;
    	if (isEmpty()) rear = null;
    	return DfrontItem;
    }
    
    public E adoptCat() { //가장 먼저 들어온 고양이를 입양 보내는 메소드
    	if (isEmpty()) throw new NoSuchElementException();
    	Node<E> q = front;
    	while(true) { //계속 반복시킴
    		if(Cfront.getItem() == q.getItem()) { //맨 앞이 고양이라면 바로 입양보내는 조건문
    			front = front.getNext();
    			size--;
    			break; //조건문 통과 후 반복문 탈출
    		}
    		else { //맨앞이 개 일때 개 뒤에 있는 고양이를 입양보내는 조건문 
    			q = q.getNext(); //공용의 큐의 front가 고양이가 아니므로 다음 노드로 간다.
    			if(Cfront.getItem() == q.getItem()) { //다음노드로 간 후 고양이인지 확인 ->고양이면 입양보내고 반복문 탈출, ->고양이가 아니면 다시 반복
    				q = q.getNext();
    				front.setNext(q);
        			size--;
        			break;	
    			}
    		}
    	}
    	E CfrontItem = Cfront.getItem(); //고양이만의 큐에서도 입양을 보낸다.
    	Cfront = Cfront.getNext();
    	Csize--;
    	if (isEmpty()) rear = null;
    	return CfrontItem;
    }
    
    public void print() { //출력하는 메소드
    	if (isEmpty()) throw new NoSuchElementException();
    	Node<E> q = front;
    	for(int i = 0; i < size; i++) {
    		
    		System.out.print(q.getItem() + "\t");
    		q = q.getNext();
    	}
    	System.out.println();
    }
}
