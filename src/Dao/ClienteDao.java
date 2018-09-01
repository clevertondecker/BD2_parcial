/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClienteDao implements IDao<Cliente> {

    private Connection connection;

    public ClienteDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Cliente t) {

        String SQL = "INSERT INTO Cliente (`nome`, `nascimento`, `sexo`, `peso`,`email`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(SQL);
            pstmt.setString(1, t.getNome());
            pstmt.setString(2, t.getNascimento());
            pstmt.setString(3, t.getSexo());
            pstmt.setDouble(4, t.getPeso());
            pstmt.setString(5, t.getEmail());
            pstmt.execute();
            System.out.println("Cliente inserido com sucesso");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Cliente getOne(int id) {

        Cliente c = null;
        try {
            Statement sta = connection.createStatement();
            ResultSet elements = sta.executeQuery("select * from Cliente " + "where id = " + id);
            while (elements.next()) {
                c = new Cliente();
                c.setId(elements.getInt("id"));
                c.setNome(elements.getString("nome"));
                c.setNascimento(elements.getString("nascimento"));
                c.setSexo(elements.getString("sexo"));
                c.setPeso(elements.getDouble("peso"));
                c.setEmail(elements.getString("email"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Cliente> list() {
        List<Cliente> list = new ArrayList<>();
        Cliente c;

        try {
            Statement sta = connection.createStatement();

            ResultSet elements = sta.executeQuery("select * from Cliente ");
            while (elements.next()) {
                c = new Cliente();
                c.setId(elements.getInt("id"));
                c.setNome(elements.getString("nome"));
                c.setNascimento(elements.getString("nascimento"));
                c.setSexo(elements.getString("sexo"));
                c.setPeso(elements.getDouble("peso"));
                c.setEmail(elements.getString("email"));
                list.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Cliente f) {

        String SQL = "update Cliente set nome=?, nascimento=?, sexo=?, peso=?, email=? where id=?";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(SQL);
            pstmt.setString(1, f.getNome());
            pstmt.setString(2, f.getNascimento());
            pstmt.setString(3, f.getSexo());
            pstmt.setDouble(4, f.getPeso());
            pstmt.setString(5, f.getEmail());
            pstmt.setInt(6, f.getId());
            pstmt.execute();
            System.out.println("Cliente atualizado com sucesso");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String SQL = "Delete from Cliente where id = ?";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.execute();
            System.out.println("Cliente removido com sucesso");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void SelectTables() {

        //String SQL = "insert into livro (id, titulo, generoID) values (?,?,?)";
        String SQL = "select Cliente.nome, Cliente.email, Cliente.atendente from Cliente join Atendente;";

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                String nome = rs.getString("nome");
                String atendente = rs.getString("atendente");
                String email = rs.getString("email");

             
                Cliente c = new Cliente(nome, atendente, email);
                System.out.println(c.getNome()+ " - " + c.getAtendente()+ " - " + c.getEmail());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
