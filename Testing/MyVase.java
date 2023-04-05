package Testing;

class MyBase{
	public void func(){
		System.out.println("Base static called");
	}
}

public class MyVase extends MyBase{
	public void func(){                // is this allowed?
		System.out.println("Derived static called");
	}
}

