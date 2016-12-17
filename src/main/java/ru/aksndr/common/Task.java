package ru.aksndr.common;//Created by Arzamastsev on 09.11.2016.

import com.opentext.livelink.oml.OScriptObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Task implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Task.class.getSimpleName());

    private String script = null;
    private OScriptObject prgCtx = null;
    private Map params = new HashMap();
    private Map result = new HashMap();

    public Task(OScriptObject prgCtx, String script, Map params) {
        this.prgCtx = prgCtx;
        this.script = script;
        this.params = params;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(5000);
            OScriptObject uSession = (OScriptObject) prgCtx.invokeScript("USession");
            logger.info(uSession.toString());
            this.result = (Map<String, Object>) OScriptObject.runScript("$LLIAPI.UsersPkg.NameGetByID", uSession, 1000);

        } catch (Exception e) {
            this.result = Utils.error(e.toString());
            logger.error(e.toString());
        }

        System.out.println("Executed: " + script + " prgCtx: " + prgCtx);
    }

    public Map getResult() {
        return result;
    }

}
