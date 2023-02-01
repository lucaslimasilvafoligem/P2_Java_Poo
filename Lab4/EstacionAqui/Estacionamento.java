public class Estacionamento {
    vaga vagas[];
    Comentario comentarios[];
    int totalDeVagasDisponivel;
    int totalDeComentariosDisponivel;
    double precoVaga;

    public Estacionamento() {
        totalDeVagasDisponivel = 100;
        totalDeComentariosDisponivel = 5;
        vagas = new vaga[totalDeVagasDisponivel];
        comentarios = new Comentario[totalDeComentariosDisponivel];
        precoVaga = 3;
    }

    public void cadastraVagas(int posicao, String endereco, double area) {
        if(vagasIguais(endereco, area)) {
            System.out.println("Essa vaga já foi cadastrada");
        }
        vagas[posicao] = new vaga(posicao, endereco, area);
    }

    public void cadastraVagas(int posicao, String endereco, double area, String link) {
        if(vagasIguais(endereco, area)) {
            System.out.println("Essa vaga já foi cadastrada");
        }
        vagas[posicao] = new vaga(posicao, endereco, area, link);
    }

    public boolean vagasIguais(String endereco, double area) {
        for (int i = 0; i < vagas.length; i++) {
            if(vagas[i] != null) {
                if(vagas[i].vagasIguais(endereco, area)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void setStatus(int posicao) {
        vagas[posicao].setStatus();
    }

    public double simulaPreco(int posicao, int horasUso) {
        if(posicao < 0 && posicao > 99 && horasUso < 0) {
            System.out.println("Parametro invalido");
        }
        return vagas[posicao].getArea() * precoVaga;
    }

	public int vagasAtivas() {
        int vagasAtivas = 0;
        for (int w = 0; w < vagas.length; w++) {
            if(vagas[w] != null) {
                vagasAtivas += 1;
            }
        }
        return vagasAtivas;
    }

    public int vagasLivres() {
        for (int x = 0; x < vagas.length; x++) {
            if(vagas[x] != null) {
                if(vagas[x].getStatus().equals("LIVRE")) {
                    return x;
                }
            }
        }
        return -1;
    }

    public int vagasLivres(String endereco, double area) {
        for (int x = 0; x < vagas.length; x++) {
            if(vagas[x] != null) {
                if(vagas[x].getEndereco().equals(endereco) && vagas[x].getArea() == area && vagas[x].getStatus().equals("LIVRE")) {
                    return x;
                }
            }
        }
        return -1;
    }

    public String relatorioVagas() {
        String usoDeVagas =  "RELATORIO\n";
        for (int y = 0; y < vagas.length; y++) {
            if(vagas[y] != null) {
                usoDeVagas = "Vaga " + y +" - " + vagas[y].getocupacao() + "\n";
            }
        }
        return usoDeVagas;
    }

    public String listarVagasAtivas() {
        String vagasAtivas = "";
        for (int z = 0; z < vagas.length; z++) {
            if(vagas[z] != null) {
                vagasAtivas += z + " - " + vagas[z].toString() + "\n";
            }
        }
        return vagasAtivas;
    }

    public void adicionaComentario(String comentario) {
        String[] arrayComentario = comentario.split("”");
        arrayComentario[0].replace("“", "");
        arrayComentario[1].replace(" “", "");
        Comentario oComentario;
        if(arrayComentario.length == 2) {
            oComentario = new Comentario(arrayComentario[0], arrayComentario[1]);
        } else {
            oComentario = new Comentario(arrayComentario[0]);
        }
        for (int a = 0; a < comentarios.length; a++) {
            if(comentarios[a] == null) {
                comentarios[a] = oComentario;
                return;  
            }
        }
        
        for (int b = 4; b < comentarios.length;) {
            comentarios[b + 1] = comentarios[b];
            b -= 1;
            if(b == 0) {
                break;
            }
        }
        comentarios[0] = oComentario;
    }

}