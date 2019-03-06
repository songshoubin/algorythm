package algorythm;


/**
 * 链表的反转
 * @author song
 *
 */
public class LInkedLIstReverse {
	public static void main(String[] args) {
		Node head =  new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		
		//反转前打印链表
		Node hNode = head;
		while(hNode!=null){
			System.out.println(hNode.getData());
			hNode = hNode.getNext();
		}
		
		//调用反转函数
		head = reverseLinkedList(head);
		
		//打印反转链表
		Node hNode2 = head;
		while(hNode2!=null){
			System.out.println(hNode2.getData());
			hNode2 = hNode2.getNext();
		}
		
		
	}
	
	public static Node reverseLinkedList(Node head){//递归反转链表
		if(head==null||head.getNext()==null)//空链表或者递归
			return head;
		Node rehead = reverseLinkedList(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return rehead;
	}
}

//定义结点
class Node {
	private int Data;// 数据域
	private Node Next;// 指针域

	public Node(int Data) {
		// super();
		this.Data = Data;
	}

	public int getData() {
		return Data;
	}

	public void setData(int Data) {
		this.Data = Data;
	}

	public Node getNext() {
		return Next;
	}

	public void setNext(Node Next) {
		this.Next = Next;
	}
}
