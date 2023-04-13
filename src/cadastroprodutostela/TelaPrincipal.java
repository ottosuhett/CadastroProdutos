/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroprodutostela;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JScrollPane;


import models.Listar;
import models.DAOCadastroProdutos;
/**
 *
 * @author ottopereira
 */
public class TelaPrincipal extends JFrame{
    private JPanel panel;
    private JPanel panelBotoes;

    private JButton btNovo;
    private JButton btSair;

    private JLabel labelTitle;

    private JMenuBar btMenu;
    private JMenu menuPrograma;
    private JMenuItem itemCadastro;
    private JMenuItem itemSair;
    
   
    private JList<Listar> lista;
    private JScrollPane scroll_lista;
    private DAOCadastroProdutos dao;

    public TelaPrincipal(){
        this.initialize();
        this.setExtendedState(NORMAL);
    }
    public void initialize(){
       
        this.dao = DAOCadastroProdutos.getInstance();
        
        btNovo = new JButton("Cadastrar Produto");
        btSair = new JButton("Sair");

        labelTitle = new JLabel("Cadastro de produtos");

        panel = new JPanel();
        panelBotoes = new JPanel();

        btMenu = new JMenuBar();
        menuPrograma = new JMenu("Menu");
        itemCadastro = new JMenuItem("Cadastrar Produto");
        itemSair = new JMenuItem("Sair");

        menuPrograma.add(itemCadastro);
        menuPrograma.addSeparator();
        menuPrograma.add(itemSair);

        btMenu.add(menuPrograma);
        this.setJMenuBar(btMenu);

        panel.setLayout(new BorderLayout(5,5));

        this.setBounds(0,0,600,300);
        this.setPreferredSize(new Dimension(600,300));
        
        /*Comecei a fazer a lista aqui*/
        lista = new JList();
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setModel(dao.list());
        lista.setVisibleRowCount(-1);
        
        scroll_lista = new JScrollPane(lista);
        panel.add(scroll_lista, BorderLayout.CENTER);
        
        
        panel.add(labelTitle, BorderLayout.PAGE_START);
        panelBotoes.setLayout(new GridLayout(6,1,10,10));
        
        
        btSair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        itemCadastro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                TelaCadastro tela = new TelaCadastro();
            }
        });



        btNovo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                TelaCadastro tela = new TelaCadastro();
            }
        
        });

        panelBotoes.add(btNovo);
        panelBotoes.add(btSair);

        panel.add(panelBotoes, BorderLayout.LINE_END);

        this.add(panel);
        this.pack();
        this.setTitle("Cadastro de Produtos");
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
