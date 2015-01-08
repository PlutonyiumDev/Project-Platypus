package model;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;

public class ItemList
{
	private LinkedList<Item> items = new LinkedList<Item>();

	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public ItemList()
	{
		//items
	}

	private void readLargerTextFile(String aFileName) throws IOException
	{
  		Path path = Paths.get(aFileName);
  	 	try (Scanner scanner =  new Scanner(path, ENCODING.name()))
  	 	{
   	 		while (scanner.hasNextLine())
   	 		{
   	    		//process each line in some way
   	    		System.out.println(scanner.nextLine());
    		}      
   		}
  	}
}