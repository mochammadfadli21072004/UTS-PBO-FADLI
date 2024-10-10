/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Tampilan;
import Akses.Admin;
import Akses.Customer;
import Opsi.Kelola;
import java.util.Scanner;
/**
 *
 * @author Family
 */
public class tampilMenu {
    public static void main(String[] args){
    Scanner input = new Scanner (System.in);
    Kelola fitur = new Kelola(10);
    Admin adm = new Admin();
    Customer cst = new Customer();
    int pilihan;
    
        do{
           System.out.println("  ======================== ");
           System.out.println(" |       Hotel Evenue     |");
           System.out.println("  ======================== ");
           System.out.println(" |                        |");
           System.out.println(" |     1. Admin           |");
           System.out.println(" |     2. Customer        |");
           System.out.println(" |     3. Keluar          |");
           System.out.println(" |                        |");
           System.out.println("  ======================== ");
           System.out.println("\n");
           System.out.println("Anda ingin masuk sebagai? ");
           
           while(!input.hasNextInt()) {
               System.out.println("Opsi yang anda pilih tidak tersedia! ");
               input.next();
           }
           
           pilihan = input.nextInt();
           switch(pilihan){
               case 1:
                   adminMenu(input, adm, fitur);
                   break;
               case 2:
                   customerMenu(input, cst, fitur);
                   break;
               case 3:
                   System.out.println("Terimakasih telah telah menggunakan sistem reservasi Hotel Evenue!");
                   input.close();
                   System.exit(0);
                   break;
               default:
                   System.out.println("Pilihan tidak valid! Silahkan coba lagi" );
           }
        } while (pilihan != 3);
    }


    public static void adminMenu(Scanner input, Admin adm, Kelola fitur){
        System.out.println("Login Sebagai Admin");
        System.out.println("Masukkan nama anda: ");
        input.nextLine();
        String nama = input.next();

        System.out.println("Masukkan password: ");
        input.nextLine();
        String password = input.nextLine();

        if(adm.Login(password, nama)){
          System.out.println("Login Berhasil! ");
          System.out.println("\n");
          System.out.println("Selamat Datang, " + adm.getNama() + " !");
          int pilihan1;
          
          do {
            System.out.println("  ========================== ");
            System.out.println(" |          Admin           |");
            System.out.println("  ========================== ");
            System.out.println(" |                          |");
            System.out.println(" |      1. Cek Kamar        |");
            System.out.println(" |      2. Tambah Kamar     |");
            System.out.println(" |      3. Detail Pesanan   |");
            System.out.println(" |      4. Logout           |");
            System.out.println(" |                          |");
            System.out.println("  ========================== ");
            System.out.println("\n");
            System.out.println("Pilih Menu: ");

            while(!input.hasNextInt()) {
               System.out.println("Menu yang dipilih tidak valid! ");
               input.next();
            }   

            pilihan1 = input.nextInt();
            switch(pilihan1){
               case 1:
                   System.out.println("Cek Kamar");
                   System.out.println("Jumlah Kamar kosong: " + fitur.kamarKosong());
                   break;
               case 2:
                   System.out.println("Tambah Kamar");
                   System.out.println("Berapa jumlah kamar yang ingin anda tambahkan?");
                   fitur.tambahKamar();
                   break;
               case 3:
                   System.out.println("Detail Pesanan");
                   System.out.println("Masukkan Id Customer untuk melihat detail pesanan yang telah dibuat: ");
                   while (!input.hasNextInt()) {
                       System.out.println("Masukkan angka yang valid!");
                       input.next();
                    }
                    int idPesanan = input.nextInt();
                    fitur.detailPesanan(idPesanan);
                   break;
                case 4:
                    System.out.println("Logout Berhasil! ");
                    break;
               default:
                   System.out.println("Pilihan tidak valid! Silahkan coba lagi" );
                }
            } while (pilihan1 != 4);
        } else {
            System.out.println("Password dan Nama salah! Coba lagi ");
          }
    }


    public static void customerMenu(Scanner input, Customer cst, Kelola fitur){
        System.out.println("Login Sebagai Customer");
        System.out.println("Masukkan nama anda: ");
        while (!input.hasNextLine()) {
        input.next();
        }
        String nama = input.next();

        System.out.println("Masukkan Id Customer: ");
        while (!input.hasNextInt()) {
        input.next();
        }

        int customerId = input.nextInt();

        if(cst.Login(nama, customerId)){
            System.out.println("\n");
            System.out.println("Selamat Datang, " + cst.getNama() + " !");
            int pilihan2;

            do {
                System.out.println("  ========================== ");
                System.out.println(" |          Admin           |");
                System.out.println("  ========================== ");
                System.out.println(" |                          |");
                System.out.println(" |      1. Cek Kamar        |");
                System.out.println(" |      2. Pesan Kamar      |");
                System.out.println(" |      3. Detail Pesanan   |");
                System.out.println(" |      4. Logout           |");
                System.out.println(" |                          |");
                System.out.println("  ========================== ");
                System.out.println("\n");
                System.out.println("Pilih Menu: ");
                
                while (!input.hasNextInt()) {
                System.out.println("Masukkan angka yang valid!");
                input.next(); // Skip input yang salah
                }

                pilihan2 = input.nextInt();
                switch(pilihan2){
                    case 1:
                        System.out.println("Cek Kamar");
                        System.out.println("Jumlah Kamar kosong: " + fitur.kamarKosong());
                        break;
                    case 2:
                        System.out.println("Cek Kamar");
                        if (fitur.kamarKosong() > 0){
                            if (fitur.pesanKamar(nama, customerId)){
                            }
                        } else {
                            System.out.println("Kamar sudah terisi penuh! ");
                        }
                        break;
                    case 3:
                        fitur.detailPesanan(customerId);
                        break;
                    case 4:
                        System.out.println("Logout Berhasil! ");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid! Silahkan coba lagi" );
                    }
            } while (pilihan2 != 4);
        } else {
            System.out.println("Nama dan Id tidak valid! ");
          }
    }

}


