package Tugas2;

public class MataKuliah {
    int kode;
    String mataKuliah;
    int sks;
    public MataKuliah(int kode, String mataKuliah, int sks){
        this.kode = kode;
        this.mataKuliah = mataKuliah;
        this.sks = sks;
    }
    public String toString(){
        return kode+"\t\t\t "+mataKuliah+"\t\t\t"+sks;
    }
}
