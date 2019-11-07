package com.binaryOp;

import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class TestSuite_1 {
    public static void add(){

        long bin1, bin2;
        int i=0,overFlow=0;
        int[] sum=new int[20];
        int[] testCase1={1,1,1,1,1};
        Scanner read=new Scanner(System.in);
        System.out.println("Ingrese un numero binario");
        bin1=read.nextLong();
        System.out.println("Ingrese otro numero binario");
        bin2=read.nextLong();

        while(bin1 !=0 ||bin2!=0){
            sum[i++]=(int)((bin1%10+bin2%10+overFlow)%2);
            overFlow=(int)((bin1%10+bin2%10+overFlow)/2);
            bin1=bin1/10;
            bin2=bin2/10;


        }
        if(overFlow!=0){
            sum[i++]=overFlow;

        }
        System.out.println("La suma de los binarios es:");
        while(i>=0){
            System.out.print(sum[i--]);
        }
        System.out.println("\n");

        assertArrayEquals(testCase1,sum);
    }

    public static void main(String[] args) {
        add();

    }
}
