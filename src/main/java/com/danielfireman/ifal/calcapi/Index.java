package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.*;

@Path("/")
public class Index {
    
    @GET
    public String index() {
        return "Bem-vindo(a) a API calculadora!";
    }

}
