package mg.itu.tpcustomerrakotoarimananasandratriniaina.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */

//@Path("jakartaee10")
@Path("jakartaee")
public class JakartaEE10Resource {
    
    @GET
    public Response ping() {
        //.ok("ping Jakarta EE")
        return Response
                .ok("ping Jakarta EE 10 [OK]")
                .build();
    }
    
}
