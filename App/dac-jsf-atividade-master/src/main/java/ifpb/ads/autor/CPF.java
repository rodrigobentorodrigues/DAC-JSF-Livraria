package ifpb.ads.autor;

public class CPF {

    private String valor; // sem pontos, apenas digitos

    public CPF(String valor) {
        this.valor = valor;
    }

    public CPF() {
    }

    public String getValor() {
        return valor;
    }
    
    public String formatado() {
        String cpf = valor;

        if (cpf != null && cpf.length() == 11) {
            cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        }
        return cpf;
    }
    
    public String getValorFormatado(){
        String cpf = valor;

        if (cpf != null && cpf.length() == 11) {
            cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        }
        return cpf;
    }
    
    public boolean isValid(){
        return this.valor.length()==11;
    }

}
