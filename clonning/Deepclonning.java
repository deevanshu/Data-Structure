package com.java.clonning;

public class Deepclonning {

	 public static void main(String[] args)
	    {
	        Course1 science = new Course1("Physics", "Chemistry", "Biology");
	 
	        student1 student11 = new student1(111, "John", science);
	 
	        student1 student12 = null;
	 
	        try
	        {
	            //Creating a clone of student11 and assigning it to student12
	 
	            student12 = (student1) student11.clone();
	        }
	        catch (CloneNotSupportedException e)
	        {
	            e.printStackTrace();
	        }
	 
	        //Printing the subject3 of 'student11'
	 
	        System.out.println(student11.Course1.subject3);         //Output : Biology
	 
	        //Changing the subject3 of 'student12'
	 
	        student12.Course1.subject3 = "Maths";
	 
	        //This change will be reflected in original student1 'student11'
	 
	        System.out.println(student11.Course1.subject3);       //Output : Maths
	        student11.id=1;
	        System.out.println(student11.id);
	        System.out.println(student12.id);
	    }


}
class Course1 implements Cloneable
{
	String subject1;

	String subject2;

	String subject3;

	public Course1(String sub1, String sub2, String sub3)
	{
		this.subject1 = sub1;

		this.subject2 = sub2;

		this.subject3 = sub3;
	}
	
	protected Object clone() throws CloneNotSupportedException
	{
		
		System.out.println(super.clone());
		return super.clone();
	}
}

class student1 implements Cloneable
{
	int id;

	String name;

	Course1 Course1;

	public student1(int id, String name, Course1 Course1)
	{
		this.id = id;

		this.name = name;

		this.Course1 = Course1;
	}

	//Default version of clone() method. It creates shallow copy of an object.

	protected Object clone() throws CloneNotSupportedException
	{
		student1 st = (student1)super.clone();
		st.Course1 =  (Course1)super.clone();  // getting clone of Course and setting it to clone of student so that student has it's own reference of Course .
		return st;
	}

}