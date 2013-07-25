mkdir -p $1/plugins/fonetica-portuguesa &&\
 cp dist/* $1/plugins/fonetica-portuguesa &&\
 echo "Fonetica Portuguesa Plugin" &&\
 echo "Installed in $1" &&\
 echo "Need to restart elasticsearch"
