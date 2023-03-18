package ec.insuasti.ups.homeworks.camelroute;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FacturaProcessor implements Processor{
    private Logger log = LoggerFactory.getLogger(FacturaProcessor.class);
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void process(Exchange exchange) throws Exception {
        Factura nuevFactura = modelMapper.map(exchange.getMessage().getBody(), Factura.class);
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
        if (nuevFactura.getValue() >= 100 ){
            exchange.getIn().setHeader("ruta", "1");
        }
        else {
            exchange.getIn().setHeader("ruta", "2");
        }
        exchange.getIn().setBody(nuevFactura);
        log.info("processando factura {}", nuevFactura); 
    }
}
