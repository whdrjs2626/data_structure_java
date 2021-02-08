package Queue_03;

import java.util.NoSuchElementException;

import SLL.Node;

public class AnimalShelter <E> {
	private Node<E> Dfront, Drear, Cfront, Crear, front, rear;
    private int size, Csize, Dsize;
    public AnimalShelter() {
    	Dfront = Drear = null; //���� ������ ť
    	Cfront = Crear = null; //����̸� ������ ť
    	front = rear = null; //�Ѵ� ����� ť
    	size = 0; //����ť�� ũ��
    	Dsize = 0; //�� ť�� ũ��
    	Csize = 0; //����� ť�� ũ��
    }
    public int size() { return size; }
    public int Dsize() { return Dsize; }
    public int Csize() { return Csize; }
    public boolean isEmpty() { return size() == 0; }
    public boolean DisEmpty() { return Dsize() == 0; }
    public boolean CisEmpty() { return Csize() == 0; }
    
    public void add(E newItem) { //������ �߰� �޼ҵ�
    	Node newNode = new Node(newItem, null);
    	if (isEmpty()) front = newNode;
    	else rear.setNext(newNode);
    	rear = newNode;
    	size++;
    }
    
    public E remove() { //������ ���� �޼ҵ�
    	if (isEmpty()) throw new NoSuchElementException();
    	E frontItem = front.getItem();
    	front = front.getNext();
    	size--;
    	if(isEmpty()) rear = null;
    	return frontItem;
    }
    
    public void addDog(E newItem) { //���� �߰��ϴ� �޼ҵ�
        E newItem2 = (E)((String)newItem + " (Dog)"); //�Է¹��� newItem�� (Dog)�� �߰���
    	Node newNode = new Node(newItem2, null); 
    	if (DisEmpty()) Dfront = newNode; //������ ť�� �߰�
    	else Drear.setNext(newNode);
    	Drear = newNode;
    	Dsize++;
    	this.add(newItem2); //���� ť�� �߰�
    }
    
    public void addCat(E newItem) { //����̸� �߰��ϴ� �޼ҵ�
    	E newItem2 = (E)((String)newItem + " (Cat)"); //�Է¹��� newItem�� (Cat)�� �߰���
    	Node newNode = new Node(newItem2, null);
    	if (CisEmpty()) Cfront = newNode; //����̸��� ť�� �߰�
    	else Crear.setNext(newNode);
    	Crear = newNode;
    	Csize++;
    	this.add(newItem2); //���� ť�� �߰�
    }
    
    public E adoptAny() { //�����, �� ���� ���� ���� ���� ������ �Ծ� ������ �޼ҵ�
    	E q = this.remove(); //���� ť���� ���� �� q�� ������ ����
    	if (q == Dfront.getItem()) { //������ q�� ���� ������ ť������ ������
    		Dfront = Dfront.getNext();
    		Dsize--;
    		if (isEmpty()) rear = null;
    	}
    	else { // ������ q�� ����̸� ����̸��� ť������ ������
    		Cfront = Cfront.getNext();
    		Csize--;
    		if (isEmpty()) rear = null;
    	}
    	return q;
    }
    
    public E adoptDog() { //���� ���� ���� ���� �Ծ� ������ �޼ҵ�
    	if (isEmpty()) throw new NoSuchElementException();
    	Node<E> q = front;
    	while(true) { //��� �ݺ���Ŵ
    		if(Dfront.getItem() == q.getItem()) { //�� ���� ����� �ٷ� �Ծ纸���� ���ǹ� 
    			front = front.getNext();
    			size--;
    			break; //���ǹ� ��� �� �ݺ��� Ż��
    		}
    		else { //�� ���� ����� �϶� ����� �ڿ� �ִ� ���� �Ծ纸���� ���ǹ� 
    			q = q.getNext(); //������ ť�� front�� ���� �ƴϿ��� ������ ���� ���� ����.
    			if(Dfront.getItem() == q.getItem()) { //�������� �� �� ������ Ȯ��  ->����� �Ծ纸���� �ݺ��� Ż��, ->���� �ƴϸ� �ٽùݺ�
    				q = q.getNext();
    				front.setNext(q);
        			size--;
        			break;	
    			}
    		}
    	}
    	E DfrontItem = Dfront.getItem(); //������ ť������ �Ծ��� ������.
    	Dfront = Dfront.getNext();
    	Dsize--;
    	if (isEmpty()) rear = null;
    	return DfrontItem;
    }
    
    public E adoptCat() { //���� ���� ���� ����̸� �Ծ� ������ �޼ҵ�
    	if (isEmpty()) throw new NoSuchElementException();
    	Node<E> q = front;
    	while(true) { //��� �ݺ���Ŵ
    		if(Cfront.getItem() == q.getItem()) { //�� ���� ����̶�� �ٷ� �Ծ纸���� ���ǹ�
    			front = front.getNext();
    			size--;
    			break; //���ǹ� ��� �� �ݺ��� Ż��
    		}
    		else { //�Ǿ��� �� �϶� �� �ڿ� �ִ� ����̸� �Ծ纸���� ���ǹ� 
    			q = q.getNext(); //������ ť�� front�� ����̰� �ƴϹǷ� ���� ���� ����.
    			if(Cfront.getItem() == q.getItem()) { //�������� �� �� ��������� Ȯ�� ->����̸� �Ծ纸���� �ݺ��� Ż��, ->����̰� �ƴϸ� �ٽ� �ݺ�
    				q = q.getNext();
    				front.setNext(q);
        			size--;
        			break;	
    			}
    		}
    	}
    	E CfrontItem = Cfront.getItem(); //����̸��� ť������ �Ծ��� ������.
    	Cfront = Cfront.getNext();
    	Csize--;
    	if (isEmpty()) rear = null;
    	return CfrontItem;
    }
    
    public void print() { //����ϴ� �޼ҵ�
    	if (isEmpty()) throw new NoSuchElementException();
    	Node<E> q = front;
    	for(int i = 0; i < size; i++) {
    		
    		System.out.print(q.getItem() + "\t");
    		q = q.getNext();
    	}
    	System.out.println();
    }
}
