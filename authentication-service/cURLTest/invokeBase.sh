curl -X GET \
  http://localhost:8888/microservicio \
  -H 'authorization: Bearer 2d5de33e-0cad-4d57-9328-621a93886468' \
  -H 'cache-control: no-cache' 
  
  
  
  curl -X GET -v \
  http://microserviciosbase-v4-0.127.0.0.1.nip.io/microservicio/v3/mensaje \
  -H 'authorization: Bearer a4ac35db-dc0f-4dd3-83ad-e1d00316285b' \
  -H 'cache-control: no-cache' 
  
  
  a4ac35db-dc0f-4dd3-83ad-e1d00316285b
  
  curl -X GET  -k  https://zuulsvr-v4-0.127.0.0.1.nip.io/api/microservicio-base/microservicio/marco   -H 'authorization: Bearer 763934aa-1c8c-49bc-95e4-33f1d015cf36'   -H 'cache-control: no-cache' 
  curl -X GET  -k  https://zuulsvr-v4-0.127.0.0.1.nip.io/api/microservicio-base/microservicio/v3/mensaje   -H 'authorization: Bearer 763934aa-1c8c-49bc-95e4-33f1d015cf36'   -H 'cache-control: no-cache' 
  
  
  curl -X GET  -k  https://zuulsvr-v4-0.127.0.0.1.nip.io/api/microservicio-dummy/microservicio/v3/mensaje   -H 'authorization: Bearer a4ac35db-dc0f-4dd3-83ad-e1d00316285b'   -H 'cache-control: no-cache' 
  
  
  curl -X GET -v \
  http://microserviciosbase-v4-0.127.0.0.1.nip.io/microservicio \
  -H 'authorization: Bearer a4ac35db-dc0f-4dd3-83ad-e1d00316285b'
  
  
    
  curl -X POST -v http://microserviciosbase-v4-0.127.0.0.1.nip.io/microservicio/event -H 'authorization: Bearer a4ac35db-dc0f-4dd3-83ad-e1d00316285b'