/**
 * @author Alexandre Ferreira
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe para a gestão de aulas de um ginásio
 */
public class Ginasio {
    /**
     * ArrayList que contém todas as aulas do ginásio
     */
    private final ArrayList<Aula> aulas;

    /**
     * Construtor da classe sem parâmetros, inicializa o atributo
     */

    public Ginasio(){
        this.aulas=new ArrayList<>();
    }
    /**
     * Método para adicionar aulas ao ginásio
     */
    public void adicionaAula(){
        this.aulas.add(new AulasIndividuais(false, new Professor("João","professorjoao@gym.com"),new Horario("3","11","2022","14","00"),60,30));
        this.aulas.add(new AulasIndividuais(true, new Professor("Augusto","professoraugusto@gym.com"),new Horario("4","11","2022","15","45"),60,6));
        this.aulas.add(new AulasIndividuais(true, new Professor("Manuel","professormanuel@gym.com"),new Horario("5","11","2022","14","15"),90,12));
        this.aulas.add(new AulasIndividuais(true, new Professor("Zé","professorze@gym.com"),new Horario("6","11","2022","14","30"),60,15));
        this.aulas.add(new AulasIndividuais(true, new Professor("José","professorjose@gym.com"),new Horario("7","11","2022","14","30"),60,10));
        this.aulas.add(new AulasdeGrupo(true,new Professor("Augusto","professoraugusto@gym.com"),new Horario("3","11","2022","16","30"),90,"Cardio",15));
        this.aulas.add(new AulasdeGrupo(true,new Professor("José","professorjose@gym.com"),new Horario("4","11","2022","17","30"),90,"Pilates",20));
        this.aulas.add(new AulasdeGrupo(true,new Professor("Manuel","professormanuel@gym.com"),new Horario("5","11","2022","16","00"),90,"Yoga",8));
        this.aulas.add(new AulasdeGrupo(true,new Professor("João","professorjoao@gym.com"),new Horario("6","11","2022","16","30"),90,"Zumba",4));
        this.aulas.add(new AulasdeGrupo(true,new Professor("Zé","professorze@gym.com"),new Horario("7","11","2022","17","30"),90,"Cycling",16));
    }

    /**
     * Método que imprime toda a informação de cada aula pertencente ao ginásio no ecrã
     */
    public void imprimeAulas(){
        if (this.aulas.isEmpty()){
            System.out.println("Não existe nenhuma aula marcada.");
        }
        else{
            for (Aula aula: this.aulas) {
                System.out.println(aula);
            }
        }
    }
    /**
     *Método que imprime toda a informação de cada aula cancelada pertencente ao ginásio no ecrã
     */
    public void imprimeCanceladas(){
        int contador=0;
        if (this.aulas.isEmpty()){
            System.out.println("Não existe nenhuma aula.");
        }
        else{
            for (Aula aula: this.aulas) {
                if (!(aula.getEstado())) {
                    System.out.println(aula);
                    contador++;
                }
            }
            if(contador==0){
                System.out.println("Não existem aulas canceladas.");
            }
        }
    }

    /**
     * Imprime a modalidade e horário das aulas de grupo com número máximo de alunos inferior a 10 e a informação das aulas individuais com um custo superior a 20 euros no ecrã, chamando os métodos das respetivas classes
     */
    public void imprimeAulasCondicao(){
        int contadorAG=0;
        int contadorAI=0;
        if (this.aulas.isEmpty()){
            System.out.println("Não existe nenhuma aula.");
        }
        else{
            for (Aula aula: this.aulas) {
                if (aula.identificacao()==1){
                    contadorAI+= aula.informacao();
                } else if (aula.identificacao()==0){
                    contadorAG+= aula.informacao();
                }
            }
            if(contadorAI==0){
                System.out.println("Não existem aulas individuais com um custo superior a 20 euros");
            }
            if(contadorAG==0){
                System.out.println("Não existem aulas de grupo com número máximo de alunos inferior a 10");
            }
        }
    }
    /**
     * Método main:
     * Cria um ginásio e inicializa-o.
     * Disponibiliza um menu com todos os métodos da classe para o utilizador.
     * @param args argumentos
     */
    public static void main(String[] args) {
        int opcao;
        Scanner sc=new Scanner(System.in);
        Ginasio ginasio=new Ginasio();
        do{
            System.out.println("--------Menu--------");
            System.out.println("0 - Sair");
            System.out.println("1 - Adicionar aulas");
            System.out.println("2 - Imprimir todas as aulas");
            System.out.println("3 - Imprimir todas as aulas que foram canceladas");
            System.out.println("4 - Imprimir a modalidade e horário das aulas de grupo com número máximo de alunos inferior a 10 e a informação das aulas individuais com um custo superior a 20 euros");
            System.out.println("Escolha a sua opcao:");
            opcao=sc.nextInt();
            switch (opcao) {
                case 0 -> System.out.println("FIM");
                case 1 -> ginasio.adicionaAula();
                case 2 -> ginasio.imprimeAulas();
                case 3 -> ginasio.imprimeCanceladas();
                case 4 -> ginasio.imprimeAulasCondicao();
                default -> System.out.println("Opcao inválida.Tente novamente.");
            }
        }while (opcao!=0);
    }
}