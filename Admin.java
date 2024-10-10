/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Akses;

/**
 *
 * @author Family
 */
public class Admin implements admLogin{
    private static String Nama = "Udin";
    private static String password = "Admin123";

    public String getNama(){
    return Nama;
    }
    
    @Override
    public boolean Login(String pass, String n) {
        return password.equals(pass) && Nama.equals(n);
    }

    
}

