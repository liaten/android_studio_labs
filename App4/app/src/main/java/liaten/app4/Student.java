package liaten.app4;

public class Student {
    private String Full_Name;
    private String Gender;
    private String Programming_Languages;
    private String IDE;

    public Student(String Full_Name_Add, String Gender_Add, String Programming_Languages_Add, String IDE_Add) {
        this.Full_Name = Full_Name_Add;
        this.Gender = Gender_Add;
        this.Programming_Languages = Programming_Languages_Add;
        this.IDE = IDE_Add;
    }

    public String Get_Full_Name() {
        return this.Full_Name;
    }

    public void Set_Full_Name(String New_Full_Name) {
        this.Full_Name = New_Full_Name;
    }

    public String Get_Gender() {
        return this.Gender;
    }

    public void Set_Gender(String New_Gender) {
        this.Gender = New_Gender;
    }

    public String Get_Programming_Languages() {
        return this.Programming_Languages;
    }

    public void Set_Programming_Languages(String New_Programming_Languages) {
        this.Programming_Languages = New_Programming_Languages;
    }

    public String Get_IDE() {
        return this.IDE;
    }

    public void Set_IDE(String New_IDE) {
        this.IDE = New_IDE;
    }

}
