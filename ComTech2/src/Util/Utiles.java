package Util;

import java.awt.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Utiles {

	public static Date convertStringToDate(String fechaString) {
		Date date = null;
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = simpleFormat.parse(fechaString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

	public static String convertDateToString(Date fecha) {
		String date = null;
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");

		date = simpleFormat.format(fecha);

		return date;
	}




	public static boolean isAlpha(String name) {

		if (name.isEmpty())
			return false;
		return name != null && Pattern.matches("[a-zA-Z ]*", name);
	}

	public static boolean isUsername(String name) {

		if (name.isEmpty())
			return false;
		return name != null && Pattern.matches("[a-zA-Z0-9 ]*", name);
	}

	public static boolean isNum(String name) {
		if (name.isEmpty())
			return false;
		return name != null && Pattern.matches("[0-9-]*", name) && name.length() >= 10 && name.length() <= 12;

	}
	public static boolean isFloat(String name) {
		if (name.isEmpty())
			return false;
		Pattern p = Pattern.compile("[0-9]*\\.?[0-9]+");
		Matcher m = p.matcher(name);
		return name != null && m.find();
		
	}

	public static boolean isOnlyNum(String name) {
		if (name.isEmpty())
			return false;
		return name != null && Pattern.matches("[0-9]*", name);
	}

	

	public static boolean isPassword(String password) {
		if (password.isEmpty())
			return false;
		return password != null && password.length() >= 3;
	}

	public static boolean isAddress(String name) {
		if (name.isEmpty())
			return false;
		return name != null && Pattern.matches("[0-9a-zA-Z ,-]*", name);
	}

	public static void setErrorColor(JComponent comp) {
		(comp).setBorder(new LineBorder(Color.RED, 2));
	}

	public static void setColor(JComponent comp) {
		(comp).setBorder(new LineBorder(SystemColor.activeCaption, 2));
	}

}
