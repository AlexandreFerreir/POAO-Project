/**
 * @author Alexandre Ferreira
 * @version 1.0
 */

/**
 * Classe para definir um horário
 */
public class Horario {
    /**
     * Dia, mês, ano, hora e minutos do horário
     */
    protected String dia,mes,ano,hora,minutos;

    /**
     * Construtor sem parâmetros
     */
    public Horario(){}

    /**
     * Construtor da classe, recebe dados para a inicialização dos atributos
     * @param dia Dia do horário
     * @param mes Mes do horário
     * @param ano Ano do horário
     * @param hora Hora do horário
     * @param minutos Minutos do horário
     */

    public Horario(String dia,String mes,String ano,String hora, String minutos){
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
        this.hora=hora;
        this.minutos=minutos;
    }

    /**
     * Método para obter o dia do horário
     * @return Dia do horário
     */
    public String getDia() {
        return dia;
    }

    /**
     * Método para definir o dia do horário
     * @param dia Dia do horário
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Método para obter o mês do horário
     * @return Mês do horário
     */
    public String getMes() {
        return mes;
    }

    /**
     * Método para definir o mês do horário
     * @param mes Mês do horário
     */

    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * Método para obter o ano do horário
     * @return Ano do horário
     */

    public String getAno() {
        return ano;
    }

    /**
     * Método para definir o ano do horário
     * @param ano Ano do horário
     */

    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * Método para obter a hora do horário
     * @return Hora do horário
     */

    public String getHora() {
        return hora;
    }

    /**
     * Método para definir a hora do horário
     * @param hora Hora do horário
     */

    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Método para obter os minutos do horário
     * @return Minutos do horário
     */

    public String getMinutos() {
        return minutos;
    }

    /**
     * Método para definir os minutos do horário
     * @param minutos Minutos do horário
     */

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    /**
     * Método toString:
     * Imprime a informação do horário no ecrã
     * @return Dia + Mês + Ano + Hora + Minutos
     */
    @Override
    public String toString(){
        return this.getDia() + "/" + this.getMes() + "/" + this.getAno() + " às "+ this.getHora()+":"+this.getMinutos();
    }
}
