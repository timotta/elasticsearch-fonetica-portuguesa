package com.timotta.es;

import org.apache.commons.codec.Encoder;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.phonetic.PhoneticFilter;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class PhoneticTokenFilterFactory extends AbstractTokenFilterFactory {

	private final Encoder encoder;
	private final boolean replace;

	@Inject
	public PhoneticTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
		super(indexSettings, name, settings);
		this.replace = settings.getAsBoolean("replace", true);
		this.encoder = new FoneticaPortuguesa();
	}

	@Override
	public TokenStream create(TokenStream tokenStream) {
		return new PhoneticFilter(tokenStream, encoder, !replace);
	}
}