
import br.edu.isp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;
import javax.persistence.Persistence;


public class Principal {
    
    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public static void main(String[] args) {
        adicionarProdutos();
    }
    
    public static void adicionarProdutos() {
        for (int i = 0; i < 10; i++) {
            Produto p = new Produto();
            p.setDescricao("produto "+i);
            p.setQuantidade(i*10);
            p.setPreco(new BigDecimal((i+1)*100));
            
            produtoDAO.inserir(p);
        }
    }
}
