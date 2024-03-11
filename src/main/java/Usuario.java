import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuario {

    public static ResultSet consultarTablaPersona (Connection connection) throws SQLException {
        //Se crea consulta SQL
        String sql_sentencia = "SELECT * FROM dbo.Usuario";
        ResultSet resultSet = null;
        try {
            //2. CREAR OBJETO STATEMENT, preparar sentencia
            Statement sentencia = connection.createStatement();

            //3. CREAR OBJETO RESULTSET, obtener los registros
            resultSet = sentencia.executeQuery(sql_sentencia);
            System.out.println("Consulta correcta");
        } catch (SQLException e) {
            System.out.println("ALGO SALIÓ MAL EN LA CONSULTA");
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void imprimirRegistros (ResultSet resultSet) throws SQLException {
        // Procesar los resultados
        while (resultSet.next()) {
            try {
                // Obtener datos de la fila actual
                int clave = resultSet.getInt("clave");
                String userID = resultSet.getString("UserID");
                String password = resultSet.getString("Passwd");
                String nombre = resultSet.getString("Nombre");
                String apellidos = resultSet.getString("Apellidos");
                // Hacer algo con los datos, por ejemplo, imprimirlos
                System.out.println("CLAVE: " + clave + ", Nombre: " + nombre + " "+ apellidos +  ", Usuario: " + userID + ", Password: " + password +"\n");
            } catch (SQLException e){
                System.out.println("Alguna columna no tiene el nombre correcto o el tipo de dato no es correcto?");
                e.printStackTrace();
            }

        }
    }
}
