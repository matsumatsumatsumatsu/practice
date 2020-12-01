package tera;

public interface ApplicationController{
    RequestContext getRequest(Object request);

    ResponseContext handleRepuest(RequestContext req);

    void handleResponse(RequestContext req,ResponseContext res);
}