/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroprodutostela;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

/**
 *
 * @author ottopereira
 */
public class TelaCadastro extends JDialog {
    private JPanel panel;
    private JLabel labelNome;
    private JLabel labelMarca;
    private JLabel labelPreco;

    private JTextField textNome;
    private JTextField textMarca;
    private JTextField textPreco;

    private JButton btCadastra;
    private JButton btCancela;


    public TelaCadastro(){
        this.initialize();
        this.setModal(true);
        
    }

    public void initialize(){
        panel = new JPanel();
        GridLayout g1 = new GridLayout(5,2,10,10);
        panel.setLayout(g1);
        this.setBounds(0,0,800,400);

        labelNome = new JLabel("Nome:");
        labelMarca = new JLabel("Marca:");
        labelPreco = new JLabel("Preco:");

        textNome = new JTextField();
        textMarca = new JTextField();
        textPreco = new JTextField();

        btCadastra = new JButton("Cadastrar");
        btCancela = new JButton("Cancelar");
        
        btCadastra.addActionListener(new ListenerSalvar(textNome,textMarca,textPreco));
 
       
        btCancela.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelMarca);
        panel.add(textMarca);
        panel.add(labelPreco);
        panel.add(textPreco);
        panel.add(btCadastra);
        panel.add(btCancela);

        this.add(panel);
        this.setPreferredSize(new Dimension(400, 200));
        this.setTitle("Cadastro de Produto");
        this.pack();

        this.setVisible(true);
    
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
