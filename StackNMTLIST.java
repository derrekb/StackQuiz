package Stack;

public class StackNMTLIST<X> implements StackIList<X>{
	private X car; 
	private StackIList<X> cdr;
	
	public StackNMTLIST(X f, StackIList<X> r) {
		car = f;
		cdr = r;	}
	
	public StackIList<X> cons(X v){
		return new StackNMTLIST<X>(v,this);	}
	
	
	public boolean isEmpty() {return false;}
	//purpose: To check if a stack is empty but returns false because a stack cannot be empty in the non empty class. 
	
	public boolean equals(StackIList<X> l) {
		//variable l is our local stack
		//Purpose: to check if two stacks have equal elements
		try {return((this.first().equals(l.first())) && this.rest().equals(l.rest()));}
		//compares the first of both the lists and the rest of the elements in both of the lists.
		catch(Exception e) 
		{
			System.out.println("Error StackNMTLIST equals: "+e.getMessage());
			return false;}	}
	
	public X first() throws Exception{return car;}
	public int lenght() {return (1 + this.cdr.lenght());}
	
	public StackIList<X> rest() throws Exception {return cdr;}
	
	public X listref(int i) throws Exception{
		if(i==0) {return car;}
		else {return this.cdr.listref(i-1);}}
		
	public StackIList<X> append(StackIList<X> L){
		try{
			return (new StackNMTLIST<X>(this.first(), this.rest().append(L)));
			}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST append: "+ e.getMessage());
		return this;}}
	
	private StackIList<X> revhelper(StackIList<X> l, StackIList<X>res)
	//ACCUM INV: reverse(this) == append(reverse(l), res)
	{try {if(l.isEmpty()) {return res;}
	else{return (revhelper(l.rest(), res.cons(l.first())));}}
	catch(Exception e) {
		System.out.println("Error StackNMTLIST append: "+ e.getMessage());
		return this;}	}
	
	public StackIList<X> reverse() {return(revhelper(this, new StackMTLIST<X>()));}
	
	public <R> StackIList<R> map(StackIFun<X,R>f){
		try {return (new StackNMTLIST<R> (f.f(this.first()), this.rest().map(f)));}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST append: "+ e.getMessage());
			return (new StackMTLIST<R>());
		}}
	
		public StackIList<X> filter(StackIPred<X> p){
		try {if (p.p(this.first())) {
			return (new StackNMTLIST<X> (this.first(), this.rest().filter(p)));}
			else { return this.rest().filter(p);}
			}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST append: "+ e.getMessage());
			return (new StackMTLIST<X>());	}
	}
		
	public <R> R foldl(StackIFun2<X,R> f, R res) {
		try {
			{return (this.rest().foldl(f, f.f(this.first(), res)));}}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST append: "+ e.getMessage());
			return res;
		}}
	
	public <R> R foldr(StackIFun2 <X,R> f, R res) {return(this.reverse().foldl(f, res));}
	
	public boolean ormap(StackIPred<X> p){
		try {if (p.p(this.first())) {
			return true;}
			else if(this.rest().ormap(p)) {return true;}
			else {return false;}
			}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST append: "+ e.getMessage());
			return false;}}
	
	public boolean andmap(StackIPred<X> p){
			try {if (p.p(this.first())==false){return false;}
		else if(this.rest().andmap(p)) {return false;}
			else{return true;}			
			}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST append: "+ e.getMessage());
			return false;}}
	
	public X second() throws Exception{
		return this.rest().first();
	}
	
	public X third() throws Exception{
		return this.rest().rest().first();
	}
	
	public boolean member(StackIPred<X> p){
		try {if (p.p(this.first())) {
			return true;}
			else if(this.rest().member(p)) {return true;}
			else {return false;}
			}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST append: "+ e.getMessage());
			return false;}} 
	
	public StackIList<X> remove(X v){
		StackIList<X> res = this.filter((p -> !p.equals(v)));
		return res;
		}
}
