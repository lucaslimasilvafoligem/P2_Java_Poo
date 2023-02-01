package src;
/**
 * Class que representa uma vaga do estacionamento
 * 
 * @author Hernandes Matheus da Silva
 *
 */
public class Vaga {
    private static final  int VALOR_PADRAO = 3; 
    private String endereco;
    private String linkGoogleMaps;
    private double area;
    private boolean livre;
    private int quantidadeDeVezesOcupada;

    public Vaga(String endereco, double area){
        this(endereco, "", area);
    }

    public Vaga(String endereco,String link,  double area){
        this.linkGoogleMaps ="https://"+link;
        this.endereco = endereco;
        this.area = area;
        this.quantidadeDeVezesOcupada = 0;
        this.livre = true;
    }

    @Override
    public String toString() {
        String status  = livre? "LIVRE": "OCUPADA";
        return endereco+" - "+linkGoogleMaps+" - "+status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        final Vaga other = (Vaga) obj;
        if(!this.endereco.equals(other.endereco)) return false;
        if(!(this.area == other.area)) return false;
        return true;
    }

    public boolean getLivre(){
        return livre;
    }
    
    public void mudarStatus(){
        if(!livre) quantidadeDeVezesOcupada ++;
        livre = !livre;
    }

    public int getQuantidadeDeVezesOcupada(){
        return quantidadeDeVezesOcupada;
    }

    public double simularPreco(int horasGasta){
        return (horasGasta * VALOR_PADRAO + 0.1*area);
    }



}
