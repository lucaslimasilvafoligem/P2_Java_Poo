public class Dog {
    private String dognome;
    private String tutor;
    private int qtdDiariaRacao;
    private String dog;
    private String restricaoAlimentar;

    public Dog(String nomeDog, String tutorDog, int qtdDiariaRacaoDog, String restricaoAlimentarDog) {
        this.dognome = nomeDog;
        this.tutor = tutorDog;
        this.qtdDiariaRacao = qtdDiariaRacaoDog;
        this.restricaoAlimentar = restricaoAlimentarDog;
        if(restricaoAlimentar != "") {
            qtdDiariaRacao = qtdDiariaRacao * 2;
        }
        dog = "Dog [nome=" + dognome + ", tutor=" + tutor + "]";
    }    

    public String toString() {
        return dog;        
    }

    public boolean verificaDogs(String dogComparativo) {
        return this.dog.equals(dogComparativo.toString());
    }
    
    public int getqtdDiariaRacao() {
        return qtdDiariaRacao;
    }

    public String getNomeDog() {
        return dognome;
    }
}
