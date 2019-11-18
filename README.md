# ws-pharmacy
rest service that returns pharmacies on duty with filters

> import with specific gradle version : 5.2

#Request

* pharmacy 
* method: Get
* path: /information/pharmacy

{
	"region_id": "7",
	"filter": {
		"comuna_nombre": "las condes",
		"local_nombre": "cruz verde"
	}
}


* commune
* method: Post
* path: /information/commune

{
	"reg_id": "7"
}
 
# DockerFile
ws-pharmacy/src/main/docker/Dockerfile

# Openapi
ws-pharmacy/deploy/swagger.yaml
