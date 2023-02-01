public class vaga {
    String endereco;
    String link;
    double area;
    int id;
    String status;
    int ocupacao;

    public vaga(int id, String endereco, double area) {
        this.id = id;
        this.endereco = endereco;
        this.area = area;
        this.link = "https://";
        this.status = "LIVRE";
        this.ocupacao = 0;
    }

    public vaga(int id, String endereco, double area, String link) {
        this.id = id;
        this.endereco = endereco;
        this.area = area;
        this.link = link;
        this.status = "LIVRE";
        this.ocupacao = 0;
    }

    public String toString() {
        return id + " - " + endereco + " - " + link + " - " + status;
    }

    public double getArea() {
        return this.area;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public boolean vagasIguais(String endereco, double area) {
        return this.getArea() == area && this.getEndereco().equals(endereco);
    }

    public void setStatus() {
        if(this.status.equals("LIVRE")) {
            this.status = "OCUPADO";
            this.ocupacao += 1;
        } else {
            this.status = "LIVRE";
        }
    }

    public String getStatus() {
        return this.status;
    }

    public int getocupacao() {
        return this.ocupacao;
    }
}