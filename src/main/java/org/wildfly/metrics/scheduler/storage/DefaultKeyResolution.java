package org.wildfly.metrics.scheduler.storage;

import org.wildfly.metrics.scheduler.polling.Task;

/**
 * Resolve data input attributes to final metric (storage) names.
 *
 * @author Heiko Braun
 * @since 24/10/14
 */
public class DefaultKeyResolution implements KeyResolution {
    @Override
    public String resolve(Task task) {
        if(task.getHost()!=null && !task.getHost().equals(""))
        {
            // domain
            return task.getHost()+"."+task.getServer()+"."+task.getAttribute();
        }
        else if (task.getAlias() != null && !task.getAlias().trim().equalsIgnoreCase(""))
        {
            // standalone ( if alias != null put only alias value in the name that be saved on db)
            return task.getServer() + "."+task.getAlias();
        } else {
        	// standalone
        	return task.getServer() + "."+task.getAttribute();
        }
        

    }
}
