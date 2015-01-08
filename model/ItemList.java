//package model;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;

public class ItemList
{
	private LinkedList<Item> items = new LinkedList<Item>();
  

	final static Charset ENCODING = StandardCharsets.UTF_8;
	
  public static void main(String[] args) throws IOException{
    new ItemList();
  }
	public ItemList() throws IOException
	{		
    readLargerTextFile("ItemData.txt");
    for (Item item : items)
    {
      item.outputData();
    }
	}

	private void readLargerTextFile(String aFileName) throws IOException
	{
  		Path path = Paths.get(aFileName);     
      LinkedList<String> stats = new LinkedList<String>(); 
      int counter = 0;
  	 	try (Scanner scanner =  new Scanner(path, ENCODING.name()))
  	 	{
   	 		while (scanner.hasNextLine())
   	 		{
            String temp = scanner.nextLine();
            stats.add(temp);
            
   	    		if(temp.contains(";"))
            {
              String filter = stats.removeLast();
              stats.add(filter.split(";")[0]);
              Item tempItem = new Item(counter, stats.get(0), Integer.parseInt(stats.get(1)));
              Hashtable<String, Integer> statData = new Hashtable<String, Integer>();
              for (int i = 2; i < stats.size(); i++)
              {
                String[] data = stats.get(i).split(" ");
                statData.put(data[0], Integer.parseInt(data[1]));
              }
              tempItem.setStats(statData);
              items.add(tempItem);
              stats.clear();
              counter++;
            }
    		}      
   		}
  	}
}