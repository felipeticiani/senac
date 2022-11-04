package br.senac.sc.consumindoapi_viacep.webservice;

import br.senac.sc.consumindoapi_viacep.entidade.Endereco;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class CepRest {
    private Client client;
    private WebResource webResource;

    public CepRest() {
        ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
        client.addFilter(new LoggingFilter(System.out));
        webResource = client.resource("https://viacep.com.br/ws/");
    }
    
    public Endereco pesquisaCep(String cep) {
        return webResource.path(cep).path("/json").get(Endereco.class);
    }
    
    public static void main(String[] args) {
        CepRest cepRest = new CepRest();
        Endereco endereco = cepRest.pesquisaCep("88110612");
        System.out.println(endereco.toString());
    }
}
