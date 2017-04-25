package nl.craftsmen.log4j.plugins;


import java.io.Serializable;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;


@Plugin(name = "MyAppender", category = "Core", elementType = "appender", printObject = true)
public class MyAppender extends AbstractAppender {

    public MyAppender(String name, Filter filter,
                      Layout<? extends Serializable> layout, boolean ignoreExceptions) {
        super(name, filter, layout);
    }

    public void append(LogEvent logEvent) {
        System.out.println("every logline looks the same to me!");
    }

    @PluginFactory
    public static MyAppender createAppender(@PluginAttribute("name") String name,
                                            @PluginElement("Layout") Layout<? extends Serializable> layout,
                                            @PluginElement("Filter") final Filter filter,
                                            @PluginAttribute("ignoreExceptions") boolean ignoreExceptions) {
        return new MyAppender(name, filter, layout, ignoreExceptions);
    }
}
