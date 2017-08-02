package ifpb.ads.autor;

import java.io.Serializable;

public class Autor implements Serializable {

    private String nome;
    private String email;
    private CPF cpf = new CPF();
    
    public Autor() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Autor{" + "nome=" + nome + ", email=" + email + ", cpf=" + cpf.getValor() + '}';
    }

}
