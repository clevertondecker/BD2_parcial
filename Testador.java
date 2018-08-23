package principal;

import conexao.Conexao;
import conexao.Conexao;
import dao.LivroDao;
import dominio.Livro;

public class Testador {

    public static void main(String[] args) {

        //  Livro l = new Livro("Getting real", "37 signals", "37 signals", 4, 25.87);
        Livro l2 = new Livro("Fire in the palace", "Beta", "kaleals", 4, 23.87);

        Conexao c = new Conexao();
        LivroDao ldao = new LivroDao(c.abrirConexao());

        ldao.save(l2);

        System.out.println(ldao.getOne(1));

        //   Livro atualizado = new Livro("Valley of Genius", "don't know", "don't know either", 3, 54.34);
        //     atualizado.setId(1);
        //    ldao.update(atualizado);
        
        //ldao.delete();
        System.out.println(ldao.list());
        
        c.fecharConexao();

    }

}

