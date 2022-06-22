package Tugas2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Penilaian {
    List<Nilai> nilaiList = new ArrayList<>();
    List<Mahasiswa> mahasiswaList = new ArrayList<>();
    List<MataKuliah> mataKuliahList = new ArrayList<>();
    public void getAllMhsPrint() {
        System.out.println("");
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("***************************************");
        System.out.println("NIM\t\t\t\t Nama\t\t\t Telf");
        if (!mahasiswaList.isEmpty()) {
            mahasiswaList.stream().forEach(mhs -> {
                System.out.println(mhs.toString());
            });
        }
    }
    public int getIndexMhs(int nim){
        for (int i = 0; i < mahasiswaList.size(); i++) {
            if(nim == (mahasiswaList.get(i).nim)){
                return i;
            }
        }
        return -1;
    }
    public void getAllMatkulPrint(){
        System.out.println("");
        System.out.println("DAFTAR MATAKULIAH");
        System.out.println("****************************************");
        System.out.println("Kode\t\t\tMata Kuliah\t\t\tSKS");
        if(!mataKuliahList.isEmpty()) {
            mataKuliahList.stream().forEach(matkul -> {
                System.out.println(matkul.toString());
            });
        }
    }
    public int getIndexMatkul(int  kode){
        for (int i = 0; i < mataKuliahList.size(); i++) {
            if(kode == (mataKuliahList.get(i).kode)){
                return i;
            }
        }
        return -1;
    }
    //1
    public void inputNilai(){
        System.out.println("Masukkan data  ");
        System.out.print("Masukkan kode: ");
        String kode = new Scanner(System.in).nextLine();

        System.out.print("Nilai : ");
        int inputNilai = new Scanner(System.in).nextInt();
        //search mahasiswa
        getAllMhsPrint();
        System.out.print("Pilih Mahasiswa by nim: ");
        int kodeMhs = new Scanner(System.in).nextInt();
        getAllMatkulPrint();
        System.out.print("Pilih MK by kode: ");
        int kodeMk = new Scanner(System.in).nextInt();
        Nilai penilaian = new Nilai(mahasiswaList.get(getIndexMhs(kodeMhs)).nim,mahasiswaList.get(getIndexMhs(kodeMhs)).nama,mataKuliahList.get(getIndexMatkul(kodeMk)).mataKuliah,mataKuliahList.get(getIndexMatkul(kodeMk)).sks,inputNilai);
        nilaiList.add(penilaian);
    }
    //2
    public void showAllNilai(){
        System.out.println("");
        System.out.println("Nim\t\t\tNama\t\t\tMata Kuliah\t\t\t\tSKS\t\t Nilai");
        if(!nilaiList.isEmpty()) {
            nilaiList.stream().forEach(nli -> {
                System.out.println(nli.toString());
            });
        }
    }
    //3
    public void getNilaiMahasiswa(){
        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("***********************************************");
        showAllNilai();
        System.out.print("Masukkan data mahasiswa[nim]: ");
        int  inputNim = new Scanner(System.in).nextInt();
        if(!nilaiList.isEmpty()){
            System.out.println(nilaiList.get(getIndexSpesifikNilaiMhs(inputNim)).toString());
            int getSks = nilaiList.get(getIndexSpesifikNilaiMhs(inputNim)).sks;
            System.out.printf("Total SKS %s telah diambil \n",getSks);
        }
    }
    //4
    public void sortNilai(){
        for (int i = 0; i <nilaiList.size()-1 ; i++) {
            if(nilaiList.get(i+1).nilai<nilaiList.get(i).nilai){
                Nilai temp = nilaiList.get(i+1);
                nilaiList.set(i+1,nilaiList.get(i));
                nilaiList.set(i,temp);
            }
        }
    }
    public int getIndexSpesifikNilaiMhs(int nim){
        for (int i = 0; i < nilaiList.size(); i++) {
            if(nim == (nilaiList.get(i).nim)){
                return i;
            }
        }
        return -1;
    }

    public  void showMenu(){
        System.out.println("************************************************");
        System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
        System.out.println("************************************************");
        while (true){
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            String pilih = new Scanner(System.in).nextLine();
            if(pilih.equals("1")){
                inputNilai();
            }else if(pilih.equals("2")){
                showAllNilai();
            }else if(pilih.equals("3")){
                getNilaiMahasiswa();
            }else if(pilih.equals("4")){
                sortNilai();
                showAllNilai();
            } else if (pilih.equals("5")) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Penilaian penilaian = new Penilaian();
        penilaian.mahasiswaList.add(new Mahasiswa(2141720239,"Yelan","081946708738"));
        penilaian.mahasiswaList.add(new Mahasiswa(2141720238,"Alkheema","082134443727"));
        penilaian.mahasiswaList.add(new Mahasiswa(2141720237,"Keqing","081946708721"));
        penilaian.mahasiswaList.add(new Mahasiswa(2141720236,"Xiang ling","083765654784"));

        penilaian.mataKuliahList.add(new MataKuliah(2011,"Pancasila",3));
        penilaian.mataKuliahList.add(new MataKuliah(2012,"Sistem Operasi",2));
        penilaian.mataKuliahList.add(new MataKuliah(2013,"Algoritma dan Struktur data",3));
        penilaian.mataKuliahList.add(new MataKuliah(2014,"Ilmu Komunikasi",2));
        penilaian.showMenu();
    }
}
