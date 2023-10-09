
echo Deteniendo ...
sudo docker stop postgresql
echo Eliminando ...
sudo docker rm postgresql
echo Creando ...
sudo docker run --name postgresql -e POSTGRES_PASSWORD=Paulina -e POSTGRES_USER=Paulina -e POSTGRES_DB=dimex  -d postgres -p 5432:5432 -v ./data:/var/lib/postgresql/data -d postgres
echo Iniciando ..
sudo docker start postgresql
sleep 1
ps -ef | grep postgres
