import java.util.*;
public class main {

    public static int bitToDecimal(int[] num){
        int ac=0;

        for(int i=num.length-1;i>0;i--){
            if(num[i]==1){
                ac+=Math.pow(2,Math.abs((i+1)-5));

            }

        }
        return ac;
    }
    public static int[] decimalToBit(int num){
        int[] res=new int[6];
        int residuo=1;
        int bit=0;
        float temp=0;
        int puntero=res.length-1;
        while(num>=1){
            if(num%2==0){
                res[puntero]=0;

            }else{
                res[puntero]=1;
            }
            puntero--;
            num=Math.floorDiv(num,2);
            System.out.println(num);

        }
        return res;
    }

    public static int[] sumaYRestaMetodo2(int[]num1, int[]num2,boolean sum) {
        int[] res=new int[6];
        int ac=0;
        int ac2=0;
        int resDecimal=0;
        for(int i=num1.length-1; i>=0; i--){
            if(num1[i]==1){
                ac+=Math.pow(2,Math.abs((i+1)-5));

            }
            if(num2[i]==1){
                ac2+=Math.pow(2,Math.abs((i+1)-5));

            }
        }
        if(sum) {
            resDecimal = ac + ac2;
        }else{
            resDecimal = ac - ac2;
        }
        System.out.println(resDecimal);
        res=decimalToBit(resDecimal);



        System.out.println(ac);
        return res;
    }

    public static int[] sumaNormal(int[]primerNumero, int[] segundoNumero){
        // scumulsdor temporal
        int temp=0;
        int[] res=new int[6];
        int overFlow=0;
        boolean overFlowFinal=false;
        for(int i=4; i>=0;i--){
            temp=primerNumero[i]+segundoNumero[i]+overFlow;
            if(temp==2){
                overFlow=1;
                res[i+1]=0;

            }else if(temp==3){
                overFlow=1;
                res[i+1]=1;
            }else{
                overFlow=0;
                res[i+1]=temp;

            }

            if(i==0 &&overFlow==1){
                overFlowFinal=true;
            }

        }

        if(overFlowFinal){
            res[0]=1;
        }
        return res;


    }
    public static int[] sumaNormal2( int[]primerNumero,int[] segundoNumero){
        // scumulsdor temporal
        int temp=0;
        int[] res=new int[6];
        int overFlow=0;
        boolean overFlowFinal=false;
        for(int i=4; i>=0;i--){
            temp=primerNumero[i]+segundoNumero[i+2]+overFlow;
            if(temp==2){
                overFlow=1;
                res[i+1]=0;

            }else if(temp==3){
                overFlow=1;
                res[i+1]=1;
            }else{
                overFlow=0;
                res[i+1]=temp;

            }

            if(i==0 &&overFlow==1){
                overFlowFinal=true;
            }

        }

        if(overFlowFinal){
            res[0]=1;
        }
        return res;


    }

    public static int[] restaNormal(int[] primerNumero, int[] segundoNumero) {
        int temp = 0;
        int[] res = new int[6];
        int overFlow = 0;
        boolean overFlowFinal = false;
        for (int i = 4; i >= 0; i--) {
            temp = (primerNumero[i] - overFlow) - segundoNumero[i];
            if(temp==-1){
                overFlow=1;
                res[i+1]=1;

            }
            else if(temp==-2){
                overFlow=1;
                res[i+1]=0;
            }else{
                res[i+1]=temp;
                overFlow=0;
            }
            if(i==0 &&overFlow==1){
                overFlowFinal=true;
            }
            if(overFlowFinal){
                res[0]=1;
            }
        }
        return res;

    }

    public static int[] restaComplemento2(int[] num1, int[] num2) {
        int res[] = new int[6];
        int sum1[] = {0, 0, 0, 0, 1};
        int nuevoNum2[] = new int[5];
        boolean resPos = false;
        int ac1 = 0;
        int ac2 = 0;
        int temp = 0;
        int overFlow = 0;
        for (int i = num2.length - 1; i >= 0; i--) {
            if (num2[i] == 0) {
                num2[i] = 1;
            } else {
                num2[i] = 0;
            }
        }


        for (int i = num2.length - 1; i >= 0; i--) {
            temp = num2[i] + sum1[i] + overFlow;
            if (temp == 2) {
                overFlow = 1;
                nuevoNum2[i] = 0;
            } else if (temp == 3) {
                overFlow = 1;
                nuevoNum2[i] = 1;
            } else {
                overFlow = 0;
                nuevoNum2[i] = temp;
            }
        }
        imprimir(nuevoNum2);
        ac1 = bitToDecimal(num1);
        ac2 = bitToDecimal(num2);

        if (ac1 - ac2 < 0) {
            resPos = false;
        } else {
            resPos = true;
        }
        for (int i = num1.length - 1; i >= 0; i--) {
            temp = num1[i] + nuevoNum2[i] + overFlow;
            if (temp == 2) {
                overFlow = 1;
                res[i + 1] = 0;
            } else if (temp == 3) {
                overFlow = 1;
                res[i + 1] = 1;
            } else {
                overFlow = 0;
                res[i + 1] = temp;
            }


        }
        if (num1[0]==1 && num2[0]==0) {
            if(overFlow==1){
                res[0]=0;
            }else{
                res[0]=1;
            }
        }

        return res;
    }

    public static int[] sumaComplemento2(int [] num1, int[] num2){


        int res[]=new int[6];
        int temp=0;
        int overFlow=0;

        for(int i=num1.length-1;i>=0;i--){
            temp=num1[i]+num2[i]+overFlow;
            if(temp==2){
                overFlow=1;
                res[i+1]=0;
            }
            else if(temp==3){
                overFlow=1;
                res[i+1]=1;
            }else{
                overFlow=0;
                res[i+1]=temp;
            }
        }
        if(overFlow==1){
            res[0]=1;
        }


        return res;

    }
    public static int[] agregarNumero(Scanner leer){
        int bit;
        int cont=0;
        int [] arrayDigitosUsuario=new int[5];
        System.out.println("Ingrese 5 digitos binarios");
        while(cont<5) {
            bit = leer.nextInt();
            if(bit==1 ||bit==0) {
                arrayDigitosUsuario[cont] = bit;
                cont++;
            }else{
                System.out.println("No es un numero binario");
            }
        }

        return arrayDigitosUsuario;
    }

    public static boolean seleccionarOperacion(Scanner leer){
        System.out.println("Seleccione una operacion: \n1-Suma\n2-Resta");
        boolean sum=true;

        int opc=leer.nextInt();
        if(opc==1){
            sum=true;
        }else{
            sum=false;
        }
        return sum;
    }
    public static int seleccionarTipo(Scanner leer){
        System.out.println("Seleccione un tipo de operacion\n1-Normal\n2-Complemento a 2");
        int opc=leer.nextInt();
        return opc;
    }
    public static void imprimir(int[] arrayDigitosUsuario){
        for(int i=0; i<arrayDigitosUsuario.length;i++){
            System.out.print(arrayDigitosUsuario[i]);

        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        String opc="";
        int[] res=null;
        int[]primerNumero=agregarNumero(leer);
        int tipo=seleccionarTipo(leer);
        int[]segundoNumero=agregarNumero(leer);
        boolean operacion=seleccionarOperacion(leer);
        imprimir(primerNumero);
        imprimir(segundoNumero);
        switch(tipo){
            case 1:
                if(operacion==true) {
                    res = sumaNormal(primerNumero, segundoNumero);
                }else{
                    res=restaNormal(primerNumero,segundoNumero);
                }
                break;
            case 2:
                if(operacion==true) {
                    res = sumaComplemento2(primerNumero, segundoNumero);
                }else{
                    res= restaComplemento2(primerNumero,segundoNumero);
                }

                break;
        }
        imprimir(res);

    }

}
