package dao;

import model.Imovel;

import java.util.ArrayList;
import java.util.List;

public class ImovelDAO {
    private List<Imovel> imovelList;

    public ImovelDAO() {
        imovelList = new ArrayList<>();
    }

    public Boolean incluirImovel(Imovel imovelNovo){
        for(Imovel imovel : imovelList){
            if(imovel != null && imovel.getCodigo().equals(imovelNovo.getCodigo())){
                // Já existe um imovel com esse código
                return false; // interrompe o metodo
            }
        }

        imovelList.add(imovelNovo);
        return true;
    }

    public Boolean alterarImovel(String codigo, Imovel imovelAtualizado){
        for(Imovel imovel : imovelList){
            if(codigo.equals(imovel.getCodigo())){
                imovel.setCodigo(imovelAtualizado.getCodigo());

                imovel.setCep(imovelAtualizado.getCep());
                imovel.setRua(imovelAtualizado.getRua());
                imovel.setNumero(imovelAtualizado.getNumero());
                imovel.setBairro(imovelAtualizado.getBairro());
                imovel.setEstado(imovelAtualizado.getEstado());
                imovel.setCidade(imovelAtualizado.getCidade());
                imovel.setPais(imovelAtualizado.getPais());

                imovel.setQuantidadeGaragens(imovelAtualizado.getQuantidadeGaragens());
                imovel.setQuantidadeQuartos(imovelAtualizado.getQuantidadeQuartos());
                imovel.setQuantidadeSeguranca(imovelAtualizado.getQuantidadeSeguranca());
                imovel.setQuantidadeSuites(imovelAtualizado.getQuantidadeSuites());

                imovel.setTipo(imovelAtualizado.getTipo());
                imovel.setDescricao(imovelAtualizado.getDescricao());
                imovel.setValorAluguel(imovelAtualizado.getValorAluguel());
                imovel.setValorCondominio(imovelAtualizado.getValorCondominio());
                return true;
            }
        }

        return false;
    }

    public Boolean excluirImovel(String codigo){
        for(Imovel imovel : imovelList){
            if(imovel!= null && imovel.getCodigo().equals(codigo)){
                imovelList.remove(imovel);
                return true;
            }
        }

        return false;
    }

    public Imovel getImovel(String codigo){
        for(Imovel imovel : imovelList){
            if(imovel != null && imovel.getCodigo().equals(codigo)){
                return imovel;
            }
        }
        return null;
    }

    public List<Imovel> getImoveis(){
        return imovelList;
    }
}
