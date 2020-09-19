package segundoPeriodo.bd_dio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] args) throws SQLException {

        String urlConnection = "jdbc:mysql://localhost/dio_escola";

        try (Connection conn = DriverManager.getConnection(urlConnection, "jmarcos9", "luemarcos23")){
            //getConnection(urlConnection, "jmarcos9", "password");
            System.out.println("sucesso");
        } catch (Exception e){
            System.out.println("Falha");
        }

        //forma antiga
        //Connection conn = null;
        /*try {
            conn = DriverManager.getConnection(urlConnection, "jmarcos9", "luemarcos23");
                    //getConnection(urlConnection, "jmarcos9", "password");
            System.out.println("sucesso");
        } catch (Exception e){
            System.out.println("Falha");
        } finally {
            conn.close();
        }*/

        //Definir paramentros para se conectar ao banco de dados msql
        String diver = "mysql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "dio_escola";
        String user = "jmarcos9";
        String password = "luemarcos23";

        //Contrução String de conexão
        StringBuilder sb = new StringBuilder("jdbc:")
                .append(diver).append("://")
                .append(dataBaseAddress).append("/")
                .append(dataBaseName);

        String connectionUrl = sb.toString();

        //4criar conexão uando Drivermanneger pasando paramrteos string de conexão, usuario e senha
        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password) ){
            System.out.println("Sucesso na conexão com o baco");
        } catch (SQLException e){
            System.out.println("Falha na Conexão com banco");
            e.printStackTrace();
        }

    }
}
