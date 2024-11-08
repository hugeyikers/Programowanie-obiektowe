import static java.lang.Math.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

 class Main {

     public static boolean dokladnosc(int x, int y, int k)
     {
         int roznica = x-y;
         int bezwzgledna = abs(roznica);
         if(bezwzgledna<=Math.pow(10,-k))
         {
             return true;
         }
         else return false;
     }
     /*
     public static int najblizszySasiad(int S)
     {
         int x = S-1;
         int xn= (int)((x+(S/x))/2.0);
         while(dokladnosc(xn,x,1)!=true)
         {

         }

     }
     */

     public static int podciag(int[] tab)
     {
         int licznik=0;
         int licznik1=0;
         for(int i=0;i<tab.length;i++)
         {
             if(i+1<=tab.length-1)
             {
                 if(tab[i+1]<=tab[i])
                 {
                     licznik++;
                 }
                 else if(tab[i+1]>tab[i])
                 {
                     if(licznik1>=licznik)
                     {
                         licznik=0;
                     }
                     else
                     {
                         licznik1=licznik;
                         licznik=0;
                     }
                 }
             }
         }
         return licznik1+1;
     }

     public static boolean czyPalindrom(int n)
     {
         int a=0;
         int liczba = n;
         while(n!=0)
         {
             int b = n%10;
             a= a*10 + b;
             n=n/10;
         }
         if(liczba-a==0)
         {
             return true;
         }
         else
         {
             return false;
         }
     }

     public static void palindromLiczbowy(int m)
     {
         int a = (int)Math.pow(10, m-1);
         Random random = new Random();
         while(true)
         {
             int randomliczba1 = a + random.nextInt((a*10)-1 - a + 1);
             int liczba1 = randomliczba1;
             int randomliczba2 = a + random.nextInt((a*10)-1 - a + 1);
             int liczba2 = randomliczba2;
             int wynik=liczba1*liczba2;
             if(czyPalindrom(wynik)==true)
             {
                 System.out.println(liczba1+" x "+ liczba2+ " = "+ wynik);
                 break;
             }
         }
     }


    public static void main(String[] args) {
        System.out.println(dokladnosc(2,1,1));
        int[] tab = new int[7];
        tab[0]=1;
        tab[1]=2;
        tab[2]=0;
        tab[3]=3;
        tab[4]=5;
        tab[5]=1;
        tab[6]=4;
        System.out.println(podciag(tab));
        System.out.println(czyPalindrom(5115));
        palindromLiczbowy(2);


    }
}