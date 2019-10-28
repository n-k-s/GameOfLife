//test code
public class GameOfLife
{
  private int[][] g;
  //constructor
  public GameOfLife(int n, int m)
  {
     this.g = new int[n][m];
  }
  //getter
  public int[][] getGrid()
  {
    		return this.g;
	}
  public void nextIteration()
  {
    int[][] copyG = new int[this.g.length][this.g[0].length];
   for (int i = 1; i < this.g.length -1 ; i++)
   {
      for(int j = 1; j < this.g.length -1; j++)
      {
         int aliveAdjacent = 0;
         //checks that it's not the outer ring
         if (i != 0 && j != 0 && i != this.g.length -1 && j != this.g.length -1)
         {
           	//checking the adjacent squares
            if (this.g[i - 1][j - 1] == 1)
               aliveAdjacent++;
            if (this.g[i - 1][j] == 1)
               aliveAdjacent++;
            if (this.g[i - 1][j + 1] == 1)
               aliveAdjacent++;
            if (this.g[i][j - 1] == 1)
               aliveAdjacent++;
            if (this.g[i][j + 1] == 1)
               aliveAdjacent++;
            if (this.g[i + 1][j - 1] == 1)
               aliveAdjacent++;
            if (this.g[i + 1][j] == 1)
               aliveAdjacent++;
            if (this.g[i + 1][j + 1] == 1)
               aliveAdjacent++;
         }
         // checking the rules of the game of life
        
        /*
         The Game of Life Rules1.Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
         2.Any live cell with more than three live neighbors dies, as if by overcrowding.
         3.Any live cell with two or three neighbors lives on to the next generation.
         4.Any dead cell with exactly three live neighbors becomes a live cell
         */
         
         if (this.g[i][j] == 1)
         {
           	//Any live cell with fewer than two live neighbors dies, as if caused by underpopulation
            if (aliveAdjacent < 2)
               copyG[i][j] = 0;
            else if (aliveAdjacent  > 3)
               copyG[i][j] = 0;
           	else if (aliveAdjacent == 2 || aliveAdjacent == 3)
              	copyG[i][j] = 1;
         }
         else
            if (aliveAdjacent == 3)
               copyG[i][j] = 1;
      }
   } 
   //overwriting the copy to the original
   for (int k = 1; k < copyG.length-1; k++)
      for (int l = 1; l < copyG.length-1; l++)
         this.g[k][l] = copyG[k][l];
  }
  public void  oscillatePatternInitialGrid()
  {
    //subtracting the 1 so we can get the actual array index value for the midpoint
    int halfr = this.g.length / 2 - 1;
    int halfc = this.g[0].length / 2 - 1;
   
    for(int i = 0; i < this.g.length; i++)
    {
      for (int j = 0; j < this.g[0].length; j++)
        if(i == halfr && ((j == halfc + 1) || (j == halfc - 1) || j == halfc))
        {
          this.g[i][j] = 1;
        }
      	else
        {
          this.g[i][j] = 0;
      	}
    }

  }
  public void blockPatternInitialGrid()
  {
    //subtracting the 1 so we can get the actual array index value for the midpoint
    int halfr = this.g.length / 2 - 1;
    int halfc = this.g[0].length / 2 - 1;
    
        for(int i = 0; i < this.g.length; i++)
    {
      for (int j = 0; j < this.g[0].length; j++)
        if((i == halfr || i == halfr + 1) && ((j == halfc + 1) || j == halfc))
        {
          this.g[i][j] = 1;
        }
      	else
        {
          this.g[i][j] = 0;
      	}
    }
  }
  public void randomizeInitialGrid()
  {
    for(int i = 0; i < this.g.length; i++)
    {
      for( int j = 0; j < this.g[0].length; j++)
      {
         this.g[i][j] = (int) (Math.random() * 2);
      }
    }
  }
}