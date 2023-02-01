public class DogHost {
    private String anfitriao;
    private int qtdMaximaCaes;
    private int qtdMaximaRacao;
    private String tipoRestricaoAlimentar;
    private String[] listaDogs;
    private int[] listaGastosRacao;
    private double[] listaDespesas;
    private int casaDogs;


    public DogHost(String anfitriaoCasa, int qtdDiariaRacaoAnfitriao, int qtdMaximaVagasCaes) {
        this.anfitriao = anfitriaoCasa;
        this.qtdMaximaRacao = qtdDiariaRacaoAnfitriao;
        this.qtdMaximaCaes = qtdMaximaVagasCaes;
        this.listaDogs = new String[qtdMaximaVagasCaes];
        this.listaGastosRacao = new int[qtdMaximaVagasCaes];
        this.listaDespesas = new double[qtdMaximaVagasCaes];
        this.casaDogs = 0;
        
    }

    public boolean adicionaDog(String nome, String tutor, int qtdRacao) {
        casaDogs += 1;
        if(casaDogs <= qtdMaximaCaes) {
            tipoRestricaoAlimentar = "";
            qtdMaximaRacao -= qtdRacao;
            if(qtdMaximaRacao < 0) {
                qtdMaximaRacao += qtdRacao;
                casaDogs -= 1;
                return false;
            }
            Dog cao = new Dog( nome, tutor, qtdRacao, tipoRestricaoAlimentar);
            for(int x = 0; x < listaDogs.length; x ++) {
                if(listaDogs[x] == null) {
                    listaDogs[x] = cao.toString();
                    listaGastosRacao[x] = qtdRacao;
                    listaDespesas[x]= consultaValorHospedagem(cao, 1);
                    return true;
                }
            }
        } else {
            casaDogs -= 1;
            return false;
        }
        return false;
    }

    public boolean adicionaDog(String nome, String tutor, int qtdRacao, String tipoRestricao) {
        casaDogs += 1;
        if(casaDogs <= qtdMaximaCaes) {
            tipoRestricaoAlimentar = tipoRestricao;
            qtdMaximaRacao -= qtdRacao;
            if(qtdMaximaRacao < 0) {
                qtdMaximaRacao += qtdRacao;
                casaDogs -= 1;
                return false;
            }
            Dog cao = new Dog( nome, tutor, qtdRacao, tipoRestricaoAlimentar);
            for(int x = 0; x < listaDogs.length; x ++) {
                if(listaDogs[x] == null) {
                    listaDogs[x] = cao.toString();
                    listaGastosRacao[x] = qtdRacao;
                    listaDespesas[x]= consultaValorHospedagem(cao, 1);
                    return true;
                }
            }
        } else {
            casaDogs -= 1;
            return false;
        }
        return false;
    }
    
    public String listaDogs() {
        String lista = anfitriao + ":\n";
        for(int i = 0; i < listaDogs.length; i++) {
            if(listaDogs[i] != null) {
                lista += listaDogs[i] + "\n";
            }
        }
        return lista;
    }

    public double consultaValorHospedagem(Dog toto, int dias) {
        int qtdComida = toto.getqtdDiariaRacao();
        double despesa = (qtdComida * 0.4) + (dias * 40.0);
        return despesa;
    }
}