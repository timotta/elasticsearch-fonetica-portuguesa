package com.timotta.es;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

/**
 */
public class FoneticaPortuguesaPlugin extends Plugin implements AnalysisPlugin {

	private final static Logger LOG = LogManager.getLogger(FoneticaPortuguesaPlugin.class);

	public FoneticaPortuguesaPlugin() {
		LOG.info("Plugin fonetica portuguesa instanciado");
	}

	@Override
	public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
		return Collections.singletonMap("phonetic", PhoneticTokenFilterFactory::new);
	}
}
