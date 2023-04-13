/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroprodutostela;

import models.DAOCadastroProdutos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




/**
 *
 * @author ottopereira
 */

public class ListenerSalvar implements ActionListener {
    private JTextField nome;
    private JTextField marca;
    private JTextField preco;
    

    private DAOCadastroProdutos dao;
    
    
    public ListenerSalvar(JTextField nome, JTextField marca, JTextField preco){
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
       
       if(nome.getText().equals("") || marca.getText().equals("") || preco.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Prencha os dados");
       }else{
           String msg = "Produto Cadastrado com Sucesso"+"\nNome: " + nome.getText() + "\nMarca: "+ marca.getText() + "\nPreco: " + preco.getText();
            JOptionPane.showMessageDialog(null, msg);
            this.dao = DAOCadastroProdutos.getInstance();
            dao.save(nome.getText(),marca.getText(),preco.getText());
            System.out.print("Salvo com Sucesso!");
            System.exit(0);
       }
       
       
        
    }
}
