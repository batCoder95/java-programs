public class FloydWarshall {

	public static void floydWarshall(int[][] graph){
		int N = graph.length;
		int dist[][] = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				dist[i][j] = graph[i][j];
			}
		}
			
		for(int k=0;k<N;k++){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(dist[i][j]!=-999)
					dist[i][j] = Math.max(dist[i][k]+dist[k][j],dist[i][j]);
				}
			}
		}
		
		for(int i=0;i<N;i++){
			System.out.println();
			for(int j=0;j<N;j++){
				System.out.print(" "+dist[i][j]+" ");;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int graph[][] = {{-999,-999,-999,-999},
		                 {3,4,5,-999},
		                 {40,8,9,10},
		                 {-999,1,2,3}
               };
		 floydWarshall(graph);
	}

}
