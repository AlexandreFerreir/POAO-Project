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
 * Subclasse da classe Restauracao para definir um restaurante local
 */
class RestauranteLocal extends Restaurante {
    /**
     * número de mesas esplanada
     */
    protected int nrmesasesplanada;
    /**
     * custo de licenca anual por mesa de esplanada
     */
    protected double custolicencaanualmesplanada;
    /**
     * Atributo estático para conter o índice do restaurante local com maior receita anual no arrraylist de empresas
     */

    protected static int maiorreceitaRLocal;
    /**
     * Atributo estático para conter o índice do restaurante local com menor despesa anual no arrraylist de empresas
     */
    protected static int menordespesaRLocal;
    /**
     * Atributo estático para conter o índice do restaurante local com maior lucro anual no arrraylist de empresas
     */
    protected static int maiorlucroRLocal;
    /**
     * Atributo estático para conter o número de restaurante locais existentes no arraylist de empresas
     */
    protected static int contadorRlocal;
    /**
     * JTextFields que irão receber os valores da empresa escolhida no JList para serem apresentados na frame de edição de uma empresa
     */

    protected JTextField txtnrmesasesplanada, txtcustolicencaanualmesplanada;

    /**
     * Construtor sem parâmetros
     */
    public RestauranteLocal(){}

    /**
     * Construtor da classe restaurante local, recebe dados para a inicialização dos atributos da superclasse e dela própria
     * @param categoria categoria da empresa
     * @param nome  nome da empresa
     * @param distrito distrito onde a empresa se encontra
     * @param localizacao localização da empresa
     * @param nrmedioclientesdiario número médio de clientes diário
     * @param nrempregadosmesa número de empregados de mesa
     * @param custosalariomedioanual custo do salário médio anual
     * @param nrmesasinteriores numero de mesas interiores
     * @param nrdiasfuncionamentoano numero de dias em funcionamento
     * @param vmfaturacaomesadia valor medio faturacao por mesa por dia
     * @param nrmesasesplanada numero de mesas esplanadas
     * @param custolicencaanualmesplanada custo de licenca anual por mesa esplanada
     */
    public RestauranteLocal(String categoria,String nome, String distrito, Localizacao localizacao,double nrmedioclientesdiario, int nrempregadosmesa, double custosalariomedioanual, int nrmesasinteriores, int nrdiasfuncionamentoano,double vmfaturacaomesadia,int nrmesasesplanada,double custolicencaanualmesplanada){
        super(categoria, nome, distrito, localizacao, nrmedioclientesdiario, nrempregadosmesa, custosalariomedioanual, nrmesasinteriores, nrdiasfuncionamentoano, vmfaturacaomesadia);
        this.nrmesasesplanada=nrmesasesplanada;
        this.custolicencaanualmesplanada=custolicencaanualmesplanada;
    }

    /**
     *Método para obter o numero de mesas esplanadas
     * @return numero de mesas esplanadas
     */


    public int getNrmesasesplanada() {
        return nrmesasesplanada;
    }

    /**
     * metodo para definir o nnumero de mesas esplanadas
     * @param nrmesasesplanada nnumero de mesas esplanadas
     */

    public void setNrmesasesplanada(int nrmesasesplanada) {
        this.nrmesasesplanada = nrmesasesplanada;
    }

    /**
     * metodo para obter o custo de licenca anual por mesa esplanada
     * @return custo de licenca anual por mesa esplanada
     */

    public double getCustolicencaanualmesplanada() {
        return custolicencaanualmesplanada;
    }

    /**
     * metodo para definir o custo de licenca anual por mesa esplanada
     * @param custolicencaanualmesplanada custo de licenca anual por mesa esplanada
     */
    public void setCustolicencaanualmesplanada(double custolicencaanualmesplanada) {
        this.custolicencaanualmesplanada = custolicencaanualmesplanada;
    }

    /**
     * Método para obter o índice do restaurante local  com maior receita anua
     * @return índice do restaurante local  com maior receita anual
     */

    public static int getMaiorreceitaRLocal() {
        return maiorreceitaRLocal;
    }

    /**
     * Método para definir o índice do restaurante local com maior receita anual
     * @param maiorreceitaRLocal índice do restaurante local com maior receita anual
     */

    public static void setMaiorreceitaRLocal(int maiorreceitaRLocal) {
        RestauranteLocal.maiorreceitaRLocal = maiorreceitaRLocal;
    }

    /**
     * Método para obter o índice do restaurante local  com menor despesa anual
     * @return índice do restaurante local  com menor despesa anual
     */

    public static int getMenordespesaRLocal() {
        return menordespesaRLocal;
    }

    /**
     * Método para definir o índice do restaurante local  com menor despesa anual
     * @param menordespesaRLocal índice do restaurante local  com menor despesa anual
     */

    public static void setMenordespesaRLocal(int menordespesaRLocal) {
        RestauranteLocal.menordespesaRLocal = menordespesaRLocal;
    }

    /**
     * Método para obter o índice do restaurante local  com maior lucro anual
     * @return índice do restaurante local  com maior lucro anual
     */

    public static int getMaiorlucroRLocal() {
        return maiorlucroRLocal;
    }

    /**
     * Método para definir o índice do Crestaurante local fé com maior lucro anual
     * @param maiorlucroRLocal
     */

    public static void setMaiorlucroRLocal(int maiorlucroRLocal) {
        RestauranteLocal.maiorlucroRLocal = maiorlucroRLocal;
    }

    /**
     * Método para obter número de restaurante local
     * @return número de restaurante local
     */

    public static int getContadorRlocal() {
        return contadorRlocal;
    }

    /**
     * Método para definir número de restaurante local
     * @param contadorRlocal número de restaurante local
     */

    public static void setContadorRlocal(int contadorRlocal) {
        RestauranteLocal.contadorRlocal = contadorRlocal;
    }

    /**
     * Método para diminuir o contador de restaurante local
     */
    @Override
    protected void diminuicontador(){
        this.contadorRlocal--;
    }

    /**
     * Método para aumentar o contador de restaurante local
     */
    @Override
    protected void aumentacontador(){
        this.contadorRlocal++;
    }

    /**
     * Método para calcular a despesa
     * @return despesa
     */

    @Override
    protected double despesa(){
        return getNrempregadosmesa()*getCustosalariomedioanual()+getNrmesasesplanada()*getCustolicencaanualmesplanada();
    }

    /**
     * Método para calcular a receita
     * @return receita
     */
    @Override
    protected double receita(){
        return (getNrmesasinteriores()+getNrmesasesplanada())*getVmfaturacaomesadia()*getNrdiasfuncionamentoano();
    }

    /**
     * Método para inicializar os atributos estáticos
     * @param indice indice da empresa inicializadora
     */
    @Override
    protected void inicializa(int indice){
        setMaiorreceitaRLocal(indice);
        setMenordespesaRLocal(indice);
        setMaiorlucroRLocal(indice);
    }

    /**
     * Método para comparar a receita do restaurante local  referenciado por this com o restaurante local  com maior receita anual
     * O que tiver maior receita passará a ter o seu indice do arraylist no atributo maiorreceitaRLocal
     * @param listaempresas arraylist de empresas
     * @param indice indice da restaurante local  que vai passar a ser a restaurante local  com maior receita anual
     */

    @Override
    protected void comparamaiorReceita(ArrayList<Empresa> listaempresas,int indice){
        if (this.receita()>listaempresas.get(getMaiorreceitaRLocal()).receita()){
            setMaiorreceitaRLocal(indice);
        }
    }

    /***
     *Método para comparar a despesa do restaurante local  referenciado por this com o restaurante local  com menor despesa anual
     * O que tiver menor despesa passará a ter o seu indice do arraylist no atributo menordespesaRlocal
     * @param listaempresas arraylist de empresas
     * @param indice indice da empresa que vai passar a ser a empresa com menor receita anual
     */

    @Override
    protected void comparamenorDespesa(ArrayList<Empresa> listaempresas,int indice){
        if (this.despesa()<listaempresas.get(getMenordespesaRLocal()).despesa()){
            setMenordespesaRLocal(indice);
        }
    }

    /**
     * Método para comparar o lucro do restaurante local  referenciado por this com o restaurante local  com maior lucro anual
     * O que tiver maior lucro passará a ter o seu indice do arraylist no atributo maiorlucroRLocal
     * @param listaempresas arraylist de empresas
     * @param indice indice da empresa que vai passar a ser a empresa com maior lucro anual
     */
    @Override
    protected void comparamaiorLucro(ArrayList<Empresa> listaempresas,int indice){
        if (this.lucro()>listaempresas.get(getMaiorlucroRLocal()).lucro()){
            setMaiorlucroRLocal(indice);
        }
    }

    /**
     * Método para criar a janela de edição de uma empresa caso esta seja um Cafe
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
        gravar.addActionListener(new ButtongravarrlocalListener());

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
        JLabel labelnrdiasfuncionamentoano = new JLabel("número de diasde funcionamento por ano:");
        JLabel labelvmfaturacaomesadia = new JLabel("Valor médio de faturação de cada mesa por dia:");
        JLabel labelnrmesasesplanada = new JLabel("Número de mesas na esplanada:");
        JLabel labelcustolicencaanualmesplanada = new JLabel("Custo de licença anual por mesa de esplanada:");

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
        txtnrmesasesplanada = new JTextField(String.valueOf(this.nrmesasesplanada));
        txtcustolicencaanualmesplanada = new JTextField(String.valueOf(this.custolicencaanualmesplanada));

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
        paneledita.add(labelnrmesasesplanada);
        paneledita.add(txtnrmesasesplanada);
        paneledita.add(labelcustolicencaanualmesplanada);
        paneledita.add(txtcustolicencaanualmesplanada);
        paneledita.add(voltar);
        paneledita.add(gravar);


        frameedita.add(paneledita);
        framemenu.setVisible(false);
        frameedita.setVisible(true);

    }
    private class ButtongravarrlocalListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                listaEmpresas.replaceEmpresa(selectedIndex,new RestauranteLocal(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtnrmedioclientesdiario.getText()), Integer.parseInt(txtnrempregadosmesa.getText()), Double.parseDouble(txtcustosalariomedioanual.getText()), Integer.parseInt(txtnrmesasinteriores.getText()), Integer.parseInt(txtnrdiasfuncionamentoano.getText()), Double.parseDouble(txtvmfaturacaomesadia.getText()), Integer.parseInt(txtnrmesasesplanada.getText()), Double.parseDouble(txtcustolicencaanualmesplanada.getText())));
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
                txtnrmesasesplanada.setBackground(Color.red);
                txtcustolicencaanualmesplanada.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Os campos tem que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método toString:
     * Retorna a informação do cafe
     * @return  número de mesas esplanada+ custo de licenca anual por mesa de esplanada+
     */

    @Override
    public String toString() {
        return super.toString()+"RLocal{" +
                "nrmesasesplanada=" + nrmesasesplanada +
                ", custolicencaanualmesplanada=" + custolicencaanualmesplanada + ", Despesa= " + this.despesa() + ", Receita=" + this.receita() + ", Lucro= "+this.lucrostring()+
                '}';
    }
}
