package com.sun.www.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author suny
 * @version 1.0
 * @date 2017年09月29日
 */
public class VelocityUtil {

    private static final String CLASSPTAH = "classpath";
    private static final String CLASSLOADER = "classpath.resource.loader.class";

    public static void template(String templatePath, String outPath, HashMap<String, Object> map) throws Exception {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, CLASSPTAH);
        velocityEngine.setProperty(CLASSLOADER, ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        Template actionTpt = velocityEngine.getTemplate(templatePath);
        VelocityContext ctx = new VelocityContext();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            ctx.put(key, map.get(key));
        }
        merge(actionTpt, ctx, outPath);
    }

    private static void merge(Template template, VelocityContext ctx, String path) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path);
            template.merge(ctx, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
