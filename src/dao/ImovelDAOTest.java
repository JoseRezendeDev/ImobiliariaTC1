package dao;

import model.Imovel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ImovelDAOTest {
    private ImovelDAO imovelDAO;

    @BeforeAll
    public void inicializaImovelDAO(){
        imovelDAO = new ImovelDAO();
    }

    @Test
    @Order(1)
    void incluirImovel() {
        Imovel imovel = new Imovel(
                "C3A19",
                "Descrição da casa",
                "Rua Idamazia Ferreira Nascimento",
                99,
                "JD Belo Horizonte do Tambury",
                "Sertãozinho",
                "SP",
                "Brasil",
                "14169-510",
                "casa",
                3,
                1,
                3,
                Arrays.asList("câmera de segurança", "interfone"),
                1000.00f,
                0
        );

        imovelDAO.incluirImovel(imovel);
        Imovel imovelInserido = imovelDAO.getImovel("C3A19");

        assertAll(
                ()-> assertEquals(imovel.getCodigo(), imovelInserido.getCodigo()),
                ()-> assertEquals(imovel.getDescricao(), imovelInserido.getDescricao()),
                ()-> assertEquals(imovel.getRua(), imovelInserido.getRua()),
                ()-> assertEquals(imovel.getNumero(), imovelInserido.getNumero()),
                ()-> assertEquals(imovel.getBairro(), imovelInserido.getBairro()),
                ()-> assertEquals(imovel.getCidade(), imovelInserido.getCidade()),
                ()-> assertIterableEquals(imovel.getItensSeguranca(), imovelInserido.getItensSeguranca()),
                ()-> assertEquals(imovel.getValorAluguel(), imovelInserido.getValorAluguel())
        );
    }

    @Test
    @Order(2)
    void alterarImovel() {
        Imovel imovel = new Imovel(
                "C3A19",
                "Descrição da casa",
                "Rua Idamazia Ferreira Nascimento",
                99,
                "JD Belo Horizonte do Tambury",
                "Sertãozinho",
                "SP",
                "Brasil",
                "14169-510",
                "casa",
                3,
                1,
                3,
                Arrays.asList("câmera de segurança", "interfone"),
                1000.00f,
                0
        );

        Imovel imovelNovo = new Imovel(
                "E204JR7",
                "Descrição do apartamento",
                "Rua Américo Jacomino Canhoto",
                157,
                "JD Nova Santa Paula",
                "São Carlos",
                "SP",
                "Brasil",
                "13569-310",
                "apartamento",
                1,
                0,
                2,
                Arrays.asList("câmera de segurança", "guarita", "extintor de incêndio"),
                750.00f,
                250.00f
        );

        imovelDAO.incluirImovel(imovel);
        imovelDAO.alterarImovel(imovel.getCodigo(), imovelNovo);

        Imovel imovelAlterado = imovelDAO.getImovel(imovelNovo.getCodigo());
        assertNotNull(imovelAlterado);
        assertNotEquals(imovel.getCidade(), imovelNovo.getCidade());
        assertNotEquals(imovel.getCodigo(), imovelNovo.getCodigo());
    }

    @Test
    @Order(3)
    void excluirImovel() {
        Imovel imovel = new Imovel(
                "E204JR7",
                "Descrição do apartamento",
                "Rua Américo Jacomino Canhoto",
                157,
                "JD Nova Santa Paula",
                "São Carlos",
                "SP",
                "Brasil",
                "13569-310",
                "apartamento",
                1,
                0,
                2,
                Arrays.asList("câmera de segurança", "guarita", "extintor de incêndio"),
                750.00f,
                250.00f
        );

        imovelDAO.incluirImovel(imovel);
        assertNotNull(imovelDAO.getImovel(imovel.getCodigo()));
        imovelDAO.excluirImovel(imovel.getCodigo());
        assertNull(imovelDAO.getImovel(imovel.getCodigo()));
    }

    @Test
    @Order(4)
    void getImovel() {
        Imovel imovel = new Imovel(
                "C3A19",
                "Descrição da casa",
                "Rua Idamazia Ferreira Nascimento",
                99,
                "JD Belo Horizonte do Tambury",
                "Sertãozinho",
                "SP",
                "Brasil",
                "14169-510",
                "casa",
                3,
                1,
                3,
                Arrays.asList("câmera de segurança", "interfone"),
                1000.00f,
                0
        );
        imovelDAO.incluirImovel(imovel);
        Imovel imovelIncluido = imovelDAO.getImovel(imovel.getCodigo());
        assertNotNull(imovelDAO.getImovel(imovelIncluido.getCodigo()));
    }

    @Test
    @Order(5)
    void getImoveis() {
        Imovel imovel;
        imovel = new Imovel(
                "C3A19",
                "Descrição da casa",
                "Rua Idamazia Ferreira Nascimento",
                99,
                "JD Belo Horizonte do Tambury",
                "Sertãozinho",
                "SP",
                "Brasil",
                "14169-510",
                "casa",
                3,
                1,
                3,
                Arrays.asList("câmera de segurança", "interfone"),
                1000.00f,
                0
        );

        Imovel outroImovel = new Imovel(
                "E204JR7",
                "Descrição do apartamento",
                "Rua Américo Jacomino Canhoto",
                157,
                "JD Nova Santa Paula",
                "São Carlos",
                "SP",
                "Brasil",
                "13569-310",
                "apartamento",
                1,
                0,
                2,
                Arrays.asList("câmera de segurança", "guarita", "extintor de incêndio"),
                750.00f,
                250.00f
        );

        imovelDAO.incluirImovel(imovel);
        imovelDAO.incluirImovel(outroImovel);
        assertEquals(imovelDAO.getImoveis().size(), 2);
    }
}