/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.mysql.jdbc.Connection;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import models.Pessoa;

/**
 *
 * @author Sr. Roosevelt
 */
@ManagedBean
@ViewScoped
public class PessoaMB {
    private Pessoa pessoa = new Pessoa();
    private ArrayList<Pessoa> test = new ArrayList<Pessoa>();
    
    public void cadastrarUser(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/testweb", "root", "");
            String exemplo = "insert into cadastro (nome, sobrenome, email) values (?, ?, ?) ";
            
            PreparedStatement consulta = con.prepareStatement("insert into cadastro (nome, sobrenome, email) values (?, ?, ?) ");
           
            consulta.setString(1, pessoa.getNome());
            consulta.setString(2, pessoa.getSobrenome());
            consulta.setString(3, pessoa.getEmail());
            
            consulta.execute();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PessoaMB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public PessoaMB() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ArrayList<Pessoa> getTest() {
        return test;
    }

    public void setTest(ArrayList<Pessoa> test) {
        this.test = test;
    }
    
    public void cadastrar(){
        test.add(pessoa);
        pessoa = new Pessoa();
    }
}
