package com.example.demogroup.utils;

import java.time.LocalDate;

public final class DateUtils {


    public static LocalDate addSixMonthsToDate(LocalDate localDate) {

        LocalDate afterSixMonthsDate = localDate.plusMonths(6);

        return afterSixMonthsDate;
    }
}
