package org.example;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Pessoa p = new Pessoa();
        p.setDataNascimento(LocalDate.of(2020,10,5));
        PessoaDAO dao = new PessoaDAO();


        dao.insert(p);

        dao.deleteID(-1);
        System.out.println( "Hello World!" );
    }
}
