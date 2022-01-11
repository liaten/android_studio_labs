package liaten.app4;

import android.os.Parcel;
import android.os.Parcelable;

public class PStudent implements Parcelable {
    private String Full_Name, Gender, Programming_Languages, IDE;

    public PStudent(String Full_Name_Add, String Gender_Add, String Programming_Languages_Add, String IDE_Add) {
        this.Full_Name = Full_Name_Add;
        this.Gender = Gender_Add;
        this.Programming_Languages = Programming_Languages_Add;
        this.IDE = IDE_Add;
    }

    protected PStudent(Parcel in) {
        Full_Name = in.readString();
        Gender = in.readString();
        Programming_Languages = in.readString();
        IDE = in.readString();
    }

    public static final Creator<PStudent> CREATOR = new Creator<PStudent>() {
        @Override
        public PStudent createFromParcel(Parcel in) {
            return new PStudent(in);
        }

        @Override
        public PStudent[] newArray(int size) {
            return new PStudent[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Full_Name);
        parcel.writeString(Gender);
        parcel.writeString(Programming_Languages);
        parcel.writeString(IDE);
    }
}
