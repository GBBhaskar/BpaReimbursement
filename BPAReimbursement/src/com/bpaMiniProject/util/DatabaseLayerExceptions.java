package com.bpaMiniProject.util;

public class DatabaseLayerExceptions extends RuntimeException
{
	 public DatabaseLayerExceptions() 
	 {
	 
	 }

	 public DatabaseLayerExceptions(String message) 
	 {
		 super(message);
	 }

	 public DatabaseLayerExceptions(Throwable cause)
	 {
		 super(cause);
	 }

	 public DatabaseLayerExceptions(String message, Throwable cause)
	 {
		 super(message, cause);
	 }
}
