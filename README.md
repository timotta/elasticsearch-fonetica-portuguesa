# Portuguese Phonetic Plugin for ElasticSearch

A Phonetic plugin for portuguese languaged based on Phonetic Analysis plugin.

## Install

To install, clone this repository into your machine and run the following commands on your terminal:

    mvn clean install
    sudo $ES_HOME/bin/elasticsearch-plugin install file://$(pwd)/target/releases/elasticsearch-fonetica-portuguesa-0.0.1.zip --verbose
    
## Config

In `config/elasticsearch.yml` configure an filter and an analyser like this:

```
index :
    analysis :
        analyzer :
            fonetico :
                type : custom
                tokenizer : standard
                filter : [ standard, lowercase, foneticaportuguesa_filter, asciifolding ]
        filter :
            foneticaportuguesa_filter:
                type : foneticaportuguesa
                replace : false
```

  * The `replace` parameter (defaults to `true`) controls if the token processed should be replaced with the encoded one (set it to `true`), or added (set it to `false`).

  * For best results never put `asciifolding` before your `foneticaportuguesa` filter

Then, you have to map your document to use this analyser. 
Folder `scripts` has some examples using a analyser with the plugin and without the plugin, go there and have some fun. 

## ElasticSearch Versions

This plugin was created for elastic search 5.4.0. I've forked the original branch and upgraded the code to be compatible with the latest elasticsearch versions

## License

Still, do whathever you want. I don't care.