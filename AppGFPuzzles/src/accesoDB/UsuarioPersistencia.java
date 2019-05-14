package accesoDB;

//CLASE DE COMPORTAMIENTO QUE TENDRÁ LOS METODOS DE ACCESO A LA TABLA USUARIO DE LA BD

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.AutorPojo;
import model.UsuarioPojo;

public class UsuarioPersistencia {

	// *******ATRIBUTOS*********
	private AccesoDB acceso;

	// *******CONSTRUCTOR*********
	public UsuarioPersistencia() {
		this.acceso = new AccesoDB();
	}

	// *******METODOS*********

	// metodo para comprobar lo que nos introducen en los campos de la
	// ventana Login y confirmar si lo introducido es correcto o no
	public boolean comprobarUser(UsuarioPojo user) {
		boolean usuarioOK = false;

		Connection con = null;
		PreparedStatement pstmt = null; // pstmt porque tenemos dos incognitas en la select
		ResultSet rslt = null;

		try {
			con = acceso.getConexion();

			// antes de crear el pstmt tenemos que especificar la query:
			String query = "SELECT * FROM empleados WHERE e_mail_emple = ? AND password_emple = ?";
			pstmt = con.prepareStatement(query);

			// asignamos a nuestro pstmt dos valores, uno para cada ?:
			pstmt.setString(1, user.getE_mail_emple());
			pstmt.setString(2, user.getPassword_emple());

			rslt = pstmt.executeQuery();

			if (rslt.next()) {
				usuarioOK = true;
				// cambiamos boolean en funcion si devuelve o no registro esta consulta
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuarioOK;
	}

	// metodo para insertar nuevo usuario en la BD cuando registramos nuevo empleado
	public int insertarUser(UsuarioPojo newUser) {
		int res = 0;

		//int id = obtenerIdEmple();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = acceso.getConexion();

			String query = "INSERT INTO empleados ('ape_nom_emple', 'num_ssocIal','cuentaBancaria', 'dni', 'e_mail_emple', 'password_emple') VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);

			//pstmt.setInt(1, (id+1)); // es autoincrement
			pstmt.setString(1, newUser.getApe_nom_emple());
			pstmt.setInt(2, newUser.getNum_ssocIal());
			pstmt.setString(3, newUser.getCuentaBancaria());
			pstmt.setString(4, newUser.getDni());
			pstmt.setString(5, newUser.getE_mail_emple());
			pstmt.setString(6, newUser.getPassword_emple());

			// almacenamos pstmt en una variable, si se guarda ok res=1, si no, res=0
			res = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	/*public int obtenerIdEmple() {
		// necesitamos q el metodo retorne el numero de registros
		int contador = 1;

		// declaramos los recursos de acceso a la BD que necesitamos
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;

		// inicializamos los recuros y controlamos su excepcion
		try {
			con = acceso.getConexion();
			String query = "SELECT * FROM empleados";
			stmt = con.createStatement(); // como no hay interrogaciones será Statement
			rslt = stmt.executeQuery(query); // como es Select, tendrá ResultSet

			// para recuperar la informacion del resulSet, los registros, recorremos la
			// colección moviendo el cursor sobre los diferentes registros, y aumentamos el
			// contador
			while (rslt.next()) {
				contador++;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // aquí cerraremos los recursos que hayamos utilizado
			try {
				if (rslt != null)
					rslt.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contador;
	}*/

	public void modificarUser() {
		// TODO metodo para modificar un empleado de la lista de empleados
	}

	public void borrarUser() {
		// TODO metodo para borrar un empleado de la lista de empleados
	}

	// metodo para listar los usuarios dados de alta en la base de datos
	public ArrayList<UsuarioPojo> listarUser() {
		// necesitamos q el metodo retorne una coleccion, recogerá más de un Objeto
		ArrayList<UsuarioPojo> listaEmpleados = new ArrayList<UsuarioPojo>();

		// declaramos los recursos de acceso a la BD que necesitamos
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;

		// inicializamos los recuros y controlamos su excepcion
		try {
			con = acceso.getConexion();
			String query = "SELECT * FROM empleados";
			stmt = con.createStatement(); // como no hay interrogaciones será Statement
			rslt = stmt.executeQuery(query); // como es Select, tendrá ResultSet

			// para recuperar la informacion del resulSet, los registros, recorremos la
			// colección moviendo el cursor sobre los diferentes registros, con un WHILE
			// necesitaremos 7 variables para ir volcando las 7 columnas de cada registro
			// y un objeto POJO(usuario)
			int idEmple = 0;
			String apenomEmple = "";
			int numSegSocial = 0;
			String cuentaBancaria = "";
			String dniEmple = "";
			String mailEmple = "";
			String passwdEmple = "";
			UsuarioPojo user = null;

			while (rslt.next()) {
				idEmple = rslt.getInt(1);// cogemos la posición 1 del resulSet y lo almaceno en la variable
				apenomEmple = rslt.getString(2);
				numSegSocial = rslt.getInt(3);
				cuentaBancaria = rslt.getString(4);
				dniEmple = rslt.getString(5);
				mailEmple = rslt.getString(6);
				passwdEmple = rslt.getString(7);

				// y creamos el Objeto Usuario con esos datos
				user = new UsuarioPojo(idEmple, apenomEmple, numSegSocial, cuentaBancaria, dniEmple, mailEmple,
						passwdEmple);
				// y lo añadimos a la lista
				listaEmpleados.add(user);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // aquí cerraremos los recursos que hayamos utilizado
			try {
				if (rslt != null)
					rslt.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaEmpleados;
	}

}
