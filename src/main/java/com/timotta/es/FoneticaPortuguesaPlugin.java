package com.timotta.es;

import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

/**
 */
public class FoneticaPortuguesaPlugin extends Plugin implements AnalysisPlugin {

	private final static Logger LOG = Logger.getLogger(FoneticaPortuguesaPlugin.class.getSimpleName());

	public FoneticaPortuguesaPlugin() {
		LOG.info("Plugin fonetica portuguesa instanciado");
	}

	@Override
	public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
		return Collections.singletonMap("fonetica-portuguesa", PhoneticTokenFilterFactory::new);
	}
}
