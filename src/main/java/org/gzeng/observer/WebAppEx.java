package org.gzeng.observer;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

/**
 *
 */
public class WebAppEx {

    public static WebApplicationException make(Response.Status status, String appSpecificCode, String message) {
        return make(status, appSpecificCode, message, null);
    }
    
    public static WebApplicationException make(int status, String appSpecificCode, String message) {
        return make(status, appSpecificCode, message, null);
    }
    
    public static WebApplicationException make(Response.Status status, String appSpecificCode, String message, Throwable cause) {
        return make(status.getStatusCode(), appSpecificCode, message, cause);
    }
    
    public static WebApplicationException make(int status, String appSpecificCode, String message, Throwable cause) {
        HashMap<String,Object> errorMessage = new HashMap();
        errorMessage.put("status", status);
        errorMessage.put("message", message);
        errorMessage.put("code", appSpecificCode);
        
        return new WebApplicationException(appSpecificCode+"/"+errorMessage, cause,
                Response.status(status)
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .build() );
    }
}
