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
 * Subclasse da classe Mercearia para definir uma frutaria
 */
class Frutaria extends Mercearia{
    /**
     * Número de produtos
     */
    protected int nrprodutos;
    /**
     * Valor médio de faturação anual por produto
     */
    protected double vmfaturacaoanualproduto;
    /**
     * Atributo estático para conter o índice da Frutaria com maior receita anual no arrraylist de empresas
     */

    protected static int maiorreceitaFrutaria;
    /**
     * Atributo estático para conter o índice da Frutaria com menor despesa anual no arrraylist de empresas
     */
    protected static int menordespesaFrutaria;
    /**
     * Atributo estático para conter o índice da Frutaria com maior lucro anual no arrraylist de empresas
     */
    protected static int maiorlucroFrutaria;
    /**
     * Atributo estático para conter o número de frutarias existentes no arraylist de empresas
     */
    protected static int contadorFrutaria;
    /**
     * JTextFields que irão receber os valores da empresa escolhida no JList para serem apresentados na frame de edição de uma empresa
     */
    protected JTextField txtnrprodutos, txtvmfaturacaoanualproduto;

    /**
     * Construtor sem parâmetros
     */
    public Frutaria(){}

    /**
     * Construtor da classe Frutaria, recebe dados para a inicialização dos atributos da superclasse e dela própria
     * @param categoria categoria da empresa
     * @param nome nome da empresa
     * @param distrito distrito onde a empresa se encontra
     * @param localizacao localização da empresa
     * @param custoanuallimpeza custo anual de limpeza
     * @param nrprodutos número de produtos
     * @param vmfaturacaoanualproduto Valor médio de faturação anual por produto
     */

    public Frutaria(String categoria,String nome, String distrito, Localizacao localizacao, double custoanuallimpeza,int nrprodutos, double vmfaturacaoanualproduto){
        super(categoria,nome,distrito,localizacao,custoanuallimpeza);
        this.nrprodutos=nrprodutos;
        this.vmfaturacaoanualproduto=vmfaturacaoanualproduto;
    }

    /**
     * Método para obter o número de produtos
     * @return número de produtos
     */
    public int getNrprodutos() {
        return nrprodutos;
    }

    /**
     * Método para definir o número de produtos
     * @param nrprodutos número de produtos
     */

    public void setNrprodutos(int nrprodutos) {
        this.nrprodutos = nrprodutos;
    }

    /**
     * Método para obter valor médio de faturação anual por produto
     * @return  valor médio de faturação anual por produto
     */

    public double getVmfaturacaoanualproduto() {
        return vmfaturacaoanualproduto;
    }

    /**
     * Método para definir valor médio de faturação anual por produto
     * @param vmfaturacaoanualproduto valor médio de faturação anual por produto
     */

    public void setVmfaturacaoanualproduto(double vmfaturacaoanualproduto) {
        this.vmfaturacaoanualproduto = vmfaturacaoanualproduto;
    }

    /**
     * Método para obter o índice da frutaria com maior receita anual
     * @return índice da frutaria com maior receita anual
     */
    public static int getMaiorreceitaFrutaria() {
        return maiorreceitaFrutaria;
    }

    /**
     * Método para definir o índice da frutaria com maior receita anual
     * @param maiorreceitaFrutaria índice da frutaria com maior receita anual
     */

    public static void setMaiorreceitaFrutaria(int maiorreceitaFrutaria) {
        Frutaria.maiorreceitaFrutaria = maiorreceitaFrutaria;
    }

    /**
     * Método para obter o índice da frutaria com menor despesa anual
     * @return índice da frutaria com menor despesa anual
     */
    public static int getMenordespesaFrutaria() {
        return menordespesaFrutaria;
    }

    /**
     * Método para definir o índice da frutaria com menor despesa anual
     * @param menordespesaFrutaria índice da frutaria com menor despesa anual
     */

    public static void setMenordespesaFrutaria(int menordespesaFrutaria) {
        Frutaria.menordespesaFrutaria = menordespesaFrutaria;
    }

    /**
     * Método para obter o índice da frutaria com maior lucro anual
     * @return índice da frutaria com maior lucro anual
     */

    public static int getMaiorlucroFrutaria() {
        return maiorlucroFrutaria;
    }

    /**
     * Método para definir o índice da frutaria com maior lucro anual
     * @param maiorlucroFrutaria índice da frutaria com maior lucro anual
     */

    public static void setMaiorlucroFrutaria(int maiorlucroFrutaria) {
        Frutaria.maiorlucroFrutaria = maiorlucroFrutaria;
    }

    /**
     * Método para obter número de frutarias
     * @return número de frutarias
     */

    public static int getContadorFrutaria() {
        return contadorFrutaria;
    }

    /**
     * Método para definir número de frutarias
     * @param contadorFrutaria número de frutarias
     */

    public static void setContadorFrutaria(int contadorFrutaria) {
        Frutaria.contadorFrutaria = contadorFrutaria;
    }

    /**
     * Método para diminuir o contador de frutarias
     */
    @Override
    protected void diminuicontador(){
        this.contadorFrutaria--;
    }

    /**
     * Método para aumentar o contador de frutarias
     */
    @Override
    protected void aumentacontador(){
        this.contadorFrutaria++;
    }

    /**
     * Método para calcular a despesa
     * @return despesa
     */

    @Override
    protected double despesa(){
        return this.custoanuallimpeza;
    }

    /**
     * Método para calcular a receita
     * @return receita
     */

    @Override
    protected double receita(){
        return getNrprodutos()*getVmfaturacaoanualproduto();
    }

    /**
     * Método para inicializar os atributos estáticos
     * @param indice indice da empresa inicializadora
     */
    @Override
    protected void inicializa(int indice){
        setMaiorreceitaFrutaria(indice);
        setMenordespesaFrutaria(indice);
        setMaiorlucroFrutaria(indice);
    }

    /**
     * Método para comparar a receita da frutaria referenciada por this com a frutaria com maior receita anual
     * A que tiver maior receita passará a ter o seu indice do arraylist no atributo maiorreceitaFrutaria
     * @param listaempresas arraylist de empresas
     * @param indice indice da frutaria que vai passar a ser a frutaria com maior receita anual
     */

    @Override
    protected void comparamaiorReceita(ArrayList<Empresa> listaempresas,int indice){
        if (this.receita()>listaempresas.get(getMaiorreceitaFrutaria()).receita()){
            setMaiorreceitaFrutaria(indice);
        }
    }

    /**
     * Método para comparar a despesa da frutaria referenciada por this com a frutaria com menor despesa anual
     * O que tiver menor despesa passará a ter o seu indice do arraylist no atributo menordespesaFrutaria
     * @param listaempresas arraylist de empresas
     * @param indice indice da frutaria que vai passar a ser a frutaria com menor receita anual
     */

    @Override
    protected void comparamenorDespesa(ArrayList<Empresa> listaempresas,int indice){
        if (this.despesa()<listaempresas.get(getMenordespesaFrutaria()).despesa()){
            setMenordespesaFrutaria(indice);
        }
    }

    /**
     * Método para comparar o lucro da frutaria referenciado por this com a frutaria com maior lucro anual
     * O que tiver maior lucro passará a ter o seu indice do arraylist no atributo maiorlucroFrutaria
     * @param listaempresas arraylist de empresas
     * @param indice indice da frutaria que vai passar a ser a frutaria com maior lucro anual
     */
    @Override
    protected void comparamaiorLucro(ArrayList<Empresa> listaempresas,int indice){
        if (this.lucro()>listaempresas.get(getMaiorlucroFrutaria()).lucro()){
            setMaiorlucroFrutaria(indice);
        }
    }

    /**
     * Método para criar a janela de edição de uma empresa caso esta seja uma frutaria
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
        gravar.addActionListener(new ButtongravarfrutariaListener());

        JButton voltar=new JButton("Voltar");
        voltar.addActionListener(new ButtonvoltareditarmenuListener());

        JLabel labelnome = new JLabel("Nome:");
        JLabel labelcategoria = new JLabel("Categoria:");
        JLabel labeldistrito = new JLabel("Distrito:");
        JLabel labellatitude = new JLabel("Latitude da localização:");
        JLabel labellongitude = new JLabel("Longitude da localização");
        JLabel labelcustoanuallimpeza = new JLabel("custo anual de limpeza do estabelecimento:");
        JLabel labelnrprodutos = new JLabel("número de produtos:");
        JLabel labelvmfaturacaoanualproduto = new JLabel("valor médio de faturação anual por produto:");

        txtnome = new JTextField(this.nome);
        txtcategoria = new JTextField(this.categoria);
        txtdistrito = new JTextField(this.distrito);
        txtlatitude = new JTextField(this.localizacao.latitude);
        txtlongitude = new JTextField(this.localizacao.longitude);
        txtcustoanuallimpeza = new JTextField(String.valueOf(this.custoanuallimpeza));
        txtnrprodutos = new JTextField(String.valueOf(this.nrprodutos));
        txtvmfaturacaoanualproduto = new JTextField(String.valueOf(this.vmfaturacaoanualproduto));

        JPanel paneledita = new JPanel();
        paneledita.setLayout(new GridLayout(9, 2));
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
        paneledita.add(labelcustoanuallimpeza);
        paneledita.add(txtcustoanuallimpeza);
        paneledita.add(labelnrprodutos);
        paneledita.add(txtnrprodutos);
        paneledita.add(labelvmfaturacaoanualproduto);
        paneledita.add(txtvmfaturacaoanualproduto);
        paneledita.add(voltar);
        paneledita.add(gravar);
        frameedita.add(paneledita);
        framemenu.setVisible(false);
        frameedita.setVisible(true);

    }
    private class ButtongravarfrutariaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                listaEmpresas.replaceEmpresa(selectedIndex,new Frutaria(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtcustoanuallimpeza.getText()), Integer.parseInt(txtnrprodutos.getText()), Double.parseDouble(txtvmfaturacaoanualproduto.getText())));

                JOptionPane.showMessageDialog(null, "A empresa foi editada com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                framemenu.setVisible(true);
                frameedita.setVisible(false);
            }catch (NumberFormatException ex){
                txtcustoanuallimpeza.setBackground(Color.red);
                txtnrprodutos.setBackground(Color.red);
                txtvmfaturacaoanualproduto.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Os campos tem que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    /**
     * Método toString:
     * Retorna a informação da frutaria
     * @return Número de produtos + Valor médio de faturação anual por produto + despesa + receita + Lucro (Sim ou Nao)
     */

    @Override
    public String toString() {
        return super.toString()+"Frutaria{" +
                "nrprodutos=" + nrprodutos +
                ", vmfaturacaoanualproduto=" + vmfaturacaoanualproduto + ", Despesa= " + this.despesa() + ", Receita=" + this.receita() + ", Lucro= "+this.lucrostring()+
                '}';
    }
}
