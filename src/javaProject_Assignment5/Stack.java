package javaProject_Assignment5; //Package declaration is mandatory

/*Create an interface Stack in package myPack with following methods
* void push(int I)
* int pop()
Create two subclasses inheriting the Stack interface.

class FixedStack that can accept a fixed numbers of integers. The size of the Stack will be specified
in the constructor. If the number of integers exceeds the size, “Stack overflow” message should
be displayed.

class VariableStack that can accept numbers more than its size. The size of the Stack will be
specified in the constructor. If the number of integers exceeds the size, the stack should
automatically grow to accommodate the new element.*/

//Import Project
import MyPack.IStack;

//class FixedStack
class FixedStack implements IStack
{
	//Declare variable
	//size of stack 
	 private int stk[ ];
	 
	 //Fixed no of integers
     private int tos;
     
     //Parameterized Constructor 
	FixedStack(int size)
	{
		//size of stack initialized
		 stk=new int[size];
         tos=-1;
	}
	
	//Method
public void push(int item) 
{
	//logic applied
	 if(tos==stk.length-1)
     {
             System.out.println("Stack Overflows");
             int t[ ]=new int[stk.length * 2];
             for(int i=0;i<stk.length;i++)
                     t[i]=stk[i];
             stk=t;
             stk[++tos]=item;
     }
     else
             stk[++tos]=item;
}
public int pop() 
{
	  if(tos<0)
      {
              System.out.println("Stack Underflows");
              return 0;
      }
      else
              return stk[tos--];
}
	
}

//class VariableStack
class VariableStack implements IStack
{
	//Method declaration
	  private int stk[ ];
      private int tos;
      
      //Parameterized Constructor 
	VariableStack(int size)
	{
		  stk=new int[size];
          tos=-1;
	
	}
	
	//Methods
public void push(int item) 
{
	 if(tos==stk.length-1)
     {
             System.out.println("Stack Overflows.");
             int t[ ]=new int[stk.length * 2];
             for(int i=0;i<stk.length;i++)
                     t[i]=stk[i];
             stk=t;
             stk[++tos]=item;
     }
     else
             stk[++tos]=item;
}
public int  pop() 
{
	 if(tos<0)
     {
             System.out.println("Stack Underflows.");
             return 0;
     }
     else
             return stk[tos--];
}
	
}

//Main class
class StackTest
{
	//Main method started
        public static void main(String args[ ])
        {
        	//object created with size of stack
                FixedStack fs=new FixedStack(3);
                VariableStack ds=new VariableStack(5);
                
                //Interface
                IStack mystk;
                //FixedStack - push
                for(int i=0;i<3;i++)
                        fs.push(i);
                System.out.println("Fixed length Stack Contents are.");
                //FixedStack =- pop
                for(int i=0;i<3;i++)
                        System.out.println(fs.pop());
                //VariableStack - pop
                for(int i=0;i<7;i++)
                        ds.push(i);
                //VariableStack - pop
                System.out.println("Dynamic length Stack Contents are");
                for(int i=0;i<7;i++)
                        System.out.println(ds.pop());
                
                mystk=fs;
                for(int i=0;i<3;i++)
                        mystk.push(i);
                System.out.println("Fixed length Stack Contents using interface reference");
                for(int i=0;i<3;i++)
                        System.out.println(mystk.pop());
                mystk=(IStack) ds;
                for(int i=0;i<7;i++)
                        mystk.push(i);
                System.out.println("Dynamic length Stack Contents using interface reference");
                for(int i=0;i<7;i++)
                        System.out.println(mystk.pop());
        }
}


