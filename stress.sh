for i in $(seq 1 10000); do
    echo "Sleeping for $1 seconds"
    curl http://192.168.49.2:30080/api/v1/produto
    sleep $1
done