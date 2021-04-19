package com.anasdroid.worldclockapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Country {
    String CountryName;
    String Time;

    public Country(String countryName, String time) {
        CountryName = countryName;
        Time = time;
    }
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
