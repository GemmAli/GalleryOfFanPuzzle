package accesoDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.AutorPojo;

//CLASE DE COMPORTAMIENTO QUE TENDRÁ LOS METODOS DE ACCESO A LA TABLA AUTORES DE LA BD

public class AutorPersistencia {

	// *******ATRIBUTOS*********
	private AccesoDB acceso;
	
	// *******CONSTRUCTOR*********
	public AutorPersistencia() {
		acceso = new AccesoDB();
	}
	
	// *******METODOS*********
	
	public ArrayList<AutorPojo> consultarAutores(){
		// necesitamos q el metodo retorne una coleccion, recogerá más de un Objeto
		ArrayList<AutorPojo> listaAutores = new ArrayList<AutorPojo>();
		
		//declaramos los recursos de acceso a la BD que necesitamos
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		//inicializamos los recuros y controlamos su excepcion
		try {
			con = acceso.getConexion();
			String query =  "SELECT * FROM autores";
			stmt = con.createStatement(); // como no hay interrogaciones será Statement
			rslt = stmt.executeQuery(query); // como es Select, tendrá ResultSet
			
			// para recuperar la informacion del resulSet, los registros, recorremos la
			// colección moviendo el cursor sobre los diferentes registros, con un WHILE
			// necesitaremos 8 variables para ir volcando las 8 columnas de cada registro
			// y un objeto POJO(Autor)
			String idAutor = "";
			String apenomAutor = "";
			String fechaNacAutor = null;
			String nacionalidadAutor = "";
			int telfAutor = 0;
			String mailAutor = "";
			String biografiaAutor = "";
			String destrezaAutor = "";
			AutorPojo autor = null;
			
			while (rslt.next()) {
				idAutor = rslt.getString(1);// cogemos la posición 1 del resulSet y lo almaceno en la variable
				apenomAutor = rslt.getString(2);
				fechaNacAutor = rslt.getString(3);
				nacionalidadAutor = rslt.getString(4);
				telfAutor = rslt.getInt(5);
				mailAutor = rslt.getString(6);
				biografiaAutor = rslt.getString(7);
				destrezaAutor = rslt.getString(8);
				
				// y creamos el Objeto Autor con esos 8 datos
				autor = new AutorPojo(idAutor, apenomAutor, fechaNacAutor, nacionalidadAutor, telfAutor, mailAutor, biografiaAutor, destrezaAutor);
				//y lo añadimos a la lista
				listaAutores.add(autor);
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
		return listaAutores;
	}
	
	/*	
		public String guardarAlumno(AlumnosPojo alumno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		// como no es select, no lleva resultSet

		String msg = ""; // declaramos esta variable para mostrar mensajes de confirmacion

		try {
			con = acceso.getConexion();
			String query = "INSERT INTO ALUMNOS VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, alumno.getId_alumno());
			pstmt.setString(2, alumno.getApenom());
			pstmt.setString(3, alumno.getEmail());
			pstmt.setString(4, alumno.getFecha_nac());
			pstmt.setString(5, alumno.getNom_padre());
			pstmt.setString(6, alumno.getTlf());

			// lo guardamos en la variable res, que será la que nos de mensaje de
			// confirmacion
			int res = pstmt.executeUpdate(); // si se hace bien res= 1, si no res=0

			if (res == 1) {
				msg = "Se ha realizado correctamente el registro";
			} else {
				msg = "No se ha podido realizar la inserción del registro";
			}

		} catch (ClassNotFoundException e) {
			msg = "Se ha producido un error en la conexión con la BBDD";
			e.printStackTrace();
		} catch (SQLException e) {
			msg = "Se ha producido un error SQL";
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

		return msg;
	}

	public String modificarAlumno(AlumnosPojo alumnoMod) {
		String msg = "";

		// recursos
		Connection con = null;
		PreparedStatement pstmt = null; // pq tendremos interrogacciones en la query
		// no hay ResulSet porque no es Select la consulta

		try {
			con = acceso.getConexion();
			String query = "UPDATE ALUMNOS SET ID_ALUMNO = ?, APENOM = ?, E_MAIL = ?, FECHA_NAC = ?, NOMBRE_PADRE = ?, TLF = ? WHERE ID_ALUMNO = ?";
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, alumnoMod.getId_alumno());
			pstmt.setString(2, alumnoMod.getApenom());
			pstmt.setString(3, alumnoMod.getEmail());
			pstmt.setString(4, alumnoMod.getFecha_nac());
			pstmt.setString(5, alumnoMod.getNom_padre());
			pstmt.setString(6, alumnoMod.getTlf());
			pstmt.setInt(7, alumnoMod.getId_alumno());

			int res = pstmt.executeUpdate();
			// el executeUpdate devuelve un entero,que será el numero de los registros
			// modificados (en este ejemplo tiene que ser un 1 para confirmar el cambio de
			// esa fila en concreto pues la seleccionamos por primary key).
			
			if (res == 1) {
				msg = "Se ha realizado la actualización correctamente";
			}

		} catch (ClassNotFoundException e) {
			msg = "No se ha podido establecer la conexion con la BBDD";
			e.printStackTrace();
		} catch (SQLException e) {
			msg = "Error de SQL";
			e.printStackTrace();
		} finally { // aquí cerraremos los recursos que hayamos utilizado
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String borrarAlumno(int idSel) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String msg = "";
		
		try {
			con = acceso.getConexion();

			String query = "DELETE FROM ALUMNOS WHERE ID_ALUMNO =?";
			pstmt = con.prepareStatement(query);
			// el primero es el uno no el cero
			pstmt.setInt(1, idSel);

			int res = pstmt.executeUpdate();

			if (res == 1) {
				msg = "Se ha borrado correctamente";
			} else {
				msg = "No se ha podido eliminar el alumno porque no existe en la tabla";
			}
		} catch (ClassNotFoundException e) {*/
			/*
			 * retornamos un mensaje, diciendo que la fila se ha borrado, por lo general se
			 * crea un pojo para todos estos retornos pero no lo vamos hacer, pero si vamos
			 * a retornar un string
			 */
			// e.printStackTrace();
			/*msg = "error de conexion con la base de datos";
		} catch (SQLException e) {
			// e.printStackTrace();
			msg = "Se ha producido un error SQL";
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
		return msg;
	
	}*/
	
}
