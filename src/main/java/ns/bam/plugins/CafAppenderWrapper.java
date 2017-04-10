package ns.bam.plugins;


import java.io.Serializable;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import nl.donna.generiek.client.caf.log4j.CafAppender;


@Plugin(name = "CafAppender", category = "Core", elementType = "appender", printObject = true)
public class CafAppenderWrapper extends AbstractAppender {

    private CafAppender cafAppender;

    public CafAppenderWrapper(String name, Filter filter,
            Layout<? extends Serializable> layout, boolean ignoreExceptions) {
        super(name, filter, layout);
        cafAppender = CafAppender.createAppender(name, layout, filter, ignoreExceptions);
    }

    public void append(LogEvent logEvent) {
        cafAppender.append(logEvent);
    }

    @PluginFactory
    public static CafAppenderWrapper createAppender(@PluginAttribute("name") String name,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginElement("Filter") final Filter filter,
            @PluginAttribute("ignoreExceptions") boolean ignoreExceptions) {
        return new CafAppenderWrapper(name, filter, layout, ignoreExceptions);
    }
}
