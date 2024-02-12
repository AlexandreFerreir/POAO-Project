/**
 * @author Alexandre Ferreira
 * @author Duarte
 * @version 1.0
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe para a gestão de empresas da empresa StarThrive
 */
public class StarThrive implements Serializable {
    /**
     * Arraylist que contém todas as empresas da StarThrive
     */
    protected ArrayList<Empresa> listaempresas;
    protected Ficheiro ficheiro;

    /**
     * Construtor da classe sem parâmetros, inicializa o atributo
     */
    public StarThrive() {
        this.listaempresas = new ArrayList<>();
        ficheiro=new Ficheiro();
    }

    /**
     * Método para adicionar uma empresa ao arraylist de empresas
     * @param empresa empresa a adicionar
     */

    protected void adicionarEmpresa(Empresa empresa) {
        this.listaempresas.add(empresa);
        empresa.aumentacontador();
        ficheiro.gravarFicObjeto(this.listaempresas,"starthrive.dat");
    }

    /**
     * Método para remover uma empresa ao arraylist de empresas
     * @param empresa empresa a remover
     */
    protected void apagarEmpresa(Empresa empresa) {
        this.listaempresas.remove(empresa);
        empresa.diminuicontador();
        ficheiro.gravarFicObjeto(this.listaempresas,"starthrive.dat");
    }

    /**
     * Método para substituir a empresa da posição dada por indice por outra empresa
     * @param indice indice da empresa a ser substituida
     * @param empresa empresa que substitui
     */
    protected void replaceEmpresa(int indice,Empresa empresa){
        this.listaempresas.set(indice,empresa);
        ficheiro.gravarFicObjeto(this.listaempresas,"starthrive.dat");
    }

    /**
     * Método para inicializar os atributos estáticos de cada categoria de empresa
     */

    protected void inicializar() {
        for (int i = 0; i < this.listaempresas.size(); i++) {
            this.listaempresas.get(i).inicializa(i);
        }
    }

    /**
     * Método que percorre o arraylist de empresas e atualiza os atributos estáticos correspondentes a cada categoria de empresa que contenham o indice da empresa com maior receita anual
     */
    protected void atualizaMaiorReceita() {
        inicializar();
        for (int i = 0; i < this.listaempresas.size(); i++) {
            this.listaempresas.get(i).comparamaiorReceita(this.listaempresas, i);
        }
    }
    /**
     * Método que percorre o arraylist de empresas e atualiza os atributos estáticos correspondentes a cada categoria de empresa que contenham o indice da empresa com menor despesa anual
     */
    protected void atualizaMenorDespesa() {
        inicializar();
        for (int i = 0; i < this.listaempresas.size(); i++) {
            this.listaempresas.get(i).comparamenorDespesa(this.listaempresas, i);
        }
    }
    /**
     * Método que percorre o arraylist de empresas e atualiza os atributos estáticos correspondentes a cada categoria de empresa que contenham o indice da empresa com maior lucro anual
     */
    protected void atualizaMaiorLucro() {
        inicializar();
        for (int i = 0; i < this.listaempresas.size(); i++) {
            this.listaempresas.get(i).comparamaiorLucro(this.listaempresas, i);
        }
    }

    /**
     * Método que percorre o arraylist de empresas e atualiza os atributos estáticos "maiorcapacidadeclientes1" e "maiorcapacidadeclientes2" da classe Restauracao
     */
    protected void maisclientesdiarioRestauracao() {
        inicializar();
        for (int i = 0; i < this.listaempresas.size(); i++) {
            this.listaempresas.get(i).maisclientesdiario(this.listaempresas, Restauracao.getMaiorcapacidadeclientes1(), i);
        }
        for (int i = 0; i < this.listaempresas.size(); i++) {
            if (this.listaempresas.get(i) != this.listaempresas.get(Restauracao.getMaiorcapacidadeclientes1())) {
                this.listaempresas.get(i).maisclientesdiario(this.listaempresas, Restauracao.getMaiorcapacidadeclientes2(), i);
            }
        }
    }

    /**
     * Método main:
     * Cria uma janela e iniciliza-a, para que o utilizador tenha interação com a aplicação através do JFrames
     * @param args argumentos
     */
    public static void main(String[] args) {
        Janela janela=new Janela();
    }
}