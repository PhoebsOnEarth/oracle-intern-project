package com.example.oracleinternchallenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {

        List<Long> fibArr = GenFibArr(10);
        fibArr.forEach(System.out::println);
        System.out.println();
        List<Long> sorted = SortedFibArr(fibArr);
        sorted.forEach(System.out::println);


    }


    public static List<Long> SortedFibArr(List<Long> fibArr) {

        List<Long> sortedFibArr = new ArrayList<>();

        fibArr.stream().filter(val -> val % 2 == 0)
                .sorted(Comparator.reverseOrder()).forEach(sortedFibArr::add);

        fibArr.stream().filter(val -> val % 2 != 0)
                .sorted(Comparator.reverseOrder()).forEach(sortedFibArr::add);


        return sortedFibArr;
    }


    public static List<Long> GenFibArr(long n) {

        List<Long> FibArray = new ArrayList<>();

        for (long i = 0L; i < n; i++) {
            FibArray.add(GenFib(i));
        }

        return FibArray;

    }

    public static long[][] multi(long[][] ans,long[][] base){
        long[][] temp = new long[2][2];
        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
                for(int k=0;k<2;k++) {
                    temp[i][j] = (temp[i][j]+(ans[i][k]*base[k][j])%1000000007)%1000000007;
                }
            }
        }
        return temp;
    }

    public static long GenFib(long n ) {
        long[][] base = {{1,1},{1,0}};
        long[][] ans = {{1,0},{0,1}};
        while(n>0) {
            if((n&1)==1) {
                ans  = multi(ans, base);
            }
            base = multi(base, base);
            n >>= 1;
        }
        return ans[0][1];
    }


}





