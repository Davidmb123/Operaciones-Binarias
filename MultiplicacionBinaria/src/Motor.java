import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;



    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author Antonio
     */
    public class Motor {

        public Motor(){
            System.out.println("Ingrese primer numero");
            primero=num.nextLine();
            if(autentificador(primero)==false){
                ver=false;
            }
            System.out.println("Ingrese Segundo numero");
            segundo=num.nextLine();
            if(autentificador(segundo)==false){
                ver=false;
            }
            if(ver==false){
                System.out.println("Uno de los inputs no es binario");
            }else{
                System.out.println(Arrays.toString(this.multiplicacion(primero,segundo)).replaceAll(",", "").replace("[", "").replace("]", ""));
            }
        }

        public boolean autentificador(String n){
            return n.matches("^[01]+$");
        }

        public int[] multiplicacion(String n1,String n2){
            String[] part1=n1.split("");
            String[] part2=n2.split("");
            int[] arrayre=new int[part1.length+part2.length];

            int[] M = Stream.of(n1.split("")).mapToInt(Integer::parseInt).toArray();
            int[] Q = Stream.of(n2.split("")).mapToInt(Integer::parseInt).toArray();
            int Q1=0;
            int j=Q.length-1;
            int p=0;
            //funcion para copiar Q en  array grande
            for(int i=arrayre.length-1;i>0;i--){
                if(j>=0){
                    arrayre[i]=Q[j];
                }
                j--;
            }
            //comprobar longitud de numeros
            if(M.length==Q.length){

                for(int l=0;l<M.length;l++){
                    res=0;
                    //comparar Qo y Q-1
                    if(arrayre[arrayre.length-1]==1 && Q1==0){
                        //resta
                        for(int i=part1.length-1;i>=0;i--){
                            int val=arrayre[i]-M[i]-res;
                            if(val==1){
                                res=0;
                                arrayre[i]=1;
                            }
                            else if(val==0){
                                res=0;
                                arrayre[i]=0;
                            }
                            else if(val==-1){
                                res=1;
                                arrayre[i]=1;
                            }
                        }
                        arrayre[1]=res;
                    }else if(arrayre[arrayre.length-1]==0 && Q1==1){
                        //suma
                        for(int i=part1.length-1;i>=0;i--){
                            int val=arrayre[i]+M[i]+res;
                            if(val==1){
                                res=0;
                                arrayre[i]=1;
                            }else if(val==0){
                                res=0;
                                arrayre[i]=0;
                            }else if(val==2){
                                res=1;
                                arrayre[i]=0;
                            }else if(val==3){
                                res=1;
                                arrayre[i]=1;
                            }
                        }


                    }


                    //funcion para shiftear
                    p=arrayre[0];
                    Q1=arrayre[arrayre.length-1];
                    for(int k=arrayre.length-1;k>0;k--){
                        arrayre[k]=arrayre[k-1];
                    }
                    arrayre[0]=p;
                }
            }else{
                System.out.println("Numero de digitos es diferente");
            }


            return resultado=arrayre.clone();
        }


        Scanner num = new Scanner(System.in);
        String primero;
        String segundo;
        int [] resultado;
        boolean ver=true;
        int res=0;
    }


