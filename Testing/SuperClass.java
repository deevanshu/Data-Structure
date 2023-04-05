package Testing;
import java.io.IOException;

public class SuperClass {

	// SuperClass declares an exception
	void method() throws IOException
	{
		System.out.println("SuperClass");
	}
}

//SuperClass inherited by the SubClass
class SubClass extends SuperClass {

	// SubClass declaring without exception
	void method()
	{
		System.out.println("SubClass");
	}

	// Driver code
	public static void main(String args[])
	{
		SuperClass s = new SubClass();
		try {
			s.method();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
