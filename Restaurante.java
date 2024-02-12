/**
 * @author Alexandre Ferreira
 * @author Duarte
 * @version 1.0
 */
import javax.swing.*;

/**
 * Subclasse abstrata da classe empresa para definir uma empresa do tipo Restaurante
 */
abstract class Restaurante extends Restauracao{
    /**
     * Numero medio de mesas interiores
     */
    protected int nrmesasinteriores;
    /**
     * Numero de dias de funcionamento no ano
     */
    protected int nrdiasfuncionamentoano;
    /**
     * Valor medio da faturaçao das mesas por dia
     */
    protected double vmfaturacaomesadia;
    /**
     * JTextFields que irão receber os valores do numero medio de mesas interiores, numero de dias de funcionamento no ano e do valor medio da faturaçao das mesas por dia
     */
    protected JTextField txtnrmesasinteriores, txtnrdiasfuncionamentoano, txtvmfaturacaomesadia;
    public Restaurante(){}

    /**
     * Construtor da classe Restaurante, recebe dados para a inicialização dos atributos da superclasse e dela própria
     * @param categoria categoria
     * @param nome nome
     * @param distrito distrito
     * @param localizacao localizacao
     * @param nrmedioclientesdiario numero medio de clientes diarios
     * @param nrempregadosmesa numero de empregados de mesa
     * @param custosalariomedioanual custo medio do salario anual
     * @param nrmesasinteriores numero de mesas interiores
     * @param nrdiasfuncionamentoano numero de dias defuncionamento no ano
     * @param vmfaturacaomesadia valor mmedio de faturacao das mesas por dia
     */
    public Restaurante(String categoria,String nome, String distrito, Localizacao localizacao,double nrmedioclientesdiario, int nrempregadosmesa, double custosalariomedioanual, int nrmesasinteriores, int nrdiasfuncionamentoano,double vmfaturacaomesadia){
        super(categoria,nome,distrito,localizacao,nrmedioclientesdiario,nrempregadosmesa,custosalariomedioanual);
        this.nrmesasinteriores=nrmesasinteriores;
        this.nrdiasfuncionamentoano=nrdiasfuncionamentoano;
        this.vmfaturacaomesadia=vmfaturacaomesadia;
    }

    /**
     * Método para obter o numero de mesas interiores
     * @return numero de mesas interiores
     */
    public int getNrmesasinteriores() {
        return nrmesasinteriores;
    }

    /**
     *  Método para defenir o numero de mesas interiores
     * @param nrmesasinteriores numero de mesas interiores
     */
    public void setNrmesasinteriores(int nrmesasinteriores) {
        this.nrmesasinteriores = nrmesasinteriores;
    }

    /**
     * Método para obter o numero de dias de funconamento no ano
     * @return numero de dias de funconamento no ano
     */
    public int getNrdiasfuncionamentoano() {
        return nrdiasfuncionamentoano;
    }

    /**
     * Método para dedfenir o numero de dias de funconamento no ano
     * @param nrdiasfuncionamentoano numero de dias de funconamento no ano
     */
    public void setNrdiasfuncionamentoano(int nrdiasfuncionamentoano) {
        this.nrdiasfuncionamentoano = nrdiasfuncionamentoano;
    }

    /**
     * Método para obter o valor medio de faturacao das mesas por dia
     * @return valor medio de faturacao das mesas por dia
     */
    public double getVmfaturacaomesadia() {
        return vmfaturacaomesadia;
    }

    /**
     * Método para defenir o valor medio de faturacao das mesas por dia
     * @param vmfaturacaomesadia valor medio de faturacao das mesas por dia
     */
    public void setVmfaturacaomesadia(double vmfaturacaomesadia) {
        this.vmfaturacaomesadia = vmfaturacaomesadia;
    }

    /**
     * Método toString:
     * Retorna a informação de uma empresa pertencente à classe Restaurante
     * @return numero de mesas interiores + numero de dias de funcionamento no ano + valor medio de faturacao das mesas por dia
     */
    @Override
    public String toString() {
        return super.toString()+"Restaurante{" +
                "nrmesasinteriores=" + nrmesasinteriores +
                ", nrdiasfuncionamentoano=" + nrdiasfuncionamentoano +
                ", vmfaturacaomesadia=" + vmfaturacaomesadia +
                '}';
    }
}
