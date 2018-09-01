/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;


public class Cliente extends Pessoa{
    
    public String atendente;
    
  public Cliente(String nome, String nascimento, String sexo, double peso, String email, String cargo) {
        super(nome, nascimento, sexo, peso, email);
    }
  
   public Cliente() {
    
   }

    public Cliente(String nome, String atendente, String email) {
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

    @Override
    public String toString() {
        return "Cliente{" + "atendente=" + atendente + '}';
    }
  
    
    
    
    
}
