package Stack;

public class NMTSTACK<X> implements ISTACK<X> {
	private X car; //first of the list
	private ISTACK<X> cdr; // rest of the list
	
	public NMTSTACK(X f, ISTACK<X> r) {
		car = f;//first of the list
		cdr = r;//restt of the list	}
	
	//Purpose: to push an element on a stack, (putting an new element on top). var X is our list and local variable v get puts on top of the stack.
	public ISTACK<X> push(X v){
		return new NMTSTACK<X>(v,this);	}//Returns a new non empty stack with new element as the first element 
	
	//Purpose: To pop a stack which returns the rest of the list.
	public ISTACK<X> pop() throws Exception {//if the rest is empty, then return the exception
		return this.cdr;//cdr is a private variable that returns rest of list. 
	}
		
	//Purpose: Returns the first element or "top" of the stack. Does not get changed in any way.	
	public X top() throws Exception{return car;}//Exception used to try to catch a error. 
	
	
	//Purpose: To check if the stack is empty or not
	public boolean emptyStack() {return false;}// returns false because the non empty stack will lever be empty.
	
	//Purpose: Helps reverse the stack
	private ISTACK<X> revhelper(ISTACK<X> l, ISTACK<X>res)//creates 2 stacks 
	//ACCUM INV: reverse(this) == append(reverse(l), res)
	{try {if(l.emptyStack()) {return res;}//if the stack is empty, returns the empty resonator
	else{return (revhelper(l.stackrest(), res.push(l.top())));}}//Takes in rest of the stack and pushes the top element of l onto res. 
	catch(Exception e) {
		System.out.println("Error StackNMTLIST append: "+ e.getMessage());//if error is caught, it returns the string.
		return this;}	}
	
	//Purpose: Revereses a stack and returns its reversed form	
	public ISTACK<X> reverse() {ISTACK<X> A = new MTSTACK<X>(); //creates a new empty stack
		return(revhelper(this, A));}//Uses the empty list to place the reversed stack
	
	//Purpose: Returns the given stack in a string
	public String ToString() {return "First Stack: "+this.car+""+this.cdr.ToString();}

	public static void main(String[] args) throws Exception {
		ISTACK<String> A = new MTSTACK<String>();
		ISTACK<String> A1 = A.push("Hans").push("there ").push("Hello ");
		ISTACK<String> A2 = A.push("Hello ").push("there ").push("Hans ");
		ISTACK<String> A3 = A.push("Hans").push("there ");
	
	
		System.out.println((A1.pop().ToString()));
		System.out.println(A3.ToString());
	}



}
