package com.java.designpatterns;

public class SingletonDesign {

//	LAZY LOADING
	
//	    private static SingletonDesign obj;
//	 
//	    private SingletonDesign() {}
//	 
//	    public static SingletonDesign getInstance()
//	    {
//	        if (obj==null)
//	            obj = new SingletonDesign();
//	        return obj;
//	    }
	
// EAGER LOADING 
	
//    private static SingletonDesign obj = newSingletonDesign() ;
// 
//    private SingletonDesign() {}
// 
//    public static SingletonDesign getInstance()
//    {
//        return obj;
//    }
	
//  THRED SAFE SYNCHRONIZED 
	
//  private static SingletonDesign obj ;
//
//  private SingletonDesign() {}
//
//  public static synchronized  SingletonDesign getInstance()
//  {
//      if (obj==null)
//       {
//      	obj = new SingletonDesign();
//          return obj;
//         }
//  }	
	
	
//  THRED SAFE SYNCHRONIZED 
	
//  private static SingletonDesign obj ;
//
//  private SingletonDesign() {}
//
//  public static  SingletonDesign getInstance()
//  {
//      if (obj==null)
//       {
//      	synchronized(SingletonDesign.class){
//      	obj = new SingletonDesign();
//          }
//       }
//     return obj;	
//  }	
}
