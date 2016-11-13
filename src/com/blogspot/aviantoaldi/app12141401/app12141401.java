package com.blogspot.aviantoaldi.app12141401;

import java.util.Scanner;

public class app12141401 {
    String nama;
    byte level = 1;
    byte kesempatan = 5, sisa;
    short tebak;
    short banyak=0;
    int random, score=0;
    char jawab;
    int total = 0;
    String dataNama[] = {"Jeni","Idi","Ana","Andi","Tami","Aziz"};
    int dataScore[] = {240,300,150,400,240,200};
    
    public int Level(){
        return level*5;
    }
    
    public void hasilTebakan() {
      sisa--;
      banyak++;
      
      
        System.out.println("Tebakan anda ? " + tebak);
        if (tebak<random){
            System.out.print("Tebakan Anda telalu kecil!");
        }
        if (tebak>random){
            System.out.print("Tebakan Anda telalu besar!");
        }
        if (tebak==random){
            System.out.print("Selamat Anda berhasil menebak sebanyak " + banyak + " kali tebakan");
        }
        
        if (sisa>0&&tebak!=random){
            System.out.println("Anda mempunyai kesempatan " + sisa + " kali lagi.");
        }
        if (sisa<=0) {
            System.out.println("Game Over");
        }
    }
    
    public void Score() {
        if (banyak>0){
            score= 100*level;
        }
        if (banyak>1){
            score= 70*level;
        }
        if (banyak>2){
            score= 50*level;
        }
        if (banyak>3){
            score= 30*level;
        }
        if (banyak>4){
            score= 0*level;
        }
        System.out.println();
        System.out.println("Score anda adalah\t: " + score);
        total=total+score;
    }
    
    public void totalScore(){
        System.out.println("Total Score History :");
        for (int x=0;x<6;x++){
            System.out.println(dataNama[x] + "\t: " + dataScore[x]);
        }
        System.out.println(nama + "\t: " + total);        
    }
    
    public void Reset(){        
    level = 1;
    kesempatan = 5;
    banyak=0;
    total=0;
    }
    
    public static void main(String[] args) {
        app12141401 main = new app12141401();
        
        
        
        Scanner inputString = new Scanner(System.in);
        Scanner inputAngka = new Scanner(System.in);
        
        do{
        System.out.println("Masukkan nama Anda untuk memulai atau tekan 'T (besar)' utuk keluar.");
        main.nama=inputString.nextLine();
        
          if ("T".equals(main.nama)){
              break;
          }
          else{
            do {
            main.random = (short) (Math.random()*main.Level());
            System.out.println("# Level " + main.level);  
            System.out.println("Selamat datang " + main.nama);   
            System.out.println("Silakan tebak angka antara 1 s/d " + main.Level());    
            System.out.println("Anda mempunyai kesempatan menebak " + main.kesempatan + " kali"); 
            main.sisa=main.kesempatan;
            
            do{
                System.out.println();   
                System.out.println("Masukkan tebakan : "); 
                main.tebak = inputAngka.nextShort();
                main.hasilTebakan();
            }while(main.tebak!=main.random&&main.sisa>0);
            
            
            if (main.tebak==main.random){
                main.Score();
                System.out.println("Apakah anda ingin melanjutkan ke level berikutnya ? (y/t)");
                main.jawab=inputString.nextLine().charAt(0);
                main.level++;
                main.banyak=0;
            }
            else {     break;}
            }while(main.jawab=='y');
            main.totalScore();
            main.Reset();
          }
        }while(!"T".equals(main.nama)); 
        
    }    
}