package tera;
public interface ResponseContext{
    public Object getResult();
    public String getTarget();
    public void setResult(Object bean);
    public void  setTarget(String transeforInfo);
    public void setResponse(Object obj);
    public Object getResponse();
} 