package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ShowDTO;
import facades.ShowFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.List;

@Path("show")
public class ShowResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final ShowFacade FACADE = ShowFacade.getShowFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    //@RolesAllowed("user")
    public Response getAllShows(){
        List<ShowDTO> showDTOList = FACADE.getAllShows();
        return Response.ok().entity(GSON.toJson(showDTOList)).build();
    }
}
