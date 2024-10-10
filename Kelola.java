/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Opsi;

import static Akses.Customer.Id;
import java.util.Scanner;

/**
 *
 * @author Family
 */
public class Kelola {
    private int Kamar;
    private int kamarTerisi;
    int pesan, K;

    public Kelola(int k) {
        k = 10;
        this.Kamar = k;  
        this.kamarTerisi = 0;
    }

    public void tambahKamar() {
        Scanner jmlh = new Scanner(System.in);
        System.out.println("Jumlah Kamar yang ingin ditambahkan: ");
        int kmr;
        kmr = jmlh.nextInt();
        Kamar += kmr;
        System.out.println("Berhasil menambahkan kamar! Total sekarang adalah: " + Kamar);
    }

    public boolean pesanKamar(String nama, int idCustomer) {
        if (kamarKosong() > 0) {
            Scanner psn = new Scanner(System.in);
            System.out.println("Berapa kamar yang ingin Anda pesan?");
            pesan = psn.nextInt();
            Kamar -= pesan;
            System.out.println("Kamar berhasil dipesan atas nama: " + nama + " dengan ID Customer: " + idCustomer);
            return true;
        } else {
            System.out.println("Tidak ada kamar yang tersedia.");
            return false;
        }
    }

    public int kamarKosong() {
        return Kamar - kamarTerisi;
    }

    public void detailPesanan(int idCustomer) {
        K = pesan;
        if (idCustomer == Id && K > 0){
        System.out.println("Detail pesanan untuk ID Customer: " + idCustomer);
        System.out.println("Customer " + idCustomer + " telah memesan " + K + " Kamar");
        } else if (idCustomer == Id && K <= 0) {
            System.out.println("Tidak ada riwayat pesanan untuk ID Customer: " + idCustomer);
        } else {
            System.out.println("Id Customer tidak terdaftar!");
        }
    }
    
    
}


