import java.util.Scanner;
public class caesar_cipher {
    public static void decrypt(String str,char arr[],int n){
        String ct="";
        String pt="";
        int b;
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else {
                ct = ct + str.toLowerCase().charAt(i);
            }
        }
        for(int i=0;i<ct.length();i++) {
            for (int j = 0; j < arr.length; j++) {
                if (ct.charAt(i) == arr[j]) {
                    b = (j - n) % 26;
                    pt = pt + arr[b];
                }
            }
        }
        System.out.println(pt);
    }
    public static void encrypt(String str,char arr[],int n){
        String ct="";
        String pt="";
        int b;
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else {
                pt = pt + str.charAt(i);
            }
        }
        for(int i=0;i<pt.length();i++) {
            for (int j = 0; j < arr.length; j++) {
                if (pt.charAt(i) == arr[j]) {
                    b = (j + n) % 26;
                    ct = ct + arr[b];
                }
            }
        }
        System.out.println(ct.toUpperCase());
    }
    public static void main(String args[]) {
        char arr[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int n;
        int choice;
        String str;
        Scanner in = new Scanner(System.in);
            System.out.println("enter a string");
            str = in.nextLine();
            System.out.println("enter the shift");
            n = in.nextInt();
            System.out.println("1.encrypt 2.decrypt 3.exit");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    encrypt(str, arr, n);
                    break;
                case 2:
                    decrypt(str, arr, n);
                    break;
                default:
                    break;
            }
        }

}
