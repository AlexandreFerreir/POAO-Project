/**
 * @author Alexandre Ferreira
 * @author Duarte
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe para criar janelas, para que a aplicação tenha interação com o utilizador
 */

public class Janela extends JFrame {
    /**
     * Objeto da classe StarThrive para se ter acesso aos seus atributos e métodos
     */
    protected StarThrive gestoraempresas;
    /**
     * JFrame inicial da aplicação
     */
    protected JFrame framesaudacao;
    /**
     * Objeto da classe Ficheiro para se ter acesso aos seus atributos e métodos
     */
    protected Ficheiro ficheiro;

    /**
     * Construtor sem parâmetros, inicializa os atributos e cria as janelas necessárias consoante as ações do utilizador
     */

    public Janela() {
        ficheiro=new Ficheiro();
        gestoraempresas=new StarThrive();
        gestoraempresas.listaempresas=ficheiro.carregaDados(gestoraempresas,"starthrive.dat","starthrive.txt");
        for (Empresa empresa: gestoraempresas.listaempresas) {
            empresa.aumentacontador();
        }
        framesaudacao = new JFrame("StarThrive");
        framesaudacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framesaudacao.setSize(500, 500);

        JLabel labelsaudacao = new JLabel("Bem-vindo à StarThrive!",SwingConstants.CENTER);

        JButton seguinte = new JButton("Seguinte");
        seguinte.addActionListener(new ButtonseguinteListener());


        JPanel panelsaudacao = new JPanel();
        panelsaudacao.setLayout(new BorderLayout());
        panelsaudacao.add(labelsaudacao);
        panelsaudacao.add(seguinte, BorderLayout.SOUTH);

        framesaudacao.add(panelsaudacao);
        framesaudacao.setVisible(true);

    }

    private class ButtonseguinteListener implements ActionListener {
        protected JFrame framemenu;
        protected JPanel panelmenu;
        protected JLabel labelmenu;
        protected JButton listarempresa, criarempresa, maiorreceitaanual, menordespesaanual, maiorlucroanual, maiorcapacidadeclientes;

        @Override
        public void actionPerformed(ActionEvent e) {
            framemenu = new JFrame("StarThrive");
            framemenu.setSize(1000, 1000);
            framemenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            labelmenu = new JLabel("Por favor, escolha uma das opções.");

            listarempresa = new JButton("Listar empresas");
            listarempresa.addActionListener(new ButtonlistarempresaListener());

            criarempresa = new JButton("Criar uma nova empresa");
            criarempresa.addActionListener(new ButtoncriarempresaListener());


            maiorreceitaanual = new JButton("Maior receita anual");
            maiorreceitaanual.addActionListener(new ButtonmaiorreceitaListener());
            menordespesaanual = new JButton("Menor despesa anual");
            menordespesaanual.addActionListener(new ButtonmenordespesaListener());
            maiorlucroanual = new JButton("Maior lucro anual");
            maiorlucroanual.addActionListener(new ButtonmaiorlucroListener());

            maiorcapacidadeclientes = new JButton("Visualizar as 2 empresas do tipo restauração com maior capacidade de clientes por dia");
            maiorcapacidadeclientes.addActionListener(new ButtonmaiorcapacidadeclientesListener());


            panelmenu = new JPanel();
            panelmenu.setLayout(new GridLayout(9, 1));
            panelmenu.add(labelmenu);

            panelmenu.add(listarempresa);
            panelmenu.add(criarempresa);
            panelmenu.add(maiorreceitaanual);
            panelmenu.add(menordespesaanual);
            panelmenu.add(maiorlucroanual);
            panelmenu.add(maiorcapacidadeclientes);

            framemenu.add(panelmenu);
            framesaudacao.setVisible(false);
            framemenu.setVisible(true);
        }

        private class ButtonlistarempresaListener implements ActionListener {
            protected JList list;
            protected JLabel labelajuda;
            protected JFrame frameinformacoesempresa;
            protected JPanel panelinformacaoempresas;
            protected JButton voltar,editarempresa, apagarempresa;

            @Override
            public void actionPerformed(ActionEvent e) {
                frameinformacoesempresa = new JFrame("Informações de todas as empresas");
                frameinformacoesempresa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameinformacoesempresa.setSize(2000, 2000);
                labelajuda = new JLabel("Se quiser editar ou apagar uma empresa,selecione uma empresa na seguinte lista.");
                labelajuda.setBounds(50, 10, 500, 50);
                panelinformacaoempresas = new JPanel();
                panelinformacaoempresas.setLayout(null);

                voltar=new JButton("Voltar");
                voltar.setBounds(950,600,400,50);
                voltar.addActionListener(new Buttonvoltarlistarmenu());

                editarempresa = new JButton("Editar");
                editarempresa.setBounds(50, 600, 400, 50);
                editarempresa.addActionListener(new ButtoneditarempresaListener());

                apagarempresa = new JButton("Apagar");
                apagarempresa.setBounds(500, 600, 400, 50);
                apagarempresa.addActionListener(new ButtonapagarempresaListener());

                DefaultListModel listempresas = new DefaultListModel();

                for (Empresa empresa : gestoraempresas.listaempresas) {
                    listempresas.addElement(empresa.toString());
                }
                list = new JList<>(listempresas);
                JScrollPane listScroller = new JScrollPane(list);
                listScroller.setBounds(50, 50, 1000, 500);
                panelinformacaoempresas.add(labelajuda);
                panelinformacaoempresas.add(listScroller);
                panelinformacaoempresas.add(editarempresa);
                panelinformacaoempresas.add(apagarempresa);
                panelinformacaoempresas.add(voltar);
                frameinformacoesempresa.add(panelinformacaoempresas);
                framemenu.setVisible(false);
                frameinformacoesempresa.setVisible(true);
            }
            private class Buttonvoltarlistarmenu implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e) {
                    framemenu.setVisible(true);
                    frameinformacoesempresa.setVisible(false);
                }
            }

            private class ButtonapagarempresaListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        gestoraempresas.apagarEmpresa(gestoraempresas.listaempresas.get(list.getSelectedIndex()));
                        ficheiro.gravarFicObjeto(gestoraempresas.listaempresas,"starthrive.dat");
                        JOptionPane.showMessageDialog(null, "A empresa foi eliminada com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                        framemenu.setVisible(true);
                        frameinformacoesempresa.setVisible(false);
                    } catch (IndexOutOfBoundsException ex) {
                        JOptionPane.showMessageDialog(null, "Selecione uma empresa.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            private class ButtoneditarempresaListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                    gestoraempresas.listaempresas.get(list.getSelectedIndex()).criajanela(gestoraempresas,list.getSelectedIndex(),framemenu,frameinformacoesempresa);
                }catch (IndexOutOfBoundsException ex){
                        JOptionPane.showMessageDialog(null, "Selecione uma empresa.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        private class ButtoncriarempresaListener implements ActionListener {
            protected JFrame framecriarempresa;
            protected JPanel panelcriarempresa;
            protected JButton voltar,cafe, pastelaria, rlocal, rfastfood, frutaria, mercado;
            protected JLabel labelcriarempresa;

            @Override
            public void actionPerformed(ActionEvent e) {

                framecriarempresa = new JFrame();
                framecriarempresa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                framecriarempresa.setSize(1000, 1000);
                labelcriarempresa = new JLabel("Escolha a empresa que deseja criar");
                cafe = new JButton("Café");
                cafe.addActionListener(new ButtoncriacafeListener());
                pastelaria = new JButton("Pastelaria");
                pastelaria.addActionListener(new ButtoncriapastelariaListener());
                rlocal = new JButton("Restaurante local");
                rlocal.addActionListener(new ButtoncriarlocalListener());
                rfastfood = new JButton("Restaurante fast-food");
                rfastfood.addActionListener(new ButtoncriarfastfoodListener());
                frutaria = new JButton("Frutaria");
                frutaria.addActionListener(new ButtoncriarfrutariaListener());
                mercado = new JButton("Mercado");
                mercado.addActionListener(new ButtoncriamercadoListener());
                voltar=new JButton("Voltar");
                voltar.addActionListener(new ButtonvoltarcriarempresamenuListener());
                panelcriarempresa = new JPanel();
                panelcriarempresa.setLayout(new GridLayout(8, 1));
                panelcriarempresa.add(labelcriarempresa);
                panelcriarempresa.add(cafe);
                panelcriarempresa.add(pastelaria);
                panelcriarempresa.add(rlocal);
                panelcriarempresa.add(rfastfood);
                panelcriarempresa.add(frutaria);
                panelcriarempresa.add(mercado);
                panelcriarempresa.add(voltar);

                framecriarempresa.add(panelcriarempresa);
                framemenu.setVisible(false);
                framecriarempresa.setVisible(true);
            }
            private class ButtonvoltarcriarempresamenuListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e) {
                    framemenu.setVisible(true);
                    framecriarempresa.setVisible(false);

                }
            }

            private class ButtoncriacafeListener implements ActionListener {
                protected JButton criar,voltar;
                protected JFrame framecriacafe;
                protected JPanel panelcriacafe;
                protected JLabel labelnome, labelcategoria, labeldistrito, labellatitude, labellongitude, labelnrmedioclientesdiario, labelnrempregadosmesa, labelcustosalariomedioanual, labelnrmediocafesdia, labelvmfaturacaoanualcafedia;
                protected JTextField txtnome, txtcategoria, txtdistrito, txtlatitude, txtlongitude, txtnrmedioclientesdiario, txtnrempregadosmesa, txtcustosalariomedioanual, txtnrmediocafesdia, txtvmfaturacaoanualcafedia;

                @Override
                public void actionPerformed(ActionEvent e) {
                    framecriacafe = new JFrame();
                    framecriacafe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    framecriacafe.setSize(1000, 1000);
                    labelnome = new JLabel("Nome:");
                    labelcategoria = new JLabel("Categoria:");
                    labeldistrito = new JLabel("Distrito:");
                    labellatitude = new JLabel("Latitude da localização:");
                    labellongitude = new JLabel("Longitude da localização");
                    labelnrmedioclientesdiario = new JLabel("Número médio de clientes diário:");
                    labelnrempregadosmesa = new JLabel("Número de empregados de mesa:");
                    labelcustosalariomedioanual = new JLabel("Custo do salário médio anual");
                    labelnrmediocafesdia = new JLabel("Número médio de cafés por dia:");
                    labelvmfaturacaoanualcafedia = new JLabel("Valor médio de faturação anual por café vendido por dia");

                    txtnome = new JTextField();
                    txtcategoria = new JTextField();

                    txtdistrito = new JTextField();

                    txtlatitude = new JTextField();

                    txtlongitude = new JTextField();

                    txtnrmedioclientesdiario = new JTextField();

                    txtnrempregadosmesa = new JTextField();

                    txtcustosalariomedioanual = new JTextField();


                    txtnrmediocafesdia = new JTextField();

                    txtvmfaturacaoanualcafedia = new JTextField();

                    voltar=new JButton("Voltar");
                    voltar.addActionListener(new Buttonvoltarcafecriarempresa());
                    criar = new JButton("Criar");
                    criar.addActionListener(new ButtoncriagravarListener());
                    panelcriacafe = new JPanel();
                    panelcriacafe.setLayout(new GridLayout(11, 2));
                    panelcriacafe.add(labelnome);
                    panelcriacafe.add(txtnome);
                    panelcriacafe.add(labelcategoria);
                    panelcriacafe.add(txtcategoria);
                    panelcriacafe.add(labeldistrito);
                    panelcriacafe.add(txtdistrito);
                    panelcriacafe.add(labellatitude);
                    panelcriacafe.add(txtlatitude);
                    panelcriacafe.add(labellongitude);
                    panelcriacafe.add(txtlongitude);
                    panelcriacafe.add(labelnrmedioclientesdiario);
                    panelcriacafe.add(txtnrmedioclientesdiario);
                    panelcriacafe.add(labelnrempregadosmesa);
                    panelcriacafe.add(txtnrempregadosmesa);
                    panelcriacafe.add(labelcustosalariomedioanual);
                    panelcriacafe.add(txtcustosalariomedioanual);
                    panelcriacafe.add(labelnrmediocafesdia);
                    panelcriacafe.add(txtnrmediocafesdia);
                    panelcriacafe.add(labelvmfaturacaoanualcafedia);
                    panelcriacafe.add(txtvmfaturacaoanualcafedia);
                    panelcriacafe.add(voltar);
                    panelcriacafe.add(criar);


                    framecriacafe.add(panelcriacafe);
                    framecriarempresa.setVisible(false);
                    framecriacafe.setVisible(true);

                }
                private class Buttonvoltarcafecriarempresa implements ActionListener{
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        framecriarempresa.setVisible(true);
                        framecriacafe.setVisible(false);

                    }
                }

                private class ButtoncriagravarListener implements ActionListener {
                    protected Cafe cafe;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            cafe = new Cafe(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtnrmedioclientesdiario.getText()), Integer.parseInt(txtnrempregadosmesa.getText()), Double.parseDouble(txtcustosalariomedioanual.getText()), Double.parseDouble(txtnrmediocafesdia.getText()), Double.parseDouble(txtvmfaturacaoanualcafedia.getText()));
                            gestoraempresas.adicionarEmpresa(cafe);
                            framecriarempresa.setVisible(true);
                            framecriacafe.setVisible(false);
                            JOptionPane.showMessageDialog(null, "O novo café foi criado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                        } catch (NumberFormatException ex) {
                            txtnrmedioclientesdiario.setBackground(Color.red);
                            txtnrempregadosmesa.setBackground(Color.red);
                            txtcustosalariomedioanual.setBackground(Color.red);
                            txtnrmediocafesdia.setBackground(Color.red);
                            txtvmfaturacaoanualcafedia.setBackground(Color.red);
                            JOptionPane.showMessageDialog(null, "Os campos tem que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

            private class ButtoncriapastelariaListener implements ActionListener {
                protected JButton voltar,criar;
                protected JFrame framecriapastelaria;
                protected JPanel panelcriapastelaria;
                protected JLabel labelnome, labelcategoria, labeldistrito, labellatitude, labellongitude, labelnrmedioclientesdiario, labelnrempregadosmesa, labelcustosalariomedioanual, labelnrmediobolosdia, labelvmfaturacaoanualbolodia;
                protected JTextField txtnome, txtcategoria, txtdistrito, txtlatitude, txtlongitude, txtnrmedioclientesdiario, txtnrempregadosmesa, txtcustosalariomedioanual, txtnrmediobolosdia, txtvmfaturacaoanualbolodia;

                @Override
                public void actionPerformed(ActionEvent e) {
                    framecriapastelaria = new JFrame();
                    framecriapastelaria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    framecriapastelaria.setSize(1000, 1000);
                    labelnome = new JLabel("Nome:");
                    labelcategoria = new JLabel("Categoria:");
                    labeldistrito = new JLabel("Distrito:");
                    labellatitude = new JLabel("Latitude da localização:");
                    labellongitude = new JLabel("Longitude da localização");
                    labelnrmedioclientesdiario = new JLabel("Número médio de clientes diário:");
                    labelnrempregadosmesa = new JLabel("Número de empregados de mesa:");
                    labelcustosalariomedioanual = new JLabel("Custo do salário médio anual");
                    labelnrmediobolosdia = new JLabel("Número médio de bolos por dia:");
                    labelvmfaturacaoanualbolodia = new JLabel("Valor médio de faturação anual por bolo vendido por dia");


                    txtnome = new JTextField();
                    txtcategoria = new JTextField();
                    txtdistrito = new JTextField();

                    txtlatitude = new JTextField();

                    txtlongitude = new JTextField();

                    txtnrmedioclientesdiario = new JTextField();

                    txtnrempregadosmesa = new JTextField();

                    txtcustosalariomedioanual = new JTextField();


                    txtnrmediobolosdia = new JTextField();

                    txtvmfaturacaoanualbolodia = new JTextField();

                    voltar=new JButton("Voltar");
                    voltar.addActionListener(new ButtonvoltarpastelariacriarempresaListener());
                    criar = new JButton("Criar");
                    criar.addActionListener(new ButtoncriagravarListener());
                    panelcriapastelaria = new JPanel();
                    panelcriapastelaria.setLayout(new GridLayout(11, 2));
                    panelcriapastelaria.add(labelnome);
                    panelcriapastelaria.add(txtnome);
                    panelcriapastelaria.add(labelcategoria);
                    panelcriapastelaria.add(txtcategoria);
                    panelcriapastelaria.add(labeldistrito);
                    panelcriapastelaria.add(txtdistrito);
                    panelcriapastelaria.add(labellatitude);
                    panelcriapastelaria.add(txtlatitude);
                    panelcriapastelaria.add(labellongitude);
                    panelcriapastelaria.add(txtlongitude);
                    panelcriapastelaria.add(labelnrmedioclientesdiario);
                    panelcriapastelaria.add(txtnrmedioclientesdiario);
                    panelcriapastelaria.add(labelnrempregadosmesa);
                    panelcriapastelaria.add(txtnrempregadosmesa);
                    panelcriapastelaria.add(labelcustosalariomedioanual);
                    panelcriapastelaria.add(txtcustosalariomedioanual);
                    panelcriapastelaria.add(labelnrmediobolosdia);
                    panelcriapastelaria.add(txtnrmediobolosdia);
                    panelcriapastelaria.add(labelvmfaturacaoanualbolodia);
                    panelcriapastelaria.add(txtvmfaturacaoanualbolodia);
                    panelcriapastelaria.add(voltar);
                    panelcriapastelaria.add(criar);


                    framecriapastelaria.add(panelcriapastelaria);
                    framecriapastelaria.setVisible(true);
                    framecriarempresa.setVisible(false);

                }
                private class ButtonvoltarpastelariacriarempresaListener implements ActionListener{
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        framecriapastelaria.setVisible(false);
                        framecriarempresa.setVisible(true);

                    }
                }

                private class ButtoncriagravarListener implements ActionListener {
                    protected Pastelaria pastelaria;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            pastelaria = new Pastelaria(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtnrmedioclientesdiario.getText()), Integer.parseInt(txtnrempregadosmesa.getText()), Double.parseDouble(txtcustosalariomedioanual.getText()), Integer.parseInt(txtnrmediobolosdia.getText()), Double.parseDouble(txtvmfaturacaoanualbolodia.getText()));
                            gestoraempresas.adicionarEmpresa(pastelaria);
                            framecriapastelaria.setVisible(false);
                            framecriarempresa.setVisible(true);
                            JOptionPane.showMessageDialog(null, "A nova pastelaria foi criada com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                        } catch (NumberFormatException ex) {
                            txtnrmedioclientesdiario.setBackground(Color.red);
                            txtnrempregadosmesa.setBackground(Color.red);
                            txtcustosalariomedioanual.setBackground(Color.red);
                            txtnrmediobolosdia.setBackground(Color.red);
                            txtvmfaturacaoanualbolodia.setBackground(Color.red);
                            JOptionPane.showMessageDialog(null, "Os campos tem que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

            private class ButtoncriarlocalListener implements ActionListener {
                protected JButton voltar,criar;
                protected JFrame framecriarlocal;
                protected JPanel panelcriarlocal;
                protected JLabel labelnome, labelcategoria, labeldistrito, labellatitude, labellongitude, labelnrmedioclientesdiario, labelnrempregadosmesa, labelcustosalariomedioanual, labelnrmesasinteriores, labelnrdiasfuncionamentoano, labelvmfaturacaomesadia, labelnrmesasesplanada, labelcustolicencaanualmesplanada;
                protected JTextField txtnome, txtcategoria, txtdistrito, txtlatitude, txtlongitude, txtnrmedioclientesdiario, txtnrempregadosmesa, txtcustosalariomedioanual, txtnrmesasinteriores, txtnrdiasfuncionamentoano, txtvmfaturacaomesadia, txtnrmesasesplanada, txtcustolicencaanualmesplanada;

                @Override
                public void actionPerformed(ActionEvent e) {
                    framecriarlocal = new JFrame();
                    framecriarlocal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    framecriarlocal.setSize(1000, 1000);
                    labelnome = new JLabel("Nome:");
                    labelcategoria = new JLabel("Categoria:");
                    labeldistrito = new JLabel("Distrito:");
                    labellatitude = new JLabel("Latitude da localização:");
                    labellongitude = new JLabel("Longitude da localização");
                    labelnrmedioclientesdiario = new JLabel("Número médio de clientes diário:");
                    labelnrempregadosmesa = new JLabel("Número de empregados de mesa:");
                    labelcustosalariomedioanual = new JLabel("Custo do salário médio anual");
                    labelnrmesasinteriores = new JLabel(" número de mesas interiores:");
                    labelnrdiasfuncionamentoano = new JLabel("número de diasde funcionamento por ano:");
                    labelvmfaturacaomesadia = new JLabel("Valor médio de faturação de cada mesa por dia:");
                    labelnrmesasesplanada = new JLabel("Número de mesas na esplanada:");
                    labelcustolicencaanualmesplanada = new JLabel("Custo de licença anual por mesa de esplanada:");


                    txtnome = new JTextField();
                    txtcategoria = new JTextField();
                    txtdistrito = new JTextField();
                    txtlatitude = new JTextField();
                    txtlongitude = new JTextField();
                    txtnrmedioclientesdiario = new JTextField();
                    txtnrempregadosmesa = new JTextField();
                    txtcustosalariomedioanual = new JTextField();
                    txtnrmesasinteriores = new JTextField();
                    txtnrdiasfuncionamentoano = new JTextField();
                    txtvmfaturacaomesadia = new JTextField();
                    txtnrmesasesplanada = new JTextField();
                    txtcustolicencaanualmesplanada = new JTextField();

                    voltar=new JButton("Voltar");
                    voltar.addActionListener(new ButtonvoltarrlocalcriarempresaListener());
                    criar = new JButton("Criar");
                    criar.addActionListener(new ButtoncriagravarListener());

                    panelcriarlocal = new JPanel();
                    panelcriarlocal.setLayout(new GridLayout(14, 2));
                    panelcriarlocal.add(labelnome);
                    panelcriarlocal.add(txtnome);
                    panelcriarlocal.add(labelcategoria);
                    panelcriarlocal.add(txtcategoria);
                    panelcriarlocal.add(labeldistrito);
                    panelcriarlocal.add(txtdistrito);
                    panelcriarlocal.add(labellatitude);
                    panelcriarlocal.add(txtlatitude);
                    panelcriarlocal.add(labellongitude);
                    panelcriarlocal.add(txtlongitude);
                    panelcriarlocal.add(labelnrmedioclientesdiario);
                    panelcriarlocal.add(txtnrmedioclientesdiario);
                    panelcriarlocal.add(labelnrempregadosmesa);
                    panelcriarlocal.add(txtnrempregadosmesa);
                    panelcriarlocal.add(labelcustosalariomedioanual);
                    panelcriarlocal.add(txtcustosalariomedioanual);
                    panelcriarlocal.add(labelnrmesasinteriores);
                    panelcriarlocal.add(txtnrmesasinteriores);
                    panelcriarlocal.add(labelnrdiasfuncionamentoano);
                    panelcriarlocal.add(txtnrdiasfuncionamentoano);
                    panelcriarlocal.add(labelvmfaturacaomesadia);
                    panelcriarlocal.add(txtvmfaturacaomesadia);
                    panelcriarlocal.add(labelnrmesasesplanada);
                    panelcriarlocal.add(txtnrmesasesplanada);
                    panelcriarlocal.add(labelcustolicencaanualmesplanada);
                    panelcriarlocal.add(txtcustolicencaanualmesplanada);
                    panelcriarlocal.add(voltar);
                    panelcriarlocal.add(criar);


                    framecriarlocal.add(panelcriarlocal);
                    framecriarlocal.setVisible(true);
                    framecriarempresa.setVisible(false);

                }
                private class ButtonvoltarrlocalcriarempresaListener implements ActionListener{
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        framecriarempresa.setVisible(true);
                        framecriarlocal.setVisible(false);
                    }
                }

                private class ButtoncriagravarListener implements ActionListener {
                    protected RestauranteLocal rLocal;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            rLocal = new RestauranteLocal(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtnrmedioclientesdiario.getText()), Integer.parseInt(txtnrempregadosmesa.getText()), Double.parseDouble(txtcustosalariomedioanual.getText()), Integer.parseInt(txtnrmesasinteriores.getText()), Integer.parseInt(txtnrdiasfuncionamentoano.getText()), Double.parseDouble(txtvmfaturacaomesadia.getText()), Integer.parseInt(txtnrmesasesplanada.getText()), Double.parseDouble(txtcustolicencaanualmesplanada.getText()));
                            gestoraempresas.adicionarEmpresa(rLocal);
                            framecriarlocal.setVisible(false);
                            framecriarempresa.setVisible(true);
                            JOptionPane.showMessageDialog(null, "O novo restaurante local foi criado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                        } catch (NumberFormatException ex) {
                            txtnrmedioclientesdiario.setBackground(Color.red);
                            txtnrempregadosmesa.setBackground(Color.red);
                            txtcustosalariomedioanual.setBackground(Color.red);
                            txtnrmesasinteriores.setBackground(Color.red);
                            txtnrdiasfuncionamentoano.setBackground(Color.red);
                            txtvmfaturacaomesadia.setBackground(Color.red);
                            txtnrmesasesplanada.setBackground(Color.red);
                            txtcustolicencaanualmesplanada.setBackground(Color.red);
                            JOptionPane.showMessageDialog(null, "Os campos tem que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

            private class ButtoncriarfastfoodListener implements ActionListener {
                protected JButton voltar,criar;
                protected JFrame framecriarfastfood;
                protected JPanel panelcriarfastfood;
                protected JLabel labelnome, labelcategoria, labeldistrito, labellatitude, labellongitude, labelnrmedioclientesdiario, labelnrempregadosmesa, labelcustosalariomedioanual, labelnrmesasinteriores, labelnrdiasfuncionamentoano, labelvmfaturacaomesadia, labelnrmedioclientsdrive, labelvmfaturacaoclientsdrive;
                protected JTextField txtnome, txtcategoria, txtdistrito, txtlatitude, txtlongitude, txtnrmedioclientesdiario, txtnrempregadosmesa, txtcustosalariomedioanual, txtnrmesasinteriores, txtnrdiasfuncionamentoano, txtvmfaturacaomesadia, txtnrmedioclientsdrive, txtvmfaturacaoclientsdrive;

                @Override
                public void actionPerformed(ActionEvent e) {
                    framecriarfastfood = new JFrame();
                    framecriarfastfood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    framecriarfastfood.setSize(1000, 1000);
                    labelnome = new JLabel("Nome:");
                    labelcategoria = new JLabel("Categoria:");
                    labeldistrito = new JLabel("Distrito:");
                    labellatitude = new JLabel("Latitude da localização:");
                    labellongitude = new JLabel("Longitude da localização");
                    labelnrmedioclientesdiario = new JLabel("Número médio de clientes diário:");
                    labelnrempregadosmesa = new JLabel("Número de empregados de mesa:");
                    labelcustosalariomedioanual = new JLabel("Custo do salário médio anual");
                    labelnrmesasinteriores = new JLabel(" número de mesas interiores:");
                    labelnrdiasfuncionamentoano = new JLabel("número de dias de funcionamento por ano:");
                    labelvmfaturacaomesadia = new JLabel("Valor médio de faturação de cada mesa por dia:");
                    labelnrmedioclientsdrive = new JLabel("número médio diário de clientes drive-thru:");
                    labelvmfaturacaoclientsdrive = new JLabel("valor médio diário de faturação por cada cliente drive-thru:");


                    txtnome = new JTextField();
                    txtcategoria = new JTextField();
                    txtdistrito = new JTextField();
                    txtlatitude = new JTextField();
                    txtlongitude = new JTextField();
                    txtnrmedioclientesdiario = new JTextField();
                    txtnrempregadosmesa = new JTextField();
                    txtcustosalariomedioanual = new JTextField();
                    txtnrmesasinteriores = new JTextField();
                    txtnrdiasfuncionamentoano = new JTextField();
                    txtvmfaturacaomesadia = new JTextField();
                    txtnrmedioclientsdrive = new JTextField();
                    txtvmfaturacaoclientsdrive = new JTextField();

                    voltar=new JButton("Voltar");
                    voltar.addActionListener(new ButtonvoltarrfastfoodcriarempresaListener());
                    criar = new JButton("Criar");
                    criar.addActionListener(new ButtoncriagravarListener());

                    panelcriarfastfood = new JPanel();
                    panelcriarfastfood.setLayout(new GridLayout(14, 2));
                    panelcriarfastfood.add(labelnome);
                    panelcriarfastfood.add(txtnome);
                    panelcriarfastfood.add(labelcategoria);
                    panelcriarfastfood.add(txtcategoria);
                    panelcriarfastfood.add(labeldistrito);
                    panelcriarfastfood.add(txtdistrito);
                    panelcriarfastfood.add(labellatitude);
                    panelcriarfastfood.add(txtlatitude);
                    panelcriarfastfood.add(labellongitude);
                    panelcriarfastfood.add(txtlongitude);
                    panelcriarfastfood.add(labelnrmedioclientesdiario);
                    panelcriarfastfood.add(txtnrmedioclientesdiario);
                    panelcriarfastfood.add(labelnrempregadosmesa);
                    panelcriarfastfood.add(txtnrempregadosmesa);
                    panelcriarfastfood.add(labelcustosalariomedioanual);
                    panelcriarfastfood.add(txtcustosalariomedioanual);
                    panelcriarfastfood.add(labelnrmesasinteriores);
                    panelcriarfastfood.add(txtnrmesasinteriores);
                    panelcriarfastfood.add(labelnrdiasfuncionamentoano);
                    panelcriarfastfood.add(txtnrdiasfuncionamentoano);
                    panelcriarfastfood.add(labelvmfaturacaomesadia);
                    panelcriarfastfood.add(txtvmfaturacaomesadia);
                    panelcriarfastfood.add(labelnrmedioclientsdrive);
                    panelcriarfastfood.add(txtnrmedioclientsdrive);
                    panelcriarfastfood.add(labelvmfaturacaoclientsdrive);
                    panelcriarfastfood.add(txtvmfaturacaoclientsdrive);
                    panelcriarfastfood.add(voltar);
                    panelcriarfastfood.add(criar);


                    framecriarfastfood.add(panelcriarfastfood);
                    framecriarfastfood.setVisible(true);
                    framecriarempresa.setVisible(false);

                }
                private class ButtonvoltarrfastfoodcriarempresaListener implements ActionListener{

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        framecriarempresa.setVisible(true);
                        framecriarfastfood.setVisible(false);
                    }
                }

                private class ButtoncriagravarListener implements ActionListener {
                    protected RestauranteFastfood rfastfood;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            rfastfood = new RestauranteFastfood(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtnrmedioclientesdiario.getText()), Integer.parseInt(txtnrempregadosmesa.getText()), Double.parseDouble(txtcustosalariomedioanual.getText()), Integer.parseInt(txtnrdiasfuncionamentoano.getText()), Integer.parseInt(txtnrmesasinteriores.getText()), Double.parseDouble(txtvmfaturacaomesadia.getText()), Double.parseDouble(txtnrmedioclientsdrive.getText()), Double.parseDouble(txtvmfaturacaoclientsdrive.getText()));
                            gestoraempresas.adicionarEmpresa(rfastfood);
                            framecriarfastfood.setVisible(false);
                            framecriarempresa.setVisible(true);
                            JOptionPane.showMessageDialog(null, "O novo restaurante fast-food foi criado com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                        } catch (NumberFormatException ex) {
                            txtnrmedioclientesdiario.setBackground(Color.red);
                            txtnrempregadosmesa.setBackground(Color.red);
                            txtcustosalariomedioanual.setBackground(Color.red);
                            txtnrmesasinteriores.setBackground(Color.red);
                            txtnrdiasfuncionamentoano.setBackground(Color.red);
                            txtvmfaturacaomesadia.setBackground(Color.red);
                            txtnrmedioclientsdrive.setBackground(Color.red);
                            txtvmfaturacaoclientsdrive.setBackground(Color.red);
                            JOptionPane.showMessageDialog(null, "Os campos tem que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

            private class ButtoncriarfrutariaListener implements ActionListener {
                protected JButton voltar,criar;
                protected JFrame framecriafrutaria;
                protected JPanel panelcriafrutaria;
                protected JLabel labelnome, labelcategoria, labeldistrito, labellatitude, labellongitude, labelcustoanuallimpeza, labelnrprodutos, labelvmfaturacaoanualproduto;
                protected JTextField txtnome, txtcategoria, txtdistrito, txtlatitude, txtlongitude, txtcustoanuallimpeza, txtnrprodutos, txtvmfaturacaoanualproduto;

                @Override
                public void actionPerformed(ActionEvent e) {
                    framecriafrutaria = new JFrame();
                    framecriafrutaria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    framecriafrutaria.setSize(1000, 1000);
                    labelnome = new JLabel("Nome:");
                    labelcategoria = new JLabel("Categoria:");
                    labeldistrito = new JLabel("Distrito:");
                    labellatitude = new JLabel("Latitude da localização:");
                    labellongitude = new JLabel("Longitude da localização");
                    labelcustoanuallimpeza = new JLabel("custo anual de limpeza do estabelecimento:");
                    labelnrprodutos = new JLabel("número de produtos:");
                    labelvmfaturacaoanualproduto = new JLabel("valor médio de faturação anual por produto:");


                    txtnome = new JTextField();
                    txtcategoria = new JTextField();
                    txtdistrito = new JTextField();
                    txtlatitude = new JTextField();
                    txtlongitude = new JTextField();
                    txtcustoanuallimpeza = new JTextField();
                    txtnrprodutos = new JTextField();
                    txtvmfaturacaoanualproduto = new JTextField();

                    voltar=new JButton("Voltar");
                    voltar.addActionListener(new ButtonvoltarfrutariacriarempresaListener());

                    criar = new JButton("Criar");
                    criar.addActionListener(new ButtoncriagravarListener());

                    panelcriafrutaria = new JPanel();
                    panelcriafrutaria.setLayout(new GridLayout(9, 2));
                    panelcriafrutaria.add(labelnome);
                    panelcriafrutaria.add(txtnome);
                    panelcriafrutaria.add(labelcategoria);
                    panelcriafrutaria.add(txtcategoria);
                    panelcriafrutaria.add(labeldistrito);
                    panelcriafrutaria.add(txtdistrito);
                    panelcriafrutaria.add(labellatitude);
                    panelcriafrutaria.add(txtlatitude);
                    panelcriafrutaria.add(labellongitude);
                    panelcriafrutaria.add(txtlongitude);
                    panelcriafrutaria.add(labelcustoanuallimpeza);
                    panelcriafrutaria.add(txtcustoanuallimpeza);
                    panelcriafrutaria.add(labelnrprodutos);
                    panelcriafrutaria.add(txtnrprodutos);
                    panelcriafrutaria.add(labelvmfaturacaoanualproduto);
                    panelcriafrutaria.add(txtvmfaturacaoanualproduto);
                    panelcriafrutaria.add(voltar);
                    panelcriafrutaria.add(criar);


                    framecriafrutaria.add(panelcriafrutaria);
                    framecriafrutaria.setVisible(true);
                    framecriarempresa.setVisible(false);

                }
                private class ButtonvoltarfrutariacriarempresaListener implements ActionListener{
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        framecriarempresa.setVisible(true);
                        framecriafrutaria.setVisible(false);
                    }
                }

                private class ButtoncriagravarListener implements ActionListener {
                    protected Frutaria frutaria;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            frutaria = new Frutaria(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtcustoanuallimpeza.getText()), Integer.parseInt(txtnrprodutos.getText()), Double.parseDouble(txtvmfaturacaoanualproduto.getText()));
                            gestoraempresas.adicionarEmpresa(frutaria);
                            framecriafrutaria.setVisible(false);
                            framecriarempresa.setVisible(true);
                            JOptionPane.showMessageDialog(null, "A nova frutaria foi criada com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                        } catch (NumberFormatException ex) {
                            txtcustoanuallimpeza.setBackground(Color.red);
                            txtnrprodutos.setBackground(Color.red);
                            txtvmfaturacaoanualproduto.setBackground(Color.red);
                            JOptionPane.showMessageDialog(null, "Os campos tem que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }

            private class ButtoncriamercadoListener implements ActionListener {
                protected JButton voltar,criar;
                protected JFrame framecriamercado;
                protected JPanel panelcriamercado;
                protected JLabel labelnome, labelcategoria, labeldistrito, labellatitude, labellongitude, labelcustoanuallimpeza, labeltipo , labelarea, labelvmfaturacaom2;
                protected JTextField txtnome, txtcategoria, txtdistrito, txtlatitude, txtlongitude, txtcustoanuallimpeza, txtarea, txtvmfaturacaom2;
                JComboBox<String> tipo;

                @Override
                public void actionPerformed(ActionEvent e) {
                    framecriamercado = new JFrame();
                    framecriamercado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    framecriamercado.setSize(1000, 1000);
                    labelnome = new JLabel("Nome:");
                    labelcategoria = new JLabel("Categoria:");
                    labeldistrito = new JLabel("Distrito:");
                    labellatitude = new JLabel("Latitude da localização:");
                    labellongitude = new JLabel("Longitude da localização");
                    labelcustoanuallimpeza = new JLabel("custo anual de limpeza do estabelecimento:");
                    labeltipo = new JLabel("Tipo:");
                    labelarea = new JLabel("área de corredores:");
                    labelvmfaturacaom2 = new JLabel(" valor médio de faturação anual por metro quadrado:");


                    txtnome = new JTextField();
                    txtcategoria = new JTextField();
                    txtdistrito = new JTextField();
                    txtlatitude = new JTextField();
                    txtlongitude = new JTextField();
                    txtcustoanuallimpeza = new JTextField();
                    txtarea = new JTextField();
                    txtvmfaturacaom2 = new JTextField();

                    String[] tipos = {"Selecione uma das opções","Min","Super", "Hiper"};
                    tipo = new JComboBox<>(tipos);
                    voltar=new JButton("Voltar");
                    voltar.addActionListener(new ButtonvoltarmercadocriarempresaListener());

                    criar = new JButton("Criar");
                    criar.addActionListener(new ButtoncriagravarListener());

                    panelcriamercado = new JPanel();
                    panelcriamercado.setLayout(new GridLayout(10, 2));
                    panelcriamercado.add(labelnome);
                    panelcriamercado.add(txtnome);
                    panelcriamercado.add(labelcategoria);
                    panelcriamercado.add(txtcategoria);
                    panelcriamercado.add(labeldistrito);
                    panelcriamercado.add(txtdistrito);
                    panelcriamercado.add(labellatitude);
                    panelcriamercado.add(txtlatitude);
                    panelcriamercado.add(labellongitude);
                    panelcriamercado.add(txtlongitude);
                    panelcriamercado.add(labelcustoanuallimpeza);
                    panelcriamercado.add(txtcustoanuallimpeza);
                    panelcriamercado.add(labeltipo);
                    panelcriamercado.add(tipo);
                    panelcriamercado.add(labelarea);
                    panelcriamercado.add(txtarea);
                    panelcriamercado.add(labelvmfaturacaom2);
                    panelcriamercado.add(txtvmfaturacaom2);
                    panelcriamercado.add(voltar);
                    panelcriamercado.add(criar);


                    framecriamercado.add(panelcriamercado);
                    framecriamercado.setVisible(true);
                    framecriarempresa.setVisible(false);
                }
                private class ButtonvoltarmercadocriarempresaListener implements ActionListener{
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        framecriarempresa.setVisible(true);
                        framecriamercado.setVisible(false);
                    }
                }

                private class ButtoncriagravarListener implements ActionListener {
                    protected Mercado mercado;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (tipo.getSelectedIndex()==0){
                                tipo.setBackground(Color.red);
                                JOptionPane.showMessageDialog(null, "Tem que selecionar uma das opções", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                            else{
                                mercado = new Mercado(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtcustoanuallimpeza.getText()),tipo.getItemAt(tipo.getSelectedIndex()), Double.parseDouble(txtarea.getText()), Double.parseDouble(txtvmfaturacaom2.getText()));
                                gestoraempresas.adicionarEmpresa(mercado);
                                framecriarempresa.setVisible(true);
                                framecriamercado.setVisible(false);
                                JOptionPane.showMessageDialog(null, "O novo mercado foi criado com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                            }
                        } catch (NumberFormatException ex) {
                            txtcustoanuallimpeza.setBackground(Color.red);
                            txtarea.setBackground(Color.red);
                            txtvmfaturacaom2.setBackground(Color.red);
                            JOptionPane.showMessageDialog(null, "Os campos tem que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }

        private class ButtonmaiorreceitaListener implements ActionListener {
            protected JFrame framemaiorreceita;
            protected JTable tabelamaiorreceita;
            protected JButton voltar;

            @Override
            public void actionPerformed(ActionEvent e) {
                gestoraempresas.atualizaMaiorReceita();
                framemaiorreceita = new JFrame();
                framemaiorreceita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                framemaiorreceita.setSize(500, 200);
                framemaiorreceita.setLayout(new BorderLayout());
                voltar=new JButton("Voltar");
                voltar.addActionListener(new ButtonvoltarmaiorreceitamenuListener());
                String nomecafe;
                String valorcafe;
                if (Cafe.getContadorcafe() == 0) {
                    nomecafe = "-----";
                    valorcafe = "-----";
                } else {
                    nomecafe = gestoraempresas.listaempresas.get(Cafe.getMaiorreceitaCafe()).getNome();
                    valorcafe = String.valueOf(gestoraempresas.listaempresas.get(Cafe.getMaiorreceitaCafe()).receita());
                }
                String nomepastelaria;
                String valorpastelaria;
                if (Pastelaria.getContadorPastelaria() == 0) {
                    nomepastelaria = "-----";
                    valorpastelaria = "-----";
                } else {
                    nomepastelaria = gestoraempresas.listaempresas.get(Pastelaria.getMaiorreceitaPastelaria()).getNome();
                    valorpastelaria = String.valueOf(gestoraempresas.listaempresas.get(Pastelaria.getMaiorreceitaPastelaria()).receita());
                }
                String nomerfastfood;
                String valorrfastfood;
                if (RestauranteFastfood.getContadorRfastfood() == 0) {
                    nomerfastfood = "-----";
                    valorrfastfood = "-----";
                } else {
                    nomerfastfood = gestoraempresas.listaempresas.get(RestauranteFastfood.getMaiorreceitaRfastfood()).getNome();
                    valorrfastfood = String.valueOf(gestoraempresas.listaempresas.get(RestauranteFastfood.getMaiorreceitaRfastfood()).receita());
                }
                String nomerlocal;
                String valorrlocal;
                if (RestauranteLocal.getContadorRlocal() == 0) {
                    nomerlocal = "-----";
                    valorrlocal = "-----";
                } else {
                    nomerlocal = gestoraempresas.listaempresas.get(RestauranteLocal.getMaiorreceitaRLocal()).getNome();
                    valorrlocal = String.valueOf(gestoraempresas.listaempresas.get(RestauranteLocal.getMaiorreceitaRLocal()).receita());
                }
                String nomemercado;
                String valormercado;
                if (Mercado.getContadorMercado() == 0) {
                    nomemercado = "-----";
                    valormercado = "-----";
                } else {
                    nomemercado = gestoraempresas.listaempresas.get(Mercado.getMaiorreceitaMercado()).getNome();
                    valormercado = String.valueOf(gestoraempresas.listaempresas.get(Mercado.getMaiorreceitaMercado()).receita());
                }
                String nomefrutaria;
                String valorfrutaria;
                if (Frutaria.getContadorFrutaria() == 0) {
                    nomefrutaria = "-----";
                    valorfrutaria = "-----";
                } else {
                    nomefrutaria = gestoraempresas.listaempresas.get(Frutaria.getMaiorreceitaFrutaria()).getNome();
                    valorfrutaria = String.valueOf(gestoraempresas.listaempresas.get(Frutaria.getMaiorreceitaFrutaria()).receita());
                }
                String[][] data = {
                        {"Cafe", nomecafe, valorcafe},
                        {"Pastelaria", nomepastelaria, valorpastelaria},
                        {"Restaurante local", nomerlocal, valorrlocal},
                        {"Restaurante fast-food", nomerfastfood, valorrfastfood},
                        {"Mercado", nomemercado, valormercado},
                        {"Frutaria", nomefrutaria, valorfrutaria}
                };
                String[] column = {"Categoria da Empresa", "Nome", "Valor"};
                tabelamaiorreceita = new JTable(data, column);
                tabelamaiorreceita.setBounds(30, 1000, 200, 1000);
                JScrollPane sp = new JScrollPane(tabelamaiorreceita);
                framemaiorreceita.add(sp,BorderLayout.CENTER);
                framemaiorreceita.add(voltar,BorderLayout.SOUTH);
                framemaiorreceita.setVisible(true);
                framemenu.setVisible(false);
            }
            private class ButtonvoltarmaiorreceitamenuListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e) {
                    framemenu.setVisible(true);
                    framemaiorreceita.setVisible(false);

                }
            }
        }

        private class ButtonmenordespesaListener implements ActionListener {
            protected JFrame framemenordespesa;
            protected JTable tabelamenordespesa;
            protected JButton voltar;

            @Override
            public void actionPerformed(ActionEvent e) {
                gestoraempresas.atualizaMenorDespesa();
                framemenordespesa = new JFrame();
                framemenordespesa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                framemenordespesa.setSize(500, 200);
                framemenordespesa.setLayout(new BorderLayout());
                voltar=new JButton("Voltar");
                voltar.addActionListener(new ButtonvoltarmenordespesamenuListener());
                String nomecafe;
                String valorcafe;
                if (Cafe.getContadorcafe() == 0) {
                    nomecafe = "-----";
                    valorcafe = "-----";
                } else {
                    nomecafe = gestoraempresas.listaempresas.get(Cafe.getMenordespesaCafe()).getNome();
                    valorcafe = String.valueOf(gestoraempresas.listaempresas.get(Cafe.getMenordespesaCafe()).despesa());
                }
                String nomepastelaria;
                String valorpastelaria;
                if (Pastelaria.getContadorPastelaria() == 0) {
                    nomepastelaria = "-----";
                    valorpastelaria = "-----";
                } else {
                    nomepastelaria = gestoraempresas.listaempresas.get(Pastelaria.getMenordespesaPastelaria()).getNome();
                    valorpastelaria = String.valueOf(gestoraempresas.listaempresas.get(Pastelaria.getMenordespesaPastelaria()).despesa());
                }
                String nomerfastfood;
                String valorrfastfood;
                if (RestauranteFastfood.getContadorRfastfood() == 0) {
                    nomerfastfood = "-----";
                    valorrfastfood = "-----";
                } else {
                    nomerfastfood = gestoraempresas.listaempresas.get(RestauranteFastfood.getMenordespesaRfastfood()).getNome();
                    valorrfastfood = String.valueOf(gestoraempresas.listaempresas.get(RestauranteFastfood.getMenordespesaRfastfood()).despesa());
                }
                String nomerlocal;
                String valorrlocal;
                if (RestauranteLocal.getContadorRlocal() == 0) {
                    nomerlocal = "-----";
                    valorrlocal = "-----";
                } else {
                    nomerlocal = gestoraempresas.listaempresas.get(RestauranteLocal.getMenordespesaRLocal()).getNome();
                    valorrlocal = String.valueOf(gestoraempresas.listaempresas.get(RestauranteLocal.getMenordespesaRLocal()).despesa());
                }
                String nomemercado;
                String valormercado;
                if (Mercado.getContadorMercado() == 0) {
                    nomemercado = "-----";
                    valormercado = "-----";
                } else {
                    nomemercado = gestoraempresas.listaempresas.get(Mercado.getMenordespesaMercado()).getNome();
                    valormercado = String.valueOf(gestoraempresas.listaempresas.get(Mercado.getMenordespesaMercado()).despesa());
                }
                String valorfrutaria;
                String nomefrutaria;
                if (Frutaria.getContadorFrutaria() == 0) {
                    nomefrutaria = "-----";
                    valorfrutaria = "-----";
                } else {
                    nomefrutaria = gestoraempresas.listaempresas.get(Frutaria.getMenordespesaFrutaria()).getNome();
                    valorfrutaria = String.valueOf(gestoraempresas.listaempresas.get(Frutaria.getMenordespesaFrutaria()).despesa());
                }
                String[][] data = {
                        {"Cafe", nomecafe, valorcafe},
                        {"Pastelaria", nomepastelaria, valorpastelaria},
                        {"Restaurante local", nomerlocal, valorrlocal},
                        {"Restaurante fast-food", nomerfastfood, valorrfastfood},
                        {"Mercado", nomemercado, valormercado},
                        {"Frutaria", nomefrutaria, valorfrutaria}
                };
                String[] column = {"Categoria da Empresa", "Nome", "Valor"};
                tabelamenordespesa = new JTable(data, column);
                tabelamenordespesa.setBounds(30, 1000, 200, 1000);
                JScrollPane sp = new JScrollPane(tabelamenordespesa);
                framemenordespesa.add(sp,BorderLayout.CENTER);
                framemenordespesa.add(voltar,BorderLayout.SOUTH);
                framemenordespesa.setVisible(true);
                framemenu.setVisible(false);
            }
            private class ButtonvoltarmenordespesamenuListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e) {
                    framemenu.setVisible(true);
                    framemenordespesa.setVisible(false);
                }
            }
        }

        private class ButtonmaiorlucroListener implements ActionListener {
            protected JFrame framemaiorlucro;
            protected JTable tabelamaiorlucro;
            protected JButton voltar;

            @Override
            public void actionPerformed(ActionEvent e) {
                gestoraempresas.atualizaMaiorLucro();
                framemaiorlucro = new JFrame();
                framemaiorlucro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                framemaiorlucro.setSize(500, 200);
                framemaiorlucro.setLayout(new BorderLayout());
                voltar=new JButton("Voltar");
                voltar.addActionListener(new ButtonvoltarmaiorlucromenuListener());
                String nomecafe;
                String valorcafe;
                if (Cafe.getContadorcafe() == 0) {
                    nomecafe = "-----";
                    valorcafe = "-----";
                } else {
                    nomecafe = gestoraempresas.listaempresas.get(Cafe.getMaiorlucroCafe()).getNome();
                    valorcafe = String.valueOf(gestoraempresas.listaempresas.get(Cafe.getMaiorlucroCafe()).lucro());
                }
                String nomepastelaria;
                String valorpastelaria;
                if (Pastelaria.getContadorPastelaria() == 0) {
                    nomepastelaria = "-----";
                    valorpastelaria = "-----";
                } else {
                    nomepastelaria = gestoraempresas.listaempresas.get(Pastelaria.getMaiorlucroPastelaria()).getNome();
                    valorpastelaria = String.valueOf(gestoraempresas.listaempresas.get(Pastelaria.getMaiorlucroPastelaria()).lucro());
                }
                String nomerfastfood;
                String valorrfastfood;
                if (RestauranteFastfood.getContadorRfastfood() == 0) {
                    nomerfastfood = "-----";
                    valorrfastfood = "-----";
                } else {
                    nomerfastfood = gestoraempresas.listaempresas.get(RestauranteFastfood.getMaiorlucroRfastfood()).getNome();
                    valorrfastfood = String.valueOf(gestoraempresas.listaempresas.get(RestauranteFastfood.getMaiorlucroRfastfood()).lucro());
                }
                String nomerlocal;
                String valorrlocal;
                if (RestauranteLocal.getContadorRlocal() == 0) {
                    nomerlocal = "-----";
                    valorrlocal = "-----";
                } else {
                    nomerlocal = gestoraempresas.listaempresas.get(RestauranteLocal.getMaiorlucroRLocal()).getNome();
                    valorrlocal = String.valueOf(gestoraempresas.listaempresas.get(RestauranteLocal.getMaiorlucroRLocal()).lucro());
                }
                String nomemercado;
                String valormercado;
                if (Mercado.getContadorMercado() == 0) {
                    nomemercado = "-----";
                    valormercado = "-----";
                } else {
                    nomemercado = gestoraempresas.listaempresas.get(Mercado.getMaiorlucroMercado()).getNome();
                    valormercado = String.valueOf(gestoraempresas.listaempresas.get(Mercado.getMaiorlucroMercado()).lucro());
                }
                String nomefrutaria;
                String valorfrutaria;
                if (Frutaria.getContadorFrutaria() == 0) {
                    nomefrutaria = "-----";
                    valorfrutaria = "-----";
                } else {
                    nomefrutaria = gestoraempresas.listaempresas.get(Frutaria.getMaiorlucroFrutaria()).getNome();
                    valorfrutaria = String.valueOf(gestoraempresas.listaempresas.get(Frutaria.getMaiorlucroFrutaria()).lucro());
                }
                String[][] data = {
                        {"Cafe", nomecafe, valorcafe},
                        {"Pastelaria", nomepastelaria, valorpastelaria},
                        {"Restaurante local", nomerlocal, valorrlocal},
                        {"Restaurante fast-food", nomerfastfood, valorrfastfood},
                        {"Mercado", nomemercado, valormercado},
                        {"Frutaria", nomefrutaria, valorfrutaria}
                };
                String[] column = {"Categoria da Empresa", "Nome", "Valor"};
                tabelamaiorlucro = new JTable(data, column);
                tabelamaiorlucro.setBounds(30, 1000, 200, 1000);
                JScrollPane sp = new JScrollPane(tabelamaiorlucro);
                framemaiorlucro.add(sp,BorderLayout.CENTER);
                framemaiorlucro.add(voltar,BorderLayout.SOUTH);
                framemaiorlucro.setVisible(true);
                framemenu.setVisible(false);
            }
            private class ButtonvoltarmaiorlucromenuListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e) {
                    framemenu.setVisible(true);
                    framemaiorlucro.setVisible(false);
                }
            }
        }

        private class ButtonmaiorcapacidadeclientesListener implements ActionListener {
            protected JFrame framemaiorclientes;
            protected JPanel panelmaiorclientes;
            protected JList list;
            protected JButton voltar;

            @Override
            public void actionPerformed(ActionEvent e) {
                gestoraempresas.maisclientesdiarioRestauracao();
                framemaiorclientes = new JFrame();
                framemaiorclientes.setSize(1000, 600);
                framemaiorclientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                voltar=new JButton("Voltar");
                voltar.addActionListener(new ButtonvoltarmaiorlucromenuListener());

                panelmaiorclientes = new JPanel();
                panelmaiorclientes.setLayout(new BorderLayout());
                DefaultListModel listempresas = new DefaultListModel();
                if (Cafe.getContadorcafe() + Pastelaria.getContadorPastelaria() + RestauranteFastfood.getContadorRfastfood() + RestauranteLocal.getContadorRlocal() == 0) {
                    JOptionPane.showMessageDialog(null, "Não existem empresas!", "Aviso", JOptionPane.PLAIN_MESSAGE);
                } else if ((Cafe.getContadorcafe() == 1 && Pastelaria.getContadorPastelaria() == 0 && RestauranteFastfood.getContadorRfastfood() == 0 && RestauranteLocal.getContadorRlocal() == 0) || (Cafe.getContadorcafe() == 0 && Pastelaria.getContadorPastelaria() == 1 && RestauranteFastfood.getContadorRfastfood() == 0 && RestauranteLocal.getContadorRlocal() == 0) || (Cafe.getContadorcafe() == 0 && Pastelaria.getContadorPastelaria() == 0 && RestauranteFastfood.getContadorRfastfood() == 1 && RestauranteLocal.getContadorRlocal() == 0) || (Cafe.getContadorcafe() == 0 && Pastelaria.getContadorPastelaria() == 0 && RestauranteFastfood.getContadorRfastfood() == 0 && RestauranteLocal.getContadorRlocal() == 1)) {
                    listempresas.addElement("1-" + gestoraempresas.listaempresas.get(Restauracao.getMaiorcapacidadeclientes1()).toString());
                    JOptionPane.showMessageDialog(null, "Apensas existe uma empresa do tipo restauração!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                } else {
                    listempresas.addElement("Primeira - " + gestoraempresas.listaempresas.get(Restauracao.getMaiorcapacidadeclientes1()).toString());
                    listempresas.addElement("Segunda - " + gestoraempresas.listaempresas.get(Restauracao.getMaiorcapacidadeclientes2()).toString());

                }
                list = new JList<>(listempresas);
                JScrollPane listScroller = new JScrollPane(list);
                listScroller.setBounds(50, 50, 600, 300);
                panelmaiorclientes.add(listScroller,BorderLayout.CENTER);
                panelmaiorclientes.add(voltar,BorderLayout.SOUTH);
                framemaiorclientes.add(panelmaiorclientes);
                framemaiorclientes.setVisible(true);
                framemenu.setVisible(false);
            }
            private class ButtonvoltarmaiorlucromenuListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e) {
                    framemenu.setVisible(true);
                    framemaiorclientes.setVisible(false);
                }
            }
        }
    }
}

