package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/soma/{op}/{op2}")
public class Soma {

    @GET
    public double calculaSoma(@PathParam double op, @PathParam double op2) {
        try {
          return op+op2;
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetro inválido: " + op);
        }
    }
}
