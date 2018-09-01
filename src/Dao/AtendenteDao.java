/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dominio.Atendente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class AtendenteDao implements IDao<Atendente> {

    private Connection connection;

    public AtendenteDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Atendente t) {

        String SQL = "INSERT INTO Atendente (`nome`, `nascimento`, `sexo`, `peso`,`email`,`cargo`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(SQL);
            pstmt.setString(1, t.getNome());
            pstmt.setString(2, t.getNascimento());
            pstmt.setString(3, t.getSexo());
            pstmt.setDouble(4, t.getPeso());
            pstmt.setString(5, t.getEmail());
            pstmt.setString(6, t.getCargo());
            pstmt.execute();
            System.out.println("Atendente inserido com sucesso");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Atendente getOne(int id) {

        Atendente p = null;
        try {
            Statement sta = connection.createStatement();
            ResultSet elements = sta.executeQuery("select * from Atendente " + "where id = " + id);
            while (elements.next()) {
                p = new Atendente();
                p.setId(elements.getInt("id"));
                p.setNome(elements.getString("nome"));
                p.setNascimento(elements.getString("nascimento"));
                p.setSexo(elements.getString("sexo"));
                p.setPeso(elements.getDouble("peso"));
                p.setEmail(elements.getString("email"));
                p.setCargo(elements.getString("cargo"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Atendente> list() {
        List<Atendente> list = new ArrayList<>();
        Atendente f;

        try {
            Statement sta = connection.createStatement();

            ResultSet elements = sta.executeQuery("select * from Atendente ");
            while (elements.next()) {
                f = new Atendente();
                f.setId(elements.getInt("id"));
                f.setNome(elements.getString("nome"));
                f.setNascimento(elements.getString("nascimento"));
                f.setSexo(elements.getString("sexo"));
                f.setPeso(elements.getDouble("peso"));
                f.setEmail(elements.getString("email"));
                f.setCargo(elements.getString("cargo"));
                list.add(f);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    @Override
    public void update(Atendente f) {

        String SQL = "update Atendente set nome=?, nascimento=?, sexo=?, peso=?, email=?, cargo=? where id=?";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(SQL);
            pstmt.setString(1, f.getNome());
            pstmt.setString(2, f.getNascimento());
            pstmt.setString(3, f.getSexo());
            pstmt.setDouble(4, f.getPeso());
            pstmt.setString(5, f.getEmail());
            pstmt.setString(6, f.getCargo());
            pstmt.setInt(7, f.getId());
            pstmt.execute();
            System.out.println("Atendente atualizado com sucesso");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void delete(int id) {

        String SQL = "Delete from Atendente where id = ?";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(SQL);
            pstmt.setInt(1, id);
            pstmt.execute();
            System.out.println("Atendente removido com sucesso");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

   @Override
    public void SelectTables() {

        String SQL = "select Cliente.nome, Cliente.email, Cliente.atendente from Cliente join Atendente;";

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {

                String nome = rs.getString("nome");
                String atendente = rs.getString("atendente");
                String email = rs.getString("email");

             
                Atendente a = new  Atendente(nome, atendente, email);
                System.out.println(a.getNome()+ " - " + a.getAtendente()+ " - " + a.getEmail());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
