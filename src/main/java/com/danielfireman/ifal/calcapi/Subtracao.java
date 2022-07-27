package com.danielfireman.ifal.calcapi;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("/subtracao/{num}/{num2}")
public class Subtracao {

    @GET
    public double calculaSubtracao(@PathParam double num, @PathParam double num2) {
        try {
          return num-num2;
        } catch (NumberFormatException nfe) {
          throw new BadRequestException("Parâmetros inválidos: " + num + " " +num2);
        }
    }
}
