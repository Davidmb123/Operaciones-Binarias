import java.util.Formatter;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {
    public static int calcularLength(int num1){
        int digitos=0;
        while(num1!=0){
            num1=num1/10;
            digitos++;
        }
        return digitos;
    }
 public static int calcularLengthLong(long num1){
        int digitos=0;
        while(num1!=0){
            num1=num1/10;
            digitos++;
        }
        return digitos;
    }



    public static int[] shiftRight(int[] multiplicacion){
        for(int i=multiplicacion.length-1 ;i>0;i--){
            multiplicacion[i]=multiplicacion[i-1];
        }
        multiplicacion[0]=0;

        return multiplicacion;

    }
    public static int[] arithmeticShift(int[] multiplicacion){
        int keepNum=multiplicacion[0];
        for(int i=multiplicacion.length-1 ;i>0;i--){

            multiplicacion[i]=multiplicacion[i-1];
        }
        multiplicacion[0]=keepNum;

        return multiplicacion;
    }

    //Metodo para multiplicar binario con signo (Algoritmo booht)
    public static void algoritmoBooth2(String num1String, String num2String){
        //Obtener el largo de los numeros
        int length=num1String.length();
        int length2=num2String.length();
        int num1,num2=0;
        if(length<length2){
            length=length2;
        }else{
            length=length;
        }
        try{
            num1=Integer.parseInt(num1String);
            num2=Integer.parseInt(num2String);
        }catch(Exception e){
            System.out.println("Error, el numero ingresado no esta en el formato correcto");
            return;
        }

        int cont=length;
        int[] multiplicacion=new int[(length*2)+1];
        int overFlow=0;
        int j=length-1;
        long a=0;
        long tempNum2=num2;
        String aString="";
        //Inicializar el array CAQQ-1
        for(int i=multiplicacion.length-2;i>0;i--){
            multiplicacion[i]=(int)num1%10;
            num1/=10;
        }
        //Inicio del algoritmo
        while(cont>0){
            tempNum2=num2;
            j=length-1;
            overFlow=0;
        if(multiplicacion[multiplicacion.length-1]==0 &&multiplicacion[multiplicacion.length-2]==1){
            while (j>=0){
                //Resta A-M
                multiplicacion[j--] = (int) Math.abs(((a % 10 - tempNum2 % 10 - overFlow) % 2));
                //Determinar overFlow
                overFlow=(int)((a%10-overFlow));
                if(overFlow==1) {
                    overFlow = 0;
                }
                else if(overFlow==0&&tempNum2%10==1){
                    overFlow=1;
                }
                else if(overFlow==-1){
                    overFlow=1;
                }
                tempNum2 /= 10;
                a/=10;
            }
        }else if(multiplicacion[multiplicacion.length-1]==1 && multiplicacion[multiplicacion.length-2]==0){
            while (j>=0) {
                //Suma A+M
                multiplicacion[j--] = (int) ((a % 10 + tempNum2 % 10 + overFlow) % 2);
                overFlow = (int) ((a % 10 + tempNum2 % 10 + overFlow) / 2);
                tempNum2 /= 10;
                a /= 10;
            }

        }
        //Shift Aritmetico
        multiplicacion=arithmeticShift(multiplicacion);
        a=Long.parseLong(getAString2(multiplicacion,length));
        cont--;

        }
        int[] multiplicacionFinal=new int[multiplicacion.length-1];
        for(int i=0; i<multiplicacionFinal.length;i++){
            multiplicacionFinal[i]=multiplicacion[i];
        }

        imprimir(multiplicacionFinal);
    }

    public static void imprimirFinal(int[] multiplicacion,int length){

        for(int i=length-1;i<multiplicacion.length;i++){
            System.out.print(multiplicacion[i]);
        }
    }
    //Metodo para multiplicar binario
    public static void multiplicarBinario(int num1, int num2){
        //Obtener el largo de los numeros
        int length=calcularLength(num1);
        int length2=calcularLength(num2);
        if(length>length2){
            length=length;
        }else{
            length=length2;
        }
        System.out.println(length);
        //Declaracion de variables
        int cont=length;
        int[] multiplicacion=new int[(length*2)+1];
        int overFlow=0;
        int j=length;
        long a=0;
        long tempNum2=num2;
        int cont2=0;
        String aString="";
        //Inicializar el array CAQ
        for(int i=multiplicacion.length-1;i>1;i--){
            multiplicacion[i]=(int)num1%10;
            num1/=10;
        }
        //Inicio de algoritmo
        while(cont>0) {
            tempNum2=num2;
            j=length;

            //Comprobar si el numero en la primera posicion es 1
            if (multiplicacion[multiplicacion.length-1]==1) {
                while (j>=0){
                    //Suma A+M
                    multiplicacion[j--] = (int) ((a % 10 + tempNum2 % 10 + overFlow) % 2);
                    overFlow=(int)((a%10+tempNum2%10+overFlow)/2);
                    tempNum2 /= 10;
                    a/=10;
                }
            }
            //Shift Right
            multiplicacion=shiftRight(multiplicacion);
            //Nuevo valor de A
            a=Long.parseLong(getAString(multiplicacion,length));
            //Fin de la iteracion
            cont--;

        }
        //Imprimir array
        imprimir(multiplicacion);
    }

    public static int[] shiftLeft(int[] division){
        for(int i=0; i<division.length-1;i++){
            division[i]=division[i+1];
        }
        division[division.length-1]=0;
        return division;
    }
    public static void divisionBinaria(int num1, int num2){
        //Obtener el largo de los numeros
        int length=calcularLength(num1);
        int length2=calcularLength(num2);
        if(length>length2){
            length=length;
        }else{
            length=length2;
        }
        System.out.println(length);
        //Declaracion de variables
        int cont=length;
        int[] division=new int[(length*2)];
        int overFlow=0;
        int j=length;
        long a=0;
        long tempNum2=num2;
        String aString="";
        //Inicializar el array CAQ
        for(int i=division.length-1;i>0;i--){
            division[i]=(int)num1%10;
            num1/=10;
        }
        //Inicio
        while(cont>0){
            tempNum2=num2;
            j=length-1;
            overFlow=0;
            //Shift left
            division=shiftLeft(division);
            //Nuevo valor de A
            a=Integer.parseInt(getAString(division,length-1));

            while (j>=0){
                //Resta A-M
                division[j--] = (int) Math.abs(((a % 10 - tempNum2 % 10 - overFlow) % 2));
                //Determinar overFlow
                overFlow=(int)((a%10-overFlow));
               if(overFlow==1) {
                   overFlow = 0;
               }
               else if(overFlow==0&&tempNum2%10==1){
                   overFlow=1;
               }
               else if(overFlow==-1){
                   overFlow=1;
               }

                tempNum2 /= 10;
                a/=10;
            }
            //Nuevo valor de A
            a=Integer.parseInt(getAString(division,length-1));
            //Comprobar si el numero resultante de la resta es negativo
            if(overFlow==1){
                division[division.length-1]=0;
                overFlow=0;
                j=length-1;
                tempNum2=num2;
                while (j>=0){
                    //Suma A+M
                    division[j--] = (int) ((a % 10 + tempNum2 % 10 + overFlow) % 2);
                    overFlow=(int)((a%10+tempNum2%10+overFlow)/2);

                  tempNum2 /= 10;
                    a/=10;
                }

            }else {
                division[division.length-1]=1;
            }

            cont--;


        }
        imprimir(division);

    }
    public static void imprimir(int[] multiplicacion){
        for(int i=0; i<multiplicacion.length;i++){

            System.out.print(multiplicacion[i]);
        }
        System.out.println("");
    }
    public static String getAString(int[] multiplicacion,int length){
        String aString="";
        int cont2=0;
        while(cont2<length+1) {
            aString += multiplicacion[cont2];
            cont2++;


        }
        return aString;

    }    public static String getAString2(int[] multiplicacion,int length){
        String aString="";
        int cont2=0;
        while(cont2<=length-1) {
            aString += multiplicacion[cont2];
            cont2++;


        }
        return aString;

    }

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        Scanner leerString=new Scanner(System.in);
        Formatter fmt = new Formatter();
        int opc=0;
        int num1=0;
        int num2=0;
        System.out.println("Ingrese un numero");
        System.out.println("1.Multiplicacion");
        System.out.println("2.Division");
        System.out.println("3.Multiplicacion con signo");
        opc=leer.nextInt();
        switch(opc){
            case 1:
                System.out.println("Ingrese un numero");
                num1=leer.nextInt();
                System.out.println("Ingrese otro numero");
                num2=leer.nextInt();
                multiplicarBinario(num1,num2);
                break;
            case 2:
                System.out.println("Ingrese un numero");
                num1=leer.nextInt();
                System.out.println("Ingrese otro numero");
                num2=leer.nextInt();

                divisionBinaria(num1,num2);
                break;
            case 3:
                System.out.println("Ingrese un numero");
                String n1=leerString.nextLine();
                System.out.println("Ingrese otro numero");
                String n2=leerString.nextLine();
                algoritmoBooth2(n1,n2);

        }



    }


}

