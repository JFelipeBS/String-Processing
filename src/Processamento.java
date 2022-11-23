
public class Processamento {

    public void forcaBruta(String fraseTeste, String palavraTeste) {

        int numeroDeComparacoes = 0;
        int numeroDeOcorrencias = 0;
        int numTotalDeComparaçoes = 0;
        String palavraretorno = "";
        for (int i = 0; i < fraseTeste.length(); i++) {
            String palavraTestada = "";

            int temp = i;
            for (int j = 0; j < palavraTeste.length(); j++) {

                numeroDeComparacoes++;
                if (fraseTeste.charAt(temp) != palavraTeste.charAt(j)) {
                    break;
                } else {
                    palavraTestada += fraseTeste.charAt(temp);

                    if (temp < fraseTeste.length() - 1) {
                        temp++;
                    }

                }

                if (palavraTestada.length() == palavraTeste.length()) {
                    numeroDeOcorrencias++;

                    System.out.println("Ocorrencia " + numeroDeOcorrencias + " foram necessaria " + numeroDeComparacoes
                            + " compraçoes" + " Palavrea " + palavraTestada);

                    numTotalDeComparaçoes += numeroDeComparacoes;
                    numeroDeComparacoes = 0;
                    palavraretorno = palavraTestada;

                    break;
                }

            }

        }

        System.out.println();
        System.out.println("Resumo Geral");
        System.out.println("----------------");
        System.out.println("A palavra " + palavraretorno +
                " foi encontrada " + numeroDeOcorrencias + " vezes" +
                " com um numero de comparação total de " + numTotalDeComparaçoes);
        System.out.println("----------------");
        System.out.println();

    }

    public void KMP(String fraseTeste, String Palavrateste) {

        int[] tabelaPrefixo = tabelaPrefixos(Palavrateste);
        int numeroDeComparacoes = 0;
        int numeroDeOcorrencias = 0;
        int numTotalDeComparaçoes = 0;

        int auxiliar = 0;
        int index = 0;
        String palavraTestada = "";
        String palavraRetorno = "";


        while (index < fraseTeste.length()) {

            if (fraseTeste.charAt(index) == Palavrateste.charAt(auxiliar)) {

                palavraTestada += fraseTeste.charAt(index);

                numeroDeComparacoes++;
                index++;
                auxiliar++;

            } else {
                palavraTestada = "";
            }

            // verifica se apavra foi encontrada
            if (Palavrateste.length() == auxiliar) {
                numeroDeOcorrencias++;

                System.out.println("Ocorrencia " + numeroDeOcorrencias + " foram necessaria " + numeroDeComparacoes
                        + " compraçoes" + " Palavrea " + palavraTestada);

                palavraRetorno = palavraTestada;
                numTotalDeComparaçoes += numeroDeComparacoes;
                numeroDeComparacoes = 0;
                // modifica auxiliar
                auxiliar = tabelaPrefixo[auxiliar - 1];
            } else {

                if (index < fraseTeste.length() && Palavrateste.charAt(auxiliar) != fraseTeste.charAt(index)) {
                    numeroDeComparacoes++;
                    // modifica auxiliar
                    if (auxiliar != 0) {
                        auxiliar = tabelaPrefixo[auxiliar - 1];
                    } else {
                        index++;
                    }
                }

            }

        }

        System.out.println();
        System.out.println("Resumo Geral");
        System.out.println("----------------");
        System.out.println("A palavra " + palavraRetorno +
                " foi encontrada " + numeroDeOcorrencias + " vezes" +
                " com um numero de comparação total de " + numTotalDeComparaçoes);
        System.out.println("----------------");
        System.out.println();

    }

    public int[] tabelaPrefixos(String padrao) {

        int tamPrefixo = 0;
        int[] tabelaPrefixo = new int[padrao.length()];

        tabelaPrefixo[0] = 0; // inicia sempre em zero
        int i = 1;

        while (i < padrao.length()) {

            if (padrao.charAt(i) == padrao.charAt(tamPrefixo)) {
                tamPrefixo++;
                tabelaPrefixo[i] = tamPrefixo;
                i++;
            } else { // padrao diferente

                if (tamPrefixo != 0) {
                    tamPrefixo = tabelaPrefixo[tamPrefixo - 1];

                } else { // tamprefixo == 0
                    tabelaPrefixo[i] = tamPrefixo;
                    i++;
                }

            }

        }

        return tabelaPrefixo;

    }

}