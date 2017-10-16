package de.thelearningtriangle.mapbuilder.core;

public class MapController
{

	public static int[][] generateBlankMap(int worldSize)
	{
		
		int[][] map = new int[worldSize][worldSize];
		
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map.length; j++)
			{
				map[i][j] = 1;
				
				if(i==0 || j == 0 || i== map.length-1 || j == map.length-1){
					map[i][j]=2;
				}
			}
		}
		
		return map;
	}
	
	
}
