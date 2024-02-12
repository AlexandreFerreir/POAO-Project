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
 * Subclasse da classe Restauracao para definir uma pastelaria
 */
class Pastelaria extends Restauracao{
    /**
     * Número de bolos por dia
     */
    protected int nrbolosdia;
    /**
     * Valor médio de faturação anual por bolo vendido por dia
     */
    protected double vmfaturacaoanualbolodia;
    /**
     * Atributo estático para conter o índice da pastelaria com maior receita anual no arrraylist de empresas
     */

    protected static int maiorreceitaPastelaria;
    /**
     * Atributo estático para conter o índice da pastelaria com menor despesa anual no arrraylist de empresas
     */
    protected static int menordespesaPastelaria;
    /**
     * Atributo estático para conter o índice da pastelaria com maior lucro anual no arrraylist de empresas
     */
    protected static int maiorlucroPastelaria;
    /**
     * Atributo estático para conter o número de pastelarias existentes no arraylist de empresas
     */
    protected static int contadorPastelaria;
    /**
     * JTextFields que irão receber os valores da empresa escolhida no JList para serem apresentados na frame de edição de uma empresa
     */
    protected JTextField txtnrmediobolosdia, txtvmfaturacaoanualbolodia;

    /**
     * Construtor sem parâmetros
     */

    public Pastelaria(){}

    /**
     * Construtor da classe Pastelaria, recebe dados para a inicialização dos atributos da superclasse e dela própria
     * @param categoria categoria da empresa
     * @param nome nome da empresa
     * @param distrito distrito onde a empresa se encontra
     * @param localizacao localização da empresa
     * @param nrmedioclientesdiario número médio de clientes diário
     * @param nrempregadosmesa número de empregados de mesa
     * @param custosalariomedioanual custo do salário médio anual
     * @param nrbolosdia número de bolos por dia
     * @param vmfaturacaoanualbolodia valor médio de faturação anual por bolos por dia
     */
    public Pastelaria(String categoria,String nome, String distrito, Localizacao localizacao,double nrmedioclientesdiario, int nrempregadosmesa, double custosalariomedioanual, int nrbolosdia,double vmfaturacaoanualbolodia){
        super(categoria,nome,distrito,localizacao,nrmedioclientesdiario,nrempregadosmesa,custosalariomedioanual);
        this.nrbolosdia=nrbolosdia;
        this.vmfaturacaoanualbolodia=vmfaturacaoanualbolodia;
    }

    /**
     * Método para obter o número de bolos por dia
     * @return número de bolos por dia
     */

    public int getNrbolosdia() {return nrbolosdia;}

    /**
     * Método para definir o número de bolos por dia
     * @param nrbolosdia número de bolos por dia
     */

    public void setNrbolosdia(int nrbolosdia) {
        this.nrbolosdia = nrbolosdia;
    }

    /**
     * Método para obter o valor médio de faturação anual por bolos por dia
     * @return valor médio de faturação anual por bolos por dia
     */

    public double getVmfaturacaoanualbolodia() {
        return vmfaturacaoanualbolodia;
    }

    /**
     * Método para definir o valor médio de faturação anual por bolos por dia
     * @param vmfaturacaoanualbolodia valor médio de faturação anual por bolos por dia
     */

    public void setVmfaturacaoanualbolodia(double vmfaturacaoanualbolodia) {
        this.vmfaturacaoanualbolodia = vmfaturacaoanualbolodia;
    }

    /**
     *  Método para obter o índice da pastelaria com maior receita anual
     * @return índice da pastelaria com maior receita anual
     */

    public static int getMaiorreceitaPastelaria() {
        return maiorreceitaPastelaria;
    }

    /**
     * Método para definir o índice da pastelaria com maior receita anual
     * @param maiorreceitaPastelaria índice da pastelaria com maior receita anual
     */

    public static void setMaiorreceitaPastelaria(int maiorreceitaPastelaria) {
        Pastelaria.maiorreceitaPastelaria = maiorreceitaPastelaria;
    }

    /**
     * Método para obter o índice da pastelaria com menor despesa anual
     * @return índice da pastelaria com menor despesa anual
     */

    public static int getMenordespesaPastelaria() {
        return menordespesaPastelaria;
    }

    /**
     * Método para definir o índice da pastelaria com menor despesa anual
     * @param menordespesaPastelaria índice da pastelaria com menor despesa anual
     */

    public static void setMenordespesaPastelaria(int menordespesaPastelaria) {
        Pastelaria.menordespesaPastelaria = menordespesaPastelaria;
    }

    /**
     *  Método para obter o índice da pastelaria com maior lucro anual
     * @return índice da pastelaria com maior lucro anual
     */

    public static int getMaiorlucroPastelaria() {
        return maiorlucroPastelaria;
    }

    /**
     * Método para definir o índice da pastelaria com maior lucro anual
     * @param maiorlucroPastelaria índice da frutaria com maior lucro anual
     */

    public static void setMaiorlucroPastelaria(int maiorlucroPastelaria) {
        Pastelaria.maiorlucroPastelaria = maiorlucroPastelaria;
    }

    /**
     * Método para obter número de pastelarias
     * @return número de pastelarias
     */

    public static int getContadorPastelaria() {
        return contadorPastelaria;
    }

    /**
     * Método para definir o número de pastelarias
     * @param contadorPastelaria número de pastelarias
     */

    public static void setContadorPastelaria(int contadorPastelaria) {
        Pastelaria.contadorPastelaria = contadorPastelaria;
    }

    /**
     * Método para diminuir o contador de pastelarias
     */
    @Override
    protected void diminuicontador(){
        this.contadorPastelaria--;
    }

    /**
     * Método para aumentar o contador de pastelarias
     */
    @Override
    protected void aumentacontador(){
        this.contadorPastelaria++;
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
        return getNrbolosdia()*getVmfaturacaoanualbolodia();
    }

    /**
     * Método para inicializar os atributos estáticos
     * @param indice indice da empresa inicializadora
     */

    @Override
    protected void inicializa(int indice){
        setMaiorreceitaPastelaria(indice);
        setMenordespesaPastelaria(indice);
        setMaiorlucroPastelaria(indice);
    }

    /**
     * Método para comparar a receita da pastelaria referenciada por this com a pastelaria com maior receita anual
     * A que tiver maior receita passará a ter o seu indice do arraylist no atributo maiorreceitaPastelaria
     * @param listaempresas arraylist de empresas
     * @param indice indice da pastelaria que vai passar a ser a pastelaria com maior receita anual
     */

    @Override
    protected void comparamaiorReceita(ArrayList<Empresa> listaempresas,int indice){
        if (this.receita()>listaempresas.get(getMaiorreceitaPastelaria()).receita()){
            setMaiorreceitaPastelaria(indice);
        }
    }

    /**
     * Método para comparar a despesa da pastelaria referenciada por this com a pastelaria com menor despesa anual
     * O que tiver menor despesa passará a ter o seu indice do arraylist no atributo menordespesaPastelaria
     * @param listaempresas arraylist de empresas
     * @param indice indice da pastelaria que vai passar a ser a pastelaria com menor receita anual
     */

    @Override
    protected void comparamenorDespesa(ArrayList<Empresa> listaempresas,int indice){
        if (this.despesa()<listaempresas.get(getMenordespesaPastelaria()).despesa()){
            setMenordespesaPastelaria(indice);
        }
    }

    /**
     * Método para comparar o lucro da pastelaria referenciado por this com a pastelaria com maior lucro anual
     *  O que tiver maior lucro passará a ter o seu indice do arraylist no atributo maiorlucroPastelaria
     * @param listaempresas arraylist de empresas
     * @param indice indice da pastelaria que vai passar a ser a pastelaria com maior lucro anual
     */
    @Override
    protected void comparamaiorLucro(ArrayList<Empresa> listaempresas,int indice){
        if (this.lucro()>listaempresas.get(getMaiorlucroPastelaria()).lucro()){
            setMaiorlucroPastelaria(indice);
        }
    }

    /**
     * Método para criar a janela de edição de uma empresa caso esta seja uma pastelaria
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
        gravar.addActionListener(new ButtongravarpastelariaListener());

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
        JLabel labelnrmediobolosdia = new JLabel("Número médio de bolos por dia:");
        JLabel labelvmfaturacaoanualbolodia = new JLabel("Valor médio de faturação anual por bolo vendido por dia");
        txtnome = new JTextField(this.nome);
        txtcategoria = new JTextField(this.categoria);
        txtdistrito = new JTextField(this.distrito);
        txtlatitude = new JTextField(this.localizacao.latitude);
        txtlongitude = new JTextField(this.localizacao.longitude);
        txtnrmedioclientesdiario = new JTextField(String.valueOf(this.nrmedioclientesdiario));
        txtnrempregadosmesa = new JTextField(String.valueOf(this.nrempregadosmesa));
        txtcustosalariomedioanual = new JTextField(String.valueOf(this.custosalariomedioanual));
        txtnrmediobolosdia = new JTextField(String.valueOf(this.nrbolosdia));
        txtvmfaturacaoanualbolodia = new JTextField(String.valueOf(this.vmfaturacaoanualbolodia));

        JPanel paneledita = new JPanel();
        paneledita.setLayout(new GridLayout(11, 2));
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
        paneledita.add(labelnrmediobolosdia);
        paneledita.add(txtnrmediobolosdia);
        paneledita.add(labelvmfaturacaoanualbolodia);
        paneledita.add(txtvmfaturacaoanualbolodia);
        paneledita.add(voltar);
        paneledita.add(gravar);

        frameedita.add(paneledita);
        framemenu.setVisible(false);
        frameedita.setVisible(true);
    }
    private class ButtongravarpastelariaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                listaEmpresas.replaceEmpresa(selectedIndex,new Pastelaria(txtcategoria.getText(), txtnome.getText(), txtdistrito.getText(), new Localizacao(txtlatitude.getText(), txtlongitude.getText()), Double.parseDouble(txtnrmedioclientesdiario.getText()), Integer.parseInt(txtnrempregadosmesa.getText()), Double.parseDouble(txtcustosalariomedioanual.getText()), Integer.parseInt(txtnrmediobolosdia.getText()), Double.parseDouble(txtvmfaturacaoanualbolodia.getText())));
                JOptionPane.showMessageDialog(null, "A empresa foi editada com sucesso", "Mensagem", JOptionPane.PLAIN_MESSAGE);
                framemenu.setVisible(true);
                frameedita.setVisible(false);
            }catch (NumberFormatException ex) {
                txtnrmedioclientesdiario.setBackground(Color.red);
                txtnrempregadosmesa.setBackground(Color.red);
                txtcustosalariomedioanual.setBackground(Color.red);
                txtnrmediobolosdia.setBackground(Color.red);
                txtvmfaturacaoanualbolodia.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Os campos tem que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método toString:
     * Retorna a informação da pastelaria
     * @return numero de bolos por dia + valor médio de faturação anual por bolo vendido por dia + despesa + receita + Lucro (Sim ou Nao)
     */

    @Override
    public String toString() {
        return super.toString()+ "Pastelaria{" +
                "nrbolosdia=" + nrbolosdia +
                ", vmfaturacaoanualbolodia=" + vmfaturacaoanualbolodia + ", Despesa= " + this.despesa() + ", Receita=" + this.receita() + ", Lucro= "+this.lucrostring()+
                '}';
    }
}
