package context;
import javax.servlet.http.HttpServletResponse;
public class WebResponseContext implements ResponseContext{
    private Object result;
    private String target;
    public WebResponseContext(){}
    private HttpServletResponse _reponse;
    public void setTarget(String transferInfo){
        target="/WEB-INF/jsp/"+transferInfo+".jsp";
    }
    public String getTarget(){
        return target;
    }
    public void setResult(Object bean){
        result=bean;
    }
    public Object getResponse(){
        return _reponse;
    }
    public Object getResult(){
        return result;
    }
    public void setResponse(Object obj){
        _reponse=(HttpServletResponse)obj;
    }
}