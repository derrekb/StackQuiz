package Stack;

public class StackNMTLIST<X> implements StackIList<X>{
	private X car; //creating a private variable
	private StackIList<X> cdr; //creating a private stack list
	
	public StackNMTLIST(X f, StackIList<X> r) {
		car = f;//setting car equal variable f
		cdr = r; // setting cdr equal to variable r	}
	
	public StackIList<X> cons(X v){ //method used to create a new list
		return new StackNMTLIST<X>(v,this);//returns new list	}
	
	
	public boolean isEmpty() {return false;} //check to see if a list is empty
	
	public boolean equals(StackIList<X> l) { //method is used to check if 2 lists are equal
		try {return((this.first().equals(l.first())) && this.rest().equals(l.rest()));}
		catch(Exception e) {
			System.out.println("Error StackNMTLIST equals: "+e.getMessage());//if the method catches an error, itll return error.
			return false;}	}
	
	public X first() throws Exception{return car;} //?
	public int lenght() {return (1 + this.cdr.lenght());} //method used to find the legnth of a list
	
	public StackIList<X> rest() throws Exception {return cdr;} //?
	
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
