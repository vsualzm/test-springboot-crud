package id.ilham.learn.eurekaaccountservice;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountControllers {

    @Autowired
    private EurekaClient eurekaClient;
    // list
//    private DiscoveryClient discoveryClient;



    @GetMapping(value = "hots", produces = MediaType.APPLICATION_JSON)
    public String getUserHost(){
        InstanceInfo instances = eurekaClient.getNextServerFromEureka("user-service", false);
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");

        return instances.getHomePageUrl();
    }

//    @GetMapping(value = "hots", produces = MediaType.APPLICATION_JSON)
//    public List<ServiceInstance> getUserHost(){
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//
//        return instances;
//    }



}
