package ec.insuasti.ups.homeworks.camelroute;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Factura {
    private int id;
    private String date;
    private float value;
    private String client_id;
    private String client_name; 


}
