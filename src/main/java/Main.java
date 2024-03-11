import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
            //CREAMOS LA CONEXION
           Connection conexion = ConexionBaseDeDatos.crearConexion();
           //CONSULTAMOS LOS REGISTROS EN LA TABLA PERSONAS
           ResultSet resultSet= Usuario.consultarTablaPersona(conexion);
           //IMPRIMIMOS LOS REGISTROS EN LA TABLA PERSONAS
           Usuario.imprimirRegistros(resultSet);

            //CERRAMOS LA CONEXION
            ConexionBaseDeDatos.cerrarConexion(conexion);
    }
}