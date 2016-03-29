package com.Hanjunchen.SinglyLinkedList;

public class ListNode<E> {
	public ListNode(E data, ListNode<E> next){
		this.data = data;
		this.next = next;
	}
	public ListNode(E data){
		this.data=data;
		next=null;
	}
	private E data;
	
	public E getData() {
		return data;
	}
	
	public void setData(E dataValue) {
		data = dataValue;
	}

	
	private ListNode<E> next;
	
	public ListNode<E> getNext() {
		// TODO Auto-generated method stub
		return next;
	}
	public void setNext(ListNode<E> crunchifyTemp) {
		// TODO Auto-generated method stub
		next = crunchifyTemp;
	}
}
