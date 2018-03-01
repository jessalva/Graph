/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author jessal
 */
public class BFS {

    void BFS(int graph[][],int V,int start)
    {
        boolean visited[]=new boolean[V];
        PriorityQueue<Integer> que=new PriorityQueue<>() ;
        for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }
        que.add(start);
        visited[start]=true;

            
          while(!que.isEmpty())
            {
                int adj=que.poll();
                visited[adj]=true;
            
                System.out.print(adj +" ");
                for(int i=0;i < V;i++)
                {
                    if(!visited[i]  && graph[adj][i] == 1)
                    {
                        que.add(i);
                        visited[i]=true;
                    }
                }
            }
            System.out.println("");
        
        }
    void fullBFS(int graph[][],int V)
    {
        boolean visited[]=new boolean[V];
        PriorityQueue<Integer> que=new PriorityQueue<>() ;
        for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }
        
          for(int k=0;k<V;k++)
          {
              if(!visited[k])
              {
                    que.add(k);
                    visited[k]=true;
                    while(!que.isEmpty())
                    {
                              int adj=que.poll();
                              visited[adj]=true;
                              System.out.print(adj +" ");
                              for(int i=0;i < V;i++)
                             {
                              if(!visited[i]  && graph[adj][i] == 1)
                              {
                              que.add(i);
                              visited[i]=true;
                              }
                                }
                    }
                   System.out.println(""); 
                }
          }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int V,E;
        Scanner sc=new Scanner(System.in);
        V=sc.nextInt();
        E=sc.nextInt();
        int[][] graph=new int[V][V];
        BFS grp=new BFS();       
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
              graph[i][j]=0;  
            }
        }
        for(int i=0;i<E;i++)
        {
           int a=sc.nextInt();
           int b=sc.nextInt();
           graph[a-1][b-1]=1;
           graph[b-1][a-1]=1;
        }
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println("");
        }
        grp.BFS(graph, V, 0);
        grp.fullBFS(graph, V);
    }
    
}
