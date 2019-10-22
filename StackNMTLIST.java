package Stack;

/**
  * Purpose: Class for Stack: with list
  *
  * @param <X>
  */
public class StackNMTLIST<X> implements StackIList<X>{
	
	//first of the stack
	private X car;
	// rest of the stack
	private StackIList<X> cdr;
	
	//Purpose:Implements Non Empty Stack
	public StackNMTLIST(X f, StackIList<X> r) {
		//first of the stack
		car = f;
		//rest of the stack
		cdr = r;	}
	
	//Purpose: To add an element to the top of the stack
	public StackIList<X> cons(X v){
		return new StackNMTLIST<X>(v,this);	}
		//returns stack with v at the top and this as rest
	
	//Purpose: To determine f stack is empty
	public boolean isEmpty() {
		return false;}
		//returns false since stack is not empty
	
	//Purpose: To determine if this stack is equal this stack l
	public boolean equals(StackIList<X> l) {
		try {
			return((this.first().equals(l.first())) && this.rest().equals(l.rest()));}
			//returns true if the values of first and rest of both stacks are equal
		catch(Exception e) {
			System.out.println("Error StackNMTLIST equals: "+e.getMessage());
			//Exception: Returns error if an empty stack is reached
			return false;}
		}	//returns false if the values of first and rest of both stacks are not equal
	
	//Purpose: To return top of stack
	public X first() throws Exception{
		return car;}
		//Exception: returns error if stack is empty
	
	//Purpose: To return length of stack
	public int lenght() {
		return (1 + this.cdr.lenght());}
		
	//Purpose: To return rest of stack
	public StackIList<X> rest() throws Exception {
		return cdr;}
		//Exception: returns exception if stack is empty
	
	//Purpose: to determine the ith element in the stack
	public X stackref(int i) throws Exception{
		if(i==0) {
			return car;}
			//returns first element if i==0
		else {return this.cdr.stackref(i-1);}}
			//returns  ith element from the rest of stack
		//Exception: returns error if this stack is empty
		
	//Purpose: To append this stack with the given stack L
	public StackIList<X> append(StackIList<X> L){
		try{
			return (new StackNMTLIST<X>(this.first(), this.rest().append(L)));
			}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST append: "+ e.getMessage());
			return this;}}
			//Exception: returns error if this stack is empty
	
	//Purpose: Supplementary method for reverse
	//Not our main reverse method, main reverse method is implemented in Main Class
	private StackIList<X> revhelper(StackIList<X> l, StackIList<X>res)
		//ACCUM INV: reverse(this) == append(reverse(l), res)
		{try {
			if(l.isEmpty()) {
				return res;}
				//returns res if stack l is empty
			else{return (revhelper(l.rest(), res.cons(l.first())));}}
				//returns res containing reversed elements of stack l
		catch(Exception e) {
			System.out.println("Error StackNMTLIST reverse: "+ e.getMessage());
			return l;}	}
			//returns stack l if stack is empty
			//Exception: prints error if stack is empty
	
	//Purpose:To reverse a stack
	//Not our main reverse method, main reverse method is implemented in Main Class
	public StackIList<X> reverse() {
		return(revhelper(this, new StackMTLIST<X>()));}
		//implements revhelper which returns a stack with reversed elements of this stack
	
	//Purpose: To map the given function to the elements of this stack
	public <R> StackIList<R> map(StackIFun<X,R>f){
		try {
			return (new StackNMTLIST<R> (f.f(this.first()), this.rest().map(f)));}
			//returns new stack with this stack's element, processed with StackIFun
		catch(Exception e) {
			System.out.println("Error StackNMTLIST map: "+ e.getMessage());
			return (new StackMTLIST<R>());
		}}	//returns empty stack if this stack is empty
			//Exception: prints error if this stack is empty
	
	//Purpose: to filter this stack by predicate p
	public StackIList<X> filter(StackIPred<X> p){
		try {
			if (p.p(this.first())) {
				return (new StackNMTLIST<X> (this.first(), this.rest().filter(p)));}
				//returns new stack with this stack's elements, including first, filtered with predicate p
			else { return this.rest().filter(p);}
			//returns new stack with this stack's elements, excluding first(first oes not meet predicate's requirements)
			//, filtered with predicate p
			}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST filter: "+ e.getMessage());
			return (new StackMTLIST<X>());	}
			//returns new empty stack
			//Exception: returns error if list is empty
		}
		
	//Purpose: To apply the given function to all the elements of the given
	//stack from left to right and return the accumulated result
	public <R> R foldl(StackIFun2<X,R> f, R res) {
		try {
			{return (this.rest().foldl(f, f.f(this.first(), res)));}}
			//returns stack with this stack's elements processed with f
		catch(Exception e) {
			System.out.println("Error StackNMTLIST foldl: "+ e.getMessage());
			return res;
		}}	//returns empty stack, res, if this stack is empty
			//Exception: Returns error if this stack is empty
	
	//Purpose: To apply the given function to all the elements of the given
	//stack from right to left and return the accumulated result
	public <R> R foldr(StackIFun2 <X,R> f, R res) {
		return(this.reverse().foldl(f, res));}
		//returns the reverse of method foldl
	
	//Purpose: To determine if there exist elements in a given stack for which a predicate holds
	public boolean ormap(StackIPred<X> p){
		try {
			if (p.p(this.first())) {
				return true;}
				//returns true if first element of stack passes predicate
			else if(this.rest().ormap(p))
				{return true;}
				//returns true if any element in rest of stack passes predicate
			else {return false;}
				//returns false otherwise
			}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST ormap: "+ e.getMessage());
			return false;}}
			//returns false if this stack is empty
			//Exception: returns error if stack is empty
	
	//Purpose: To determine if there exist elements in a given stack for which a predicate holds
	public boolean andmap(StackIPred<X> p){
		try {
			if (p.p(this.first())==false)
				{return false;}
				//returns false if first element of stack fails predicate
			else if(this.rest().andmap(p)) 
				{return false;}
				//returns false if all elements in rest of stack fails predicate
			else{return true;}			
				//returns true otherwise
			}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST andmap: "+ e.getMessage());
			return false;}}
			//returns false if this stack is empty
			//Exception: returns error if stack is empty
	
	//Purpose: To return the second element in the stack
	public X second() throws Exception{
		return this.rest().first();
		//returns second element in stack
		//Exception: returns error if stack is empty
	}
	
	//Purpose: To return the third element in the stack
	public X third() throws Exception{
		return this.rest().rest().first();
		//returns third element in stack
		//Exception: returns error if stack is empty
	}
	
	//Purpose:To determine if there exists elements in the given stack for which the predicate holds
	public boolean member(StackIPred<X> p){
		try {
			if (p.p(this.first())) {
				return true;}
				//returns true if first element passes predicate
			else if(this.rest().member(p)) 
				{return true;}
				//returns true if any element in rest of stack passes predicate
			else {return false;}
				//returns false otherwise
			}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST member: "+ e.getMessage());
			return false;}} 
			//returns false if stack is empty
			//Exception: returns error if stack is empty
	
	//Purpose: To remove an element from the stack
	public StackIList<X> remove(X v){
		StackIList<X> res = this.filter((p -> !p.equals(v)));
		return res;
		//returns stack with all instances of v absent
		}

	//Purpose: To push an item onto the top of the stack
	public StackIList<X> push(X v) {
		return this.cons(v);
		//implements cons of v to this stack
	}

	//Purpose: To obtain top of stack
	public X top() throws Exception {
		return this.first();
		//implements first to this stack
	}

	//Purpose: To obtain the rest of the stack
	public StackIList<X> pop() throws Exception {
		return this.remove(this.first());
		//implements remove to remove the first element in the stack
	}

	//Purpose: To return all elements in the stack as strings 
	public String ToString() {
		return "First Stack: "+this.car+""+this.cdr.ToString();}
		//prints out elements in the stack
	
}
