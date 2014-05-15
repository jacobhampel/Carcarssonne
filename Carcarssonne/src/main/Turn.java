package main;

import data.DataHelper;

public class Turn {
	static int sizeX =5;
	static int sizeY =5;
	static char[][] c = new char[sizeX][sizeY];
	
	public static void main(String[] args)
	{
		c = DataHelper.loadCard(11);
		print();
		turn();
		print();

		
	}
	
	public static void turn()
	{
		int k;
		char[][] cT = new char[sizeX][sizeY];
		cT = c;
		c = new char[sizeY][sizeX];
		for (int j=0; j<sizeY; j++){
			k=sizeX-1;
			for (int i=0; i<sizeX; i++)
			{
				c[j][k] = cT[i][j];
				k--;
			}}
		int size = sizeX;
		sizeX = sizeY;
		sizeY = size;
	}
	
	public static void print()
	{
		String output ="";
		for (int j=0; j<sizeY; j++)
		{
			for (int i=0; i<sizeX; i++)
			{
				
				output = output + "     "+c[i][j];
				
			}
			output = output + ("\n");
		}
		System.out.println(output);
	}
	
	/*public static void build()
	{
		for (int j=0; j<sizeY; j++)
		{
			for (int i=0; i<sizeX; i++)
			{
				c[i][j] = new String(" x "+ i + " y "+j);
				
				
			}
		}
	}*/
	
	

}
