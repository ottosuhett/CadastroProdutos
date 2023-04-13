/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ottopereira
 */
public class Listar {
    private String nome;
    private String marca;
    private String preco;
    
    public Listar(String nome, String marca, String preco){
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }
    @Override
    public String toString(){
        return this.nome;
    }
}
