package com.opBinary;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class opBinaryTest {





    public  static void multiplicacionBSS(long q, long m){
        int length=0;

        long tempQ=1;
        long tempM=1;
        while(tempM<=m || tempQ<=q){
            length++;
            tempM*=10;
            tempQ*=10;
        }
        int count=length;

        int[] ACQ=new int[(length*2)+1];

        for(int i=ACQ.length-1; i>=0;i--)
        {
            if(q!=0){
                ACQ[i]=(int) q%10;
                q/=10;
            }else{
                ACQ[i]=0;

            }
        }
        while(count>0){
            if(ACQ[ACQ.length-1]==1){
                int[]sumAM=addNormal(0,m,length+1);
            }
        }





    }

    public static int[] addNormal(long bin1,long bin2,int length){

        int i=0,overFlow=0;
        int[] sum=new int[length];



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
        while (i>=0){
            System.out.print(sum[i--]);
        }
        System.out.println("\n");

        return sum;
    }
    @Test
    public void test(){
        int[] testCase1={1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] testCase2={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] testCase3={0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(testCase1,addNormal(00000,11111,5));
        assertArrayEquals(testCase2,addNormal(00000,00000,5));
        assertArrayEquals(testCase3,addNormal(11111,11111,5));
    }


    }

