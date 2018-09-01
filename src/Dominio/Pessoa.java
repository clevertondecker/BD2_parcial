/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;


public abstract  class Pessoa {
    
    public int id;
    public String nome;
    public String nascimento;
    public String sexo;
    public double peso;
    public String email;
       
    
      public Pessoa() {
    
   }

    public Pessoa(String nome, String nascimento, String sexo, double peso, String email) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.peso = peso;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", sexo=" + sexo + ", peso=" + peso + ", email=" + email + '}';
    }

   
    
    
}
