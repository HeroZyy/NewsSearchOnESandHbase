package com.example.zyy;

import java.util.*;
import java.io.*;

public class Main{
    static final int N = 100010;
    static int n;
    static int[] a = new int[N];
    static long ans;
    static int[] temp = new int[N];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        for(int i=0 ; i<n ; i++) a[i] = Integer.parseInt(str[i]);

        merge_sort(0, n - 1);

        System.out.print(ans);
    }

    public static void merge_sort(int l, int r) {
        if(l >= r) return;

        int mid = l + r >> 1;
        merge_sort(l, mid);
        merge_sort(mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while(i <= mid && j <= r) {
            if(a[i] <= a[j]) temp[k++] = a[i++];
            else {
                temp[k++] = a[j++];
                ans += mid - i + 1;
            }
        }

        while(i <= mid) temp[k++] = a[i++];
        while(j <= r) temp[k++] = a[j++];

        for(i=l, k=0 ; i<=r ; i++, k++) a[i] = temp[k];
    }
}