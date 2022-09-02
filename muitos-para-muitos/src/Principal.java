
import br.edu.ifsp.pep.modelo.Item;
import br.edu.isp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.modelo.Produto;
import br.edu.ifsp.pep.modelo.Venda;
import br.edu.isp.pep.dao.VendaDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Persistence;

public class Principal {

    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    private static VendaDAO vendaDAO = new VendaDAO();

    public static void main(String[] args) {
        adicionarProdutos();
        exibirProdutos();
        adicionarVenda();
    }

    public static void adicionarProdutos() {
        for (int i = 0; i < 10; i++) {
            Produto p = new Produto();
            p.setDescricao("produto " + i);
            p.setQuantidade(i * 10);
            p.setPreco(new BigDecimal((i + 1) * 100));

            produtoDAO.inserir(p);
        }
    }

    private static void exibirProdutos() {
        List<Produto> produtos = produtoDAO.buscar();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private static void adicionarVenda() {
        Venda venda = new Venda();
        venda.setData(new Date());

        List<Produto> produtos = produtoDAO.buscar();
        Item item = new Item();
        item.setVenda(venda);
        item.setProduto(produtos.get(0));
        item.setPreco(produtos.get(0).getPreco());
        item.setQuantidade(10);
        
        List<Item> itens = new ArrayList<>();
        itens.add(item);
        
        venda.setItens(itens);
        
        vendaDAO.inserir(venda);
    }
}
