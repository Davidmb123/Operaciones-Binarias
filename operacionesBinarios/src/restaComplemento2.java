public class restaComplemento2 {

    public static void imprimir(int[] num1){
        for(int i=0; i<num1.length;i++){
            System.out.println(num1[i]);
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int[] num1={0,0,0,1,1};
        boolean num1Pos=true;
        int[] num2={0,0,1,0,0};
        boolean num2Pos=true;
        int temp=0;
        int overFlow=0;
        if(num1[0] ==1 ){
            num1Pos=false;
        }else{
            num1Pos=true;
        }
        if(num2[0]==1){
            num2Pos=false;
        }else{
            num2Pos=true;
        }
        for(int i=num2.length-1; i>=0; i--){
            if(num2[i]==1){
                num2[i]=0;
            }else{
                num2[i]=1;
            }
        }



    }
}
