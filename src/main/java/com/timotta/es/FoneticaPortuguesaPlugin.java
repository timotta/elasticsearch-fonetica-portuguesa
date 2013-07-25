package com.timotta.es;

import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.plugins.AbstractPlugin;

/**
 */
public class FoneticaPortuguesaPlugin extends AbstractPlugin {

    @Override
    public String name() {
        return "fonetica-portuguesa";
    }

    @Override
    public String description() {
        return "Portuguese phonetic analysis support";
    }

    public void onModule(AnalysisModule module) {
        module.addProcessor(new PhoneticAnalysisBinderProcessor());
    }
}

