package Tugas2;
public class Mahasiswa {
    int nim;
    String nama;
    String telf;

    public Mahasiswa(int nim,String nama,String telf){
        this.nim = nim;
        this.nama = nama;
        this.telf = telf;
    }
    public String toString(){
        return nim+"\t\t "+nama+"\t\t\t\t"+telf;
    }

}
