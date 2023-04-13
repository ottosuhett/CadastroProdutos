/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.sql.*;
import java.util.logging.*;
import javax.swing.DefaultListModel;


/**
 *
 * @author ottopereira
 */
public class DAOCadastroProdutos {
    private Connection conexao;
    private static DAOCadastroProdutos instancia;
    
    private DAOCadastroProdutos(){
        try{
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
        String host = "HOST NAME";
        String db = "DB NAME";
        String url = "jdbc:mysql://"+host+"/"+db;
        String user = "YOUR USER";
        String pwd = "YOUR PASSWORD";
        
        this.conexao = DriverManager.getConnection(url,user,pwd);
        if(this.conexao != null){
            System.out.println("Sucesso na conecao com DB");
        }else{
            System.out.println("Erro no db");
        }
        } catch(ClassNotFoundException e){
           System.out.println("O Drive Nao foi Encontrado");
        }catch(SQLException e){
            System.err.println("NAO FOI POSSIVEL CONECTAR O BANCO");
        }
    }
    
    public static DAOCadastroProdutos getInstance(){
            
        if(instancia == null){
            instancia = new DAOCadastroProdutos();
        }
        return instancia;
        }
    
    public void save(String nome, String marca, String preco){
        try{
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO cadProdutosDB (nome,marca,preco)"
                    + "VALUES(?,?,?)");
            ps.setString(1, nome);
            ps.setString(2,marca);
            ps.setString(3,preco);
            
            ps.execute();
        } catch(SQLException ex){
           Logger.getLogger(DAOCadastroProdutos.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public DefaultListModel<Listar> list(){
        DefaultListModel<Listar> model = new DefaultListModel<>();
        try{
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM cadProdutosDB");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                model.addElement(new Listar(rs.getString("nome"),rs.getString("marca"),rs.getString("preco")));
            }
            return model;
        }catch (SQLException ex){
            Logger.getLogger(DAOCadastroProdutos.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    
    
}
    
