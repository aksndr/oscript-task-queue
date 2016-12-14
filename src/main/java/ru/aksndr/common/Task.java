package ru.aksndr.common;//Created by Arzamastsev on 09.11.2016.

import com.opentext.livelink.oml.OScriptObject;

import java.util.HashMap;
import java.util.Map;

public class Task implements Runnable {

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
        this.result = Utils.ok("all ok");
        System.out.println("Executed: " + script + " prgCtx: " + prgCtx);
    }

    public Map getResult() {
        return result;
    }

}
