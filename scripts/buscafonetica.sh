curl -XGET 'http://localhost:9200/comfonetica/document/_search?pretty=true' -d '{ "query" : { "text" : { "title" : { "query" : "'$1'" } } } }'
