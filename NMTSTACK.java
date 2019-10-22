
package Stack;

	/**
	 * Purpose: Class for Non-Empty Stack : without list
	 *
	 * @param <X>
	 */
	public class NMTSTACK<X> implements ISTACK<X> {
		
		//first of the stack
		private X car; 
		// rest of the stack
		private ISTACK<X> cdr; 
		
		//Purpose: Implements non empty stack
		public NMTSTACK(X f, ISTACK<X> r) {
			//first of the stack
			car = f;
			//rest of the stack
			cdr = r;	
			}
		
		//Purpose: to push an element on a stack, (putting an new element on top). 
		//X is our stack data-type and local variable v get puts on top of the stack.
		public ISTACK<X> push(X v){
			//Returns a new non empty stack with new element as the first element 
			return new NMTSTACK<X>(v,this);	}
		
		//Purpose: To pop a stack which returns the rest of the stack.
		//if the rest is empty, then return the exception
		public ISTACK<X> pop() throws Exception {
			//cdr is a private variable that returns rest of stack. 
			return this.cdr;
		}
			
		//Purpose: Returns the first element or "top" of the stack. Does not get changed in any way.	
		//Exception used to try to catch a error. 
		public X top() throws Exception{
			return car;}
		
		//Purpose: To check if the stack is empty or not
		public boolean emptyStack() {
			return false;}
			// returns false because the non empty stack will lever be empty.
		
		//Purpose: Helps reverse the stack
		//Not our main reverse method, main reverse method is implemented in Main Class
		//takes in 2 stacks:
		private ISTACK<X> revhelper(ISTACK<X> l, ISTACK<X>res)
		//ACCUM INV: reverse(this) == append(reverse(l), res)
			{try 
				{if(l.emptyStack()) 
					{return res;}
					//if the stack is empty, returns the empty resonator
				else{return (revhelper(l.pop(), res.push(l.top())));}}
					//Takes in rest of the stack and pushes the top element of l onto res. 
			catch(Exception e) {
				System.out.println("Error StackNMTLIST reverse: "+ e.getMessage());//if error is caught, it returns the string.
				return this;}	}
		
		//Purpose: Reverses a stack and returns its reversed form	
		//Not our main reverse method, main reverse method is implemented in Main Class
		public ISTACK<X> reverse() {
			ISTACK<X> A = new MTSTACK<X>(); 
			//creates a new empty stack
			return(revhelper(this, A));}
			//Uses the empty list to place the reversed stack
		
		//Purpose: Returns the given stack in a string
		public String ToString() {
			return "First Stack: "+this.car+""+this.cdr.ToString();}

	}

