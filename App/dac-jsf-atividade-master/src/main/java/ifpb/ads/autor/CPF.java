package ifpb.ads.autor;

public class CPF {

    private String valor; // sem pontos, apenas digitos

    public CPF(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
    public String formatado() {
        String cpf = valor;

        if (naoNulo(cpf)) {
            cpf = formatarCPF(cpf);
        }
        return cpf;
    }

    private String formatarCPF(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    private boolean naoNulo(String cpf) {
        return cpf != null && cpf.length() == 11;
    }

    public boolean isValid(){
        return this.valor.length()==11;
    }

}
