package com.rightside.doutorja.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SlimpleDateFormatUtils {

    public static void main(String[] args)
    {

        Date hoje = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh");

        String diaAtual = formatter.format(hoje);


    }
}
