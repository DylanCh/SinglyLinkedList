package com.Hanjunchen.SinglyLinkedList;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        MyList<Integer> list = new MyList<Integer>(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");
            System.out.println("7. compare with an array");
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.addToHead( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.addToTail( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.size() )
                    System.out.println("Invalid position\n");
                else
                    list.add(pos,num);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.size() )
                    System.out.println("Invalid position\n");
                else
                    list.remove(p);
                break;
            case 5 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;                   
            case 6 : 
                System.out.println("Size = "+ list.size() +" \n");
                break;                         
            case 7:
            	int arraySize;
            	//Scanner input = new Scanner(System.in);
            	System.out.print("How many elements are there in your array");
            	arraySize = scan.nextInt();
            	Object[] objArray = new Object[arraySize];
            	for (int i = 0; i < arraySize; i++)
                {
                    System.out.println("Please enter the next element");
                    objArray[i]=scan.nextInt();
                }
            	System.out.print("The list and the array are");
            	if (list.equals(objArray))
            		System.out.print(" equal.");
            	else System.out.print(" not equal.");
            	break;
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
            
        } while (ch == 'Y'|| ch == 'y');               
        scan.close();
	}
}

