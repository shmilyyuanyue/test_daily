package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //test212121
        String s1=br.readLine();
        String str2[]=s1.split(" ");

        int n = Integer.valueOf(str2[0]);
        int m = Integer.valueOf(str2[1]);
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");
            map.put(strArr[0]+","+strArr[1],Integer.valueOf(strArr[2]));
        }
        String s2=br.readLine();
        String str3[]=s2.split(" ");
        int x = Integer.valueOf(str3[0]);
        int y = Integer.valueOf(str3[1]);
        int t1 = 0,t2 = 0;
        String str = x+","+y;
        if (map.containsKey(str)){
            t1 = map.get(str);
        }
        for (int i = 0; i <= y-x; i++) {
            int a = x+i;
            int b = x+i+1;
            String str4 = a+","+b;
            if (map.containsKey(str4)){
                t2 += map.get(str4);
            }
        }
        System.out.println(Math.min(t1,t2));

    }

}
