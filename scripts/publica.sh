data=$(printf "%s," "$@")
curl -XPOST http://localhost:9200/semfonetica/document -d '{"titulo": "'$data'"}'
curl -XPOST http://localhost:9200/comfonetica/document -d '{"titulo": "'$data'"}'
