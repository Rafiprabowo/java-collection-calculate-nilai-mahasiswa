package Tugas2;

public class Nilai {
    int nim;
    String nama;
    String mataKuliah;
    int sks;
    int nilai;
    public Nilai(int nim,String nama,String mataKuliah,int sks,int nilai){
        this.nim = nim;
        this.nama = nama;
        this.mataKuliah = mataKuliah;
        this.sks = sks;
        this.nilai = nilai;
    }
    public Nilai(){

    }
    public String toString(){
        return nim+"\t"+nama+"\t\t"+mataKuliah+"\t\t\t"+sks+"\t"+nilai;
    }

}
