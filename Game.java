import java.util.Scanner;

public class Game {
	
	Scanner sc=new Scanner(System.in);
	
	
	
	int [][] grid;
	int rows;
	int columns;
	int k=1;
	
	public void set(int [][] grid,int ROWS,int COLUMNS)
	{
		this.rows=ROWS;
		this.columns=COLUMNS;
		this.grid=new int[rows][columns];
		for(int i=0;i<ROWS;i++)
			for(int j=0;j<COLUMNS;j++)
			this.grid[i][j]=grid[i][j];	
	}
	
	public void get()
	{
		for(int i=0;i<rows;i++)
		{	
			for(int j=0;j<columns;j++)
			System.out.print(grid[i][j]);
		
		    System.out.println();
		}
		System.out.println();
	}
	
	  public void getStates() 
	  {
		  int n;
		 
		 do {
			 
			 System.out.println("===========GAME Program=============");
				System.out.println("1. Get Next State 2. Check Cell 3. EXIT ");
				System.out.print("Enter choice =");
				int ch=sc.nextInt();
				
				switch(ch)
				{
				case 1:gameOfLife();
				       printState();
				break;
				case 2:gameOfLife();
				       PrintCell();
				       
				break;
				case 3:System.exit(2);
				
				break;
				
				default:
					System.out.println("Wrong Choice...!!");

				}
				
				System.out.print("Do u want to continue press 1 otherwise 0 = ");
				 n=sc.nextInt();
		    }while(n!=0);
		
	  }
	
	
	   public void  gameOfLife()
	   {
		       for (int i = 0; i < rows; i++)
		      {
	                   for (int j = 0; j < columns; j++)
	                 {
	                    int Cell = grid[i][j];
	                   calculate(i,j,Cell);
	                    
	                }
	          }

	           
	   }
		 
		 public void calculate(int i,int j,int Cell) 
		 {
                int count=0;
			  
			    
	            int a = i - 1;
	            int b = i + 1;
	            int c = j - 1;
	            int d = j + 1;
	            
                   //upper side vertical cell
	               if (a >= 0 && grid[a][j]==1)
	                 count++; 
	               
	               //Lower side vertical cell
	               if(b <rows && grid[b][j]==1)
	            	count++;
	            	
	            
	            
	              //left side horizontal cell
	               if(c >=0 && grid[i][c]==1)
	               count++;
	            	
	            
	               //right side horizontal cell
	               if(d <columns && grid[i][d]==1)
	            	count++;
	            	
	            
	            
	            //lower right side diagonal cell
	            if(j>=0 && j<columns-1 && i>=0 && i<rows-1)
	            {	
	               if(grid[b][d]==1)
	            	   count++;
	                   
	            }
	            
	            //upper left side diagonal cell
	            if(i>0 && i<rows && j>0 && j<columns)
	            {
	            	if(grid[a][c]==1)
	            		count++;
	            	    
	            }
	            
	            //lower left side diagonal cell
	            if(j>0 && j<columns && i>=0 && i<rows-1)
	            {
	            	if(grid[b][c]==1)
	            		count++;
	            	 
	            }
	            
	            //upper right side diagonal cell
	            if(i>0 && i<rows && j>=0 && j<columns-1)
	            {
	            	if(grid[a][d]==1)
	            	  count++;
	            	  
	            }
	            
	            
	            //if cell is live
	            if(Cell==1)
	            {
	            	
	            //live cell with fewer than two live neighbours dies by loneliness	
	            if(count<2)
	            	grid[i][j]=0; //"0" for dead, "1" for live
	            
	            // live cell with more than three live neighbors dies, as if by overcrowding.
	            if(count>3)
	            	grid[i][j]=0; //"0" for dead, "1" for live
	            
	            // Any live cell with two or three live neighbors lives, unchanged, to the next generation.
	            if(count==2|| count==3)
	            {
	            	grid[i][j]=grid[i][j];
	            }
	            }
	            
	            //if cell is dead
	            if(Cell==0)
	            {
	            	//. Any dead cell with exactly three live neighbors comes to life
	            	if(count==3)
	            	grid[i][j]=1; //"0" for dead, "1" for live
	            }
	            

	       }
		 
	 public void printState()
	 {
		  
		     if(k<rows)
		     System.out.println("State: "+k++); //print state number
		     System.out.println();
			 for(int i=0;i<rows;i++)
			 {	 
				
				 for(int j=0;j<columns;j++)
					 System.out.print(grid[i][j]);//print state
				 
				 System.out.println();
			 }
			 System.out.println();
		 }
	    
	 
	 public void PrintCell()
		{
		    int counte = 0;
			System.out.println("Enter The Cell Which You Want To Check ");
			
			System.out.println("Enter Row plz be sure index start from zero ");
			int r=sc.nextInt();
			
			System.out.println("Enter Column plz be sure column index start from zero");
			int c=sc.nextInt();
			
			if(r<rows && c<columns)
			{	
			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<columns;j++)
					if(grid[r][c]==0)
						counte=0;
					else
						counte=1;
			}	
			
			
				if(counte==0)
					System.out.println("cell status is Dead");
				if(counte==1)
					System.out.println("cell status is Live");
				    
			}
			
			
			else
			{
				System.out.println("Plz Enter Correct Rows And Column");
				PrintCell();
			}
			
		}

	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter The Number Of Rows");
		 int ROWS=sc.nextInt();
		 
		 System.out.println("Enter The Number Of Column");
		 int COLUMN=sc.nextInt();
		 
		 int [][] grid=new int[ROWS][COLUMN];
		 
		 System.out.println( " If Cell Is Live Enter 1 OR  If Cell Is Dead Enter 0" );
		 
		 for(int i=0;i<ROWS;i++)	 
			 for(int j=0;j<COLUMN;j++)
				 grid[i][j]=sc.nextInt();
		 
		 Game obj=new Game();
		 obj.set(grid, ROWS, COLUMN);
		 obj.get();
		 obj.getStates();
		 

	}
}	

	
