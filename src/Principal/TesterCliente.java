/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Conexao.Conexao;
import Dao.ClienteDao;
import Dominio.Cliente;

public class TesterCliente {

    public static void main(String[] args) {

        Cliente c = new Cliente("Amanda", "19-12-1994", "Fem", 44.7, "@hotmail.com", "Motorista");
        Cliente c1 = new Cliente("Maria", "23-10-1934", "Fem", 44.7, "@hotmail.com", "Secretaria");

        Conexao conex = new Conexao();

        ClienteDao Cldao = new ClienteDao(conex.abrirConexao());

        //Method Save
        Cldao.save(c);

        //Method GetOne
        System.out.println(Cldao.getOne(2));

        //List All
        System.out.println(Cldao.list());

        //Method Update
        c1.setId(1);
        Cldao.update(c1);

        Cldao.delete(1);

        //Inner join entre tabelas
        Cldao.SelectTables();

        conex.fecharConexao();
    }
}
