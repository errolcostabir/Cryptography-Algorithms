import java.util.Scanner;
public class affine_cipher {

    public static void decrypt(char arr[],String str,int a, int p){
        int y,x;
        String pt="";
        String ct="";
        int inverse=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                continue;
            }
            else{
                ct=ct+str.toLowerCase().charAt(i);
            }
        }
        for(int i=1;i<100;i++){
            inverse=(i*26+1)%a;
            if(inverse==0){
                inverse=(i*26+1)/a;
                break;
            }
        }
        for(int i=0;i<ct.length();i++){
            for(int j=0;j<arr.length;j++){
                if(ct.charAt(i)==arr[j]){
                    y=j;
                    x=((inverse*y)-(inverse*p)%26)%26;
                    pt=pt+arr[x];
                }
            }
        }
        System.out.println(pt);
    }
    public static void encrypt(char arr[],String str,int a,int p){
        int y,x;
        String pt="";
        String ct="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                continue;
            }
            else{
                pt=pt+str.charAt(i);
            }
        }
        for(int i=0;i<pt.length();i++){
            for(int j=0;j<arr.length;j++){
                if(pt.charAt(i)==arr[j]){
                    x=j;
                    y=(a*x+p)%26;
                    ct=ct+arr[y];
                }
            }
        }
        System.out.println(ct.toUpperCase());
    }
    public static void main(String args[]){
        char arr[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String str;
        int a,p,choice;
        Scanner in =new Scanner(System.in);
        System.out.println("enter a string");
        str=in.nextLine();
        System.out.println("enter the pair of integers alpha and beta");
        a=in.nextInt();
        p=in.nextInt();
        System.out.println("1.Encrypt 2.Decrypt 3.Exit");
        choice=in.nextInt();
        switch(choice){
            case 1:
                encrypt(arr,str,a,p);
                break;
            case 2:
                decrypt(arr,str,a,p);
                break;
            default:
                break;
        }
    }
}
