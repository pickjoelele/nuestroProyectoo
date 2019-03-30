package loadData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import database.Database;
import logical.Admin;
import logical.Controladora;

public class loadData {
	private static Controladora control;

	public static void load() {
		control = new Controladora();
	}

	public static Controladora getControladora() {
		return control;
	}

}
