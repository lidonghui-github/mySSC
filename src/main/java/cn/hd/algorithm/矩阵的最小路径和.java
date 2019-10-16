package cn.hd.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 输入一个 N*M 的矩阵，从左上角开始，每次只能向下或者向右走，最后到达右下角的位置
 * 将路径上所有数字加起来就是路径和，求最小路径和  
 *分析：
 * 典型的动态规划。状态方程为： dp[i][j] = getMin( dp[i - 1][j] ,dp[i][j - 1] ) + arr[i][i] 。dp[i][j] 表示 达到点 arr[i][j] 是的最小路径和，因为每次只能向下或者向右，所以要达到 arr[i][j] 必须先经过 arr[i -1][j] 或者 arr[i][j - 1] 其中一个点，找出路径最小的即可。
 *
 * 因为每次只能向下和向右，所以第一行只能从左一直往右走，而第一列只能从上一直往下走，并且将经过的点累加起来。
 *
 * 所以我们可以先对第一行、第一列的 dp[i][j] 进行初始化。
 */

public class 矩阵的最小路径和 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入矩阵的行数 n=:");
		int n = scan.nextInt();			//行数
		System.out.println("请输入矩阵的列数 m=:");
		int m = scan.nextInt();			//列数
		System.out.println("请初始化矩阵的数据:");

		int[][] arr = new int[n][m];			
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				System.out.println("请输入第"+(i+1)+"行的第"+(j+1)+"列的数据:");
				arr[i][j] = scan.nextInt();
			}
		}
		System.out.println("所得矩阵数据是:");
		printArr(arr);
		System.out.println("矩阵的最小路径和是:");
		System.out.println(minPath(arr,n,m));


	}
	public static void printArr(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int minPath(int[][] arr,int n,int m){
		if(arr == null)
			return 0;

		int[][] dp = new int[n][m];
		dp[0][0] = arr[0][0];
		List<Integer> pathList = new ArrayList<>();
		for(int i = 1; i < n;i++){
			dp[i][0] = dp[i - 1][0] + arr[i][0];
		}
		for(int j = 1; j < m; j++){
			dp[0][j] = dp[0][j - 1] + arr[0][j];
		}
		pathList.add(dp[0][0]);
		for(int i = 1; i < n; i++){
			for(int j = 1; j < m; j++){
				pathList.add(Math.min(dp[i - 1][j], dp[i][j - 1]));
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
			}
		}
		System.out.println("最短路径节点是:"+pathList);
		return dp[n - 1][m - 1];
	}	

}
