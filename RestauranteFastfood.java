/**
 * @author Alexandre Ferreira
 * @author Duarte
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Classe para definir uma empresa do tipo Restaurante Fastfood
 */
class RestauranteFastfood extends Restaurante {
    /**
     * numero medio de clients no drive-thru
     */
    protected double nrmedioclientsdrive;
    /**
     * valor medio da faturacao de clients no drive-thru
     */
    protected double vmfaturacaoclientsdrive;
    /**
     *  maior receita de Restaurante fastfood
     */

    protected static int maiorreceitaRfastfood;
    /**
     * menor despesa Restaurante fastfood
     */
    protected static int menordespesaRfastfood;
    /**
     * maior lucro Restaurante fastfood
     */
    protected static int maiorlucroRfastfood;
    /**
     * contador de Restaurantes fastfood
     */
    protected static int contadorRfastfood;
    /**
     * JTextFields que irão receber os valores do numero medio de clientes no drive-thru e da faturacao media dos clientes no drive-thru
     */
    protected JTextField txtnrmedioclientsdrive, txtvmfaturacaoclientsdrive;
    public RestauranteFastfood(){}

    /**
     * construtor da empresa Restaurante fastfood
     * @param categoria tipo de empresa
     * @param nome nome da empresa
     * @param distrito distrito da empresa
     * @param localizacao localizacao da empresa
     * @param nrmedioclientesdiario numero medio de clientes diario da empresa
     * @param nrempregadosmesa numero medio de empregados de mesa da empresa
     * @param custosalariomedioanual custo medio do salario anual dos empregados
     * @param nrdiasfuncionamentoano numero de dias de funcionamento num ano
     * @param nrmesasinteriores numero de mesas interiores
     * @param vmfaturacaomesadia valor medio de faturacao das mesas por dia
     * @param nrmedioclientsdrive numero medio de clientes no drive-thru
     * @param vmfaturacaoclientsdrive valor medio de faturacao de clientes no drive-thru
     */
    public RestauranteFastfood(String categoria,String nome, String distrito, Localizacao localizacao,double nrmedioclientesdiario, int nrempregadosmesa, double custosalariomedioanual, int nrdiasfuncionamentoano,int nrmesasinteriores,double vmfaturacaomesadia,double nrmedioclientsdrive,double vmfaturacaoclientsdrive){
        super(categoria, nome, distrito, localizacao, nrmedioclientesdiario, nrempregadosmesa, custosalariomedioanual, nrmesasinteriores, nrdiasfuncionamentoano, vmfaturacaomesadia);
        this.nrmedioclientsdrive=nrmedioclientsdrive;
        this.vmfaturacaoclientsdrive=vmfaturacaoclientsdrive;
    }

    /**
     * Método para obter o número médio de clientes no drive-thru
     * @return número médio de clientes no drive-thru
     */
    public double getNrmedioclientsdrive() {
        return nrmedioclientsdrive;
    }

    /**
     * Método para definir o número médio de clientes no drive-thru
     * @param nrmedioclientsdrive número médio de clientes no drive-thru
     */
    public void setNrmedioclientsdrive(double nrmedioclientsdrive) {
        this.nrmedioclientsdrive = nrmedioclientsdrive;
    }

    /**
     * Método para obter o valor médio da faturacao de clientes no drive-thru
     * @return valor médio da faturacao de clientes no drive-thru
     */
    public double getVmfaturacaoclientsdrive() {
        return vmfaturacaoclientsdrive;
    }

    /**
     * Método para defenir o valor médio da faturacao de clientes no drive-thru
     * @param vmfaturacaoclientsdrive valor médio da faturacao de clientes no drive-thru
     */
    public void setVmfaturacaoclientsdrive(double vmfaturacaoclientsdrive) {
        this.vmfaturacaoclientsdrive = vmfaturacaoclientsdrive;
    }

    /**
     * Método para obter o indice do Restaurante fastfood com a maior receita anual
     * @return maiorreceitaRfastfood indice do Restaurante fastfood com a maior receita anual
     */
    public static int getMaiorreceitaRfastfood() {
        return maiorreceitaRfastfood;
    }

    /**
     * Método para defenir o indice do Restaurante fastfood com a maior receita anual
     * @param maiorreceitaRfastfood indice do Restaurante fastfood com a maior receita anual
     */
    public static void setMaiorreceitaRfastfood(int maiorreceitaRfastfood) {
        RestauranteFastfood.maiorreceitaRfastfood = maiorreceitaRfastfood;
    }

    /**
     * Método para obter o indice do Restaurante fastfood com a menor despesa anual
     * @return indice do Restaurante fastfood com a menor despesa anual
     */
    public static int getMenordespesaRfastfood() {
        return menordespesaRfastfood;
    }

    /**
     * Método para defenir o indice do Restaurante fastfood com a menor despesa anual
     * @param menordespesaRfastfood indice do Restaurante fastfood com a menor despesa anual
     */
    public static void setMenordespesaRfastfood(int menordespesaRfastfood) {
        RestauranteFastfood.menordespesaRfastfood = menordespesaRfastfood;
    }

    /**
     * Método para obter o indice do Restaurante fastfood com o maior lucro anual
     * @return indice do Restaurante fastfood com o maior lucro anual
     */
    public static int getMaiorlucroRfastfood() {
        return maiorlucroRfastfood;
    }

    /**
     * Método para defenir o indice do Restaurante fastfood com o maior lucro anual
     * @param maiorlucroRfastfood indice do Restaurante fastfood com o maior lucro anual
     */
    public static void setMaiorlucroRfastfood(int maiorlucroRfastfood) {
        RestauranteFastfood.maiorlucroRfastfood = maiorlucroRfastfood;
    }

    /**
     * Metodo para obter o numero de Restaurantes fastfood
     * @return numero de Restaurantes fastfood
     */
    public static int getContadorRfastfood() {
        return contadorRfastfood;
    }

    /**
     * Metodo para defenir o numero de Restaurantes fastfood
     * @param contadorRfastfood numero de Restaurantes fastfood
     */
    public static void setContadorRfastfood(int contadorRfastfood) {
        RestauranteFastfood.contadorRfastfood = contadorRfastfood;
    }

    /**
     * Método para diminuir o contador de Restaurante fastfood
     */
    @Override
    protected void diminuicontador(){
        this.contadorRfastfood--;
    }

    /**
     * Método para aumentar o contador de
     */
    @Override
    protected void aumentacontador(){
        this.contadorRfastfood++;
    }

    /**
     * Método para calcular a despesa
     * @return despesa
     */
    @Override
    protected double despesa(){
        return getNrempregadosmesa()*getCustosalariomedioanual();
    }

    /**
     * Método para calcular a receita
     * @return receita
     */
    @Override
    protected double receita(){
        return (getNrmesasinteriores()*getVmfaturacaomesadia()+getNrmedioclientsdrive()*getVmfaturacaoclientsdrive())*getNrdiasfuncionamentoano();
    }

    /**
     * Método para inicializar os atributos estáticos
     * @param indice indice da empresa inicializadora
     */
    @Override
    protected void inicializa(int indice){
        setMaiorreceitaRfastfood(indice);
        setMenordespesaRfastfood(indice);
        setMaiorlucroRfastfood(indice);
    }

    /**
     * Método para comparar a receita do Restaurante fastfood referenciado por this com o Restaurante fastfood com maior receita anual
     * O que tiver maior receita passará a ter o seu indice do arraylist no atributo maiorreceitaRestaurantefastfood
     * @param listaempresas arraylist de empresas
     * @param indice indice da empresa que vai passar a ser a empresa com maior receita anual
     */
    @Override
    protected void comparamaiorReceita(ArrayList<Empresa> listaempresas,int indice){
        if (this.receita()>listaempresas.get(getMaiorreceitaRfastfood()).receita()){
            setMaiorreceitaRfastfood(indice);
        }
    }

    /**
     * Método para comparar a despesa do Restaurante fastfood referenciado por this com o Restaurante fastfood com menor despesa anual
     * O que tiver menor despesa passará a ter o seu indice do arraylist no atributo menordespesaRestaurantefastfood
     * @param listaempresas arraylist de empresas
     * @param indice indice da empresa que vai passar a ser a empresa com menor receita anual
     */
    @Override
    protected void comparamenorDespesa(ArrayList<Empresa> listaempresas,int indice){
        if (this.despesa()<listaempresas.get(getMenordespesaRfastfood()).despesa()){
            setMenordespesaRfastfood(indice);
        }
    }

    /**
     * Método para comparar o lucro do Restaurante fastfood referenciado por this com o Restaurante fastfood com maior lucro anual
     * O que tiver maior lucro passará a ter o seu indice do arraylist no atributo maiorlucroRestaurantefastfood
     * @param listaempresas arraylist de empresas
     * @param indice indice da empresa que vai passar a ser a empresa com maior lucro anual
     */
    @Override
    protected void comparamaiorLucro(ArrayList<Empresa> listaempresas,int indice){
        if (this.lucro()>listaempresas.get(getMaiorlucroRfastfood()).lucro()){
            setMaiorlucroRfastfood(indice);
        }
    }

    /**
     * Método para criar a janela de edição de uma empresa caso esta seja um Restaurante fastfood
     * @param listaempresas arraylist de empresas
     * @param selectedIndex indice da empresa selecionada no JList
     * @param framemenu frame do menu
     * @param frameinformacoesempresa frame onde se apresenta o JList das informações das empresas todas
     */
    @Override
    protected void criajanela(StarThrive listaempresas, int selectedIndex, JFrame framemenu, JFrame frameinformacoesempresa){
        this.framemenu=framemenu;
        this.frameinformacoesempresas=frameinformacoesempresa;
        this.selectedIndex=selectedIndex;
        this.listaEmpresas=listaempresas;
        JFrame frameedita = new JFrame();
        this.frameedita=frameedita;
        frameedita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameedita.setSize(2000, 2000);

        JButton gravar= new JButton("Gravar");
        gravar.addActionListener(new ButtongravarrfastfoodListener());

        JButton voltar=new JButton("Voltar");
        voltar.addActionListener(new ButtonvoltareditarmenuListener());

        JLabel labelnome = new JLabel("Nome:");
        JLabel labelcategoria = new JLabel("Categoria:");
        JLabel labeldistrito = new JLabel("Distrito:");
        JLabel labellatitude = new JLabel("Latitude da localização:");
        JLabel labellongitude = new JLabel("Longitude da localização");
        JLabel labelnrmedioclientesdiario = new JLabel("Número médio de clientes diário:");
        JLabel labelnrempregadosmesa = new JLabel("Número de empregados de mesa:");
        JLabel labelcustosalariomedioanual = new JLabel("Custo do salário médio anual");
        JLabel labelnrmesasinteriores = new JLabel(" número de mesas interiores:");
        JLabel labelnrdiasfuncionamentoano = new JLabel("número de dias de funcionamento por ano:");
        JLabel labelvmfaturacaomesadia = new JLabel("Valor médio de faturação de cada mesa por dia:");
        JLabel labelnrmedioclientsdrive = new JLabel("número médio diário de clientes drive-thru:");
        JLabel labelvmfaturacaoclientsdrive = new JLabel("valor médio diário de faturação por cada cliente drive-thru:");

        txtnome = new JTextField(this.nome);
        txtcategoria = new JTextField(this.categoria);
        txtdistrito = new JTextField(this.distrito);
        txtlatitude = new JTextField(this.localizacao.latitude);
        txtlongitude = new JTextField(this.localizacao.longitude);
        txtnrmedioclientesdiario = new JTextField(String.valueOf(this.nrmedioclientesdiario));
        txtnrempregadosmesa = new JTextField(String.valueOf(this.nrempregadosmesa));
        txtcustosalariomedioanual = new JTextField(String.valueOf(this.custosalariomedioanual));
        txtnrmesasinteriores = new JTextField(String.valueOf(this.nrmesasinteriores));
        txtnrdiasfuncionamentoano = new JTextField(String.valueOf(this.nrdiasfuncionamentoano));
        txtvmfaturacaomesadia = new JTextField(String.valueOf(this.vmfaturacaomesadia));
        txtnrmedioclientsdrive = new JTextField(String.valueOf(this.nrmedioclientsdrive));
        txtvmfaturacaoclientsdrive = new JTextField(String.valueOf(this.vmfaturacaoclientsdrive));

        JPanel paneledita = new JPanel();
        paneledita.setLayout(new GridLayout(14, 2));
        paneledita.add(labelnome);
        paneledita.add(txtnome);
        paneledita.add(labelcategoria);
        paneledita.add(txtcategoria);
        paneledita.add(labeldistrito);
        paneledita.add(txtdistrito);
        paneledita.add(labellatitude);
        paneledita.add(txtlatitude);
        paneledita.add(labellongitude);
        paneledita.add(txtlongitude);
        paneledita.add(labelnrmedioclientesdiario);
        paneledita.add(txtnrmedioclientesdiario);
        paneledita.add(labelnrempregadosmesa);
        paneledita.add(txtnrempregadosmesa);
        paneledita.add(labelcustosalariomedioanual);
        paneledita.add(txtcustosalariomedioanual);
        paneledita.add(labelnrmesasinteriores);
        paneledita.add(txtnrmesasinteriores);
        paneledita.add(labelnrdiasfuncionamentoano);
        paneledita.add(txtnrdiasfuncionamentoano);
        paneledita.add(labelvmfaturacaomesadia);
        paneledita.add(txtvmfaturacaomesadia);
        paneledita.add(labelnrmedioclientsdrive);
        paneledita.add(txtnrmedioclientsdrive);
        paneledita.add(labelvmfaturacaoclientsdrive);
        paneledita.add(txtvmfaturacaoclientsdrive);
        paneledita.add(voltar);
        paneledita.add(gravar);


        frameedita.add(paneledita);
        frameedita.setVisible(true);
        framemenu.setVisible(false);


    }
    private class ButtongravarrfastfoodListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                listaEmpresas.replaceEmpresa(selectedIndex,new RestauranteFastfood(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtnrmedioclientesdiario.getText()), Integer.parseInt(txtnrempregadosmesa.getText()), Double.parseDouble(txtcustosalariomedioanual.getText()), Integer.parseInt(txtnrdiasfuncionamentoano.getText()), Integer.parseInt(txtnrmesasinteriores.getText()), Double.parseDouble(txtvmfaturacaomesadia.getText()), Double.parseDouble(txtnrmedioclientsdrive.getText()), Double.parseDouble(txtvmfaturacaoclientsdrive.getText())));
                JOptionPane.showMessageDialog(null, "A empresa foi editada com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                framemenu.setVisible(true);
                frameedita.setVisible(false);
            }catch (NumberFormatException ex) {
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

    /**
     * Método toString:
     * Retorna a informação do cafe
     * @return nrmedioclientsdrive+vmfaturacaoclientsdrive+Despesa+Receita+Lucro(Sim ou nao)
     */
    @Override
    public String toString() {
        return super.toString()+"Rfastfood{" +
                "nrmedioclientsdrive=" + nrmedioclientsdrive +
                ", vmfaturacaoclientsdrive=" + vmfaturacaoclientsdrive + ", Despesa= " + this.despesa() + ", Receita=" + this.receita() + ", Lucro= "+this.lucrostring()+
                '}';
    }
}