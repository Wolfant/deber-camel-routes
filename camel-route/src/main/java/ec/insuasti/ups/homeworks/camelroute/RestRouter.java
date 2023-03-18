package ec.insuasti.ups.homeworks.camelroute;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class RestRouter extends RouteBuilder {

    JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Factura.class);

    @Override
    public void configure() throws Exception {
        restConfiguration()
           .enableCORS(false);
            

        from("direct:inFactura")
        .routeId("RouteFactura")
        .process(new FacturaProcessor())
        .choice()
            .when(header("ruta").contains("1"))
                .marshal(jsonDataFormat)
                .to("rest:post:/factura?host=localhost:3000")
            .otherwise()
                .marshal(jsonDataFormat)
                .to("rest:post:/factura?host=localhost:5000")
        .end();

    }
    
}
