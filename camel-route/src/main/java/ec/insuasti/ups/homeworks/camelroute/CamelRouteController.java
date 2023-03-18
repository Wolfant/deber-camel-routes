package ec.insuasti.ups.homeworks.camelroute;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelRouteController {

    @Autowired private ProducerTemplate template;
    @PostMapping(value = "/factura")
    public ResponseEntity<String> inFactura(@RequestBody Factura factura){
        try {
            template.requestBody("direct:inFactura", factura);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
       
    }
    
}
