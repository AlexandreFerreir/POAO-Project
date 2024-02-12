/**
 * @author Alexandre Ferreira
 * @author Duarte Oliveira
 *  @version 1.0
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Classe para implementar métodos relacionados com ficheiros
 */

public class Ficheiro {
    /**
     * metodo para inicializar os dados dos ficheiros
     * @param ficObj endereco de ficheiro objeto
     * @param ficTxt endereco de ficheiro txt
     * @return array com os dados
     */
    public ArrayList<Empresa> carregaDados(StarThrive gestoraempresas,String ficObj,String ficTxt){
        ArrayList<Empresa> array;
        if(!(new File(ficObj)).exists()){
            System.out.println("Ficheiro objeto nao encontrado, carregando ficheiro de texto");
            String conteudo = Read(ficTxt);
            array = converteEmpresa(gestoraempresas,conteudo);
            gravarFicObjeto(array,"starthrive.dat");
        }else {
            System.out.println("Ficheiro objeto encontrado.");
            array = lerFicObjeto(gestoraempresas,ficObj);
        }
        return array;
    }

    /**
     * metodo para converter os dados do txt de string para a estrutura da classe
     *
     * @param conteudo string com os dados do txt
     * @return array com os dados
     */
    public ArrayList<Empresa> converteEmpresa(StarThrive gestoraempresas,String conteudo){
        ArrayList<Empresa> array;
        String[] arrayaux=conteudo.split("[;\n]");
        for(int i=0;i<arrayaux.length;i=i+11){
            if(arrayaux[i].equalsIgnoreCase("Cafe")){
                Localizacao localizacao= new Localizacao(arrayaux[i+4],arrayaux[i+5]);
                gestoraempresas.adicionarEmpresa( new Cafe(arrayaux[i+1],arrayaux[i+2],arrayaux[i+3],localizacao,Integer.parseInt(arrayaux[i+6]),Integer.parseInt(arrayaux[i+7]),Double.parseDouble(arrayaux[i+8]),Integer.parseInt(arrayaux[i+9]),Double.parseDouble(arrayaux[i+10])));
            } else if (arrayaux[i].equalsIgnoreCase("Pastelaria")) {
                Localizacao localizacao= new Localizacao(arrayaux[i+4],arrayaux[i+5]);
                gestoraempresas.adicionarEmpresa(new Pastelaria(arrayaux[i+1],arrayaux[i+2],arrayaux[i+3],localizacao,Integer.parseInt(arrayaux[i+6]),Integer.parseInt(arrayaux[i+7]),Double.parseDouble(arrayaux[i+8]),Integer.parseInt(arrayaux[i+9]),Double.parseDouble(arrayaux[i+10])));
            } else if (arrayaux[i].equalsIgnoreCase("Frutaria")) {
                Localizacao localizacao= new Localizacao(arrayaux[i+4],arrayaux[i+5]);
                gestoraempresas.adicionarEmpresa(new Frutaria(arrayaux[i+1],arrayaux[i+2],arrayaux[i+3],localizacao,Double.parseDouble(arrayaux[i+6]),Integer.parseInt(arrayaux[i+7]),Double.parseDouble(arrayaux[i+8])));
                i=i-2;
            } else if (arrayaux[i].equalsIgnoreCase("Mercado")) {
                Localizacao localizacao= new Localizacao(arrayaux[i+4],arrayaux[i+5]);
                gestoraempresas.adicionarEmpresa(new Mercado(arrayaux[i+1],arrayaux[i+2],arrayaux[i+3],localizacao,Double.parseDouble(arrayaux[i+6]),arrayaux[i+7],Double.parseDouble(arrayaux[i+8]),Double.parseDouble(arrayaux[i+9])));
                i=i-1;
            } else if (arrayaux[i].equalsIgnoreCase("RestauranteFastfood")) {
                Localizacao localizacao= new Localizacao(arrayaux[i+4],arrayaux[i+5]);
                gestoraempresas.adicionarEmpresa(new RestauranteFastfood(arrayaux[i+1],arrayaux[i+2],arrayaux[i+3],localizacao,Integer.parseInt(arrayaux[i+6]),Integer.parseInt(arrayaux[i+7]),Double.parseDouble(arrayaux[i+8]),Integer.parseInt(arrayaux[i+9]),Integer.parseInt(arrayaux[i+10]),Double.parseDouble(arrayaux[i+11]),Integer.parseInt(arrayaux[i+12]),Double.parseDouble(arrayaux[i+13])));
                i=i+3;
            } else if (arrayaux[i].equalsIgnoreCase("RestauranteLocal")) {
                Localizacao localizacao= new Localizacao(arrayaux[i+4],arrayaux[i+5]);
                gestoraempresas.adicionarEmpresa(new RestauranteLocal(arrayaux[i+1],arrayaux[i+2],arrayaux[i+3],localizacao,Integer.parseInt(arrayaux[i+6]),Integer.parseInt(arrayaux[i+7]),Double.parseDouble(arrayaux[i+8]),Integer.parseInt(arrayaux[i+9]),Integer.parseInt(arrayaux[i+10]),Double.parseDouble(arrayaux[i+11]),Integer.parseInt(arrayaux[i+12]),Double.parseDouble(arrayaux[i+13])));
                i=i+3;
            }
        }
        array=gestoraempresas.listaempresas;
        return array;
    }

    /**
     * metodo para leitura de txt
     * @param ficTxt endereco de txt
     * @return string com os dados do txt
     */
    public String Read(String ficTxt) {
        StringBuilder conteudo = new StringBuilder();
        try {
            FileReader arq = new FileReader(ficTxt);
            BufferedReader lerArq = new BufferedReader(arq);
            try {
                String linha = lerArq.readLine();
                while (linha != null) {
                    conteudo.append(linha).append("\n");
                    linha = lerArq.readLine();
                }
                arq.close();
                System.out.println("Leu ficheiro");
                return conteudo.toString();
            } catch (IOException ex) {
                System.out.println("Erro: Nao foi possivel ler ficheiro\n");
                return "erro";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: ficheiro nao encontrado\n");
            return "erro";
        }

    }

    /**
     * metodo para escrever em ficheiro objeto
     * @param array array com os dados a serem guardados
     * @param ficObj enderenco do ficheiro objeto
     */
    public void gravarFicObjeto(ArrayList<Empresa> array, String ficObj){
        File arq = new File(ficObj);
        try{
            arq.delete();
            arq.createNewFile();
            ObjectOutputStream gravarArq = new ObjectOutputStream(new FileOutputStream(arq));
            gravarArq.writeObject(array);
            gravarArq.close();
        }catch(IOException erro){
            System.out.printf("Erro: %s",erro.getMessage());
        }
    }

    /**
     * metodo para ler ficheiro obj
     *
     * @param ficObj endereco do ficheiro obj
     * @return array com os dados do ficheiro obj
     */

    public ArrayList<Empresa> lerFicObjeto(StarThrive gestoraempresas,String ficObj){
        ArrayList<Empresa> array = new ArrayList<>();
        try{
            File arq = new File(ficObj);
            if (arq.exists()){
                ObjectInputStream lerArq = new ObjectInputStream(new FileInputStream(arq));
                array = (ArrayList<Empresa>) lerArq.readObject();
                lerArq.close();
            }
        }catch (IOException e1){
            System.out.printf("Erro: %s",e1.getMessage());
        }catch (ClassNotFoundException e2){
            System.out.printf("Erro: %s",e2.getMessage());
        }
        return array;
    }
}