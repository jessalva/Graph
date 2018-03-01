/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetComponentGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author jessal
 */
public class DistinctSetGraph {
    public static void main(String[] arg)
    {
        System.out.println("Hello Graph World");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of nodes");
        int v=sc.nextInt();
        ArrayList<TreeSet> comGraph = new ArrayList<>(v); 
        Set<String> graphNode ;
        for(int i = 0; i < v; i++)
        {
                  graphNode = new TreeSet<>();
                  graphNode.add(sc.next());
                  comGraph.add(i , (TreeSet) graphNode);
        }
        int ncomp = v;
        System.out.println("Enter Number of edges");
        int e=sc.nextInt();
        for(int i = 0; i < e; i++)
        {
                 String a = sc.next();
                 String b = sc.next();
                 for(int j=0 ; j < ncomp ; j++)
                 {
                           if(comGraph.get(j).contains(a) && comGraph.get(j).contains(b))
                           {       
                           }
                           else if(comGraph.get(j).contains(a))
                           {
                                     for(int k = 0; k < ncomp ; k++ )
                                     {
                                               if(comGraph.get(k).contains(b))
                                               {
                                                         comGraph.get(j).addAll(comGraph.get(k));
                                                         if(j != k)
                                                         {
                                                                   comGraph.remove(k);
                                                         }
                                                         ncomp--;
                                               }
                                     }
                           }
                           else if(comGraph.get(j).contains(b))
                           {
                                     for(int k = 0; k < ncomp ; k++ )
                                     {
                                               if(comGraph.get(k).contains(a))
                                               {
                                                         comGraph.get(j).addAll(comGraph.get(k));
                                                         if(j != k)
                                                         {
                                                                   comGraph.remove(k);
                                                         }
                                                         ncomp--;
                                               }
                                     }
                           }
                 }
        }
        Iterator it;
        it = comGraph.iterator();
        while(it.hasNext())
        {
                  System.out.println(it.next());
        }
    }
}
