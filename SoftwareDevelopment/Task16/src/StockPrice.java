/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02 Spring
 * Project: stock
 */

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class StockPrice {
    private static final int DECREASE_YEAR = -100;
    //Later needed constants
    private static final BigDecimal ONE = new BigDecimal(1);
    private static final int DATE_DOES_NOT_EXIST = -1;
    //Entry Class
    static class Entry {
        String date;
        BigDecimal open;
        BigDecimal high;
        BigDecimal low;
        BigDecimal close;
        BigDecimal volume;
        BigDecimal adjClose;
        //constructor class
        public Entry (final String theDate, final BigDecimal theOpen,
                final BigDecimal theHigh, final BigDecimal theLow,
                final BigDecimal theClose, final BigDecimal theVolume,
                final BigDecimal theAdjClose) {
            this.date = theDate;
            this.open = theOpen;
            this.high = theHigh;
            this.low = theLow;
            this.close = theClose;
            this.volume = theVolume;
            this.adjClose = theAdjClose;
        }
        //these all get what their method name specifies
        public final String getDate () {
            return date;
        }

        public final BigDecimal getOpen () {
            open.setScale(2, BigDecimal.ROUND_HALF_UP);
            return open;
        }

        public final BigDecimal getHigh () {
            high.setScale(2, BigDecimal.ROUND_HALF_UP);
            return high;
        }

        public final BigDecimal getLow () {
            low.setScale(2, BigDecimal.ROUND_HALF_UP);
            return low;
        }

        public final BigDecimal getClose () {
            close.setScale(2, BigDecimal.ROUND_HALF_UP);
            return close;
        }

        public final BigDecimal getVolume () {
            volume.setScale(2, BigDecimal.ROUND_HALF_UP);
            return volume;
        }

        public final BigDecimal getAdjClose () {
            adjClose.setScale(2, BigDecimal.ROUND_HALF_UP);
            return adjClose;
        }

    }

    public static void main (final String[] args) throws IOException, ParseException {
        final File file = new File(args[0]);
        final Scanner fileInput = new Scanner(file);
        fileInput.useDelimiter(",|\\n");
        final Scanner stdIn = new Scanner(System.in);
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, DECREASE_YEAR);
        final SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yy");
        df.set2DigitYearStart(cal.getTime());
        final ArrayList<Entry> stockList = new ArrayList<Entry>();
        fileInput.nextLine();
        //Assigns all needed variables to the arrayList
        while (fileInput.hasNextLine()) {
            final String date = fileInput.next();
            final BigDecimal open = fileInput.nextBigDecimal();
            final BigDecimal high = fileInput.nextBigDecimal();
            final BigDecimal low = fileInput.nextBigDecimal();
            final BigDecimal close = fileInput.nextBigDecimal();
            final BigDecimal volume = fileInput.nextBigDecimal();
            final BigDecimal adjClose = fileInput.nextBigDecimal();
            final Entry e = new Entry (date, open, high, low, close, volume, adjClose);
            stockList.add(e);
            fileInput.nextLine();
        }
        //Scans the dates and finds their equivalent index and uses it
        //to calculate the averages of the 6 file inputs
        while (stdIn.hasNextLine()) {
            int firstIndex = 0;
            int secondIndex = 0;
            final String date1 = stdIn.next();
            final String date2 = stdIn.next();
            BigDecimal count = new BigDecimal(0);
            BigDecimal averageOpen = new BigDecimal(0);
            BigDecimal averageHigh = new BigDecimal(0);
            BigDecimal averageLow = new BigDecimal(0);
            BigDecimal averageClose = new BigDecimal(0);
            BigDecimal averageVolume = new BigDecimal(0);
            BigDecimal averageAdjClose = new BigDecimal(0);
            for (int i = 0; i < stockList.size(); i++) {
                if (date1.equals(stockList.get(i).getDate())) {
                    firstIndex = i;
                    break;
                } else if (i == stockList.size() - 1) {
                   firstIndex = DATE_DOES_NOT_EXIST;
                  }
            }
            for (int i = 0; i < stockList.size(); i++) {
                if (date2.equals(stockList.get(i).getDate())) {
                    secondIndex = i;
                    break;
                } else if (i == stockList.size() - 1) {
                    secondIndex = DATE_DOES_NOT_EXIST;
                  }
            }
            //calculates avg if the dates exist
            if (firstIndex != DATE_DOES_NOT_EXIST || secondIndex != DATE_DOES_NOT_EXIST) {
                for (int i = secondIndex; i < (firstIndex + 1); i++) {
                   averageOpen = averageOpen.add(stockList.get(i).getOpen());
                   averageHigh = averageHigh.add(stockList.get(i).getHigh());
                   averageLow = averageLow.add(stockList.get(i).getLow());
                   averageClose = averageClose.add(stockList.get(i).getClose());
                   averageVolume = averageVolume.add(stockList.get(i).getVolume());
                   averageAdjClose = averageAdjClose.add(stockList.get(i).getAdjClose());
                   count = count.add(ONE);
                }
                averageOpen = averageOpen.divide(count, 2, BigDecimal.ROUND_HALF_UP);
                averageHigh = averageHigh.divide(count, 2, BigDecimal.ROUND_HALF_UP);
                averageLow = averageLow.divide(count, 2, BigDecimal.ROUND_HALF_UP);
                averageClose = averageClose.divide(count, 2, BigDecimal.ROUND_HALF_UP);
                averageVolume = averageVolume.divide(count, 2, BigDecimal.ROUND_HALF_UP);
                averageAdjClose = averageAdjClose.divide
                        (count, 2, BigDecimal.ROUND_HALF_UP);
                System.out.printf("%.2f,%.2f,%.2f,%.2f,%.2f,%.2f",
                        averageOpen, averageHigh, averageLow,
                        averageClose, averageVolume, averageAdjClose);
                System.out.println();
            } else {
                System.out.println("No Data");
            }
        }
    }
}
