curl localhost:9200/comfonetica -XDELETE
curl localhost:9200/comfonetica -XPUT -d '
{
  "mappings" :{
     "document" : {
        "analyzer" : "fonetico"
     }
   }    
}'
curl localhost:9200/semfonetica -XDELETE
curl localhost:9200/semfonetica -XPUT -d '
{
  "mappings" :{
     "document" : {
        "analyzer" : "normal"
     }
   }    
}'

curl -XPOST http://localhost:9200/comfonetica/document -d '{"title": "chiclete açaí canções"}'
curl -XPOST http://localhost:9200/comfonetica/document -d '{"title": "minha casa talhada"}'
curl -XPOST http://localhost:9200/comfonetica/document -d '{"title": "homem alto cansado"}'

curl -XPOST http://localhost:9200/semfonetica/document -d '{"title": "chiclete açaí canções"}'
curl -XPOST http://localhost:9200/semfonetica/document -d '{"title": "minha casa talhada"}'
curl -XPOST http://localhost:9200/semfonetica/document -d '{"title": "homem alto cansado"}'
