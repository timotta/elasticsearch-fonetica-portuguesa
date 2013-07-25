package com.timotta.es;

import org.apache.commons.codec.Encoder;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.phonetic.PhoneticFilter;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;
import org.elasticsearch.index.settings.IndexSettings;

public class PhoneticTokenFilterFactory extends AbstractTokenFilterFactory {

    private final Encoder encoder;
    private final boolean replace;

    @Inject
    public PhoneticTokenFilterFactory(Index index, @IndexSettings Settings indexSettings, @Assisted String name, @Assisted Settings settings) {
        super(index, indexSettings, name, settings);
        this.replace = settings.getAsBoolean("replace", true);
        this.encoder = new FoneticaPortuguesa();
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new PhoneticFilter(tokenStream, encoder, !replace);
    }
}