/**
 * @author Alexandre Ferreira
 * @author Duarte
 * @version 1.0
 */
import java.io.Serializable;

/**
 * Classe para definir uma localização
 */

class Localizacao implements Serializable {
    /**
     * Latitude da localização
     */
    protected String latitude;
    /**
     * Longitude da localização
     */
    protected String longitude;

    /**
     * Construtor sem parâmetros
     */

    public Localizacao(){}

    /**
     * Construtor da classe Cafe, recebe dados para a inicialização dos atributos
     * @param latitude latitude
     * @param longitude longitude
     */
    public Localizacao(String latitude,String longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }

    /**
     * Método para obter a latitude da localização
     * @return latitude da localização
     */

    public String getLatitude() {
        return latitude;
    }

    /**
     * Método para obter a longitude da localização
     * @return longitude da localização
     */

    public String getLongitude() {
        return longitude;
    }

    /**
     * Método para definir a latitude da localização
     * @param latitude latitude da localização
     */

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Método para definir a longitude da localização
     * @param longitude longitude da localização
     */

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     *  Método toString:
     *  Retorna a informação da localização
     * @return latitude + longitude
     */
    @Override
    public String toString(){
        return this.latitude+", "+this.longitude;
    }
}
