#Portuguese Phonetic Plugin for ElasticSearch

A Phonetic plugin for portuguese languaged based on Phonetic Analysis plugin.

##Install

To install, clone this repository into your machine and run:

    ./scripts/install.sh path_to_elasticsearch
    
Here an example:

    ./scripts/install.sh ~/Programas/elasticsearch-0.20.5

##Config

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

##ElasticSearch Versions

This plugin was created for elastic search 0.20 but i'm using without problems on elastic search 1.7.1 on my pet project (http://feedsearch.me). There is only one little bug for this version, the `replace` parameter is ignored and is always `false`.

##License

Do whathever you want. I dont care.

