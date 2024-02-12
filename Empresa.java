/**
 * @author Alexandre Ferreira
 * @author Duarte Oliveira
 *  @version 1.0
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe abstrata para definir uma empresa
 */
abstract class Empresa implements Serializable {
    /**
     * Categoria da empresa
     */
    protected String categoria;
    /**
     * Nome da empresa
     */
    protected String nome;
    /**
     * Distrito onde a empresa se encontra
     */
    protected String distrito;
    /**
     * Localização da empresa
     */
    protected Localizacao localizacao;
    /**
     * Objeto da classe StarThrive para se conseguir substituir a empresa no arraylist de empresas quando o utilizador edita uma delas
     */
    protected StarThrive listaEmpresas;
    /**
     * Indice selecionado no JList
     */
    protected int selectedIndex;
    /**
     * JFrame para abrir a janela que vai editar a empresa escolhida no JList
     */
    protected JFrame frameedita;
    /**
     * JFrame que irá ser recebido por parâmetro, para se poder manusear a visibilidade da janela que contem o menu
     */
    protected JFrame framemenu;
    /**
     * JFrame que irá ser recebido por parâmetro, para se poder manusear a visibilidade da janela que contem o JList de empresas
     */
    protected JFrame frameinformacoesempresas;
    /**
     * JTextFields que irão receber os valores da empresa escolhida no JList para serem apresentados na frame de edição de uma empresa
     */
    protected JTextField txtnome, txtcategoria, txtdistrito, txtlatitude, txtlongitude;

    /**
     * Construtor sem parâmetros
     */
    public Empresa(){}

    /**
     * Construtor da classe, recebe dados para a inicialização dos atributos
     * @param categoria categoria da empresa
     * @param nome nome da empresa
     * @param distrito distrito onde a empresa se encontra
     * @param localizacao localização da empresa
     */
    public Empresa(String categoria,String nome, String distrito, Localizacao localizacao){
        this.categoria=categoria;
        this.nome=nome;
        this.distrito=distrito;
        this.localizacao=localizacao;
    }

    /**
     * Método para obter a categoria da empresa
     * @return categoria da empresa
     */

    public String getCategoria() {
        return categoria;
    }

    /**
     * Método para definir a categoria da empresa
     * @param categoria categoria da empresa
     */

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Método para obter o nome da empresa
     * @return nome da empresa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para definir o nome da empresa
     * @param nome nome da empresa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para definir o distrito da empresa
     * @return distrito da empresa
     */

    public String getDistrito() {
        return distrito;
    }

    /**
     * Método para obter o distrito de onde a empresa pertence
     * @param distrito  distrito da empresa
     */

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * Método para obter a localização da empresa
     * @return localização da empresa
     */

    public Localizacao getLocalizacao() {

        return localizacao;
    }

    /**
     * Método para definir a localização da empresa
     * @param localizacao localização da empresa
     */
    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Método abstrato para garantir polimorfismo
     * @return despesa
     */
    protected abstract double despesa();
    /**
     * Método abstrato para garantir polimorfismo
     * @return receita
     */
    protected abstract double receita();

    /**
     * Método abstrato para garantir polimorfismo
     * atualiza os atributos estáticos correspondentes a cada categoria de empresa que contenham o indice da empresa com maior receita anual
     * @param listaempresas arraylist de empresas
     * @param indice indice da empresa que vai passar a ser a empresa com maior receita anual
     */
    protected abstract void comparamaiorReceita(ArrayList<Empresa> listaempresas,int indice);

    /**
     * Método abstrato para garantir polimorfismo
     * atualiza os atributos estáticos correspondentes a cada categoria de empresa que contenham o indice da empresa com menor despesa anual
     * @param listaempresas arraylist de empresas
     * @param indice indice da empresa que vai passar a ser a empresa com menor receita anual
     */
    protected abstract void comparamenorDespesa(ArrayList<Empresa> listaempresas,int indice);
    /**
     * Método abstrato para garantir polimorfismo
     * atualiza os atributos estáticos correspondentes a cada categoria de empresa que contenham o indice da empresa com maior lucro anual
     * @param listaempresas arraylist de empresas
     * @param indice indice da empresa que vai passar a ser a empresa com maior lucro anual
     */

    protected abstract void comparamaiorLucro(ArrayList<Empresa> listaempresas,int indice);

    /**
     * Método abstrato para garantir polimorfismo
     * inicializa os atributos, maior receita, menor despesa e maior lucro, pertencentes a cada empresa
     * @param indice indice da empresa inicializadora
     */
    protected abstract void inicializa(int indice);

    /**
     * Método abstrato para garantir polimorfismo
     * Diminui o contador de cada empresa
     */
    protected abstract void diminuicontador();
    /**
     * Método abstrato para garantir polimorfismo
     * Aumenta o contador de cada empresa
     */
    protected abstract void aumentacontador();

    /**
     * Método abstrato para garantir polimorfismo
     * atualiza os atributos estáticos "maiorcapacidadeclientes1" e "maiorcapacidadeclientes2" da classe Restauracao
     * Estes contêm o indice das 2 empresas com maior capacidade de clintes por dia no arraylist de empresas, e assim serão atualizadas
     * @param listaempresas arraylist de empresas
     * @param indicemaior indice da empresa com maior capacidade de clintes por dia até ao momento
     * @param atualizarindice indice da empresa com maior capacidade de clintes que vai substituir
     */
    protected void maisclientesdiario(ArrayList<Empresa> listaempresas,int indicemaior,int atualizarindice){}

    /**
     * Método para obter o número médio de clientes diário
     * @return  número médio de clientes diário
     */
    protected double getNrmedioclientesdiario(){
        return 0;
    }

    /**
     * Método que devolve "Sim" se o lucro for positivo e "Não" se for nulo ou negativo
     * @return string
     */
    protected String lucrostring() {
        if (this.lucro()>0) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    /**
     * Método que calcula o lucro e retorna-o
     * @return lucro
     */
    protected double lucro(){
        return this.receita()-this.despesa();
    }

    /**
     * Método abstrato para garantir polimorfismo
     * Cria a janela correspondente a cada subclasse, destinada à edição da empresa escolhida pelo utilizador
     * @param listaempresas arraylist de empresas
     * @param selectedIndex indice da empresa selecionada no JList
     * @param framemenu frame do menu
     * @param frameinformacoesempresa frame onde se apresenta o JList das informações das empresas todas
     */
    protected abstract void criajanela(StarThrive listaempresas, int selectedIndex, JFrame framemenu, JFrame frameinformacoesempresa);

    /**
     * Classe para o botão voltar em cada janela de edição
     */

    protected class ButtonvoltareditarmenuListener implements ActionListener{
        /**
         * Método para definir o evento que irá ser processado ao ser primido o botão voltar
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            frameinformacoesempresas.setVisible(true);
            frameedita.setVisible(false);
        }
    }

    /**
     * Método toString:
     * Retorna a informação da empresa
     * @return categoria + nome + distrito + localização
     */
    @Override
    public String toString() {
        return "Empresa{" +
                "categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", distrito='" + distrito + '\'' +
                ", localizacao=" + localizacao +
                '}';
    }
}
