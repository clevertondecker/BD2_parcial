/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;

public class Atendente extends Pessoa {

    public String cargo;
    public String atendente;

    public Atendente(String nome, String nascimento, String sexo, double peso, String email, String cargo) {
        super(nome, nascimento, sexo, peso, email);
        this.cargo = cargo;
    }

    public Atendente() {

    }

    public Atendente(String nome, String atendente, String email) {
        this.nome = nome;
        this.atendente = atendente;
        this.email = email;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
