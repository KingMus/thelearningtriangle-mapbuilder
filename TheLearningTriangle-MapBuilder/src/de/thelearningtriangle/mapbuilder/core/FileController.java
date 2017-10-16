package de.thelearningtriangle.mapbuilder.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileController
{

	//information from author: bad usage of arrays. TODO change later to better data type
	
	/**
	 * this method reads a file and creates an int-Arrays from the values
	 * @return int[][]>
	 * @author Marco Mueller
	 */
	public static int[][] parseMapFromFile()
	{

		String file = System.getProperty("user.dir").replace('\\', '/') + "/MapFiles/Map.txt";
		BufferedReader br = null;
		String splitChar = ",";

		String line = "";

		List<String[]> fileData = new ArrayList<String[]>();
		int[][] map = null;
		
		try
		{

			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null)
			{

				String[] oneLineOfData = line.split(splitChar);
				fileData.add(oneLineOfData);

			}
			
			map = new int[fileData.size()][fileData.size()];
			
			for (int i = 0; i < map.length; i++)
			{
				for (int j = 0; j < map.length; j++)
				{
					map[i][j] = Integer.parseInt(fileData.get(i)[j]);
				}
			}
			

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		return map;

	}

	public static void parseFileFromMap(int[][] map, String randomString)
	{
		PrintWriter fileWriter = null;

		try
		{

			fileWriter = new PrintWriter(new FileWriter(System.getProperty("user.dir").replace('\\', '/') + "/MapFiles/Map"+randomString));

			for (int i = 0; i < map.length; i++)
			{
				for (int j = 0; j < map.length; j++)
				{
						fileWriter.print(""+map[i][j]);
					
					if(j<map.length-1){
						fileWriter.print(",");
					}
					
				}
				
				fileWriter.println();
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{			if (fileWriter != null)
				fileWriter.close();
		}

	}
	
	
}
