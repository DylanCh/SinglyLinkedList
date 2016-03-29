package com.Hanjunchen.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<E> implements List<E>{

	private ListNode<E> head, tail;
	private static int counter;
	
	public MyList(){
		head = null;
		tail = null;
		counter = 0;
	}
	
	/*returns true if o equals this list. Two lists are equal if they have the same
	size and the elements are pair-wisely equal.*/
	public boolean equals(Object o){
		/* check if type of Object equals type of E*/
		if ( this.getClass().equals(o.getClass())){
			List<E> list = new ArrayList<E>();
			
			E[] objArray = (E[])o;
			
			// check if length are the same
			if (!(objArray.length == this.size())){
				return false;
			}
		
			else {
				for (E i:objArray){
						list.add(i);
				}
				for (Object j : list){
					for (E k : this){
						if ( j != k){
							return false;
						}
					}
				}
				return true;
			}
		}
		else return false;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return getCounter();
	}

	private static int getCounter() {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tail == null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		boolean contains = false;
		if (!(o.getClass().equals(this.getClass()))){
			return contains;
		}
		
		for (E i : this){
			if (i == (E)o){
				contains =  true;
				break;
			}
		}
		return contains;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] objArray = null;
		for (int i=0; i<this.size();i++){
			for(E k : this){
			objArray[i]=k;
			}
		}
		return objArray;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		for (int i =0; i< a.length; i++){
			for(E k : this){
				try{
					a[i] =  (T) k;
				}
				catch(Exception e){
					e.printStackTrace();
				}	
			}
		}
		return a;
	}

	// appends the specified element to the end of this list.
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		// Initialize Node only incase of 1st element
				if (head == null) {
					head = new ListNode<E>(e);
				}
		 
				ListNode<E> crunchifyTemp = new ListNode<E>(e);
				ListNode<E> crunchifyCurrent = head;
		 
				// Let's check for NPE before iterate over crunchifyCurrent
				if (crunchifyCurrent != null) {
		 
					// starting at the head node, crawl to the end of the list and then add element after last node
					while (crunchifyCurrent.getNext() != null) {
						crunchifyCurrent = crunchifyCurrent.getNext();
					}
		 
					// the last node's "next" reference set to our new node
					crunchifyCurrent.setNext(crunchifyTemp);
				}
		 
				// increment the number of elements variable
				incrementCounter();
		return false;
	}
	
	// inserts the specified element at the specified position in this list
	@Override
	public void add(int index, E element) {
		ListNode<E> temp = new ListNode<E>(element);
		ListNode<E> current = head;
 
		// Let's check for NPE before iterate over crunchifyCurrent
		if (current != null) {
			// crawl to the requested index or the last element in the list, whichever comes first
			for (int i = 0; i < index && current.getNext() != null; i++) {
				current = current.getNext();
			}
		}
 
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.getNext());
 
		// now set this node's next-node reference to the new node
		current.setNext(temp);
 
		// increment the number of elements variable
		incrementCounter();
	}
	
	public void addToHead(E val){
		ListNode<E> nptr = new ListNode<E>(val, null);    
        counter++ ;    
        if(head == null) 
        {
            head = nptr;
            tail = head;
        }
        else 
        {
            nptr.setNext(head);
            head = nptr;
        }
	}
	
	public void addToTail(E val)
    {
        ListNode<E> nptr = new ListNode<E>(val,null);    
        counter++ ;    
        if(head == null) 
        {
            head = nptr;
            tail = head;
        }
        else 
        {
            tail.setNext(nptr);
            tail = nptr;
        }
    }

	private void incrementCounter() {
		// TODO Auto-generated method stub
		counter++;
	}

	// removes the element at the specified position in this list.
	// Object o actually serves as an index (int) in this overridden method
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		
		if(head == null) throw new RuntimeException("cannot delete");

		   if( head.getData().equals((E)o) )
		   {
		      head = head.getNext();
		      return true;
		   }

		   ListNode<E> cur  = head;
		   ListNode<E> prev = null;

		   while(cur != null && !cur.getData().equals((E)o) )
		   {
		      prev = cur;
		      cur = cur.getNext();
		   }

		   if(cur == null) throw new RuntimeException("cannot delete");
		   
		   //delete cur node
		   prev.setNext(cur.getNext());
				return true;
	}
	
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if (index < 1 || index > size()){
			System.out.println("Object does not exist");
			return null;
		}
		
		ListNode<E> current = head;
		ListNode<E> temp = new ListNode<E>(current.getData());
		if (head != null) {
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null)
					return null;
 
				temp.setData(current.getData());;
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
 
			// decrement the number of elements variable
			decrementCounter();
			return temp.getData();
 
		}
		return null;
	}

	private void decrementCounter() {
		// TODO Auto-generated method stub
		counter--;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		// index must be 1 or higher
		if (index <= 0)
			return null;
		ListNode<E> current = null;
		if (head != null) {
			current = head.getNext();
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null)
					return null;
 
				current = current.getNext();
			}
			return current.getData();
		}
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		ListNode<E> current = head;
 
		if (current != null) {
			// crawl to the requested index or the last element in the list, whichever comes first
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
		}
 
		// now set this node's next-node reference to the new node
		current.setData(element);
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		 return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements ListIterator<E>
	{
	   private ListNode<E> nextNode;

	   public LinkedListIterator()
	   {
	      nextNode = head;
	   }

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E previous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

	  }

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		String output = "";
 
		if (head != null) {
			ListNode<E> crunchifyCurrent = head.getNext();
			while (crunchifyCurrent != null) {
				output += "[" + crunchifyCurrent.getData().toString() + "]";
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
 
		}
		return output;
	}

	public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (counter == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (head.getNext() == null) 
        {
            System.out.println(head.getData() );
            return;
        }
        ListNode<E> ptr = head;
        System.out.print(head.getData()+ "->");
        ptr = head.getNext();
        while (ptr.getNext() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}

