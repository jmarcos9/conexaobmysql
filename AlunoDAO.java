package segundoPeriodo.bd_dio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public List<Aluno> list(){

        List<Aluno> alunos = new ArrayList<>();

        String urlConnection = "jdbc:mysql://localhost/dio_escola";

        try (Connection conn = DriverManager.getConnection(urlConnection, "jmarcos9", "luemarcos23")){
            //getConnection(urlConnection, "jmarcos9", "password");
            PreparedStatement prst = conn.prepareStatement("SELECT * FROM aluno");

            ResultSet rs = prst.executeQuery();

            while (rs.next()){
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        //rs.getDate("nascimeno"),
                        rs.getString("endereco"),
                        rs.getString("estado"));
                //luno(int id, String nome, Date nascimeno, String endereco, String estado)
                alunos.add(aluno);
            }
            System.out.println("sucesso");
        } catch (Exception e){
            System.out.println("Falha");
        }

        return alunos;
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

        /*//Definir paramentros para se conectar ao banco de dados msql
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
        }*/
    }

    public Aluno consularId (int id) {
        //preparar objeto para receber valores do BD
        Aluno aluno = new Aluno();

        String urlConnection = "jdbc:mysql://localhost/dio_escola";

        try (Connection conn = DriverManager.getConnection(urlConnection, "jmarcos9", "luemarcos23")) {
            //getConnection(urlConnection, "jmarcos9", "password");
            //preparar consulta BD sql
            String sql = "SELECT * FROM aluno WHERE id = ?";

            //preparar statement com paramentros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);

            //executa consulta e armazena retorno da consulta no objeto rs
            ResultSet rs = stmt.executeQuery();

            //guarda valores retomandos da tabela no objeto aluno
            if (rs.next()) {
                aluno.setId(rs.getInt("id"));
                        aluno.setNome(rs.getString("nome"));
                        //aluno.setNascimeno(rs.getDate("nascimeno"));
                        aluno.setEndereco(rs.getString("endereco"));
                        aluno.setEstado(rs.getString("estado"));


            //luno(int id, String nome, Date nascimeno, String endereco, String estado)
            } System.out.println("sucesso");
        } catch (Exception e) {
            System.out.println("Falha");
            e.printStackTrace();
        }
        //retorna aluno encontrado no banco de dados
        return aluno;
    }


    //inserção
    public void create(Aluno aluno) {

        String urlConnection = "jdbc:mysql://localhost/dio_escola";

        try (Connection conn = DriverManager.getConnection(urlConnection, "jmarcos9", "luemarcos23")) {
            //getConnection(urlConnection, "jmarcos9", "password");
            //preparar sql para inserir dados
            String sql = "INSERT INTO aluno(nome, endereco, estado) VALUES(?, ?, ?)";

            //preparar statement com paramentros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            //stmt.setDate(2,aluno.getNascimeno());
            stmt.setString(3, aluno.getEndereco());
            stmt.setString(4, aluno.getEstado());

            //executa inserção e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected );
        } catch (Exception e) {
            System.out.println("Falha na inserção");
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        String urlConnection = "jdbc:mysql://localhost/dio_escola";

        try (Connection conn = DriverManager.getConnection(urlConnection, "jmarcos9", "luemarcos23")) {
            //getConnection(urlConnection, "jmarcos9", "password");
            //preparar sql para deletar uma linha
            String sql = "DELETE FROM aluno WHERE id = ?";

            //preparar statement com paramentros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //executa inserção e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected );
        } catch (Exception e) {
            System.out.println("Falha no delete");
            e.printStackTrace();
        }
    }

    public void update(Aluno aluno) {

        String urlConnection = "jdbc:mysql://localhost/dio_escola";

        try (Connection conn = DriverManager.getConnection(urlConnection, "jmarcos9", "luemarcos23")) {
            //getConnection(urlConnection, "jmarcos9", "password");
            //preparar sql para atualizar uma linha
            String sql = "UPDATE aluno SET nome = ?, endereco = ?, estado = ? WHERE id = ?";

            //preparar statement com paramentros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEndereco());
            stmt.setString(3, aluno.getEstado());
            stmt.setInt(4, aluno.getId());


            //executa inserção e armazena o numero de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected );
        } catch (Exception e) {
            System.out.println("Falha no atualização");
            e.printStackTrace();
        }
    }



}

