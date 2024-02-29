package com.redhat.starter;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import java.util.Base64;
import javax.inject.Inject;

@Path("/")
public class GreetingResource {

    @Inject
    HttpHeaders httpHeaders;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String hostname = httpHeaders.getHeaderString("Host");
        String response = null;
        String hello = "SEVMTE9fV09STEQ=";
        String aloha = "QUxPSEFfR1JFRVRJTkc=";

        if (hostname.contains("aloha")) 
            response = new String(Base64.getDecoder().decode(aloha));
        else
            response = new String(Base64.getDecoder().decode(hello));
        
        return response;
    }
}
