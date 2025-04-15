//import java.util.Scanner;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Date;


public class app { // Classe principal que estende a classe criarConta
    public static void main(String[] args) {
        
        String destinatario = "Sujeito qualquer"; // Nome do destinatário que será usado para esse projeto
        int saldo = 1000; // Saldo inicial da conta
        HashMap<Integer,transacoes> movimentacao = new HashMap<Integer, transacoes>(); // Cria um novo mapa para armazenar as movimentações
        Date data = Calendar.getInstance().getTime(); // Obtém a data atual
        System.out.println("Criando conta exemplo... \n");
        conta novaConta = new conta("Elon Moska","54321", saldo, null); // Cria uma nova conta com os dados fornecidos

        /*Exemplo 1*/
        int valorEntrada = 500; // Variável para armazenar o valor da entrada
        movimentacao.put(conta.getId(), new pix_debito(conta.getId(), novaConta.getTitular(), destinatario, novaConta.getNumeroConta(), valorEntrada, "entrada", data, false,"Salário","PIX")); // Adiciona a movimentação de entrada ao mapa
        novaConta.setMovimentacoes(movimentacao); // Registra a entrada na conta
        saldo = novaConta.calculaSaldo(novaConta.getSaldo()); // Calcula o saldo da conta
        /*Exemplo 2*/ 
        int valorSaida = 200; // Variável para armazenar o valor da saída 
        int parcelas = 4; // Variável para armazenar o número de parcelas
        movimentacao.put(conta.getId(), new credito(conta.getId(), novaConta.getTitular(), destinatario, novaConta.getNumeroConta(), valorEntrada, "saida", data, true,"Amazon","credito",parcelas)); // Adiciona a movimentação de entrada ao mapa
        ((credito) movimentacao.get(conta.getId())).TerminoDasParcelas(); // Obtém o objeto 'credito' do mapa e chama o método para verificar se todas as parcelas foram pagas
        novaConta.setMovimentacoes(movimentacao); // Registra a entrada na conta
        saldo = novaConta.calculaSaldo(novaConta.getSaldo());

        /*Exemplo 3*/
        valorSaida = 300; // Variável para armazenar o valor da transferência
        movimentacao.put(conta.getId(), new pix_debito(conta.getId(), novaConta.getTitular(), destinatario, novaConta.getNumeroConta(), valorSaida, "saida", data, false, "Transferência para amigo", "pix")); // Adiciona a movimentação de transferência ao mapa
        novaConta.setMovimentacoes(movimentacao); // Registra a transferência na conta
        saldo = novaConta.calculaSaldo(novaConta.getSaldo());

        /*Exemplo 4*/
        valorEntrada = 150; // Variável para armazenar o valor do pagamento
        movimentacao.put(conta.getId(), new pix_debito(conta.getId(), novaConta.getTitular(), destinatario, novaConta.getNumeroConta(), valorEntrada, "entrada", data, false, "Pagamento de conta de luz", "débito")); // Adiciona a movimentação de pagamento ao mapa
        novaConta.setMovimentacoes(movimentacao); // Registra o pagamento na conta
        saldo = novaConta.calculaSaldo(novaConta.getSaldo());

        /*Exemplo 5 */
        valorSaida = 1000; // Variável para armazenar o valor da saída 
        parcelas = 5; // Variável para armazenar o número de parcelas
        movimentacao.put(conta.getId(), new credito(conta.getId(), novaConta.getTitular(), destinatario, novaConta.getNumeroConta(), valorSaida, "saida", data, true,"Amazon","credito",parcelas)); // Adiciona a movimentação de entrada ao mapa
        ((credito) movimentacao.get(conta.getId())).TerminoDasParcelas(); // Obtém o objeto 'credito' do mapa e chama o método para verificar se todas as parcelas foram pagas
        novaConta.setMovimentacoes(movimentacao); // Registra a entrada na conta
        saldo = novaConta.calculaSaldo(saldo);

        /*Exemplo 7*/
        valorEntrada = 30000;
        movimentacao.put(conta.getId(), new pix_debito(conta.getId(), novaConta.getTitular(), destinatario, novaConta.getNumeroConta(), valorEntrada, "entrada", data, false, "Transferência de um amigo", "pix")); // Adiciona a movimentação de transferência ao mapa
        novaConta.setMovimentacoes(movimentacao); // Registra a transferência na conta
        saldo = novaConta.calculaSaldo(novaConta.getSaldo());

        novaConta.imprimirRelatorio(); // Chama o método para imprimir as movimentações da conta

    }

}
