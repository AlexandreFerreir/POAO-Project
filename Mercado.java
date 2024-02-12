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
 * Subclasse da classe Mercearia para definir um mercado
 */
class Mercado extends Mercearia {
    /**
     * Tipo de mercado
     */
    protected String tipo;
    /**
     * Area do mercado
     */

    protected double area;
    /**
     * Valor médio de faturação por metro quadrado
     */
    protected double vmfaturacaom2;
    /**
     * Atributo estático para conter o índice do mercado com maior receita anual no arrraylist de empresas
     */

    protected static int maiorreceitaMercado;
    /**
     * Atributo estático para conter o índice do mercado com menor despesa anual no arrraylist de empresas
     */
    protected static int menordespesaMercado;
    /**
     * Atributo estático para conter o índice do mercado com maior lucro anual no arrraylist de empresas
     */
    protected static int maiorlucroMercado;
    /**
     * Atributo estático para conter o número de mercados existentes no arraylist de empresas
     */
    protected static int contadorMercado;
    /**
     * JTextFields que irão receber os valores da empresa escolhida no JList para serem apresentados na frame de edição de uma empresa
     */
    protected JTextField txtarea, txtvmfaturacaom2;
    /**
     * ComboBox para conter os três tipos de mercado
     */
    protected JComboBox<String> tipobox;

    /**
     * Construtor sem parâmetros
     */
    public Mercado(){}

    /**
     * Construtor da classe Mercado, recebe dados para a inicialização dos atributos da superclasse e dela própria
     * @param categoria categoria da empresa
     * @param nome nome da empresa
     * @param distrito distrito onde a empresa se encontra
     * @param localizacao localização da empresa
     * @param custoanuallimpeza custo anual de limpeza do estabelecimento
     * @param tipo Tipo de mercado
     * @param area Area do mercado
     * @param vmfaturacaom2 valor médio de faturação por metro quadrado
     */
    public Mercado(String categoria,String nome, String distrito, Localizacao localizacao,double custoanuallimpeza,String tipo,double area,double vmfaturacaom2){
        super(categoria,nome,distrito,localizacao,custoanuallimpeza);
        this.tipo=tipo;
        this.area=area;
        this.vmfaturacaom2=vmfaturacaom2;
    }

    /**
     * Método para obter o tipo de mercado
     * @return tipo de mercado
     */

    public String getTipo() {
        return tipo;
    }

    /**
     * Método para definir o tipo de mercado
     * @param tipo tipo de mercado
     */

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método para obter a área do mercado
     * @return área do mercado
     */

    public double getArea() {
        return area;
    }

    /**
     * para definir a área do mercado
     * @param area área do mercado
     */

    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Método para obter o valor médio de faturação por metro quadrado
     * @return valor médio de faturação por metro quadrado
     */

    public double getVmfaturacaom2() {
        return vmfaturacaom2;
    }

    /**
     * Método para definir o valor médio de faturação por metro quadrado
     * @param vmfaturacaom2 valor médio de faturação por metro quadrado
     */

    public void setVmfaturacaom2(double vmfaturacaom2) {
        this.vmfaturacaom2 = vmfaturacaom2;
    }

    /**
     * Método para obter o índice do Mercado com maior receita anual
     * @return índice do Mercado com maior receita anual
     */

    public static int getMaiorreceitaMercado() {
        return maiorreceitaMercado;
    }

    /**
     * Método para definir o índice do Mercado com maior receita anual
     * @param maiorreceitaMercado índice do Mercado com maior receita anual
     */

    public static void setMaiorreceitaMercado(int maiorreceitaMercado) {
        Mercado.maiorreceitaMercado = maiorreceitaMercado;
    }

    /**
     * Método para obter o índice do Mercado com menor despesa anual
     * @return índice do Mercado com menor despesa anual
     */

    public static int getMenordespesaMercado() {
        return menordespesaMercado;
    }

    /**
     * Método para definir o índice do Mercado com menor despesa anual
     * @param menordespesaMercado índice do Mercado com menor despesa anual
     */

    public static void setMenordespesaMercado(int menordespesaMercado) {
        Mercado.menordespesaMercado = menordespesaMercado;
    }

    /**
     * Método para obter o índice do Mercado com maior lucro anual
     * @return índice do Mercado com maior lucro anual
     */

    public static int getMaiorlucroMercado() {
        return maiorlucroMercado;
    }

    /**
     *  Método para definir o índice do Mercado com maior lucro anual
     * @param maiorlucroMercado índice do Mercado com maior lucro anual
     */

    public static void setMaiorlucroMercado(int maiorlucroMercado) {
        Mercado.maiorlucroMercado = maiorlucroMercado;
    }

    /**
     * Método para obter número de mercados
     * @return número de mercados
     */

    public static int getContadorMercado() {
        return contadorMercado;
    }

    /**
     * Método para definir número de mercados
     * @param contadorMercado número de mercados
     */

    public static void setContadorMercado(int contadorMercado) {
        Mercado.contadorMercado = contadorMercado;
    }

    /**
     * Método para diminuir o contador de mercados
     */
    @Override
    protected void diminuicontador(){
        this.contadorMercado--;
    }

    /**
     * Método para aumentar o contador de mercados
     */
    @Override
    protected void aumentacontador(){
        this.contadorMercado++;
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
        return getArea()*getVmfaturacaom2();
    }

    /**
     * Método para inicializar os atributos estáticos
     * @param indice indice da empresa inicializadora
     */
    @Override
    protected void inicializa(int indice){
        setMaiorreceitaMercado(indice);
        setMenordespesaMercado(indice);
        setMaiorlucroMercado(indice);
    }

    /**
     * Método para comparar a receita do mercado referenciado por this com o mercado com maior receita anual
     * O que tiver maior receita passará a ter o seu indice do arraylist no atributo maiorreceitaMercado
     * @param listaempresas arraylist de empresas
     * @param indice indice do mercado que vai passar a ser o mercado com maior receita anual
     */

    @Override
    protected void comparamaiorReceita(ArrayList<Empresa> listaempresas,int indice){
        if (this.receita()>listaempresas.get(getMaiorreceitaMercado()).receita()){
            setMaiorreceitaMercado(indice);
        }
    }

    /**
     * Método para comparar a despesa do mercado referenciado por this com o mercado com menor despesa anual
     * O que tiver menor despesa passará a ter o seu indice do arraylist no atributo menordespesaMercado
     * @param listaempresas arraylist de empresas
     * @param indice indice do mercado que vai passar a ser o mercado com menor receita anual
     */

    @Override
    protected void comparamenorDespesa(ArrayList<Empresa> listaempresas,int indice){
        if (this.despesa()<listaempresas.get(getMenordespesaMercado()).despesa()){
            setMenordespesaMercado(indice);
        }
    }

    /**
     * Método para comparar o lucro do mercado referenciado por this com o mercado com maior lucro anual
     * O que tiver maior lucro passará a ter o seu indice do arraylist no atributo maiorlucroMercado
     * @param listaempresas arraylist de empresas
     * @param indice indice da empresa que vai passar a ser a empresa com maior lucro anual
     */
    @Override
    protected void comparamaiorLucro(ArrayList<Empresa> listaempresas,int indice){
        if (this.lucro()>listaempresas.get(getMaiorlucroMercado()).lucro()){
            setMaiorlucroMercado(indice);
        }
    }

    /**
     * Método para criar a janela de edição de uma empresa caso esta seja um mercado
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
        gravar.addActionListener(new ButtongravarmercadoListener());

        JButton voltar=new JButton("Voltar");
        voltar.addActionListener(new ButtonvoltareditarmenuListener());

        String[] tipos = {"Selecione uma das opções","Min","Super", "Hiper"};
        tipobox = new JComboBox<>(tipos);

        JLabel labelnome = new JLabel("Nome:");
        JLabel labelcategoria = new JLabel("Categoria:");
        JLabel labeldistrito = new JLabel("Distrito:");
        JLabel labellatitude = new JLabel("Latitude da localização:");
        JLabel labellongitude = new JLabel("Longitude da localização");
        JLabel labelcustoanuallimpeza = new JLabel("custo anual de limpeza do estabelecimento:");
        JLabel labeltipo = new JLabel("Tipo:");
        JLabel labelarea = new JLabel("área de corredores:");
        JLabel labelvmfaturacaom2 = new JLabel(" valor médio de faturação anual por metro quadrado:");

        txtnome = new JTextField(this.nome);
        txtcategoria = new JTextField(this.categoria);
        txtdistrito = new JTextField(this.distrito);
        txtlatitude = new JTextField(this.localizacao.latitude);
        txtlongitude = new JTextField(this.localizacao.longitude);
        txtcustoanuallimpeza = new JTextField(String.valueOf(this.custoanuallimpeza));
        txtarea = new JTextField(String.valueOf(this.area));
        txtvmfaturacaom2 = new JTextField(String.valueOf(this.vmfaturacaom2));

        JPanel paneledita = new JPanel();
        paneledita.setLayout(new GridLayout(10, 2));
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
        paneledita.add(labeltipo);
        paneledita.add(tipobox);
        paneledita.add(labelarea);
        paneledita.add(txtarea);
        paneledita.add(labelvmfaturacaom2);
        paneledita.add(txtvmfaturacaom2);
        paneledita.add(voltar);
        paneledita.add(gravar);
        frameedita.add(paneledita);
        framemenu.setVisible(false);
        frameedita.setVisible(true);

    }
    private class ButtongravarmercadoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if (tipobox.getSelectedIndex()==0){
                    tipobox.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Tem que selecionar uma das opções", "Erro", JOptionPane.ERROR_MESSAGE);
                }else {
                    listaEmpresas.replaceEmpresa(selectedIndex, new Mercado(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtcustoanuallimpeza.getText()), tipobox.getItemAt(tipobox.getSelectedIndex()), Double.parseDouble(txtarea.getText()), Double.parseDouble(txtvmfaturacaom2.getText())));
                    JOptionPane.showMessageDialog(null, "A empresa foi editada com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                    framemenu.setVisible(true);
                    frameedita.setVisible(false);
                }
            }catch (NumberFormatException ex) {
                txtcustoanuallimpeza.setBackground(Color.red);
                txtarea.setBackground(Color.red);
                txtvmfaturacaom2.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Os campos tem que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método toString:
     * Retorna a informação do mercado
     * @return tipo + area + valor medio de faturação por metro quadrado + despesa + receita + Lucro (Sim ou Nao)
     */
    @Override
    public String toString() {
        return super.toString()+"Mercado{" +
                "tipo='" + tipo + '\'' +
                ", area=" + area +
                ", vmfaturacaom2=" + vmfaturacaom2 + ", Despesa= " + this.despesa() + ", Receita=" + this.receita() + ", Lucro= "+this.lucrostring()+
                '}';
    }
}
