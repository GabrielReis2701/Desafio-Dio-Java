package projeto;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private static final int AGENCIA_NUM = 2209;
    private static int NUM_CONTA = 1;
    public static List<Conta> clientes = new ArrayList<>();
    protected int Agencia;
    protected int NumeroDaConta;
    protected String Tipo;
    protected double saldo = 0.00;
    protected static int Id;

    public Conta() {
        this.Agencia = Conta.AGENCIA_NUM;
        this.NumeroDaConta = NUM_CONTA++;
    }

    public int getAgencia() {
        return Agencia;
    }

    public int getNumeroDaConta() {
        return NumeroDaConta;
    }

    public static void depositar(double valor,int agencia,int numConta) {
        Conta conta =  buscarConta(agencia,numConta);
        if(conta!=null){
            conta.saldo+=valor;
            System.out.println("!Deposito realizado com sucesso, O novo saldo da sua conta é: "+conta.saldo);
        }else{
            System.out.println("!!!Verifique o numero da agencia e da conta e tente novamente!!!");
        }
        
    }

    public static Conta buscarConta(int agencia, int numConta) {
        for(Conta c: clientes){
            if(c.Agencia==agencia && c.NumeroDaConta==numConta){
                return c;
            }else{
                System.out.println("Conta não encontrada");
            }
        }
        return null; 
    }

    public static void sacar(double valor,int agencia,int numConta) {
        Conta conta =  buscarConta(agencia,numConta);
        if((conta!=null) && (conta.saldo>=valor)){
            conta.saldo -=valor;
            System.out.println("!Saque realizado com sucesso, O novo saldo da sua conta é: "+conta.saldo);
        }else{
            System.out.println("!!!Verifique o numero da agencia e da conta e tente novamente!!!");
        }
    }
    public static void getListClinte(){
        for (Conta c: clientes){
            System.out.println("----------------------------------------------");
            System.out.println("Agencia: "+ c.Agencia+"\nNumero da Conta: "+c.NumeroDaConta+"\nTipo: "+c.Tipo);
            System.out.println("----------------------------------------------");
        }
    }
    public static void transferir(double valor,Conta contaRemetente, Conta contaDestino) {
        if((contaRemetente!=null) && (contaDestino!=null) && (contaRemetente.saldo>valor)){
            contaDestino.saldo+=valor;
            contaRemetente.saldo-=valor;
            System.out.println("!Transferencia realizada com sucesso, O novo saldo da sua conta é: "+contaRemetente.saldo);
        }else{
            System.out.println("!!!Verifique o numero da agencia e da conta e tente novamente!!!");
        }

    }

    @Override
    public String toString() {
        return "Conta [Agencia=" + Agencia + ", NumeroDaConta=" + NumeroDaConta + ", Tipo=" + Tipo + ", saldo=" + saldo
                + "]";
    }

}
