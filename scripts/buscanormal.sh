curl -XGET 'http://localhost:9200/semfonetica/document/_search?pretty=true' -d '{ "query" : { "text" : { "title" : { "query" : "'$1'" } } } }'
