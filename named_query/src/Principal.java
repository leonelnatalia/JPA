
import dao.PessoaDAO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import model.Pessoa;


public class Principal {

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        for (int i = 0; i < 10; i++) {
            Pessoa p1 = new Pessoa();
            p1.setNome("Pessoa "+i);
            p1.setData_nascimento(new Date(i*2000, i, 1));
            p1.setSalario(new BigDecimal(100.0*i));
            
            pessoaDAO.inserir(p1);
        }
        
        Pessoa pessoaRetornada = pessoaDAO.buscarPorId(5);
        System.out.println(pessoaRetornada);
                
        List<Pessoa> p = (Pessoa) pessoaDAO.buscarPorNome("1");
    }
    
    

}
