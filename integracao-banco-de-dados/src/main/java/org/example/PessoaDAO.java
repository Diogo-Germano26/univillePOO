package org.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO extends BaseDAO{
    public void deleteID(long id){
        String sql="delete from Pessoa where id=?";
        try(Connection con = con(); PreparedStatement pre = con().prepareStatement(sql)){
            pre.setLong(1,id);
            pre.execute();
        }catch (SQLException e){
            System.out.println("erro ao deletar pello id"+id);
            System.out.println("erro"+e.getMessage());
        }
    }

    public void insert(Pessoa p){
        String sql= "INSERT INTO Pessoaa" +
                "(Nome, Sobrenome, dataNascimento, Ativo, CPF, Peso, Altura) VALUES (?,?,?,?,?,?,?)";;
        try(Connection con = con(); PreparedStatement pre = con().prepareStatement(sql)){
            pre.setString(1,p.getNome());
            pre.setString(2, p.getSobrenome());
            pre.setString(3, p.getDataNascimento());
            pre.setString(4, p.isAtivo());
            pre.setString(5, p.getCpf());
            pre.setString(6, p.getPeso());
            pre.setString(7, p.getAltura());
            pre.execute();
        }catch (SQLException e){
            System.out.println("erro ao deletar pello id"+p.getNome());
            System.out.println("erro"+e.getMessage());
        }
    }
}
