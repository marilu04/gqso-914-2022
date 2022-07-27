package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/subtracao/{op1}/{op2}")
public class Subtracao {

    @GET
    public double calculaSubtracao(@PathParam double op1, @PathParam double op2) {
        try {
          return op1-op2;
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetros inválidos: " + op1 + " " +op2);
        }
    }
}
