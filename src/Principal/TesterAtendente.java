/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Dao.AtendenteDao;
import Dominio.Atendente;
import Conexao.Conexao;
import Dominio.Cliente;

/**
 *
 * @author ton
 */
public class TesterAtendente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Atendente f = new Atendente("Mariana", "19-12-1994", "Fem", 87.7, "@gmail.com", "Vendas");
        Atendente f1 = new Atendente("Silvana", "19-12-1994", "Fem", 44.7, "@hotmail.com", "Telemarking");

        Conexao conex = new Conexao();

        AtendenteDao Fldao = new AtendenteDao(conex.abrirConexao());

        //Method Save
        Fldao.save(f);

        //Method GetOne
        System.out.println(Fldao.getOne(15));

        //List All
        System.out.println(Fldao.list());

        //Method Update
        f1.setId(15);
        Fldao.update(f1);

        Fldao.delete(15);

        //Inner join entre tabelas
        Fldao.SelectTables();

        conex.fecharConexao();

    }

}
