
package ifpb.ads.autor;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validadorCPF")
public class ValidadorCPF implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, 
            Object value) throws ValidatorException {
        CPF cpf = (CPF) value;
        if(!cpf.isValid()){
            FacesMessage mensagem = new FacesMessage("CPF Invalido, Valor Incorreto");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw  new ValidatorException(mensagem);
        }
    }
    
}
