package org.tables;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class Constant {

	private final static Calendar calendar = new GregorianCalendar();
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
	private final static String date = sdf.format(calendar.getTime());
	private final static String time = sdf1.format(calendar.getTime());
	
	public static final String getDate() {
		return date;
	}
	public static final String getTime() {
		return time;
	}

	
	
}
