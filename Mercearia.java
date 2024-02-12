/**
 * @author Alexandre Ferreira
 * @author Duarte
 */
import javax.swing.*;

/**
 * Subclasse abstrata da classe empresa para definir uma empresa do tipo Mercearia
 */

abstract class Mercearia extends Empresa{
    /**
     * Custo anual de limpeza do estabelecimento
     */
    protected double custoanuallimpeza;
    /**
     * JTextFields que irão receber os valores da empresa escolhida no JList para serem apresentados na frame de edição de uma empresa
     */
    protected JTextField txtcustoanuallimpeza;

    /**
     * Construtor sem parâmetros
     */
    public Mercearia(){}

    /**
     * Construtor da classe Mercearia, recebe dados para a inicialização dos atributos da superclasse e dela própria
     * @param categoria categoria
     * @param nome nome
     * @param distrito distrito
     * @param localizacao localização
     * @param custoanuallimpeza custo anual de limpeza do estabelecimento
     */
    public Mercearia(String categoria,String nome, String distrito, Localizacao localizacao, double custoanuallimpeza){
        super(categoria,nome,distrito,localizacao);
        this.custoanuallimpeza=custoanuallimpeza;
    }

    /**
     * Método para obter o custo anual de limpeza do estabelecimento
     * @return custo anual de limpeza do estabelecimento
     */
    public double getCustoanuallimpeza() {
        return custoanuallimpeza;
    }

    /**
     * Método para definir o custo anual de limpeza do estabelecimento
     * @param custoanuallimpeza custo anual de limpeza do estabelecimento
     */
    public void setCustoanuallimpeza(double custoanuallimpeza) {
        this.custoanuallimpeza = custoanuallimpeza;
    }

    /**
     * Método toString:
     * Retorna a informação de uma empresa pertencente à classe Mercearia
     * @return Custo anual de limpeza
     */

     @Override
     public String toString() {
         return super.toString()+"Mercearia{" +
                 "custoanuallimpeza=" + custoanuallimpeza +
                 '}';
     }
 }
