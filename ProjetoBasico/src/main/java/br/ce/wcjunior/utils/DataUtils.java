package br.ce.wcjunior.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
	
	public static Date obtemDataComDiferencaDeDias(int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		return calendar.getTime();
	}
	
	public static String obtemDataformatada(Date data) {
		DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(data);
	}
	
	public static String obtemDataFormatadaComDiferencaDeDias(int dias) {
		return obtemDataformatada(obtemDataComDiferencaDeDias(dias));
	}

}
