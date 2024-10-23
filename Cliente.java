package projeto;

public class Cliente {
    private String nome;
    private int CPF;

    public Cliente() {
       
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(int cPF) {
        CPF = cPF;
    }

    public String getNome() {
        return nome;
    }

    public int getCPF() {
        return CPF;
    }
    
    
}
