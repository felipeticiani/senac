package br.senac.sc.consumindoapi_viacep.webservice;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class GensonProvider implements ContextResolver<Genson>{

    private Genson genson = new GensonBuilder().setSkipNull(true).create();
    
    @Override
    public Genson getContext(Class<?> type) {
        return genson;
    }
    
}
