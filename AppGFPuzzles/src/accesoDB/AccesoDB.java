package accesoDB;

//CLASE QUE ESPECIFICA LA CONEXION CON LA BASE DE DATOS

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

public class AccesoDB {

	// dos atributos, uno para el driver (tipo especifico de ntra BBDD) y otro la
	// url (ubicacion de ntra BBDD), aunque estos datos lo normal es que vayan en un
	// fichero externo.

	private String driver;
	private String url;

	// constructor
	public AccesoDB() {
		this.driver = "org.sqlite.JDBC";
		this.url = "jdbc:sqlite:C:\\workspace\\AppGFPuzzles\\dbSQLite\\gallery.db";
	}

	// m�todo que nos permita el acceso a la BBDD y que nos devuelve la conexion
	public Connection getConexion() throws ClassNotFoundException, SQLException {
		// las dos excepciones que nos generan (driver y url) las lanzamos arriba

		Class.forName(driver); // especificamos el driver

		// especificamos caracteristicas de conexion. Indicamos que tenemos claves
		// for�neas en nuestras tablas y que vuelque dichas propiedades
		// A�adiremos esta config como par�metro en la conexi�n.
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);

		// creamos el objeto y que igualamos al DriverManager que le pasamos la url y la
		// configuraci�n config
		Connection conexion = DriverManager.getConnection(url, config.toProperties());

		System.out.println("Conexi�n establecida");
		return conexion;
	}
}
