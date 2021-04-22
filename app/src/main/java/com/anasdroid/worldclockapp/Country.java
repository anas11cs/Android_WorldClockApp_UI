package com.anasdroid.worldclockapp;

import android.opengl.Visibility;
import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class country implements Parcelable {
    String CountryName;
    String Time;
    boolean VisibilityCountry;

    public country(country c){
        this.CountryName=c.CountryName;
        this.Time=c.Time;
        this.VisibilityCountry=c.VisibilityCountry;
    }

    public country(String countryName, String time, boolean visibilityCountry) {
        CountryName = countryName;
        Time = time;
        VisibilityCountry=visibilityCountry;
    }
    // Parcelable Country Below
    protected country(Parcel in) {
        CountryName = in.readString();
        Time = in.readString();
        VisibilityCountry = in.readByte() != 0;
    }

    public static final Creator<country> CREATOR = new Creator<country>() {
        @Override
        public country createFromParcel(Parcel in) {
            return new country(in);
        }

        @Override
        public country[] newArray(int size) {
            return new country[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(CountryName);
        dest.writeString(Time);
        dest.writeByte((byte) (VisibilityCountry ? 1 : 0));
    }
    // https://www.journaldev.com/17899/java-simpledateformat-java-date-format#java-date-time-format-example
    // https://www.javatpoint.com/post/java-locale-getlanguage-method
/*    String
    // ============================================ get All Countries

    // Use of getAvailableLocales()
    Locale[] locale = Locale.getAvailableLocales();

    //   ========================================== default locale
    import java.util.*;
    public class LocaleGetDefaultExample1
    {
        public static void main(String[] args)
        {
    //
            // create a new locale
            Locale locale = Locale.getDefault();

            // print the default locale
            System.out.println("Locale:" + locale);
        }
    }

    // ========================================= get Country Name from a locale
    import java.util.*;
    public class LocaleGetDisplayCountryExample1 {
        public static void main(String[] args) {
            // Creating a new Locale
            Locale locale1 = new Locale("English", "IN");

            // display locale
                        System.out.println("Locale name: "+ locale1);

            // Use of getDisplayCountry()
                        System.out.println("Country Name: "
                                + locale1.getDisplayCountry());
                    }
                }

    //  ========================================= Time Format for a locale

    Locale locale = new Locale("fr", "FR");
    DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
    String date = dateFormat.format(new Date());
    //System.out.println(date);*/
}
