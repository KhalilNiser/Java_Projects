
/**
 * @author Niser, Khalil (2023/06/16)
 * Fibonacci.matrixFibonacci: Matrix Fibonacci
 * 
 * 				---- FIBONACCI_SEQUENCE ----
 * Nth Power of Matrix Approach to Find and Print Nth Fibonacci Numbers.
 * This approach relies on the fact that if we n times multiply the 
 * matrix M = {{1,1},{1,0}} to itself (in other words calculate power(M, n)),
 * then we get the (n+1)th Fibonacci number as the element at row and column 
 * (0, 0) in the resultant matrix.
 * 
 * ->	If n is even then k = n/2:   
 * 
 * 		->	Therefore Nth Fibonacci Number = F(n) = [2*F(k-1) + F(k)]*F(k)
 * ->	If n is odd then k = (n + 1)/2:    
 * 		->	Therefore Nth Fibonacci Number = F(n) = F(k)*F(k) + F(k-1)*F(k-1)
 * 
 * How does this formula work? 
 * 
 * The formula can be derived from the matrix equation. 
 * 
 * 
 * Taking determinant on both sides, we get (-1)n = Fn+1Fn-1 – Fn2 
 *
 * Moreover, since AnAm = An+m for any square matrix A, the following identities 
 * can be derived (they are obtained from two different coefficients of the 
 * matrix product)
 *
 * FmFn + Fm-1Fn-1 = Fm+n-1         —————————(1)
 *
 * By putting n = n+1 in equation(1),
 *
 *FmFn+1 + Fm-1Fn = Fm+n             ————————–(2)
 *
 *Putting m = n in equation(1).
 *
 *F2n-1 = Fn2 + Fn-12
 *
 *Putting m = n in equation(2)
 *
 *F2n = (Fn-1 + Fn+1)Fn = (2Fn-1 + Fn)Fn  ——–
 *
 *( By putting Fn+1 = Fn + Fn-1 )
 *
 *To get the formula to be proved, we simply need to do the following 
 *
 *If n is even, we can put k = n/2 
 *If n is odd, we can put k = (n+1)/2
 * 
 * 
 * 				---- TIME_COMPEXITY/AUXILARY_SPACE ----
 * Time Complexity: O(Log n) 
 * Auxiliary Space: O(Log n) if we consider the function call stack size, 
 * otherwise O(1).
 */

package Fibonacci.matrixFibo;

public class MatrixFibonacci 
{
	
	/**
	 * 				---- FIBONACCI_METHOD ----
	 * @param num
	 * @return Function that returns the Nth fibonacci number
	 */
	static int fibonacci( int num )
	{
		int[][] fibo = new int[][] { { 1, 1 }, { 1, 0 } };
		
		if ( num == 0 )
		{
			return 0;
		}
		
		power( fibo, num - 1 );
		
		return fibo[ 0 ][ 0 ];
		
	}
	
	
	static void multiply( int[][] fibo, int[][] matrx )
	{
		int w = fibo[ 0 ][ 0 ] * matrx[ 0 ][ 0 ] + fibo[ 0 ][ 1 ] * matrx[ 1 ][ 0 ];
		int x = fibo[ 0 ][ 0 ] * matrx[ 0 ][ 1 ] + fibo[ 0 ][ 1 ] * matrx[ 1 ][ 1 ];
		int y = fibo[ 1 ][ 0 ] * matrx[ 0 ][ 0 ] + fibo[ 1 ][ 1 ] * matrx[ 1 ][ 0 ];
		int z = fibo[ 1 ][ 0 ] * matrx[ 0 ][ 1 ] + fibo[ 1 ][ 1 ] * matrx[ 1 ][ 1 ];
		
		fibo[ 0 ][ 0 ] = w;
		fibo[ 0 ][ 1 ] = x;
		fibo[ 1 ][ 0 ] = y;
		fibo[ 1 ][ 1 ] = z;
		
	}

	/**
	 * 
	 * @param fibo
	 * @param num
	 * @return Optimized version of power() int method 4
	 */
	static void power( int[][] fibo, int num )
	{
		if ( num == 0 || num == 1 )
		{
			return;
		}
		
		int mtrx[][] = new int[][] { { 1, 1 }, { 1, 0 } };
		
		power( fibo, num / 2 );
		
		multiply( fibo, fibo );
		
		if ( num % 2 != 0 )
		{
			multiply( fibo, mtrx );
		}
		
	}
	
	/**
	 * 
	 * @param args
	 * @return Drive program to execute the above methods
	 */
	public static void main(String[] args) 
	{
		int num = 9;
		
		System.out.println( fibonacci( num ) );
		
	}

}
