/**
 * @author Alexandre Ferreira
 * @version 1.0
 */

/**
 * Classe para definir um professor
 */
public class Professor{
    /**
     * Nome e endereço de correio eletrónico do professor
     */
    protected String nome, enderecoeletronico;

    /**
     * Construtor sem parâmetros
     */
    public Professor(){}

    /**
     * Construtor da classe, recebe dados para a inicialização dos atributos
     * @param nome Nome do professor
     * @param enderecoeletronico Endereço de correio eletrónico do professor
     */
    public Professor(String nome, String enderecoeletronico){
        this.nome=nome;
        this.enderecoeletronico=enderecoeletronico;
    }

    /**
     * Método para obter o endereço de correio eletrónico do professor
     * @return Endereço de correio eletrónico do professor
     */

    public String getEnderecoeletronico() {
        return this.enderecoeletronico;
    }

    /**
     * Método para definir o endereço de correio eletrónico do professor
     * @param enderecoeletronico Endereço de correio eletrónico do professor
     */

    public void setEnderecoeletronico(String enderecoeletronico) {
        this.enderecoeletronico = enderecoeletronico;
    }

    /**
     * Método para obter o nome do professor
     * @return Nome do professor
     */

    public String getNome() {
        return this.nome;
    }

    /**
     * Método para definir o nome do professor
     * @param nome Nome do professor
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método toString:
     * Imprime a informação do professor no ecrã
     * @return Nome + Endereço de correio eletrónico
     */
    @Override
    public String toString(){
        return this.getNome() + " (endereço de correio eletrónico: "+this.getEnderecoeletronico()+") ";
    }
}
