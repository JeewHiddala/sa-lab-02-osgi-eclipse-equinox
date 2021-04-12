package servicesubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.servicepublisher.ServicePublish;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) context.getService(serviceReference);
		System.out.println(servicePublish.publishService());
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("GoodBye !!!");
		context.ungetService(serviceReference);
		
	}

}
