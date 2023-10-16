package at.gepardec.rest;

import at.gepardec.health.State;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.inject.Inject;

@RequestScoped
@Path("/togglehealth")
public class HealthToggleResource {

    @Inject
    State state;

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response toggleHealthResource() {
        state.setLiveness(!state.getLiveness());
        state.setReadiness(!state.getReadiness());
        return Response
            .status(200)
            .entity("toggled heath and liveness state to " + state.getLiveness() + " and " + state.getReadiness() + " respectively")
            .build();
    }

}
