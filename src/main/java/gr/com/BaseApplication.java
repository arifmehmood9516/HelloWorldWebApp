package gr.com;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.service.ServiceLogin;



@ApplicationPath("/api")
public class BaseApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
    	classes.add(ServiceLogin.class);
    	//classes.add(HelloWorld.class);
    	return classes;
	}
	
    /*@Override
    public Set<Object> getSingletons() {
    	Set<Object> classes = new HashSet<>();
    	classes.add(HelloWorld.class);
    	return classes;
    	
    }*/
    
}