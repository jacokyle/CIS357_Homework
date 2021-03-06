package edu.gvsu.cis.convcalc.dummy;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.ArrayList;
import java.util.List;

public class HistoryContent {
    public static final List<HistoryItem> ITEMS = new ArrayList<HistoryItem>();

    public static void addItem(HistoryItem item) {
        ITEMS.add(item);
    }

    static {
        DateTime now = DateTime.now();
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
        addItem(new HistoryItem(2.0, 1.829, "Length", "Yards", "Meters", fmt.print(now.minusDays(1))));
        addItem(new HistoryItem(1.0, 3.785, "Volume", "Gallons", "Liters", fmt.print(now.minusDays(1))));
        addItem(new HistoryItem(2.0, 1.829, "Length", "Yards", "Meters", fmt.print(now.plusDays(1))));
        addItem(new HistoryItem(1.0, 3.785, "Volume", "Gallons", "Liters", fmt.print(now.plusDays(1))));
    }

    public static class HistoryItem {
        public String _key;
        public final Double fromVal;
        public final Double toVal;
        public final String mode;
        public final String fromUnits;
        public final String toUnits;

        public final String timestamp;

        public HistoryItem() {
            _key = "";
            fromVal = 0.0;
            toVal = 0.0;
            mode = "Volume";
            fromUnits = "Gallons";
            toUnits = "Liters";
            timestamp = "";
        }

        public HistoryItem(Double fromVal, Double toVal, String mode,
                           String fromUnits, String toUnits, String timestamp) {
            this.fromVal = fromVal;
            this.toVal = toVal;
            this.mode = mode;
            this.fromUnits = fromUnits;
            this.toUnits = toUnits;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return this.fromVal + " " + this.fromUnits + " = " + this.toVal + " " + this.toUnits;
        }
    }
}