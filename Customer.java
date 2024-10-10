/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Akses;

/**
 *
 * @author Family
 */
public class Customer implements cstLogin {
    private static String Nama = "Budi";
    public static int Id = 101;

    public String getNama(){
    return Nama;
    }
    
    @Override
    public boolean Login(String nama, int id) {
        return Nama.equals(nama) && Id == id;
    }
    
    
}
